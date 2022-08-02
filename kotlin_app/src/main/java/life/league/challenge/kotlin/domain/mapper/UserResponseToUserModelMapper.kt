package life.league.challenge.kotlin.domain.mapper

import life.league.challenge.kotlin.data.response.UserResponse
import life.league.challenge.kotlin.domain.model.UserModel

object UserResponseToUserModelMapper {
    fun UserResponse.mapToModel() = UserModel(
        id = id,
        avatar = avatar.orEmpty(),
        name = name.orEmpty()
    )
}