package org.isep.homeexchange.core.dto

import org.isep.homeexchange.infrastructure.dao.ConstraintDao

data class ConstraintDto(
    val id: Long,
    val description: String,
    val housingId: Long,
)

fun ConstraintDto.toDao() = ConstraintDao(
    id = id,
    description = description,
    housing = null
)

fun List<ConstraintDto>.toDao() = map { it.toDao() }