package com.example.proyectomoviles.dataStore

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.dataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

val Context.dataStore by preferencesDataStore(name = "cofiguracion")

class ConfiguracionDataStore(private val context: Context) {

    // Guardados aplicación
    suspend fun guardarOpciones(
        idioma: String,
        correosPromocionales: Boolean,
        correosNoticias: Boolean,
        terminos: Boolean,
        privacidad: Boolean,
        ayudaPagina: Boolean,
        sobreNosotrosPagina: Boolean,
        configuracionPagina: Boolean
    ) {
        context.dataStore.edit { preferences ->
            preferences[stringPreferencesKey("idioma")] = idioma
            preferences[booleanPreferencesKey("correosPromocionales")] = correosPromocionales
            preferences[booleanPreferencesKey("correosNoticias")] = correosNoticias
            preferences[booleanPreferencesKey("terminos")] = terminos
            preferences[booleanPreferencesKey("privacidad")] = privacidad
            preferences[booleanPreferencesKey("ayudaPagina")] = ayudaPagina
            preferences[booleanPreferencesKey("sobreNosotrosPagina")] = sobreNosotrosPagina
            preferences[booleanPreferencesKey("configuracionPagina")] = configuracionPagina
        }
    }

    private fun darOpciones() = context.dataStore.data.map { preferences ->
        configuracionInterfaz(
            idioma = preferences[stringPreferencesKey("idioma")].orEmpty(),
            correosPromocionales = preferences[booleanPreferencesKey("correosPromocionales")] ?: false,
            correosNoticias = preferences[booleanPreferencesKey("correosNoticias")] ?: false,
            terminos = preferences[booleanPreferencesKey("terminos")] ?: false,
            privacidad = preferences[booleanPreferencesKey("privacidad")] ?: false,
            ayudaPagina = preferences[booleanPreferencesKey("ayudaPagina")] ?: false,
            sobreNosotrosPagina =preferences[booleanPreferencesKey("sobreNosotrosPagina")] ?: false,
            configuracionPagina = preferences[booleanPreferencesKey("configuracionPagina")] ?: false,

        )
    }

}