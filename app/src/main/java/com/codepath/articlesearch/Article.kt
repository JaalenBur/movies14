package com.codepath.articlesearch
import android.support.annotation.Keep
import com.google.gson.annotations.SerializedName
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Keep
@Serializable
data class SearchNewsResponse(
    @SerialName("response")
    val response: BaseResponse?
)

@Keep
@Serializable
data class BaseResponse(
    @SerialName("results")
    val docs: List<Flix>?
)
@Keep
@Serializable
data class Flix (


    @JvmField
    @SerializedName("title")
    var title: String? = null,


    @SerializedName("poster_path")
    var movieImageUrl: String? = null,


    @SerializedName("overview")
    var description: String? = null,

    @SerializedName("backdrop_path")
    var backdrop: String? = null



)