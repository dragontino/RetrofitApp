package com.example.retrofitapp.model

import com.google.gson.annotations.SerializedName

data class Movie(
    var name: String? = null,
    @SerializedName("realname")
    var realName: String? = null,
    var team: String? = null,
    @SerializedName("firstappearance")
    var firstAppearance: String? = null,
    @SerializedName("createdby")
    var createdBy: String? = null,
    var publisher: String? = null,
    @SerializedName("imageurl")
    var imageUrl: String? = null,
    var bio: String? = null
)
