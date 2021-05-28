package org.isep.homeexchange.core.services

import org.isep.homeexchange.core.dto.ConstraintDto

interface ConstraintService {
    fun create(dto: ConstraintDto): ConstraintDto
    fun getById(id: Long): ConstraintDto
}