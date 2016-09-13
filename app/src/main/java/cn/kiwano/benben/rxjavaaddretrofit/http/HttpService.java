package cn.kiwano.benben.rxjavaaddretrofit.http;

import cn.kiwano.benben.rxjabaandretrofit.MovieModel;
import cn.kiwano.benben.rxjavaaddretrofit.entity.BaseResultEntity;
import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by LiYuanxiong on 2016/9/12 17:01.
 * Desribe: 统一接口数据
 */
public interface HttpService {

    @GET("video")
    Observable<BaseResultEntity<MovieModel.ResultBean>> getMovie(@Query("key")String key,
                                                                 @Query("q")String q);


}
