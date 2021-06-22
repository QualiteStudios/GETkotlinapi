package com.qualitestudios.qualitehttp.data.remote

import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query


interface ApiService {
//https://api.nationalize.io/?name=chethan

@GET("name={name}")
suspend fun getData(@Query("name")name:String):Call<NationData>


}