package service.character.impl

import client.retrofit.character.CharacterClient
import model.Movie
import service.character.CharacterService

class CharacterServiceImpl(
    private val characterClient: CharacterClient
) : CharacterService {

    override fun findTop50MarvelCharacters(onSuccess: (List<Movie>) -> Unit) {
        return characterClient.findTop50MarvelCharacters { characterDto ->
            val movies = characterDto.data.results.map { character -> character.toMovie() }
            onSuccess(movies)
        }
    }
}