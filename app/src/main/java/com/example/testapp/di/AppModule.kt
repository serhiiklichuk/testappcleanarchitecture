package com.example.testapp.di

import com.example.data.ISignUpRepository
import com.example.data.SignUpRepository
import com.example.domain.usecases.ISignUpUseCase
import com.example.domain.usecases.SignUpUseCase
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    fun providesSignUpUseCaseRepository(signUpUseCase: SignUpUseCase): ISignUpUseCase {
        return signUpUseCase
    }

    @Singleton
    @Provides
    fun providesSignUpRepository(signUpRepository: SignUpRepository): ISignUpRepository {
        return signUpRepository
    }
}