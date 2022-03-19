package com.example.recycler.domain.di

import com.example.recycler.data.repositoryes.AssignAndAttachmentsRepository
import com.example.recycler.data.repositoryes.DescriptionAndTodoRepository
import com.example.recycler.data.repositoryes.TaskAndDateRepository
import com.example.recycler.domain.MainInteractor
import com.example.recycler.domain.MainInteractorImpl
import com.example.recycler.domain.useCases.*
import org.koin.dsl.module

val domainModule = module {

    single<AssignAndAttachmentsUseCase> {
        AssignAndAttachmentsUseCaseImpl(
            assignAndAttachmentsRepository = AssignAndAttachmentsRepository
        )
    }

    single<DescriptionAndTodoUseCase> {
        DescriptionAndTodoUseCaseImpl(
            descriptionAndTodoRepository = DescriptionAndTodoRepository
        )
    }

    single<TaskAndDateUseCase> {
        TaskAndDateUseCaseImpl(
            taskAndDateRepository = TaskAndDateRepository
        )
    }

    single<MainInteractor> {
        MainInteractorImpl(
            assignAndAttachmentsUseCase = get(),
            descriptionAndTodoUseCase = get(),
            taskAndDateUseCase = get()
        )
    }
}