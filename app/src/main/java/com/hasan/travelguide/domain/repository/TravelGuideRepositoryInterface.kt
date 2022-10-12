package com.hasan.travelguide.domain.repository


import com.hasan.travelguide.domain.model.remotemodel.AllTravelListItem
import com.hasan.travelguide.utils.Resource

import io.reactivex.Single


interface TravelGuideRepositoryInterface {

    suspend fun getAllListItem(): Resource<List<AllTravelListItem>>

    suspend fun getDealsFlightData():Resource<List<AllTravelListItem>>

    suspend fun getTopDestinationsData():Resource<List<AllTravelListItem>>
}