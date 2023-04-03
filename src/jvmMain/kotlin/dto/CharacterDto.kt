package dto

import model.Movie

data class CharacterThumbnailDto(
    val path: String,
    val extension: String
)

data class CharacterResultDto(
    val id: Long,
    val name: String,
    val description: String,
    val thumbnail: CharacterThumbnailDto
) {
    fun toMovie(): Movie =
        Movie(
            name = name,
            imdb = 0f,
            year = 0,
            description = description,
            imageSrc = "${thumbnail.path}.${thumbnail.extension}"
        )

}

data class CharacterDataDto(
    val results: List<CharacterResultDto>
)

data class CharacterDto(
    val code: Int,
    val data: CharacterDataDto
)