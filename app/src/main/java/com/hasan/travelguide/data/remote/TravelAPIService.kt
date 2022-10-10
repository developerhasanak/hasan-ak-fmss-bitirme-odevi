package com.hasan.travelguide.data.remote

import com.hasan.travelguide.domain.model.remotemodel.AllTravelListItem
import com.hasan.travelguide.utils.Constants.BASE_URL
import io.reactivex.Flowable
import io.reactivex.Observable
import io.reactivex.Single
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory


class TravelAPIService {

    private val api = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .build().create(TravelAPI::class.java)


    fun getDealsAllData(): Observable<List<AllTravelListItem>> {
        return api.getDealsAllList()
    }
    fun getDealsFlightData():Observable<List<AllTravelListItem>>{
        return  api.getDealsFlightList()
    }
}