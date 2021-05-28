package org.isep.homeexchange.core.services.impl

import org.isep.homeexchange.core.dto.ConstraintDto
import org.isep.homeexchange.core.dto.toDao
import org.isep.homeexchange.core.services.ConstraintService
import org.isep.homeexchange.core.services.HousingService
import org.isep.homeexchange.infrastructure.dao.ConstraintDao
import org.isep.homeexchange.infrastructure.dao.toDto
import org.isep.homeexchange.infrastructure.repository.ConstraintRepository
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException
import java.util.*

@Service
class ConstraintServiceImpl(
    private val constraintRepository: ConstraintRepository,
    private val housingService: HousingService,
) : ConstraintService {

    override fun create(dto: ConstraintDto): ConstraintDto {
        val housingDto = housingService.getById(dto.housingId)
        val constraintDao = dto.toDao()
        constraintDao.housing = housingDto.toDao()

        return constraintRepository.save(constraintDao).toDto()
    }

    override fun getById(id: Long): ConstraintDto {
        val constraint: Optional<ConstraintDao> = constraintRepository.findById(id);

        if (constraint.isEmpty) {
            throw ResponseStatusException(HttpStatus.NOT_FOUND, "Constraint doesn't exist")
        }

        return constraint.get().toDto()
    }
}