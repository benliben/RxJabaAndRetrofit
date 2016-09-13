package cn.kiwano.benben.rxjabaandretrofit;

import cn.kiwano.benben.rxjabaandretrofit.MovieModel;
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
                                 @Query("q") String q);
    @GET("video")
    Observable<MovieModel> getToMovie2(@Query("key") String key,
                                       @Query("q") String q);


}
