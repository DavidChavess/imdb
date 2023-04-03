package client.character

import dto.CharacterDto
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface CharacterClientRetrofit {
    @GET("characters")
    fun findMarvelCharacters(
        @Query("ts") ts: String? = System.getenv("TS"),
        @Query("apikey") apikey: String? = System.getenv("API_KEY"),
        @Query("hash") hash: String? = System.getenv("HASH"),
        @Query("limit") limit: Int? = 50
    ): Call<CharacterDto>
}