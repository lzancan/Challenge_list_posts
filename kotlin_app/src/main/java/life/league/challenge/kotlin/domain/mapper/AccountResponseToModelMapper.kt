package life.league.challenge.kotlin.domain.mapper

import life.league.challenge.kotlin.domain.model.AccountModel
import life.league.challenge.kotlin.data.response.AccountResponse

object AccountResponseToModelMapper {
    fun AccountResponse.mapToModel() = AccountModel(
        apiKey = apiKey.orEmpty()
    )
}