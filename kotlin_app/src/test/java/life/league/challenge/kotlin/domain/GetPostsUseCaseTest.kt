package life.league.challenge.kotlin.domain

import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import life.league.challenge.kotlin.TestHelperFactory.getPostResponseList
import life.league.challenge.kotlin.TestHelperFactory.getUserModelList
import life.league.challenge.kotlin.data.response.PostResponse
import life.league.challenge.kotlin.domain.usecase.GetPosts
import life.league.challenge.kotlin.domain.usecase.GetUsers
import org.junit.Assert
import org.junit.Test

class GetPostsUseCaseTest {

    private val repository: AppRepository = mockk()
    private val getUsers: GetUsers = mockk()

    private val getPosts = GetPosts(repository, getUsers)

    @Test
    fun `should call getPosts from AppRepository when invoked is called`() = runBlocking {
        val listOfPosts = getPostResponseList()
        prepareScenario(listOfPosts)

        val list = getPosts("key")

        coVerify {
            repository.getPosts("key")
        }
        Assert.assertEquals(listOfPosts.size, list.size)
    }

    private fun prepareScenario(
        listOfPosts: List<PostResponse> = getPostResponseList(),
    ) {
        coEvery {
            repository.getPosts(any())
        } returns listOfPosts
        coEvery { getUsers.invoke(any()) } returns getUserModelList()
    }
}