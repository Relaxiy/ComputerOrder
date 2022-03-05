package com.example.computerorder.domain.di

import com.example.computerorder.data.repositories.GraphicCardRepositoryImpl
import com.example.computerorder.data.repositories.MonitorsRepositoryImpl
import com.example.computerorder.data.repositories.OperationSystemRepositoryImpl
import com.example.computerorder.domain.GeneralInteractor
import com.example.computerorder.domain.GeneralInteractorImpl
import com.example.computerorder.domain.useCases.*
import com.example.computerorder.domain.repositories.GraphicCardRepository
import com.example.computerorder.domain.repositories.MonitorsRepository
import com.example.computerorder.domain.repositories.OperationSystemRepository
import org.koin.dsl.module

val domainModule = module {
    single<GraphicCardUseCase> {
        GraphicCardUseCaseImpl(
            graphicCardRepository = get()
        )
    }

    single<GraphicCardRepository> {
        GraphicCardRepositoryImpl()
    }

    single<MonitorUseCase> {
        MonitorUseCaseImpl(
            monitorsRepository = get()
        )
    }

    single<MonitorsRepository> {
        MonitorsRepositoryImpl()
    }

    single<OperationSystemUseCase> {
        OperationSystemUseCaseImpl(
            operationSystemRepository = get()
        )
    }

    single<OperationSystemRepository> {
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