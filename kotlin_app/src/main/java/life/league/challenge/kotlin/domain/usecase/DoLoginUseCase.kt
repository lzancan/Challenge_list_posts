package life.league.challenge.kotlin.domain.usecase

import life.league.challenge.kotlin.domain.model.AccountModel

interface DoLoginUseCase {
    suspend operator fun invoke(username: String, password: String): AccountModel
}