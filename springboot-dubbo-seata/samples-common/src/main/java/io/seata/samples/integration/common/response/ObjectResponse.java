package io.seata.samples.integration.common.response;

import java.io.Serializable;

/**
 * @author: heshouyou
 * @date: 2018-07-03 16:55
 */
public class ObjectResponse<T> extends BaseResponse implements Serializable {
    private T data;

    private long time;

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public ObjectResponse() { }

    public ObjectResponse(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
