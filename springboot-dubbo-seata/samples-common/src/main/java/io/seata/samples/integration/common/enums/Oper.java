package io.seata.samples.integration.common.enums;

/**
 * 功能：
 * 详细：
 *
 * @author xiaoheng 2019-11-29
 */
public enum Oper {
    SUB((short)1),
    ADD((short)2),
    ;

    private short oper;

    public static Oper getInstance(short oper) {
        for(Oper o: Oper.values()) {
            if(o.getOper() == oper) {
                return o;
            }
        }
        return null;
    }

    Oper(short oper) {
        this.oper = oper;
    }

    public short getOper() {
        return oper;
    }}
