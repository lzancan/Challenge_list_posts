package life.league.challenge.kotlin.data.api

import life.league.challenge.kotlin.data.response.PostResponse
import life.league.challenge.kotlin.data.response.UserResponse
import life.league.challenge.kotlin.data.response.AccountResponse
import retrofit2.http.GET
import retrofit2.http.Header

interface Api {

    @GET("login")
    suspend fun login(
        @Header("Authorization")
        credentials: String?
    ): AccountResponse

    @GET("users")
    suspend fun getUsers(
        @Header("x-access-token") apiKey: String
    ): List<UserResponse>

    @GET("posts")
    suspend fun getPosts(
        @Header("x-access-token") apiKey: String
    ): List<PostResponse>

}