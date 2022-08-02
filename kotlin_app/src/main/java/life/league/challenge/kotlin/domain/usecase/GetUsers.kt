package life.league.challenge.kotlin.domain.usecase

import javax.inject.Inject
import life.league.challenge.kotlin.domain.AppRepository
import life.league.challenge.kotlin.domain.mapper.UserResponseToUserModelMapper.mapToModel
import life.league.challenge.kotlin.domain.model.UserModel

class GetUsers @Inject constructor(
    private val repository: AppRepository
): GetUsersUseCase {

    override suspend operator fun invoke(apiKey: String): List<UserModel> {
        return repository.getUsers(apiKey).map {
            it.mapToModel()
        }
    }
}