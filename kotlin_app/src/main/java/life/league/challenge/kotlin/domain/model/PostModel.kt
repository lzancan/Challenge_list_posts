package life.league.challenge.kotlin.domain.model

data class PostModel(
    val userId: Int,
    val id: Int,
    val userName: String,
    val userAvatar: String,
    val title: String,
    val body: String
)
