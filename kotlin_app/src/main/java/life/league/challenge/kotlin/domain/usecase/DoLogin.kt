package life.league.challenge.kotlin.domain.usecase

import javax.inject.Inject
import life.league.challenge.kotlin.domain.AppRepository
import life.league.challenge.kotlin.domain.mapper.AccountResponseToModelMapper.mapToModel
import life.league.challenge.kotlin.domain.model.AccountModel

class DoLogin @Inject constructor(
    private val repository: AppRepository
): DoLoginUseCase {
    override suspend operator fun invoke(username: String, password: String): AccountModel {
        return repository.login(username, password).mapToModel()
    }
}