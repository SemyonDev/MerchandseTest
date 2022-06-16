package com.tapmobile.myapplication.usecases

import com.tapmobile.myapplication.networking.ApiServices

class GetInfoUseCaseImpl(private val apiServices: ApiServices): GetInfoUseCase {
    override suspend fun getMernchandiseList() =  apiServices.getMerchandiseList()

}