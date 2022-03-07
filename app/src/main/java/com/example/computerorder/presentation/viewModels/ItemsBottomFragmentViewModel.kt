package com.example.computerorder.presentation.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.computerorder.domain.GeneralInteractor
import com.example.computerorder.domain.models.GraphicCard
import com.example.computerorder.domain.models.Monitor
import com.example.computerorder.domain.models.OperationSystem
import kotlinx.coroutines.launch

class ItemsBottomFragmentViewModel(private val generalInteractor: GeneralInteractor) : ViewModel() {

    val graphicCard: LiveData<List<GraphicCard>> get() = _graphicCards
    private val _graphicCards = MutableLiveData<List<GraphicCard>>()

    val monitors: LiveData<List<Monitor>> get() = _monitors
    private val _monitors = MutableLiveData<List<Monitor>>()

    val operationSystem: LiveData<List<OperationSystem>> get() = _operationSystem
    private val _operationSystem = MutableLiveData<List<OperationSystem>>()

    fun loadOperationSystems(){
        viewModelScope.launch {
            _operationSystem.value = generalInteractor.getOperationSystems()
        }
    }

    fun loadGraphicCards(){
        viewModelScope.launch {
            _graphicCards.value = generalInteractor.getGraphicCards()
        }
    }

    fun loadMonitors() {
        viewModelScope.launch {
            _monitors.value = generalInteractor.getMonitors()
        }
    }
}