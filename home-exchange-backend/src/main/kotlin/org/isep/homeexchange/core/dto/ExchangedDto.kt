package org.isep.homeexchange.core.dto

import org.isep.homeexchange.infrastructure.dao.ExchangedDao
import java.util.*

data class ExchangedDto(
    val id: Long,
    val startingDate: Date,
    val endingDate: Date,
)

fun ExchangedDto.toDao() = ExchangedDao(
    id = id,
    startingDate = startingDate,
    endingDate = endingDate,
    housing = null,
    user = null
)

fun List<ExchangedDto>.toDao() = map { it.toDao() }