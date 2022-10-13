package com.codepath.articlesearch
import android.support.annotation.Keep
import com.google.gson.annotations.SerializedName
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import com.codepath.articlesearch.BaseResponse


@Keep
@Serializable
data class BaseResponse(
    @SerialName("results")
    val results: List<Flix>?
)
@Keep
@Serializable
data class Flix (


    @JvmField
    @SerialName("title")
    var title: String? = null,


    @SerialName("poster_path")
    var movieImageUrl: String? = null,


    @SerialName("overview")
    var description: String? = null,

    @SerialName("backdrop_path")
    var backdrop: String? = null,

    @SerialName("vote_average")
    var vote: String? = null,

    @SerialName("release_date")
    var release: String? = null,

    @SerialName("original_language")
    var language: String? = null





) : java.io.Serializable