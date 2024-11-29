package com.example.proyectomoviles.model.cocktail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class LlantasViewModel : ViewModel() {
    private val repository = LlantasRepository()

    private val _llantas = MutableLiveData<List<LlantasData>>()
    val llantas: LiveData<List<LlantasData>> = _llantas

    fun fetchCocktails() {
        viewModelScope.launch {
            try {
                val cards = repository.getLlantas()
                _llantas.value = cards
            } catch (e: Exception) {
                // Handle error
            }
        }
    }
}