package com.life.common.enums;

/**
 * @author jc
 */

public enum YesOrNo {
    YES(1, "yes"),
    NO(0, "no");
    public final Integer type;
    public final String value;


    YesOrNo(Integer type, String value) {
        this.type = type;
        this.value = value;
    }
}
