package life.league.challenge.kotlin.presentation.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import life.league.challenge.kotlin.domain.model.AccountModel
import life.league.challenge.kotlin.domain.model.PostModel
import life.league.challenge.kotlin.domain.usecase.DoLoginUseCase
import life.league.challenge.kotlin.domain.usecase.GetPostsUseCase
import life.league.challenge.kotlin.util.SingleLiveEvent

private const val TAG = "AppViewModel"

@HiltViewModel
class AppViewModel @Inject constructor(
    private val doLogin: DoLoginUseCase,
    private val getPosts: GetPostsUseCase
) : ViewModel() {

    val postsRetrieved = SingleLiveEvent<Unit>()

    private var account: AccountModel? = null
    val posts = mutableListOf<PostModel>()

    fun init() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                account = doLogin("hello", "world")
                getUsersAndPosts()
            } catch (t : Throwable) {
                Log.e(TAG, t.message, t)
            }
        }
    }

    private suspend fun getUsersAndPosts() = account?.run{
        val list = getPosts(apiKey)
        posts.addAll(list)
        postsRetrieved.postValue(Unit)
    }
}