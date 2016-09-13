package cn.kiwano.benben.rxjavaaddretrofit.entity;

import cn.kiwano.benben.rxjavaaddretrofit.exception.HttpTimeException;
import cn.kiwano.benben.rxjavaaddretrofit.http.HttpService;
import rx.Observable;
import rx.Subscriber;
import rx.functions.Func1;

/**
 * Created by LiYuanxiong on 2016/9/12 16:57.
 * Desribe: 请求数据统一封装类
 */
public abstract class BaseEntity<T> implements Func1<BaseResultEntity<T>,T> {

    /**
     * 设置参数
     *
     * @param methods
     * @return
     */
    public abstract Observable getObservable(HttpService methods);

    /**
     * 设置回调sub
     *
     * @return
     */
    public abstract Subscriber getSubscirber();


    @Override
    public T call(BaseResultEntity<T> httpResult) {
        if (httpResult.getError_code() == 0) {
            throw new HttpTimeException(httpResult.getReason());
        }
        return httpResult.getResult();
    }
}
