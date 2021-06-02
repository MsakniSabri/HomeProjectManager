package org.isep.homeexchange.core.dto

import org.isep.homeexchange.infrastructure.dao.PropositionDao
import java.util.*

data class PropositionDto(
    val id: Long,
)

fun PropositionDto.toDao() = PropositionDao(
    id = id,
    housing1 = null,
    housing2 = null
)

fun List<PropositionDto>.toDao() = map { it.toDao() }