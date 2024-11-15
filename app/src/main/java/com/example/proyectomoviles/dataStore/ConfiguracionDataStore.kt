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


class ConfiguracionDataStore(private val context: Context) {

    companion object {
        private val Context.dataStoree: DataStore<Preferences> by preferencesDataStore("configuracion")
        val IDIOMA = stringPreferencesKey("idioma")
        val CORREOS_PROMOCIONALES = booleanPreferencesKey("correosPromocionales")
        val CORREOS_NOTICIAS = booleanPreferencesKey("correosNoticias")
        val TERMINOS = booleanPreferencesKey("terminos")
        val PRIVACIDAD = booleanPreferencesKey("privacidad")
        val AYUDA_PAGINA = booleanPreferencesKey("ayudaPagina")
        val SOBRE_NOSOTROS_PAGINAS = booleanPreferencesKey("sobreNosotrosPagina")
        val CONFIGURACION_PAGINA = booleanPreferencesKey("configuracionPagina")
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

    val getAyudaPagina: Flow<Boolean> = context.dataStoree.data
        .map { preferences ->
            preferences[AYUDA_PAGINA] ?: false
        }

    suspend fun saveAyudaPagina(ayudaPagina: Boolean) {
        context.dataStoree.edit { preferences ->
            preferences[AYUDA_PAGINA] = ayudaPagina
        }
    }

    val getSobreNosotrosPagina: Flow<Boolean> = context.dataStoree.data
        .map { preferences ->
            preferences[SOBRE_NOSOTROS_PAGINAS] ?: false
        }

    suspend fun saveSobreNosotrosPagina(sobreNosotrosPagina: Boolean) {
        context.dataStoree.edit { preferences ->
            preferences[SOBRE_NOSOTROS_PAGINAS] = sobreNosotrosPagina
        }
    }

    val getConfiguracionPagina: Flow<Boolean> = context.dataStoree.data
        .map { preferences ->
            preferences[CONFIGURACION_PAGINA] ?: false
        }

    suspend fun saveConfiguracionPagina(configuracionPagina: Boolean) {
        context.dataStoree.edit { preferences ->
            preferences[CONFIGURACION_PAGINA] = configuracionPagina
        }
    }
}
