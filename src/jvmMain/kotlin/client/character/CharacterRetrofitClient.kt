package client.character

import dto.CharacterDto
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class CharacterRetrofitClient : CharacterClient {
    override fun findTop50MarvelCharacters(onSuccess: (result: CharacterDto?) -> Unit) {
        characterClientRetrofit()
            .findMarvelCharacters(limit = 50)
            .enqueue(object : Callback<CharacterDto> {
                override fun onResponse(call: Call<CharacterDto>, response: Response<CharacterDto>) {
                    if (response.isSuccessful) {
                        onSuccess(response.body())
                    }
                }

                override fun onFailure(call: Call<CharacterDto>, t: Throwable) {
                    throw RuntimeException("Erro ao buscar personagens")
                }
            })
    }

    private fun characterClientRetrofit(): CharacterClientRetrofit {
        val client = Retrofit.Builder()
            .baseUrl(System.getenv("MARVEL_BASE_URL"))
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        return client.create(CharacterClientRetrofit::class.java)
    }
}