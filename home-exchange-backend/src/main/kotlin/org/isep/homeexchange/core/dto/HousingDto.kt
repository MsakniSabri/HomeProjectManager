package org.isep.homeexchange.core.dto

import org.isep.homeexchange.infrastructure.dao.HousingDao

data class HousingDto(
    val id: Long,
    val description: String,
    val userId: Long,
    val properties: List<PropertyDto>?,
    val user: UserDto,
    val images: List<ImageDto>
)

fun HousingDto.toDao() = HousingDao(
    id = id,
    description = description,
    user = user.toDao(),
    properties = properties!!.toDao(),
    images = images.toDao(),
    userId = userId
)

fun List<HousingDto>.toDao() = map { it.toDao() }