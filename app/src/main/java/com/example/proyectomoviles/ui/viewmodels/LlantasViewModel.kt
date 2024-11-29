package com.example.proyectomoviles.ui.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.proyectomoviles.model.llantas.Llantas
import kotlinx.coroutines.launch
import com.example.proyectomoviles.model.llantas.LlantasRepository

class LlantasViewModel : ViewModel() {
    private val repository = LlantasRepository()

    private val _llantas = MutableLiveData<List<Llantas>>()
    val llantas: LiveData<List<Llantas>> = _llantas


    fun fetchLlantas() {
        viewModelScope.launch {
            try {
                val llanta = repository.getLlantas()
                _llantas.value = llanta

            } catch (e: Exception) {
                println(e)
            }
        }
    }
}