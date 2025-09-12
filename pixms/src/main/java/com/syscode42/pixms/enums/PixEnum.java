package com.syscode42.pixms.enums;

public enum PixEnum {
    PF("pf"),
    PJ("pj");

    private final String value;

    PixEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
