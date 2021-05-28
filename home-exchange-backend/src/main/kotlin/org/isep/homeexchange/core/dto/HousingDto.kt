package org.isep.homeexchange.core.dto

import org.isep.homeexchange.infrastructure.dao.HousingDao

data class HousingDto(
    val id: Long,
    val description: String,
    val userId: Long,
    //ajout
    val
    constraints: List<ConstraintDto>,
    //ajout
    val images: List<ImageDto>
)

fun HousingDto.toDao() = HousingDao(
    id = id,
    description = description,
    user = null,
    //ajout
    constraints = constraints.toDao(),
    //ajout
    images = images.toDao()
)

fun List<HousingDto>.toDao() = map { it.toDao() }