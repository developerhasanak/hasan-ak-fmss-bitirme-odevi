package com.hasan.travelguide.data.remote

import com.hasan.travelguide.domain.model.remotemodel.AllTravelListItem
import io.reactivex.Flowable
import io.reactivex.Observable
import io.reactivex.Single
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface TravelAPI {

    @GET("AllTravelList?category=hotel|flight|transportation")
     fun getDealsAllList():Observable<List<AllTravelListItem>>

    @GET("AllTravelList?category=flight")
    fun getDealsFlightList():Observable<List<AllTravelListItem>>
}