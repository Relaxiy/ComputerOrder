package com.example.recycler.presentation.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.recycler.R
import com.example.recycler.domain.MainInteractor
import com.example.recycler.domain.models.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class RecyclerFragmentViewModel(private val mainInteractor: MainInteractor) : ViewModel() {

    val items: LiveData<List<GeneralItem>> get() = _items
    private val _items = MutableLiveData<List<GeneralItem>>()

    init {
        loadItems()
    }

    private fun loadItems() {

        viewModelScope.launch(Dispatchers.IO) {
            _items.postValue(mainInteractor.getItems())
        }
    }
}