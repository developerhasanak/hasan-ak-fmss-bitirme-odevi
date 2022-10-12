package com.hasan.travelguide.data.remote

import com.hasan.travelguide.domain.model.remotemodel.AllTravelListItem
import io.reactivex.Observable
import retrofit2.Response
import retrofit2.http.GET

interface TravelAPI {

    @GET("AllTravelList?category=hotel|flight|transportation")
    suspend fun getDealsAllList(): Response<List<AllTravelListItem>>

    @GET("AllTravelList?category=flight")
   suspend fun getDealsFlightList():Response<List<AllTravelListItem>>

    @GET("AllTravelList?category=topdestination")
    suspend fun getTopDestinationsList():Response<List<AllTravelListItem>>
}