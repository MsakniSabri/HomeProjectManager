package org.isep.homeexchange.core.services.impl

import org.isep.homeexchange.core.dto.PropositionDto
import org.isep.homeexchange.core.dto.toDao
import org.isep.homeexchange.core.services.HousingService
import org.isep.homeexchange.core.services.PropositionService
import org.isep.homeexchange.infrastructure.dao.toUserDto
import org.isep.homeexchange.infrastructure.repository.PropositionRepository
import org.springframework.stereotype.Service

@Service
class PropositionServiceImpl(
    private val propositionRepository: PropositionRepository,
    private val housingService: HousingService,
) : PropositionService {

    override fun create(housing1_id: Long,housing2_id: Long, dto: PropositionDto): PropositionDto {
        val housing1Dto = housingService.getById(housing1_id)
        val housing2Dto = housingService.getById(housing2_id)
        val propositionDao = dto.toDao()
        propositionDao.housing1 = housing1Dto.toDao()
        propositionDao.housing2 = housing2Dto.toDao()

        return propositionRepository.save(propositionDao).toUserDto()
    }

    override fun delete(id: Long){
        propositionRepository.deleteById(id);
    }

}