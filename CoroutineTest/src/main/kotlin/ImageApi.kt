package org.example

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query
import java.awt.ComponentOrientation

interface ImageApi {
    //@GET("https://api.unsplash.com/search/photos?query=autumn&per_page=5&orientation=landscape&client_id=Abed2b9A8CYciNLGC3Ilzfwkw9Lh4-aINn6yKl7ZOxc")
    @GET("/search/photos")
    fun getImages(
        @Query("query") query : String,
        @Query("per_page") quantity : Int,
        @Query("orientation") orient: String,
        @Query("client_id") clientId: String
    ): Call<ImageDTO>
            //Call<List<ImageDTO>>
}



