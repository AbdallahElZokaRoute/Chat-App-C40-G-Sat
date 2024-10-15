package com.route.data.di

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.route.data.dataSourceImpl.online.AuthOnlineDataSourceImpl
import com.route.data.dataSourceImpl.online.UserOnlineDataSourceImpl
import com.route.data.repositoryImpl.AuthRepositoryImpl
import com.route.data.repositoryImpl.UserRepositoryImpl
import com.route.domain.repository.AuthOnlineDataSource
import com.route.domain.repository.AuthRepository
import com.route.domain.repository.UserOnlineDataSource
import com.route.domain.repository.UserRepository
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
    fun provideFirebaseFirestore(): FirebaseFirestore {
        return Firebase.firestore
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

    @Provides
    @Singleton
    fun provideUserRepository(onlineDataSource: UserOnlineDataSource): UserRepository {
        return UserRepositoryImpl(onlineDataSource)
    }

    @Provides
    @Singleton
    fun provideUserOnlineDataSource(firebaseFirestore: FirebaseFirestore): UserOnlineDataSource {
        return UserOnlineDataSourceImpl(firebaseFirestore)
    }
}
