package com.example.computerorder.domain.di

import com.example.computerorder.data.api.GraphicCardApi
import com.example.computerorder.data.api.MonitorApi
import com.example.computerorder.data.api.OperationSystemApi
import com.example.computerorder.data.repositories.GraphicCardRepositoryImpl
import com.example.computerorder.data.repositories.MonitorsRepositoryImpl
import com.example.computerorder.data.repositories.OperationSystemRepositoryImpl
import com.example.computerorder.domain.GeneralInteractor
import com.example.computerorder.domain.GeneralInteractorImpl
import com.example.computerorder.domain.useCases.*
import org.koin.dsl.module

val domainModule = module {
    single<GraphicCardUseCase> {
        GraphicCardUseCaseImpl(
            graphicCardApi = get()
        )
    }

    single<GraphicCardApi> {
        GraphicCardRepositoryImpl()
    }

    single<MonitorUseCase> {
        MonitorUseCaseImpl(
            monitorApi = get()
        )
    }

    single<MonitorApi> {
        MonitorsRepositoryImpl()
    }

    single<OperationSystemUseCase> {
        OperationSystemUseCaseImpl(
            operationSystemApi = get()
        )
    }

    single<OperationSystemApi> {
        OperationSystemRepositoryImpl()
    }

    single<GeneralInteractor> {
        GeneralInteractorImpl(
            graphicCardUseCase = get(),
            monitorUseCase = get(),
            operationSystemUseCase = get()
        )
    }
}