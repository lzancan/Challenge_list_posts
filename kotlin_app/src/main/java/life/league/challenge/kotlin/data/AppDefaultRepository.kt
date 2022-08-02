package life.league.challenge.kotlin.data

import javax.inject.Inject
import life.league.challenge.kotlin.data.datasource.RemoteDataSource
import life.league.challenge.kotlin.data.response.PostResponse
import life.league.challenge.kotlin.data.response.UserResponse
import life.league.challenge.kotlin.domain.AppRepository
import life.league.challenge.kotlin.data.response.AccountResponse

class AppDefaultRepository @Inject constructor(
    private val dataSource: RemoteDataSource
): AppRepository {
    override suspend fun login(username: String, password: String): AccountResponse {
        return dataSource.login(username, password)
    }

    override suspend fun getUsers(apiKey: String): List<UserResponse> {
        return dataSource.getUsers(apiKey)
    }

    override suspend fun getPosts(apiKey: String): List<PostResponse> {
        return dataSource.getPosts(apiKey)
    }

}