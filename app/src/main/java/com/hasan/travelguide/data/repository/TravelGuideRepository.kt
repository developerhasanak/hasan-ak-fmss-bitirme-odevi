package com.hasan.travelguide.data.repository


import com.hasan.travelguide.data.remote.TravelAPI
import com.hasan.travelguide.domain.model.remotemodel.AllTravelListItem
import com.hasan.travelguide.domain.repository.TravelGuideRepositoryInterface
import com.hasan.travelguide.utils.Resource
import javax.inject.Inject

class TravelGuideRepository @Inject constructor(
    private val travelApi: TravelAPI
) : TravelGuideRepositoryInterface {
    override suspend fun getAllListItem(): Resource<List<AllTravelListItem>> {
        return try {

            val response = travelApi.getAllList()
            if (response.isSuccessful) {
                response.body()?.let {
                    return@let Resource.success(it)
                } ?: Resource.error("Error", null)
            } else {
                Resource.error("Error", null)
            }
        } catch (e: Exception) {
            Resource.error("No data!", null)
        }
    }
}

