package com.hasan.travelguide.presentation.home.deals.all


import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hasan.travelguide.domain.model.remotemodel.AllTravelListItem
import com.hasan.travelguide.domain.repository.TravelGuideRepositoryInterface
import com.hasan.travelguide.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AllfragmentViewModel @Inject constructor(
    private val repository: TravelGuideRepositoryInterface
) :ViewModel() {

    var allList = MutableLiveData<Resource<List<AllTravelListItem>>>()

    fun getAllItem(){
        allList.value = Resource.loading(null)
        viewModelScope.launch {
            val response = repository.getAllListItem()
            allList.value = response
        }
    }
}