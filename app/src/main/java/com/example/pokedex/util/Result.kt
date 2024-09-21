package com.example.pokedex.util


sealed class ResultState<T>(val date: T? = null, val message: String? = null) {


    class Success<T>(date: T) : ResultState<T>(date)
    class Error<T>(message: String) : ResultState<T>(message = message, date = null)
    class Loading<T>() : ResultState<T>()
}