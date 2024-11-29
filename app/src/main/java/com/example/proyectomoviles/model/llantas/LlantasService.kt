package com.example.proyectomoviles.model.llantas

import retrofit2.http.GET

interface LlantasService {
    @GET("/lookup.php?i=11000")
    suspend fun getLlantas(): List<LlantasData>
}