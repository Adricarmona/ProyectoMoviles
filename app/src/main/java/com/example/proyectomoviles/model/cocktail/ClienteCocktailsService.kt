package com.example.proyectomoviles.model.cocktail

import retrofit2.http.GET

interface ClienteCocktailsService {
    @GET("/lookup.php?i=11000")
    suspend fun getCocktails(): List<CocktailsData>
}