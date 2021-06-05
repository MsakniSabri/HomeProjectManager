package org.isep.homeexchange.core.services.impl

import org.isep.homeexchange.core.dto.PropertyDto
import org.isep.homeexchange.core.dto.toDao
import org.isep.homeexchange.core.services.PropertyService
import org.isep.homeexchange.core.services.HousingService
import org.isep.homeexchange.infrastructure.dao.PropertyDao
import org.isep.homeexchange.infrastructure.dao.toPropertyDto
import org.isep.homeexchange.infrastructure.repository.PropertyRepository
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException
import java.util.*

@Service
class PropertyServiceImpl(
    private val propertyRepository: PropertyRepository,
    private val housingService: HousingService,
) : PropertyService {

    override fun create(id: Long, dto: PropertyDto): PropertyDto {
        val housingDto = housingService.getById(id)
        val propertyDao = dto.toDao()
        propertyDao.housing = housingDto.toDao()

        return propertyRepository.save(propertyDao).toPropertyDto()
    }

    override fun getById(id: Long): PropertyDto {
        val property: Optional<PropertyDao> = propertyRepository.findById(id)

        if (property.isEmpty) {
            throw ResponseStatusException(HttpStatus.NOT_FOUND, "Property doesn't exist")
        }

        return property.get().toPropertyDto()
    }

    override fun updateDescription(id: Long, description: String): PropertyDto {
        val propertyDao = getById(id).toDao()
        propertyDao.description = description
        return propertyRepository.save(propertyDao).toPropertyDto()
    }

    override fun delete(id: Long){
        propertyRepository.deleteById(id);
    }

}