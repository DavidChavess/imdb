package service

import model.Movie

interface CharacterService {
    fun findTop50MarvelCharacters(): List<Movie>
}