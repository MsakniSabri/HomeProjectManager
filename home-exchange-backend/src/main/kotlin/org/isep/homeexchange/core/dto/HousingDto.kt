package org.isep.homeexchange.core.dto

import org.isep.homeexchange.infrastructure.dao.HousingDao

data class HousingDto(
    val id: Long,
    val description: String,
    val userId: Long,
    //ajout
    val
    properties: List<PropertyDto>,
    //ajout
    val images: List<ImageDto>
)

fun HousingDto.toDao() = HousingDao(
    id = id,
    description = description,
    user = null,
    //ajout
    properties = properties.toDao(),
    //ajout
    images = images.toDao(),
    userId = userId
)

fun List<HousingDto>.toDao() = map { it.toDao() }