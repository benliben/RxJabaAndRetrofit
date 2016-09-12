package cn.kiwano.benben.rxjabaandretrofit.utils;

import java.util.concurrent.TimeUnit;

import cn.kiwano.benben.rxjabaandretrofit.Constant;
import cn.kiwano.benben.rxjabaandretrofit.http.HttpResult;
import cn.kiwano.benben.rxjabaandretrofit.model.MovieModel;
import cn.kiwano.benben.rxjabaandretrofit.service.MoveService;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by LiYuanxiong on 2016/9/6 17:01.
 * Desribe:
 */
public class HttpUtil {
    public static final String BASE_URL = Constant.BASE_URL;
    public static final int DEFAULT_TIMEOUT = 5;

    private Retrofit retrofit;
    private MoveService moveService;


    /*创建方法私有*/
    public HttpUtil() {
        /*手动创建一个OKHTTPClient并设置超时时间*/
        OkHttpClient.Builder httpClientBuilder = new OkHttpClient.Builder();
        httpClientBuilder.connectTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS);

        retrofit = new Retrofit.Builder()
                .client(httpClientBuilder.build())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .baseUrl(BASE_URL)
                .build();

        moveService = retrofit.create(MoveService.class);
    }

    /*在访问HttpUtils时创建单例*/
    private static class singletonHolder {
        private static final HttpUtil INSTANCE = new HttpUtil();
    }

    /*获取单例*/
    public static HttpUtil getInstance() {
        return singletonHolder.INSTANCE;
    }

//    public void getToMovie(Subscriber<MovieModel> subscriber, String key, String name) {
//        moveService.getToMovie2(key, name)
//                .subscribeOn(Schedulers.io())
//                .unsubscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(subscriber);
//
//    }

    public void getToMovie2(Subscriber<MovieModel> subscriber, String key, String name, int size) {
        moveService.getToMovie3(key, name, size)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }



    private class HttpResultFunc<T> implements Func1<HttpResult<T>,T>{

        @Override
        public T call(HttpResult<T> httpResult) {

            return null;
        }
    }
}
