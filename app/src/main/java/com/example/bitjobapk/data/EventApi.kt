package com.plcoding.retrofitcrashcourse

import com.example.bitjobapk.data.Event
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface EventApi {

    //todo

    @GET("/todos")
    suspend fun getEvents(): Response<List<Event>>

}