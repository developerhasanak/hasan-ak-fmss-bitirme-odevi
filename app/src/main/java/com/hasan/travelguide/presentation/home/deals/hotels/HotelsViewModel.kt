package com.hasan.travelguide.presentation.home.deals.hotels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hasan.travelguide.data.repository.TravelRepository
import com.hasan.travelguide.domain.model.remotemodel.AllTravelListItem
import com.hasan.travelguide.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.*
import javax.inject.Inject

@HiltViewModel
class HotelsViewModel @Inject constructor(
    private val repository: TravelRepository
) : ViewModel(){

    val hotelList= MutableLiveData<Resource<List<AllTravelListItem>>>()

    fun hotelListApi(){
        hotelList.value = Resource.loading(null)
        CoroutineScope(Dispatchers.IO).launch {
            val response = repository.getAllListItem()
            withContext(Dispatchers.Main){
                hotelList.value = response
            }

        }
    }


}