package client.retrofit.character

import dto.CharacterDto

interface CharacterClient {
    fun findTop50MarvelCharacters(onSuccess: (CharacterDto) -> Unit)
}
