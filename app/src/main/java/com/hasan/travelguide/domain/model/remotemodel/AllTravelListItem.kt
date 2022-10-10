package com.hasan.travelguide.domain.model.remotemodel


import com.google.gson.annotations.SerializedName

data class AllTravelListItem(
    @SerializedName("title")
    var title: String?,
    @SerializedName("description")
    var description: String?,
    @SerializedName("category")
    var category: String?,
    @SerializedName("country")
    var country: String?,
    @SerializedName("city")
    var city: String?,
    @SerializedName("images")
    var images: List<Image>?,
    @SerializedName("isBookmark")
    var isBookmark: Boolean?,
    @SerializedName("id")
    var id: String
)