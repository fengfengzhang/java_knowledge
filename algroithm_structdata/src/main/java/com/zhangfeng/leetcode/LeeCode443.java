package com.zhangfeng.leetcode;

/**
 * @ClassName LeeCode443
 * @Description TODO
 * @Author zhangfeng
 * @Date 2026/1/27 20:48
 */

import java.util.*;
public class LeeCode443 {

    /**
     * 基因序列可以表示为一条由 8 个字符组成的字符串，其中每个字符都是 'A'、'C'、'G' 和 'T' 之一。
     *
     * 假设我们需要调查从基因序列 start 变为 end 所发生的基因变化。一次基因变化就意味着这个基因序列中的一个字符发生了变化。
     *
     * 例如，"AACCGGTT" --> "AACCGGTA" 就是一次基因变化。
     * 另有一个基因库 bank 记录了所有有效的基因变化，只有基因库中的基因才是有效的基因序列。（变化后的基因必须位于基因库 bank 中）
     *
     * 给你两个基因序列 start 和 end ，以及一个基因库 bank ，请你找出并返回能够使 start 变化为 end 所需的最少变化次数。如果无法完成此基因变化，返回 -1 。
     *
     * 注意：起始基因序列 start 默认是有效的，但是它并不一定会出现在基因库中。
     * @param startGene
     * @param endGene
     * @param bank
     * @return
     */


    // 基因字符集
    private static final char[] GENES = {'A', 'C', 'G', 'T'};

    /**
     * 主方法：找到最少突变次数
     */
    public int minMutation(String startGene, String endGene, String[] bank) {
        // 边界情况处理
        if (startGene.equals(endGene)) {
            return 0;
        }

        // 将 bank 转换为 Set，提高查找效率
        Set<String> bankSet = new HashSet<>(Arrays.asList(bank));
        if (!bankSet.contains(endGene)) {
            return -1;
        }

        // BFS 初始化
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        queue.offer(startGene);
        visited.add(startGene);

        int steps = 0;

        // BFS 遍历
        while (!queue.isEmpty()) {
            int size = queue.size();
            steps++;

            // 遍历当前层的所有节点
            for (int i = 0; i < size; i++) {
                String current = queue.poll();

                // 生成所有可能的突变
                for (String mutation : generateMutations(current)) {
                    // 找到目标，返回步数
                    if (mutation.equals(endGene)) {
                        return steps;
                    }

                    // 检查是否在 bank 中且未访问过
                    if (bankSet.contains(mutation) && !visited.contains(mutation)) {
                        visited.add(mutation);
                        queue.offer(mutation);
                    }
                }
            }
        }

        return -1;
    }

    /**
     * 生成所有可能的单字符突变
     * @param gene 当前基因序列
     * @return 所有可能的突变列表
     */
    private List<String> generateMutations(String gene) {
        List<String> mutations = new ArrayList<>();
        char[] chars = gene.toCharArray();

        // 遍历每个位置
        for (int i = 0; i < chars.length; i++) {
            char original = chars[i];

            // 尝试替换为其他基因字符
            for (char c : GENES) {
                if (c != original) {
                    chars[i] = c;
                    mutations.add(new String(chars));
                }
            }

            // 恢复原字符
            chars[i] = original;
        }

        return mutations;
    }


public static void main(String[] args) {
        LeeCode443 leeCode443 = new LeeCode443();
        System.out.println(leeCode443.minMutation("AACCGGTT", "AAACGGTA",
                new String[]{"AACCGGTA", "AACCGCTA", "AAACGGTA"}));
    }

}