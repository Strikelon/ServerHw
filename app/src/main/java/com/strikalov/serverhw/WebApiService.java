package com.strikalov.serverhw;


import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface WebApiService {

    @GET("users/{user}")
    Observable<AvatarPogo> loadAvatar(@Path("user") String user);

}
