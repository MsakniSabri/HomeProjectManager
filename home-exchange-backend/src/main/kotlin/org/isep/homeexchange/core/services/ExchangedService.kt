package org.isep.homeexchange.core.services

import org.isep.homeexchange.core.dto.ExchangedDto

interface ExchangedService {
    fun create(id: Long, dto: ExchangedDto): ExchangedDto
    fun getById(id: Long): ExchangedDto
    fun delete(id: Long)
}