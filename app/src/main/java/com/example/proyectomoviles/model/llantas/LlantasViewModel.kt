package com.example.proyectomoviles.model.llantas

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

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
                // Handle error
            }
        }
    }
}