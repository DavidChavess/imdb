package service.impl

import client.CharacterClient
import model.Movie
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import service.CharacterService

class CharacterServiceImpl : CharacterService {
    override fun findTop50MarvelCharacters(): List<Movie> {
        val retrovit = Retrofit.Builder()
            .baseUrl("http://gateway.marvel.com/v1/public/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val client: CharacterClient = retrovit.create(CharacterClient::class.java)

        val call = client.findTop50MarvelCharacters(
            ts = System.getenv("TS"),
            apikey = System.getenv("API_KEY"),
            hash = System.getenv("HASH"),
        )

        return call.execute().body()
            ?.let { body ->
                body.data.results.map { character ->
                    Movie(
                        name = character.name,
                        imdb = 0f,
                        year = 0,
                        description = character.description,
                        imageSrc = "${character.thumbnail.path}.${character.thumbnail.extension}"
                    )
                }
            } ?: listOf()
    }
}