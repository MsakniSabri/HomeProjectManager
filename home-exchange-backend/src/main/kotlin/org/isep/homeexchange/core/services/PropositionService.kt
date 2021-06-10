package org.isep.homeexchange.core.services

import org.isep.homeexchange.core.dto.PropositionDto
import java.time.LocalDate

interface PropositionService {
    fun create(dto: PropositionDto): PropositionDto
    fun getById(id: Long): PropositionDto
    fun getAllPropositionsByAccepted(accepted: Boolean): List<PropositionDto>
    fun acceptExchange(id: Long)
    fun delete(id: Long)
}