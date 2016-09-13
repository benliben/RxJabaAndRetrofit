package cn.kiwano.benben.rxjavaaddretrofit.entity;


import cn.kiwano.benben.rxjabaandretrofit.Constant;
import cn.kiwano.benben.rxjavaaddretrofit.http.HttpService;
import rx.Observable;
import rx.Subscriber;

/**
 * Created by LiYuanxiong on 2016/9/12 16:54.
 * Desribe:测试数据
 */
public class SubjectPost extends BaseEntity {
    //    回调sub
    private Subscriber mSubscriber;

    private String key;
    private String name;


    public SubjectPost(Subscriber getTopMovieOnNext, String key, String name) {
        this.mSubscriber = getTopMovieOnNext;
        this.key = key;
        this.name = name;
    }

    @Override
    public Observable getObservable(HttpService methods) {
        return methods.getMovie(key,name);
    }

    @Override
    public Subscriber getSubscirber() {
        return mSubscriber;
    }

}
