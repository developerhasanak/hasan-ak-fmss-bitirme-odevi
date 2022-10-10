package com.hasan.travelguide.domain.repository


import com.hasan.travelguide.domain.model.remotemodel.AllTravelListItem

import io.reactivex.Single


interface TravelGuideRepositoryInterface {

    suspend fun getAllListItem(): Single<List<AllTravelListItem>>
}