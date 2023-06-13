package org.bmsk.mediaexplorer.network

import io.reactivex.rxjava3.core.Observable
import org.bmsk.mediaexplorer.model.ImageListResponse
import org.bmsk.mediaexplorer.model.VideoListResponse
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface SearchService {
    @Headers("Authorization: KakaoAK 749c24031e39cebe1f6c9085fb227e94")
    @GET("image")
    fun searchImage(@Query("query") query: String): Observable<ImageListResponse>

    @Headers("Authorization: KakaoAK 749c24031e39cebe1f6c9085fb227e94")
    @GET("vclip")
    fun searchVideo(@Query("query") query: String): Observable<VideoListResponse>
}