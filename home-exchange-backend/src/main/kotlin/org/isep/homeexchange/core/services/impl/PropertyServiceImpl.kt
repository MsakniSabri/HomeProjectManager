package org.isep.homeexchange.core.services.impl

import org.isep.homeexchange.core.dto.PropertyDto
import org.isep.homeexchange.core.dto.toDao
import org.isep.homeexchange.core.services.PropertyService
import org.isep.homeexchange.core.services.HousingService
import org.isep.homeexchange.infrastructure.dao.toDto
import org.isep.homeexchange.infrastructure.repository.PropertyRepository
import org.springframework.stereotype.Service

@Service
class PropertyServiceImpl(
    private val propertyRepository: PropertyRepository,
    private val housingService: HousingService,
) : PropertyService {

    override fun create(dto: PropertyDto): PropertyDto {
        val housingDto = housingService.getById(dto.housingId)
        val propertyDao = dto.toDao()
        propertyDao.housing = housingDto.toDao()

        return propertyRepository.save(propertyDao).toDto()
    }

    override fun delete(id: Long){
        propertyRepository.deleteById(id);
    }

}