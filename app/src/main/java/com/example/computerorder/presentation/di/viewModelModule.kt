package com.example.computerorder.presentation.di

import com.example.computerorder.presentation.viewModels.DataSharedViewModel
import com.example.computerorder.presentation.viewModels.ItemsBottomFragmentViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel {
        ItemsBottomFragmentViewModel(
            generalInteractor = get()
        )
    }

    viewModel {
        DataSharedViewModel()
    }
}