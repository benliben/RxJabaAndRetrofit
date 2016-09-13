package cn.kiwano.benben.rxjavaaddretrofit.entity;

/**
 * Created by LiYuanxiong on 2016/9/12 16:58.
 * Desribe:回调信息统一封装类
 */
public class BaseResultEntity<T> {

    private int error_code;
    private String reason;
    private T result;

    public int getError_code() {
        return error_code;
    }

    public void setError_code(int error_code) {
        this.error_code = error_code;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }
}
