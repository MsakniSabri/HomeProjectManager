package org.isep.homeexchange.core.services

import org.isep.homeexchange.core.dto.PropositionDto

interface PropositionService {
    fun create(housing1Id: Long,housing2Id: Long, dto: PropositionDto): PropositionDto
    fun acceptExchange(id: Long)
    fun getById(id: Long): PropositionDto
    fun delete(id: Long)
}