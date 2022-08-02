package life.league.challenge.kotlin.data.datasource

import javax.inject.Inject
import life.league.challenge.kotlin.data.api.Api
import life.league.challenge.kotlin.data.response.PostResponse
import life.league.challenge.kotlin.data.response.UserResponse
import life.league.challenge.kotlin.data.response.AccountResponse

class RemoteDefaultDataSource @Inject constructor(
    private val api: Api
): RemoteDataSource {
    override suspend fun login(username: String, password: String): AccountResponse {
        return api.login("Basic " + android.util.Base64.encodeToString("$username:$password".toByteArray(), android.util.Base64.NO_WRAP))
    }

    override suspend fun getUsers(apiKey: String): List<UserResponse> {
        return api.getUsers(apiKey)
    }

    override suspend fun getPosts(apiKey: String): List<PostResponse> {
        return api.getPosts(apiKey)
    }
}