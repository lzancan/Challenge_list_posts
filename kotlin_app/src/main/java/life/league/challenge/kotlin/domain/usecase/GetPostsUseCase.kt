package life.league.challenge.kotlin.domain.usecase

import life.league.challenge.kotlin.domain.model.PostModel

interface GetPostsUseCase {
    suspend operator fun invoke(apiKey: String): List<PostModel>
}