package com.hasan.travelguide.presentation.search

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
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class SearchFragmentViewNodel @Inject constructor(
    private val repository: TravelRepository
):ViewModel() {

    val topDestinatiosList = MutableLiveData<Resource<List<AllTravelListItem>>>()

    fun topDestinatiosApiData(){
        CoroutineScope(Dispatchers.IO).launch {
            val response = repository.getTopDestinationsData()
            withContext(Dispatchers.Main){
                topDestinatiosList.value = response
            }
        }
    }


}