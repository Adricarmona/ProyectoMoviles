package com.example.proyectomoviles.model.llantas

class LlantasRepository {
    private val llantasService = RetrofitInstance.llantasService

    suspend fun getLlantas(): List<LlantasData> {
        return llantasService.getLlantas()
    }
}