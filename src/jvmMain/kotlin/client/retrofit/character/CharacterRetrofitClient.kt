package client.retrofit.character

import dto.CharacterDto
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch

class CharacterRetrofitClient(
    private val characterRetrofitService: CharacterRetrofitService
) : CharacterClient {

    override fun findTop50MarvelCharacters(onSuccess: (CharacterDto) -> Unit) {
        CoroutineScope(IO).launch {
            val result = characterRetrofitService.findMarvelCharacters()
            onSuccess(result)
        }
    }
}