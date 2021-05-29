package org.isep.homeexchange.core.services

import org.isep.homeexchange.core.dto.PropertyDto

interface PropertyService {
    fun create(dto: PropertyDto): PropertyDto
    fun delete(id: Long)
}