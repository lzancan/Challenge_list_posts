package life.league.challenge.kotlin.data.datasource

import life.league.challenge.kotlin.data.response.PostResponse
import life.league.challenge.kotlin.data.response.UserResponse
import life.league.challenge.kotlin.data.response.AccountResponse

interface RemoteDataSource {
    suspend fun login(username: String, password: String): AccountResponse
    suspend fun getUsers(apiKey: String): List<UserResponse>
    suspend fun getPosts(apiKey: String): List<PostResponse>
}