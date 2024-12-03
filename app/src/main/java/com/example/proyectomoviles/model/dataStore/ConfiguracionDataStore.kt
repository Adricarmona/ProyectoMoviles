package com.example.proyectomoviles.model.dataStore

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.dataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map


class ConfiguracionDataStore(private val context: Context) {

    companion object {
        private val Context.dataStoree: DataStore<Preferences> by preferencesDataStore("configuracion")
        val IDIOMA = stringPreferencesKey("idioma")
        val CORREOS_PROMOCIONALES = booleanPreferencesKey("correosPromocionales")
        val CORREOS_NOTICIAS = booleanPreferencesKey("correosNoticias")
        val TERMINOS = booleanPreferencesKey("terminos")
        val PRIVACIDAD = booleanPreferencesKey("privacidad")
        val PAGINA = intPreferencesKey("0")
    }

    val getIdioma: Flow<String> = context.dataStoree.data
        .map { preferences ->
            preferences[IDIOMA] ?: "english"
    }

    suspend fun saveIdioma(idioma: String){
        context.dataStoree.edit { preferences ->
            preferences[IDIOMA] = idioma
        }
    }

    val getCorreosPromocionales: Flow<Boolean> = context.dataStoree.data
        .map { preferences ->
            preferences[CORREOS_PROMOCIONALES] ?: false
        }

    suspend fun saveCorreosPromocionales(correosPromocionales: Boolean){
        context.dataStoree.edit { preferences ->
            preferences[CORREOS_PROMOCIONALES] = correosPromocionales
        }
    }

    val getCorreosNoticias: Flow<Boolean> = context.dataStoree.data
        .map { preferences ->
            preferences[CORREOS_NOTICIAS] ?: false
        }

    suspend fun saveCorreosNoticias(correosNoticias: Boolean){
        context.dataStoree.edit { preferences ->
            preferences[CORREOS_NOTICIAS] = correosNoticias
        }
    }

    val getTerminos: Flow<Boolean> = context.dataStoree.data
        .map { preferences ->
            preferences[TERMINOS] ?: false
        }

    suspend fun saveTerminos(terminos: Boolean){
        context.dataStoree.edit { preferences ->
            preferences[TERMINOS] = terminos
        }
    }

    val getPrivacidad: Flow<Boolean> = context.dataStoree.data
        .map { preferences ->
            preferences[PRIVACIDAD] ?: false
        }

    suspend fun savePrivacidad(privacidad: Boolean) {
        context.dataStoree.edit { preferences ->
            preferences[PRIVACIDAD] = privacidad
        }
    }

    val getPagina: Flow<Int> = context.dataStoree.data
        .map { preferences ->
            preferences[PAGINA] ?: 1
        }

    suspend fun savePagina(pagina: Int) {
        context.dataStoree.edit { preferences ->
            preferences[PAGINA] = pagina
        }
    }

}
