package com.hasan.travelguide.domain.model.remotemodel


import com.google.gson.annotations.SerializedName

data class Image(
    @SerializedName("altText")
    val altText: Any,
    @SerializedName("height")
    val height: Int,
    @SerializedName("width")
    val width: Int,
    @SerializedName("url")
    val url: String,
    @SerializedName("isHeroImage")
    val isHeroImage: Boolean
)