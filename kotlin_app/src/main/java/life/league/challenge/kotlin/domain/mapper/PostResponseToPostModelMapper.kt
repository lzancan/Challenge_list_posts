package life.league.challenge.kotlin.domain.mapper

import life.league.challenge.kotlin.data.response.PostResponse
import life.league.challenge.kotlin.domain.model.PostModel
import life.league.challenge.kotlin.domain.model.UserModel

object PostResponseToPostModelMapper {
    fun PostResponse.mapToModel(users: List<UserModel>): PostModel{
        val user = users.firstOrNull { it.id == userId }
        return PostModel(
            userId = userId,
            id = id,
            userName = user?.name.orEmpty(),
            userAvatar = user?.avatar.orEmpty(),
            title = title.orEmpty(),
            body = body.orEmpty()
        )
    }
}