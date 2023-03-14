package com.zhangfeng.juc.atomic;


import lombok.Getter;

public enum CountryEnum {

    ONE(1,"齐"),TWO(2,"楚");


  @Getter
  private  Integer retCode;
  @Getter
  private String retMessage;

    CountryEnum(int retCode, String retMessage){
       this.retCode = retCode;
       this.retMessage = retMessage;
    }

    public static CountryEnum get(int i){
        CountryEnum[] values = CountryEnum.values();
        for(CountryEnum element : values){
            if(element.getRetCode() == i){
                return element;
            }
        }
        return null;
    }
}
