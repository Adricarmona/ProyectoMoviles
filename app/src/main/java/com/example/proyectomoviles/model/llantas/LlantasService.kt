package com.example.proyectomoviles.model.llantas

import retrofit2.http.GET

interface LlantasService {
    @GET("/f9c49d59-3f0a-4fdf-b7fc-3d745be56d99")
    suspend fun getLlantas(): List<LlantasData>
}

/*
// esto cambia cada vez que cambiamos la api
    https://run.mocky.io/v3/f9c49d59-3f0a-4fdf-b7fc-3d745be56d99

  "rims": [
    {
      "brand": "BBS",
      "model": "CH-R",
      "size": "Medium",
      "material": "Aluminum Alloy",
      "color": "Matte Black",
      "price": 350.99,
      "image_url": "https://example.com/images/bbs-chr.jpg"
    },
 */