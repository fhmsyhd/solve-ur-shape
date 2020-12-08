@file:Suppress("SpellCheckingInspection")

package org.d3if4097.solveurshape.network

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import org.d3if4097.solveurshape.database.data.DataBangunDatar
import org.d3if4097.solveurshape.utils.constant
import org.d3if4097.solveurshape.utils.constant.GET_DATAR
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

val moshi: Moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(constant.BASE_URL)
    .build()

interface ApiService {
    @GET(GET_DATAR)
    suspend fun showList(): List<DataBangunDatar>
}

object ApiShape {
    val retrofitService: ApiService = retrofit.create(ApiService::class.java)
}