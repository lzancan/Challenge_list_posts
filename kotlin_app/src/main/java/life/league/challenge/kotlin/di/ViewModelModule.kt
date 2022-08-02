package life.league.challenge.kotlin.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import life.league.challenge.kotlin.data.AppDefaultRepository
import life.league.challenge.kotlin.data.datasource.RemoteDataSource
import life.league.challenge.kotlin.data.datasource.RemoteDefaultDataSource
import life.league.challenge.kotlin.domain.AppRepository
import life.league.challenge.kotlin.domain.usecase.DoLogin
import life.league.challenge.kotlin.domain.usecase.DoLoginUseCase
import life.league.challenge.kotlin.domain.usecase.GetPosts
import life.league.challenge.kotlin.domain.usecase.GetPostsUseCase
import life.league.challenge.kotlin.domain.usecase.GetUsers
import life.league.challenge.kotlin.domain.usecase.GetUsersUseCase

@Module
@InstallIn(ViewModelComponent::class)
abstract class ViewModelModule {

    @Binds
    abstract fun bindLoginUseCase(loginUseCase: DoLogin): DoLoginUseCase

    @Binds
    abstract fun bindGetUsersUseCase(getUsersUseCase: GetUsers): GetUsersUseCase

    @Binds
    abstract fun bindGetPostsUseCase(getPostsUseCase: GetPosts): GetPostsUseCase

    @Binds
    abstract fun bindAppRepository(repository: AppDefaultRepository): AppRepository

    @Binds
    abstract fun bindAppRemoteDataSource(remoteDataSource: RemoteDefaultDataSource): RemoteDataSource
}