package com.hasan.travelguide.data.repository

import com.hasan.travelguide.data.remote.TravelAPI
import com.hasan.travelguide.domain.model.remotemodel.AllTravelListItem
import com.hasan.travelguide.domain.repository.TravelGuideRepositoryInterface
import com.hasan.travelguide.utils.Resource
import io.reactivex.Observable
import io.reactivex.Single
import javax.inject.Inject

class TravelRepository @Inject constructor(
    private val travelAPI: TravelAPI
):TravelGuideRepositoryInterface {

    override suspend fun getAllListItem(): Resource<List<AllTravelListItem>> {
        return try {
            val response = travelAPI.getDealsAllList()
            if (response.isSuccessful){
                response.body()?.let {
                    return@let Resource.success(it)
                } ?: Resource.error("Error",null)

            } else{
                Resource.error("Error",null)
            }
        } catch (e:Exception){
            Resource.error("${e.printStackTrace()}",null)

        }
    }

    override suspend fun getDealsFlightData(): Resource<List<AllTravelListItem>> {
        return try {
            val response = travelAPI.getDealsFlightList()
            if (response.isSuccessful){
                response.body()?.let {
                    return@let Resource.success(it)
                } ?: Resource.error("Error",null)

            } else{
                Resource.error("Error",null)
            }
        } catch (e:Exception){
            Resource.error("${e.printStackTrace()}",null)

        }
    }

    override suspend fun getTopDestinationsData(): Resource<List<AllTravelListItem>> {
        return try {
            val response = travelAPI.getTopDestinationsList()
            if (response.isSuccessful){
                response.body()?.let {
                    return@let Resource.success(it)
                } ?: Resource.error("Error",null)

            } else{
                Resource.error("Error",null)
            }
        } catch (e:Exception){
            Resource.error("${e.printStackTrace()}",null)

        }
    }


}