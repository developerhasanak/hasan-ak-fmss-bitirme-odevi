package com.hasan.travelguide.domain.model.remotemodel


import com.google.gson.annotations.SerializedName

data class Image(

    val altText: Any?,
    val height: Int?,
    val width: Int?,
    val url: String,
    val isHeroImage: Boolean?
)