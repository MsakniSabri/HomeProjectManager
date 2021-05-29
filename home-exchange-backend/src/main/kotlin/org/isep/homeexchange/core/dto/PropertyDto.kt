package org.isep.homeexchange.core.dto

import org.isep.homeexchange.infrastructure.dao.PropertyDao

data class PropertyDto(
    val id: Long,
    val description: String,
)
//test
fun PropertyDto.toDao() = PropertyDao(
    id = 2,
    description = description,
    housing = null
)

fun List<PropertyDto>.toDao() = map { it.toDao() }