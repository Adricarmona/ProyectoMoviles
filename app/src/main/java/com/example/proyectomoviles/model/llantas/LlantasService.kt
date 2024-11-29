package com.example.proyectomoviles.model.llantas

import retrofit2.http.GET

interface LlantasService {
    @GET("8986f8f2-398e-45e5-8f8b-b39bd0081d3d")
    suspend fun getLlantas(): List<Llantas>
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