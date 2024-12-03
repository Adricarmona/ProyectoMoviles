package com.example.proyectomoviles.model.llantas

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    private const val BASE_URL = "https://run.mocky.io/v3/"

    private val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val llantasService: LlantasService by lazy {
        retrofit.create(LlantasService::class.java)
    }
}

/*

https://run.mocky.io/v3/8986f8f2-398e-45e5-8f8b-b39bd0081d3d

{
  "rims": [
    {
      "brand": "BBS",
      "model": "CH-R",
      "size": "Medium",
      "material": "Aluminum Alloy",
      "color": "Matte Black",
      "price": 35099,
      "image_url": "https://example.com/images/bbs-chr.jpg"
    },
 */