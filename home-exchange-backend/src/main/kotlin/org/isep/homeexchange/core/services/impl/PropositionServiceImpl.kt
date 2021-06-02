package org.isep.homeexchange.core.services.impl

import org.isep.homeexchange.core.dto.PropositionDto
import org.isep.homeexchange.core.dto.toDao
import org.isep.homeexchange.core.services.HousingService
import org.isep.homeexchange.core.services.PropositionService
import org.isep.homeexchange.infrastructure.dao.PropositionDao
import org.isep.homeexchange.infrastructure.dao.toUserDto
import org.isep.homeexchange.infrastructure.repository.PropositionRepository
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException
import java.util.*

@Service
class PropositionServiceImpl(
    private val propositionRepository: PropositionRepository,
    private val housingService: HousingService,
) : PropositionService {

    override fun create(housing1Id: Long, housing2Id: Long, dto: PropositionDto): PropositionDto {
        val housing1Dto = housingService.getById(housing1Id)
        val housing2Dto = housingService.getById(housing2Id)
        val propositionDao = dto.toDao()
        propositionDao.housing1 = housing1Dto.toDao()
        propositionDao.housing2 = housing2Dto.toDao()

        return propositionRepository.save(propositionDao).toUserDto()
    }

    override fun getById(id: Long): PropositionDto {
        val proposition: Optional<PropositionDao> = propositionRepository.findById(id)

        if (proposition.isEmpty) {
            throw ResponseStatusException(HttpStatus.NOT_FOUND, "Proposition doesn't exist")
        }


        return proposition.get().toUserDto()
    }

    override fun acceptExchange(id: Long) {
        val propositionDao = getById(id).toDao()
        val housing1 = propositionDao.housing1
        val housing2 = propositionDao.housing2
        val user1 = housing1!!.user
        val user2 = housing2!!.user
    }



    override fun delete(id: Long){
        propositionRepository.deleteById(id);
    }

}