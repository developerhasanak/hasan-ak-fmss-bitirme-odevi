package com.hasan.travelguide.presentation.home.deals.transportations

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.hasan.travelguide.data.repository.TravelRepository
import com.hasan.travelguide.domain.model.remotemodel.AllTravelListItem
import com.hasan.travelguide.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class TransportationViewModel @Inject constructor(
    private val repository: TravelRepository
) :ViewModel() {

    val transportationList = MutableLiveData<Resource<List<AllTravelListItem>>>()

    fun getTransportation(){
        CoroutineScope(Dispatchers.IO).launch {
            val reponse = repository.getAllListItem()
            withContext(Dispatchers.Main){
                transportationList.value = reponse
            }
        }
    }

}