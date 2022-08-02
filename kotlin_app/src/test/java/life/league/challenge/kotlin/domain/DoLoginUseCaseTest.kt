package life.league.challenge.kotlin.domain

import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import life.league.challenge.kotlin.TestHelperFactory.getAccountResponse
import life.league.challenge.kotlin.data.response.AccountResponse
import life.league.challenge.kotlin.domain.usecase.DoLogin
import org.junit.Assert
import org.junit.Test

class DoLoginUseCaseTest {
    private val repository: AppRepository = mockk()

    private val doLogin = DoLogin(repository)

    @Test
    fun `should call doLogin from AppRepository when invoked is called`() = runBlocking {
        val accountResponse = getAccountResponse()
        prepareScenario(accountResponse)

        val model = doLogin("user", "pass")

        coVerify {
            repository.login("user", "pass")
        }
        Assert.assertEquals(accountResponse.apiKey, model.apiKey)
    }

    private fun prepareScenario(
        accountResponse: AccountResponse = getAccountResponse()
    ) {
        coEvery {
            repository.login(any(), any())
        } returns accountResponse
    }
}