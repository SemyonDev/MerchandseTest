package com.tapmobile.myapplication.usecases

import com.tapmobile.merchandsetest.entities.Merchandise
import com.tapmobile.merchandsetest.entities.MerchandiseList


interface GetInfoUseCase  {
    suspend fun getMernchandiseList(): MerchandiseList
}