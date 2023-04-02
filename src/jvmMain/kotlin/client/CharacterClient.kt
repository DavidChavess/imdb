package client

import dto.CharacterDto
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface CharacterClient {
    @GET("characters")
    fun findTop50MarvelCharacters(
        @Query("ts") ts: String,
        @Query("apikey") apikey: String,
        @Query("hash") hash: String,
        @Query("limit") limit: Int = 50
    ): Call<CharacterDto>
}