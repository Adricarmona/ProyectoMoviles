package com.example.proyectomoviles.dataStore

data class configuracionInterfaz(
    val idioma: String,
    val correosPromocionales: Boolean,
    val correosNoticias: Boolean,
    val terminos: Boolean,
    val privacidad: Boolean,
    val ayudaPagina: Boolean,
    val sobreNosotrosPagina: Boolean,
    val configuracionPagina: Boolean)
