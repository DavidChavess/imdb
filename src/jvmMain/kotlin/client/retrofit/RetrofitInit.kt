package client.retrofit

import client.retrofit.character.CharacterRetrofitService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitInit(
    baseUrl: String
) {
    private val client = Retrofit.Builder()
        .baseUrl(baseUrl)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun characterRetrofitService(): CharacterRetrofitService {
        return client.create(CharacterRetrofitService::class.java)
    }
}