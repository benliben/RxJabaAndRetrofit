package cn.kiwano.benben.rxjabaandretrofit.service;

import cn.kiwano.benben.rxjabaandretrofit.model.MovieModel;
import cn.kiwano.benben.rxjavaaddretrofit.entity.BaseResultEntity;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by LiYuanxiong on 2016/9/6 16:37.
 * Desribe:
 */
public interface MoveService {
    @GET("video")
    Call<MovieModel> getToMovie(@Query("key") String key,
                                @Query("q") String q,
                                @Query("size") int size);

    @GET("video")
    Observable<BaseResultEntity<MovieModel.ResultBean>> getToMovie2(@Query("key") String key,
                                                                    @Query("q") String q);

    @GET("void")
    Observable<MovieModel> getToMovie3(@Query("key") String key,
                                       @Query("q") String q,
                                       @Query("size") int size);
}
