package com.example.article.data.repository

import android.util.Log
import retrofit2.Response
import java.io.IOException

open class BaseRepository {

    suspend fun <T : Any> safeApiCall(call: suspend () -> Response<T>, errorMesage: String): T? {

        val result: Result<T> = safeApiResult(call, errorMesage)
        var data: T? = null

        when (result) {
            is Result.Success -> data = result.data
            is Result.Error -> {
                Log.d("ErrorRepository", "${result.exception}")
            }
        }
        return data
    }

    private suspend fun <T : Any> safeApiResult(
        call: suspend () -> Response<T>,
        errorMesage: String
    ): Result<T> {
        val response = call.invoke()
        if (response.isSuccessful) return Result.Success(response.body()!!)
        return Result.Error(IOException(errorMesage))
    }
}