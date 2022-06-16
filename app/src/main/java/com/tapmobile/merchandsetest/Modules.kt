package com.tapmobile.myapplication

import com.tapmobile.myapplication.ui.MainActivityViewModel
import com.tapmobile.myapplication.usecases.GetInfoUseCase
import com.tapmobile.myapplication.usecases.GetInfoUseCaseImpl
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module


val useCaseModule = module {
    single<GetInfoUseCase> { GetInfoUseCaseImpl(get()) }
}


val presentationModule = module {
    viewModel { MainActivityViewModel(get()) }
}
