package com.hasan.travelguide.domain.repository


import com.hasan.travelguide.domain.model.remotemodel.AllTravelListItem
import com.hasan.travelguide.utils.Resource


interface TravelGuideRepositoryInterface {

    suspend fun getAllListItem(): Resource<List<AllTravelListItem>>
}