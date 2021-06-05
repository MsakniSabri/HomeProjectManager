package org.isep.homeexchange.core.dto

import org.isep.homeexchange.infrastructure.dao.PropositionDao
import java.time.LocalDate
import java.util.*

data class PropositionDto(
    val id: Long,
    val accepted: Boolean,
    val startingDate: LocalDate,
    val endingDate: LocalDate,
    val proposedHousing: HousingDto,
    val requestedHousing: HousingDto,
)

fun PropositionDto.toDao() = PropositionDao(
    id = id,
    accepted = accepted,
    startingDate = startingDate,
    endingDate = endingDate,
    proposedHousing = proposedHousing.toDao(),
    requestedHousing = requestedHousing.toDao(),
)

fun List<PropositionDto>.toDao() = map { it.toDao() }