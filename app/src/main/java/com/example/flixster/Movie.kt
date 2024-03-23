package com.example.flixster
import com.google.gson.annotations.SerializedName
class Movie {

    @SerializedName("title")
    var title: String? = null

    @SerializedName("poster_path")
    var posterLink : String? = null

    @SerializedName("vote_average")
    var rating : String? = null

    @SerializedName("backdrop_path")
    var backdrop : String? = null

    @SerializedName("overview")
    var description : String? = null

    @SerializedName("release_date")
    var date : String? = null






}