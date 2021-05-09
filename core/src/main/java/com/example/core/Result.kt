package com.example.core

sealed class Result<out Model>
object Loading : Result<Nothing>()
data class Success<out Type>(val data: Type?) : Result<Type>()
data class Error(val throwable: Throwable) : Result<Nothing>()