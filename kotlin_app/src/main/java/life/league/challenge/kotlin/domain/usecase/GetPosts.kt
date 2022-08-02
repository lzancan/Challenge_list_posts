package life.league.challenge.kotlin.domain.usecase

import javax.inject.Inject
import life.league.challenge.kotlin.domain.AppRepository
import life.league.challenge.kotlin.domain.mapper.PostResponseToPostModelMapper.mapToModel
import life.league.challenge.kotlin.domain.model.PostModel

class GetPosts @Inject constructor(
    private val repository: AppRepository,
    private val getUsers: GetUsersUseCase
): GetPostsUseCase {
    override suspend operator fun invoke(apiKey: String): List<PostModel> {
        val users = getUsers(apiKey)
        return repository.getPosts(apiKey).map {
            it.mapToModel(users)
        }
    }
}