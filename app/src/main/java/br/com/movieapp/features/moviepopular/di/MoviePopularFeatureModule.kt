package br.com.movieapp.features.moviepopular.di

import br.com.movieapp.features.moviepopular.data.repository.MoviePopularRepositoryImpl
import br.com.movieapp.features.moviepopular.data.source.MoviePopularRemoteDataSourceImpl
import br.com.movieapp.features.moviepopular.domain.repository.MoviePopularRepository
import br.com.movieapp.features.moviepopular.domain.source.MoviePopularRemoteDataSource
import br.com.movieapp.features.moviepopular.domain.usecase.GetMoviesPopularUseCase
import br.com.movieapp.framework.data.remote.service.MovieService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object MoviePopularFeatureModule {

    @Provides
    @Singleton
    fun provideMoviePopularRemoteDataSource(service: MovieService): MoviePopularRemoteDataSource {
        return MoviePopularRemoteDataSourceImpl(service)
    }

    @Provides
    @Singleton
    fun provideMoviePopularRepository(
        remoteDataSource: MoviePopularRemoteDataSource
    ): MoviePopularRepository {
        return MoviePopularRepositoryImpl(remoteDataSource)
    }

    @Provides
    @Singleton
    fun provideGetMoviesPopularUseCase(
        repository: MoviePopularRepository
    ): GetMoviesPopularUseCase {
        return GetMoviesPopularUseCase(repository)
    }
}