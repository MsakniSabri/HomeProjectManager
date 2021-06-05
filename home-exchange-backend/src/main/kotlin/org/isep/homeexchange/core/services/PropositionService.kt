package org.isep.homeexchange.core.services

import org.isep.homeexchange.core.dto.PropositionDto
import java.time.LocalDate

interface PropositionService {
    fun create(housing1Id: Long,housing2Id: Long, startingDate: LocalDate, endingDate: LocalDate, dto: PropositionDto): PropositionDto
    fun getById(id: Long): PropositionDto
    fun getAllAcceptedPropositions(): List<PropositionDto>
    fun acceptExchange(id: Long)
    fun delete(id: Long)
}