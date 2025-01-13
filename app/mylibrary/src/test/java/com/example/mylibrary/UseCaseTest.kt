package com.example.mylibrary

import androidx.compose.runtime.ExperimentalComposeApi
import com.example.mylibrary.UseCase.UseCase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flowOf
import org.junit.Before
import org.junit.Test

class UseCaseTest {
    @ExperimentalComposeApi
    private val configuration = UseCase.Configuration(TestCoroutineDispatcher())

    private val request = mock<UseCase.Request>()
    private val response = mock<UseCase.Response>

    @ExperimentalComposeApi
    private  lateinit var usecase:
    UseCase<UseCase.Request,UseCase.Response>

    @ExperimentalComposeApi
    @Before
    fun setUp(){
        usecase = object : UseCase<UseCase.Request,UseCase.Response>(configuration){
            override fun process(request: Request): Flow<Response> {
                assertEquals(this@UseCaseTest.request,request)
                return flowOf(response)
            }
        }
    }
    @ExperimentalComposeApi
    @Test
    fun testExecuteSuccess() = runBlockingTest{
        val result = usecase.execute(request).first()
        assertEquals(Result.success(response),result)
    }
}

