package service.character.impl

import client.character.CharacterClient
import model.Movie
import service.character.CharacterService

class CharacterServiceImpl(
    private val characterClient: CharacterClient
) : CharacterService {

    override fun findTop50MarvelCharacters(onSuccess: (List<Movie>) -> Unit) {
        characterClient.findTop50MarvelCharacters { characterDto ->
            characterDto?.let {
                val movies = it.data.results.map { character -> character.toMovie() }
                onSuccess(movies)
            }
        }
    }
}