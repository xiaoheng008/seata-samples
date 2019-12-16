package io.seata.samples.integration.common.enums;

/**
 * 功能：
 * 详细：
 *
 * @author xiaoheng 2019-11-29
 */
public enum WalletSource {
    ORDER((short)1),
    ;

    private short source;

    public static WalletSource getInstance(short source) {
        for(WalletSource o: WalletSource.values()) {
            if(o.getSource() == source) {
                return o;
            }
        }
        return null;
    }

    WalletSource(short source) {
        this.source = source;
    }

    public short getSource() {
        return source;
    }}
