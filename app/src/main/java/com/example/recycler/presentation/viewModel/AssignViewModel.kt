package com.example.recycler.presentation.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.recycler.R
import com.example.recycler.domain.models.Assign

class AssignViewModel : ViewModel() {

    val items: LiveData<List<Assign>> get() = _items
    private val _items = MutableLiveData<List<Assign>>()

    init {
        load()
    }

    private fun load() {
        _items.value = listOf(
            Assign(
                R.drawable.ic_add_image
            )
        )
    }

    fun setItem(assign: Assign) {
        val list = _items.value?.toMutableList()
        list?.add(assign)
        _items.value = list
    }

}