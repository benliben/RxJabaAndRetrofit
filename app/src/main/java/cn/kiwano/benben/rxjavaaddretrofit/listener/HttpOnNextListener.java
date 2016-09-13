package cn.kiwano.benben.rxjavaaddretrofit.listener;

/**
 * Created by LiYuanxiong on 2016/9/12 16:35.
 * Desribe:成功回调处理
 */
public interface HttpOnNextListener<T> {
     void onNext(T t);
}
