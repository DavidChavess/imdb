package dto

data class CharacterThumbnailDto(
    val path: String,
    val extension: String
)

data class CharacterResultDto(
    val id: Long,
    val name: String,
    val description: String,
    val thumbnail: CharacterThumbnailDto
)

data class CharacterDataDto(
    val results: List<CharacterResultDto>
)

data class CharacterDto(
    val code: Int,
    val data: CharacterDataDto
)