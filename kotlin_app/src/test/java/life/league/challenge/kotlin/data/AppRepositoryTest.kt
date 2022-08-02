package life.league.challenge.kotlin.data

import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import life.league.challenge.kotlin.TestHelperFactory.getAccountResponse
import life.league.challenge.kotlin.TestHelperFactory.getListOfUserResponse
import life.league.challenge.kotlin.TestHelperFactory.getPostResponseList
import life.league.challenge.kotlin.data.datasource.RemoteDataSource
import life.league.challenge.kotlin.data.response.AccountResponse
import life.league.challenge.kotlin.data.response.PostResponse
import life.league.challenge.kotlin.data.response.UserResponse
import org.junit.Assert
import org.junit.Test

class AppRepositoryTest {

    private val remoteDataSource: RemoteDataSource = mockk()

    private val repository = AppDefaultRepository(remoteDataSource)

    @Test
    fun `should call getPosts from RemoteDataSource when getPosts from repository is called`() = runBlocking {
        val listOfPosts = getPostResponseList()
        prepareScenario(postsList = listOfPosts)

        val posts = repository.getPosts("key")

        coVerify {
            remoteDataSource.getPosts("key")
        }
        Assert.assertEquals(listOfPosts, posts)
    }

    @Test
    fun `should call getUsers from RemoteDataSource when getUsers from repository is called`() = runBlocking {
        val listOfUsers = getListOfUserResponse()
        prepareScenario()

        val users = repository.getUsers("key")

        coVerify {
            remoteDataSource.getUsers("key")
        }
        Assert.assertEquals(listOfUsers, users)
    }

    @Test
    fun `should call login from RemoteDataSource when login from repository is called`() = runBlocking {
        val accountResponse = getAccountResponse()
        prepareScenario()

        val account = repository.login("user", "pass")

        coVerify {
            remoteDataSource.login("user", "pass")
        }
        Assert.assertEquals(accountResponse, account)
    }

    private fun prepareScenario(
        usersList: List<UserResponse> = getListOfUserResponse(),
        postsList: List<PostResponse> = getPostResponseList(),
        accountResponse: AccountResponse = getAccountResponse()
    ) {
        coEvery {
            remoteDataSource.getPosts(any())
        } returns postsList
        coEvery {
            remoteDataSource.getUsers(any())
        } returns usersList
        coEvery {
            remoteDataSource.login(any(), any())
        } returns accountResponse
    }

}