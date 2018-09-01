package com.zgh.springboot.enums;

public enum IEnums {
    STATUS_200("200","success"),
    STATUS_400("400","error"),
    STATUS_404("404","error"),
    STATUS_500("000","error");

    IEnums(String desc, String value) {
        this.desc = desc;
        this.value = value;
    }

    private String desc;
    private String value;


    public String getDesc() {
        return desc;
    }


    public String getValue() {
        return value;
    }
}
