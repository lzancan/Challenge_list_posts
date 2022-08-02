package life.league.challenge.kotlin.data.response

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class UserResponse(
    val id: Int,
    val avatar: String?,
    val name: String?
)