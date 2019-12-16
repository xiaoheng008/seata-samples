package io.seata.samples.integration.common.enums;

/**
 * 功能：
 * 详细：
 *
 * @author xiaoheng 2019-11-28
 */
public enum TccStatus {
    TRY((short)1),
    CONFIRM((short)2),
    CANCEL((short)3)
    ;
    private short status;

    public static TccStatus getInstance(short status) {
        for(TccStatus tccStatus: TccStatus.values()) {
            if(tccStatus.getStatus() == status) {
                return tccStatus;
            }
        }
        return null;
    }

    TccStatus(short status) {
        this.status = status;
    }

    public short getStatus() {
        return status;
    }}
