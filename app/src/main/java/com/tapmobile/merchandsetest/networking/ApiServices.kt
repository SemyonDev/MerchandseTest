package com.tapmobile.myapplication.networking


import com.tapmobile.merchandsetest.entities.Merchandise
import com.tapmobile.merchandsetest.entities.MerchandiseList
import retrofit2.http.GET

interface ApiServices {

    @GET("/api/merchants/merchandises?merchantUserName=wokcano_tustin")
    suspend fun getMerchandiseList(): MerchandiseList

}

