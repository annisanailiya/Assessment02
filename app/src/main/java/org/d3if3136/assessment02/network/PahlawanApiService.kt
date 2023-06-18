package org.d3if3136.assessment02.network

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import org.d3if3136.assessment02.model.Pahlawan
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

private const val BASE_URL = "https://raw.githubusercontent.com/" +
        "annisanailiya/json.pahlawanindonesia/master/"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

interface PahlawanApiService {
    @GET("pahlawanindonesia.json")
    suspend fun getPahlawan(): List<Pahlawan>
}
object PahlawanApi {
    val service: PahlawanApiService by lazy {
        retrofit.create(PahlawanApiService::class.java)
    }

    fun getPahlawanUrl(imageResId: String): String {
        return "$BASE_URL$imageResId.png"
    }
}

enum class ApiStatus { LOADING, SUCCESS, FAILED }