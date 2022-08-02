package life.league.challenge.kotlin.domain

import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import life.league.challenge.kotlin.TestHelperFactory.getListOfUserResponse
import life.league.challenge.kotlin.data.response.UserResponse
import life.league.challenge.kotlin.domain.usecase.GetUsers
import org.junit.Assert
import org.junit.Test

class GetUsersUseCaseTest {
    private val repository: AppRepository = mockk()

    private val getUsers = GetUsers(repository)

    @Test
    fun `should call getUsers from AppRepository when invoked is called`() = runBlocking {
        val listOfUsers = getListOfUserResponse()
        prepareScenario(listOfUsers)

        val list = getUsers("key")

        coVerify {
            repository.getUsers("key")
        }
        Assert.assertEquals(listOfUsers.size, list.size)
    }

    private fun prepareScenario(
        listOfUsers: List<UserResponse> = getListOfUserResponse()
    ) {
        coEvery {
            repository.getUsers(any())
        } returns listOfUsers
    }
}