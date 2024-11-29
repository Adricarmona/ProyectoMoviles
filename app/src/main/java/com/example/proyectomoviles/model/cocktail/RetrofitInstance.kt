package com.example.proyectomoviles.model.cocktail

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    private const val BASE_URL = "https://www.thecocktaildb.com/api/json/v1/1"

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


// la api https://www.thecocktaildb.com/api.php
//
// www.thecocktaildb.com/api/json/v1/1/lookup.php?i=11000
// el primer mojito es el 11000, por que yo que se pero el 10999 no existe
// buscar por ejemplo 25 primeros cubatas o algo asi

/*
{
    "drinks": [
        {
            "idDrink": "11000",
            "strDrink": "Mojito",
            "strDrinkAlternate": null,
            "strTags": "IBA,ContemporaryClassic,Alcoholic,USA,Asia,Vegan,Citrus,Brunch,Hangover,Mild",
            "strVideo": null,
            "strCategory": "Cocktail",
            "strIBA": "Contemporary Classics",
            "strAlcoholic": "Alcoholic",
            "strGlass": "Highball glass",
            "strInstructions": "Muddle mint leaves with sugar and lime juice. Add a splash of soda water and fill the glass with cracked ice. Pour the rum and top with soda water. Garnish and serve with straw.",
            "strInstructionsES": "Mezcle las hojas de menta con el azúcar y el zumo de lima. Añada un chorrito de soda y llene el vaso con hielo picado. Verter el ron y completar con soda. Decorar y servir con pajita.",
            "strInstructionsDE": "Minzblätter mit Zucker und Limettensaft verrühren. Füge einen Spritzer Sodawasser hinzu und fülle das Glas mit gebrochenem Eis. Den Rum eingießen und mit Sodawasser übergießen. Garnieren und mit einem Strohhalm servieren.",
            "strInstructionsFR": "Mélanger les feuilles de menthe avec le sucre et le jus de citron vert. Ajoutez un filet d'eau gazeuse et remplissez le verre de glace concassée. Verser le rhum et compléter avec de l'eau gazeuse. Décorer et servir avec une paille.",
            "strInstructionsIT": "Pestare le foglie di menta con lo zucchero e il succo di lime.\r\nAggiungere una spruzzata di acqua di seltz e riempi il bicchiere con ghiaccio tritato.\r\nVersare il rum e riempire con acqua di seltz.\r\nGuarnire con una fetta di lime, servire con una cannuccia.",
            "strInstructionsZH-HANS": null,
            "strInstructionsZH-HANT": null,
            "strDrinkThumb": "https://www.thecocktaildb.com/images/media/drink/metwgh1606770327.jpg",
            "strIngredient1": "Light rum",
            "strIngredient2": "Lime",
            "strIngredient3": "Sugar",
            "strIngredient4": "Mint",
            "strIngredient5": "Soda water",
            "strIngredient6": null,
            "strIngredient7": null,
            "strIngredient8": null,
            "strIngredient9": null,
            "strIngredient10": null,
            "strIngredient11": null,
            "strIngredient12": null,
            "strIngredient13": null,
            "strIngredient14": null,
            "strIngredient15": null,
            "strMeasure1": "2-3 oz ",
            "strMeasure2": "Juice of 1 ",
            "strMeasure3": "2 tsp ",
            "strMeasure4": "2-4 ",
            "strMeasure5": null,
            "strMeasure6": null,
            "strMeasure7": null,
            "strMeasure8": null,
            "strMeasure9": null,
            "strMeasure10": null,
            "strMeasure11": null,
            "strMeasure12": null,
            "strMeasure13": null,
            "strMeasure14": null,
            "strMeasure15": null,
            "strImageSource": "https://pixabay.com/photos/cocktail-mojito-cocktail-recipe-5096281/",
            "strImageAttribution": "anilaha https://pixabay.com/users/anilaha-16242978/",
            "strCreativeCommonsConfirmed": "Yes",
            "dateModified": "2016-11-04 09:17:09"
        }
    ]
}
 */