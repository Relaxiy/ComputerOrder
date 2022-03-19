package com.example.recycler.presentation

import com.example.recycler.presentation.viewModel.AssignViewModel
import com.example.recycler.presentation.viewModel.RecyclerFragmentViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel {
        AssignViewModel()
    }

    viewModel {
        RecyclerFragmentViewModel(
            mainInteractor = get()
        )
    }
}