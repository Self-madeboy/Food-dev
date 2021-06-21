package com.life.common.enums;

/**
 * @author jc
 */

public enum Sex {
    woman(0, "woman"),
    man(1, "man"),
    secret(2, "保密");
    public final Integer type;
    public final String value;


    Sex(Integer type, String value) {
        this.type = type;
        this.value = value;
    }
}
