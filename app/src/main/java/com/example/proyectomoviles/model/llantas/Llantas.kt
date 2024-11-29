package com.example.proyectomoviles.model.llantas

data class Llantas(
    val brand: String, // la marca
    val model: String, // el modelo
    val size: String, // el tamaño (en Large, Medium, Small)
    val material: String, // el material
    val color: String, // el color
    val price: Int, // el precio
    val image_url: String, // la imagens

)

/*

https://run.mocky.io/v3/f9c49d59-3f0a-4fdf-b7fc-3d745be56d99

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