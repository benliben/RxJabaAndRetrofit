package cn.kiwano.benben.rxjabaandretrofit.http;

/**
 * Created by LiYuanxiong on 2016/9/6 17:25.
 * Desribe: 相同格式的Http请求数据的封装
 */
public class HttpResult<T> {
    private int resultCode;
    private String resultMessage;

    private T data;
}
