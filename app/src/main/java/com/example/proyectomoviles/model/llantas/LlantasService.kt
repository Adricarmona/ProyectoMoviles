package com.example.proyectomoviles.model.llantas

import retrofit2.http.GET

interface LlantasService {
    @GET("839f1c1b-753b-4e9e-83f7-4f3ee1c58e0c")
    suspend fun getLlantas(): List<Llantas>
}

/*

https://run.mocky.io/v3/839f1c1b-753b-4e9e-83f7-4f3ee1c58e0c

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