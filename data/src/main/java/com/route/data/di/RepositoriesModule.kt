package com.route.data.di

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.route.data.dataSourceImpl.online.AuthOnlineDataSourceImpl
import com.route.data.repositoryImpl.AuthRepositoryImpl
import com.route.domain.repository.AuthOnlineDataSource
import com.route.domain.repository.AuthRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoriesModule {
    @Provides
    @Singleton
    fun provideFirebaseAuth(): FirebaseAuth {
        return Firebase.auth
    }

    @Provides
    @Singleton
    fun provideAuthRepository(onlineDataSource: AuthOnlineDataSource): AuthRepository {
        return AuthRepositoryImpl(onlineDataSource)
    }

    @Provides
    @Singleton
    fun provideAuthOnlineDataSource(firebaseAuth: FirebaseAuth): AuthOnlineDataSource {
        return AuthOnlineDataSourceImpl(firebaseAuth)
    }
}
