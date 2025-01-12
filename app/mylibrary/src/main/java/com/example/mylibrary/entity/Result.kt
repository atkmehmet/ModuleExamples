package com.example.mylibrary.entity



sealed class Result<out T : Any> {
    data class Succes<out T :Any>(val data:T):Result<T>()
    class Error(val exception: UseCaseException):Result<Nothing>()
}
