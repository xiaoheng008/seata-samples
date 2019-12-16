package io.seata.samples.integration.common.exception;

import org.apache.dubbo.rpc.RpcException;

/**
 * 功能：
 * 详细：
 *
 * @author xiaoheng 2019-11-28
 */
public class ServiceException extends RpcException {
    private int maimaiCode;

    public ServiceException() {
        super(3);
    }

    public ServiceException(int maimaiCode, String message) {
        super(3, message);
        this.maimaiCode = maimaiCode;
    }

    public ServiceException(String message) {
        super(3, message);
        this.setMaimaiCode(400);
    }

    public ServiceException(String message, Throwable cause) {
        super(3, message, cause);
        this.setMaimaiCode(400);
    }

    public ServiceException(int maimaiCode, String message, Throwable cause) {
        super(3, message, cause);
        this.maimaiCode = maimaiCode;
    }

    public int getMaimaiCode() {
        return this.maimaiCode;
    }

    public void setMaimaiCode(int maimaiCode) {
        this.maimaiCode = maimaiCode;
    }
}
