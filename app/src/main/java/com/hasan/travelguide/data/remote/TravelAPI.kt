package com.hasan.travelguide.data.remote

import com.hasan.travelguide.domain.model.remotemodel.AllTravelListItem
import retrofit2.Response
import retrofit2.http.GET

interface TravelAPI {

    @GET("AllTravelList/")
    suspend fun getAllList():Response<List<AllTravelListItem>>
}