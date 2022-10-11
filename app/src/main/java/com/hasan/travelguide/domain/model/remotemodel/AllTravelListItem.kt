package com.hasan.travelguide.domain.model.remotemodel


import com.google.gson.annotations.SerializedName

data class AllTravelListItem(

    val title: String?,
    val description: String?,
    val category: String?,
    val country: String?,
    val city: String?,
    val images: List<Image>?,
    val isBookmark: Boolean?,
    var id: String
)