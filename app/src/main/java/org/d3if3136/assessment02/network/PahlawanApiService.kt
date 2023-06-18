package org.d3if3136.assessment02.network

import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.GET

private const val BASE_URL = "https://raw.githubusercontent.com/" +
        "annisanailiya/json.pahlawanindonesia/master/"

private val retrofit = Retrofit.Builder()
    .addConverterFactory(ScalarsConverterFactory.create())
    .baseUrl(BASE_URL)
    .build()

interface PahlawanApiService {
    @GET("pahlawanindonesia.json")
    suspend fun getPahlawan(): String
}
object PahlawanApi {
    val service: PahlawanApiService by lazy {
        retrofit.create(PahlawanApiService::class.java)
    }
}