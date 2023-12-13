package org.example

import kotlinx.coroutines.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.jackson.JacksonConverterFactory

//https://api.unsplash.com/photos/?client_id=YOUR_ACCESS_KEY
val startRequestUrl = "https://api.unsplash.com/search/photos?query=autumn&per_page=30&orientation=landscape&client_id=Abed2b9A8CYciNLGC3Ilzfwkw9Lh4-aINn6yKl7ZOxc"
val accesKey = "Abed2b9A8CYciNLGC3Ilzfwkw9Lh4-aINn6yKl7ZOxc"


suspend fun main(){


    val imageApi = RetroFitClient.retrofit.create(ImageApi::class.java)


    try {
        imageApi.getImages("autumn", 5, "landscape", "Abed2b9A8CYciNLGC3Ilzfwkw9Lh4-aINn6yKl7ZOxc")
            .enqueue(object : Callback<ImageDTO> {
                override fun onResponse(call: Call<ImageDTO>, response: Response<ImageDTO>) {
                    if (response.isSuccessful) {
                        val imageData = response.body()
                        println(imageData) // Process your response data here
                    } else {
                        println("Error: ${response.code()}")
                    }
                }

                override fun onFailure(call: Call<ImageDTO>, t: Throwable) {
                    println("Network request failed: ${t.message}")
                }
            })
    } catch (e: Exception) {
        println("Error: ${e.message}")
    }

}
