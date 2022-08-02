package life.league.challenge.kotlin.data.response

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class PostResponse(
    val userId: Int,
    val id: Int,
    val title: String?,
    val body: String?
)