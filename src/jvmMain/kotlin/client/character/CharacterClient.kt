package client.character

import dto.CharacterDto

interface CharacterClient {
    fun findTop50MarvelCharacters(onSuccess: (result: CharacterDto?) -> Unit)
}
