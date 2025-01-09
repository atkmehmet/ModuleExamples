package com.example.mylibrary.entity

sealed class UseCaseException (cause: Throwable):Throwable(cause) {

    class PostException(cause: Throwable):UseCaseException(cause)
}