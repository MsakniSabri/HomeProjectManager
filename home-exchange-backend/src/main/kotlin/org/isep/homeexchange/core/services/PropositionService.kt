package org.isep.homeexchange.core.services

import org.isep.homeexchange.core.dto.PropositionDto

interface PropositionService {
    fun create(housing1_id: Long,housing2_id: Long, dto: PropositionDto): PropositionDto
    fun delete(id: Long)
}