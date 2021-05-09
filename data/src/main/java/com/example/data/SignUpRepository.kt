package com.example.data

import com.example.core.Result
import com.example.core.Success
import com.example.data.models.SignUpModel
import javax.inject.Inject

class SignUpRepository @Inject constructor() : ISignUpRepository {
    override suspend fun signUpUser(model: SignUpModel): Result<Unit> {
        return Success(Unit)
    }
}