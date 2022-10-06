package org.chubxu.common;

/**
 * @ClassName R
 * @Description 分页查询统一返回结果
 * @Since 1.0.0
 * @Date 2022/10/6 18:39
 * @Author chubxu
 */
public class R<T> {
    private Integer code;
    private Integer msg;
    private T data;

    public R<T> ok() {
        R<T> r = new R<T>();
        r.setCode(0);
        return r;
    }

    public R<T> setData(T data) {
        this.data = data;
        return this;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }

    public Integer getMsg() {
        return msg;
    }

    public void setMsg(Integer msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }
}

