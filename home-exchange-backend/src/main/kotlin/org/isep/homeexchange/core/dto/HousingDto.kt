package org.isep.homeexchange.core.dto

import org.isep.homeexchange.infrastructure.dao.HousingDao

data class HousingDto(
    val id: Long,
    val description: String,
    val userId: Long,
)

fun HousingDto.toDao() = HousingDao(
    id = id,
    description = description,
    user = null
)

fun List<HousingDto>.toDao() = map { it.toDao() }