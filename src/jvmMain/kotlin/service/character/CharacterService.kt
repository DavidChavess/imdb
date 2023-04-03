package service.character

import model.Movie

interface CharacterService {
    fun findTop50MarvelCharacters(onSuccess: (List<Movie>) -> Unit)
}