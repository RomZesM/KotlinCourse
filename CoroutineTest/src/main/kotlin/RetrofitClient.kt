package org.example

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object RetroFitClient {
//https://api.unsplash.com/search/photos?query=autumn&per_page=5&orientation=landscape&client_id=Abed2b9A8CYciNLGC3Ilzfwkw9Lh4-aINn6yKl7ZOxc"
    //https://api.unsplash.com/
    private const val BASE_URL = "https://api.unsplash.com/"

     val retrofit: Retrofit by lazy {

         Retrofit.Builder()
             .baseUrl(BASE_URL)
             .addConverterFactory(GsonConverterFactory.create())
             .build()
     }

}

//object ApiClient {
//    val apiService: ImageApi by lazy{
//        RetroFitClient.retrofit.create(ImageApi::class.java)
//    }
//}