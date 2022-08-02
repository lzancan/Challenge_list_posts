package life.league.challenge.kotlin

import life.league.challenge.kotlin.data.response.AccountResponse
import life.league.challenge.kotlin.data.response.PostResponse
import life.league.challenge.kotlin.data.response.UserResponse
import life.league.challenge.kotlin.domain.model.AccountModel
import life.league.challenge.kotlin.domain.model.PostModel
import life.league.challenge.kotlin.domain.model.UserModel

object TestHelperFactory {

    fun getPostResponse() = PostResponse(
        userId = 123,
        id = 123,
        title = "title-text",
        body = "body-text"
    )
    fun getPostResponseList() = listOf(getPostResponse())

    fun getUserResponse() = UserResponse(
        id = 123,
        avatar = "avatar-url",
        name = "name-text"
    )
    fun getListOfUserResponse() = listOf(getUserResponse())

    fun getUserModel() = UserModel(
        id = 123,
        avatar = "avatar-url",
        name = "name-text"
    )
    fun getUserModelList() = listOf(getUserModel())

    fun getPostModel() = PostModel(
        userId = 123,
        id = 123,
        userName = "name-text",
        userAvatar = "avatar-url",
        title = "title-text",
        body = "body-text"
    )
    fun getPostModelList() = listOf(getPostModel())

    fun getAccountResponse() = AccountResponse(
        apiKey = "key"
    )

    fun getAccountModel() = AccountModel(
        apiKey = "key"
    )
}