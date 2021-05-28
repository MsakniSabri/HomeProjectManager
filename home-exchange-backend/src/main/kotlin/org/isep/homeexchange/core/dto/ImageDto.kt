package org.isep.homeexchange.core.dto

import org.isep.homeexchange.infrastructure.dao.ImageDao

data class ImageDto(
    val id: Long,
    val imageAddress: String,
    val housingId: Long,
)

fun ImageDto.toDao() = ImageDao(
    id = id,
    imageAddress = imageAddress,
    housing = null
)

fun List<ImageDto>.toDao() = map { it.toDao() }