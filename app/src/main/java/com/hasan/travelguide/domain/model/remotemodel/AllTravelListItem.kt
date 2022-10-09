package com.hasan.travelguide.domain.model.remotemodel


import com.google.gson.annotations.SerializedName

data class AllTravelListItem(
    @SerializedName("title")
    val title: String,
    @SerializedName("description")
    val description: String,
    @SerializedName("category")
    val category: String,
    @SerializedName("country")
    val country: String,
    @SerializedName("city")
    val city: String,
    @SerializedName("images")
    val images: List<Image>,
    @SerializedName("isBookmark")
    val isBookmark: Boolean,
    @SerializedName("id")
    val id: String
)