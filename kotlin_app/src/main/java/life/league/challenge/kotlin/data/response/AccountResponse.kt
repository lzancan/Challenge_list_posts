package life.league.challenge.kotlin.data.response

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class AccountResponse(
    @field:Json(name = "api_key")
    val apiKey: String? = null
)
