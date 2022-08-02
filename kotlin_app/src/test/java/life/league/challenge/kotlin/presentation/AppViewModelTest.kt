package life.league.challenge.kotlin.presentation

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import life.league.challenge.kotlin.TestHelperFactory.getAccountModel
import life.league.challenge.kotlin.TestHelperFactory.getPostModelList
import life.league.challenge.kotlin.domain.model.AccountModel
import life.league.challenge.kotlin.domain.model.PostModel
import life.league.challenge.kotlin.domain.usecase.DoLoginUseCase
import life.league.challenge.kotlin.domain.usecase.GetPostsUseCase
import life.league.challenge.kotlin.presentation.viewmodel.AppViewModel
import org.junit.Rule
import org.junit.Test

@ExperimentalCoroutinesApi
class AppViewModelTest {

    @get:Rule
    val instantTask = InstantTaskExecutorRule()
    @get:Rule
    val coroutinesTestRule = CoroutineTestRule()

    private val doLoginUseCase: DoLoginUseCase = mockk(relaxed = true)
    private val getPostsUseCase: GetPostsUseCase = mockk(relaxed = true)

    private lateinit var viewModel: AppViewModel

    @Test
    fun `should call login usecase when init viewmodel`() = runBlocking {
        prepareScenario()

        viewModel.init()

        coVerify(exactly = 1) {
            doLoginUseCase(any(), any())
        }
    }

    @Test
    fun `should call getPosts usecase when init viewmodel`() = runBlocking {
        prepareScenario()

        viewModel.init()

        coVerify(exactly = 1) {
            getPostsUseCase(any())
        }
    }


    private fun prepareScenario(
        postsList: List<PostModel> = getPostModelList(),
        accountModel: AccountModel = getAccountModel()
    ) {
        coEvery { getPostsUseCase(any()) } returns postsList
        coEvery { doLoginUseCase(any(), any()) } returns accountModel
        viewModel = AppViewModel(
            doLoginUseCase,
            getPostsUseCase
        )
    }
}