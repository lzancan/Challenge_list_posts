package life.league.challenge.kotlin.domain.usecase

import life.league.challenge.kotlin.domain.model.UserModel

interface GetUsersUseCase {
    suspend operator fun invoke(apiKey: String): List<UserModel>
}