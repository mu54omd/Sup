package com.mu54omd.sup.data

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ArticleRaw(

    @SerialName("title")
    val title: String,

    @SerialName("description")
    val description: String?,

    @SerialName("urlToImage")
    val urlToImage: String?,

    @SerialName("publishedAt")
    val publishedAt: String,
)