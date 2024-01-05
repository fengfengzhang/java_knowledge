package com.zhangfeng.tool;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileChannel.MapMode;

public class IbdataPaser {
    // 目前只考虑16KiB页大小的情况, 且数据文件小于2GB。
    public static final int PAGE_LENGTH_16K        = 16 * 1024;
    public static final int FIL_TRAILER_OFFSET_16K = 16376;
    public static void main(String[] args) throws IOException {
        //指定需要解析的ibd数据文件。
        String innoDbFileName = "/Users/zhangfeng/Desktop/user.ibd";
        try (RandomAccessFile innoDbFile = new RandomAccessFile(innoDbFileName, "r")) {
            long fileSize = innoDbFile.length();

            FileChannel binlogFileChannel = innoDbFile.getChannel();
            MappedByteBuffer innoDbMappedBuffer = binlogFileChannel.map(MapMode.READ_ONLY, 0, fileSize);

            int page = 0;
            while (innoDbMappedBuffer.position() < fileSize) {
                System.out.println("\nPage :" + page);
                printPageFilHeaderAndTrailer(innoDbMappedBuffer, page * PAGE_LENGTH_16K);
                page++;
            }
        }
    }

    public static byte[] printPageFilHeaderAndTrailer(final MappedByteBuffer mappedBuffer, final int pageStartPos) {
        mappedBuffer.position(pageStartPos);
        int pos = mappedBuffer.position();
        byte[] rawCheckSum = new byte[4];
        mappedBuffer.get(rawCheckSum);

        System.out.println(getRangeString(pos, mappedBuffer.position()) + formatFieldName("Checksum(4)") + " : " + bytesToHexString(rawCheckSum));

        pos=mappedBuffer.position();
        byte[] rawOffset = new byte[4];
        mappedBuffer.get(rawOffset);
        System.out.println(getRangeString(pos, mappedBuffer.position()) + formatFieldName("Offset(Page Number)(4)") + " : " + bytesToHexString(rawOffset));

        pos=mappedBuffer.position();
        byte[] rawPreviousPage = new byte[4];
        mappedBuffer.get(rawPreviousPage);
        System.out.println(getRangeString(pos, mappedBuffer.position()) + formatFieldName("Previous Page(4)") + " : " + bytesToHexString(rawPreviousPage));

        pos=mappedBuffer.position();
        byte[] rawNextPage = new byte[4];
        mappedBuffer.get(rawNextPage);
        System.out.println(getRangeString(pos, mappedBuffer.position()) + formatFieldName("Next Page(4)") + " : "+ bytesToHexString(rawNextPage));

        pos=mappedBuffer.position();
        byte[] rawLsnForLastPageModification = new byte[8];
        mappedBuffer.get(rawLsnForLastPageModification);
        System.out.println(getRangeString(pos, mappedBuffer.position()) + formatFieldName("LSN for last page modification(8)") + " : "+ bytesToHexString(rawLsnForLastPageModification));

        pos = mappedBuffer.position();
        byte[] rawFilePageType = new byte[2];
        mappedBuffer.get(rawFilePageType);
        int pageType = getInt16(rawFilePageType);
        String pageTypeName = getPageType(pageType);
        System.out.println(getRangeString(pos, mappedBuffer.position()) + formatFieldName("Page Type(4)") + " : " +pageTypeName+ " ("+ bytesToHexString(rawFilePageType) +")");

        pos = mappedBuffer.position();
        byte[] rawFlushLsn = new byte[8];
        mappedBuffer.get(rawFlushLsn);
        System.out.println(getRangeString(pos, mappedBuffer.position()) + formatFieldName("Flush LSN(8)") + " : " + bytesToHexString(rawFlushLsn));

        pos = mappedBuffer.position();
        byte[] rawSpaceId = new byte[4];
        mappedBuffer.get(rawSpaceId);
        System.out.println(getRangeString(pos, mappedBuffer.position()) + formatFieldName("Space ID(4)") + " : " + bytesToHexString(rawSpaceId));

        pos = pageStartPos + FIL_TRAILER_OFFSET_16K;
        mappedBuffer.position(pos);
        byte[] rawFilTrailerCheckSum = new byte[4];
        mappedBuffer.get(rawFilTrailerCheckSum);
        System.out.println(getRangeString(pos, mappedBuffer.position()) + formatFieldName("Trailer/Checksum(4)") + " : " + bytesToHexString(rawFilTrailerCheckSum));

        pos = mappedBuffer.position();
        byte[] rawLow32BitsOfLsn = new byte[4];
        mappedBuffer.get(rawLow32BitsOfLsn);
        System.out.println(getRangeString(pos, mappedBuffer.position()) + formatFieldName("Trailer/Low 32Bits Of LSN(4)") + " : " + bytesToHexString(rawLow32BitsOfLsn));
        return rawFilePageType;
    }

    public static String formatFieldName(String fieldName) {
        String fieldNameFormat = "%34s";
        return String.format(fieldNameFormat, fieldName);
    }

    public static String getRangeString(long begin, long end) {
        String value = begin + " - " + end;
        return  String.format("%20s", value);
    }

    public static int getInt16(final byte[] bytes) {
        int value = 0;
        for (byte b : bytes) {
            value = (value << 8) + (b & 0xFF);
        }
        return value;
    }

    public static String bytesToHexString(byte[] src) {
        StringBuilder stringBuilder = new StringBuilder("");
        if (src == null || src.length <= 0) {
            return null;
        }
        for (int i = 0; i < src.length; i++) {
            int v = src[i] & 0xFF;
            String hv = Integer.toHexString(v).toUpperCase();
            if (hv.length() < 2) {
                stringBuilder.append(0);
            }
            stringBuilder.append(hv);
        }
        return stringBuilder.toString();
    }

    /**
     * fil0fil.h: https://dev.mysql.com/doc/dev/mysql-server/latest/fil0fil_8h_source.html
     */
    public static String getPageType(int type) {
        switch(type) {
            case 17855: return "FIL_PAGE_INDEX";
            case 17854: return "FIL_PAGE_RTREE";
            case 17853: return "FIL_PAGE_SDI";
            case 1    : return "FIL_PAGE_TYPE_UNUSED";
            case 2    : return "FIL_PAGE_UNDO_LOG";
            case 3    : return "FIL_PAGE_INODE";
            case 4    : return "FIL_PAGE_IBUF_FREE_LIST";
            case 0    : return "FIL_PAGE_TYPE_ALLOCATED";
            case 5    : return "FIL_PAGE_IBUF_BITMAP";
            case 6    : return "FIL_PAGE_TYPE_SYS";
            case 7    : return "FIL_PAGE_TYPE_TRX_SYS";
            case 8    : return "FIL_PAGE_TYPE_FSP_HDR";
            case 9    : return "FIL_PAGE_TYPE_XDES";
            case 10   : return "FIL_PAGE_TYPE_BLOB";
            case 11   : return "FIL_PAGE_TYPE_ZBLOB";
            case 12   : return "FIL_PAGE_TYPE_ZBLOB2";
            case 13   : return "FIL_PAGE_TYPE_UNKNOWN";
            case 14   : return "FIL_PAGE_COMPRESSED";
            case 15   : return "FIL_PAGE_ENCRYPTED";
            case 16   : return "FIL_PAGE_COMPRESSED_AND_ENCRYPTED";
            case 17   : return "FIL_PAGE_ENCRYPTED_RTREE";
            case 18   : return "FIL_PAGE_SDI_BLOB";
            case 19   : return "FIL_PAGE_SDI_ZBLOB";
            case 20   : return "FIL_PAGE_TYPE_LEGACY_DBLWR";
            case 21   : return "FIL_PAGE_TYPE_RSEG_ARRAY";
            case 22   : return "FIL_PAGE_TYPE_LOB_INDEX";
            case 23   : return "FIL_PAGE_TYPE_LOB_DATA";
            case 24   : return "FIL_PAGE_TYPE_LOB_FIRST";
            case 25   : return "FIL_PAGE_TYPE_ZLOB_FIRST";
            case 26   : return "FIL_PAGE_TYPE_ZLOB_DATA";
            case 27   : return "FIL_PAGE_TYPE_ZLOB_INDEX";
            case 28   : return "FIL_PAGE_TYPE_ZLOB_FRAG";
            case 29   : return "FIL_PAGE_TYPE_ZLOB_FRAG_ENTRY|FIL_PAGE_TYPE_LAST";
        }
        return Integer.toString(type);
    }
}
