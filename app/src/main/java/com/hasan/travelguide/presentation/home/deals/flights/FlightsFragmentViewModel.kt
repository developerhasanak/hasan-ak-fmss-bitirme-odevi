package com.hasan.travelguide.presentation.home.deals.flights

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hasan.travelguide.domain.model.remotemodel.AllTravelListItem
import com.hasan.travelguide.domain.repository.TravelGuideRepositoryInterface
import com.hasan.travelguide.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class FlightsFragmentViewModel @Inject constructor(
    private val repository: TravelGuideRepositoryInterface
) : ViewModel(){


    val flightsList = MutableLiveData<Resource<List<AllTravelListItem>>>()

    fun getDataFromApi() {
        flightsList.value = Resource.loading(null)
        CoroutineScope(Dispatchers.IO).launch {
            val response = repository.getDealsFlightData()
            withContext(Dispatchers.Main){
                flightsList.value = response
            }
        }
    }
}