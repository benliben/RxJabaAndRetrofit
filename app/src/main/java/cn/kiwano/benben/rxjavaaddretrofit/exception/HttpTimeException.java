package cn.kiwano.benben.rxjavaaddretrofit.exception;

/**
 * Created by LiYuanxiong on 2016/9/13 9:03.
 * Desribe:
 */
public class HttpTimeException extends RuntimeException {

    public static final int NO_DATA = 0x2;

    public HttpTimeException(int resultCode) {
        this(getApiExceptionMessage(resultCode));
    }

    public HttpTimeException(String detailMessage) {
        super(detailMessage);
    }

    /**
     * 转换错误数据
     *
     * @param code
     * @return
     */
    private static String getApiExceptionMessage(int code) {
        String message = "";
        switch (code) {
            case NO_DATA:
                message = "无数据";
                break;
            default:
                message = "error";
                break;

        }
        return message;
    }

}
