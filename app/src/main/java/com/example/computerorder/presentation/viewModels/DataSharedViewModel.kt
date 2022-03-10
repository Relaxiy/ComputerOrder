package com.example.computerorder.presentation.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.computerorder.domain.models.*

class DataSharedViewModel : ViewModel() {

    val user: LiveData<User> get() = _user
    private val _user = MutableLiveData<User>()

    val graphicCards: LiveData<String> get() = _graphicCards
    private val _graphicCards = MutableLiveData("")

    val amount: LiveData<Int> get() = _amount
    private val _amount = MutableLiveData<Int>()

    val monitors: LiveData<String> get() = _monitors
    private val _monitors = MutableLiveData("")

    val operationSystem: LiveData<OperationSystem> get() = _operationSystem
    private val _operationSystem = MutableLiveData<OperationSystem>()

    val accessory: LiveData<Accessory> get() = _accessory
    private val _accessory = MutableLiveData<Accessory>()


    fun setUser(userItem: User){
        _user.value = userItem
    }

    fun setGraphicCard(graphicCardItem: String){
        _graphicCards.value += "$graphicCardItem, "
    }

    fun setAmount(itemsAmount: Int){
        _amount.value = itemsAmount
    }
    fun setMonitor(monitorItem: String){
        _monitors.value += "$monitorItem, "
    }

    fun setOperationSystem(operationSystemItem: OperationSystem){
        _operationSystem.value = operationSystemItem
    }

    fun setAccessory(accessoryItem: Accessory?){
        _accessory.value = accessoryItem
    }
}