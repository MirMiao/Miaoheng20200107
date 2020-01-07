package com.bw.miaoheng20200107.api;

import com.bw.miaoheng20200107.entity.CartEntity;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Header;

/**
 * 时间 :2020/1/7  8:56
 * 作者 :苗恒
 * 功能 :
 */
public interface CartApiService {
    @GET("small/order/verify/v1/findShoppingCart")
    Observable<CartEntity> getCarts(@Header("userId") String userId, @Header("sessionId") String sessionId);
}
