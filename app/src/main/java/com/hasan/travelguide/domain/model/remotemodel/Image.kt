package com.hasan.travelguide.domain.model.remotemodel


import com.google.gson.annotations.SerializedName

data class Image(
    @SerializedName("altText")
    var altText: Any?,
    @SerializedName("height")
    var height: Int?,
    @SerializedName("width")
    var width: Int?,
    @SerializedName("url")
    var url: String,
    @SerializedName("isHeroImage")
    var isHeroImage: Boolean?
)