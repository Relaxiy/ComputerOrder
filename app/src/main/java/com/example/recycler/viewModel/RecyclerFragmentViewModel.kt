package com.example.recycler.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.recycler.R
import com.example.recycler.models.*

class RecyclerFragmentViewModel : ViewModel() {

    val items: LiveData<List<GeneralItem>> get() = _items
    private val _items = MutableLiveData<List<GeneralItem>>()

    init {
        loadItems()
    }

    private fun loadItems() {

        _items.value = listOf(
            Task(
                task = "hello? hello! I see you? I see you!"
            ),
            Date(
                day = "Today",
                hours = "12:05"
            ),
            Description(
                description = "I find you in my repository on GitHub. Why you see that?"
            ),
            TodoItem(
                radioButtonFirstText = "Toast",
                radioButtonSecondText = "SnackBar"
            ),
            Assign(
                R.drawable.ic_add_image
            ),
            Attachment(
                imageId = R.drawable.ic_wallet,
                imageName = "image"
            ),
            Attachment(
                imageId = R.drawable.ic_wallet,
                imageName = "image"
            )
        )
    }
}