package com.example.computerorder.presentation.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.computerorder.domain.models.*

class DataSharedViewModel : ViewModel() {

    val user: LiveData<User> get() = _user
    private val _user = MutableLiveData<User>()

    val graphicCard: LiveData<GraphicCard> get() = _graphicCard
    private val _graphicCard = MutableLiveData<GraphicCard>()

    val monitor: LiveData<Monitor> get() = _monitor
    private val _monitor = MutableLiveData<Monitor>()

    val operationSystem: LiveData<OperationSystem> get() = _operationSystem
    private val _operationSystem = MutableLiveData<OperationSystem>()

    val accessory: LiveData<Accessory> get() = _accessory
    private val _accessory = MutableLiveData<Accessory>()

    fun setUser(userItem: User){
        _user.value = userItem
    }

    fun setGraphicCard(graphicCardItem: GraphicCard){
        _graphicCard.value = graphicCardItem
    }

    fun setMonitor(monitorItem: Monitor){
        _monitor.value = monitorItem
    }

    fun setOperationSystem(operationSystemItem: OperationSystem){
        _operationSystem.value = operationSystemItem
    }

    fun setAccessory(accessoryItem: Accessory?){
        _accessory.value = accessoryItem
    }
}