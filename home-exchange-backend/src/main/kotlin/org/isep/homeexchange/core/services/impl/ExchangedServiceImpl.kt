package org.isep.homeexchange.core.services.impl

import org.isep.homeexchange.core.dto.ExchangedDto
import org.isep.homeexchange.core.services.ExchangedService
import org.isep.homeexchange.infrastructure.repository.ExchangedRepository
import org.springframework.stereotype.Service

@Service
class ExchangedServiceImpl(
    private val exchangedRepository: ExchangedRepository
) : ExchangedService {

    override fun create(id: Long, dto: ExchangedDto): ExchangedDto {
        TODO("Not yet implemented")
    }

    override fun getById(id: Long): ExchangedDto {
        TODO("Not yet implemented")
    }

    override fun delete(id: Long){
        exchangedRepository.deleteById(id);
    }

}