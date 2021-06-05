package org.isep.homeexchange.core.services.impl

import org.isep.homeexchange.core.dto.PropositionDto
import org.isep.homeexchange.core.dto.toDao
import org.isep.homeexchange.core.services.HousingService
import org.isep.homeexchange.core.services.PropositionService
import org.isep.homeexchange.infrastructure.dao.HousingDao
import org.isep.homeexchange.infrastructure.dao.PropositionDao
import org.isep.homeexchange.infrastructure.dao.toUserDto
import org.isep.homeexchange.infrastructure.repository.PropositionRepository
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException
import java.time.LocalDate
import java.util.*

@Service
class PropositionServiceImpl(
    private val propositionRepository: PropositionRepository,
    private val housingService: HousingService,
) : PropositionService {

    override fun create(
        housing1Id: Long,
        housing2Id: Long,
        startingDate: LocalDate,
        endingDate: LocalDate,
        dto: PropositionDto
    ): PropositionDto {
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

    override fun getAllAcceptedPropositions(): List<PropositionDto> {
        val propositionDao: List<PropositionDao> = propositionRepository.findAllByAccepted(true);

        return propositionDao.toUserDto()
    }

    override fun acceptExchange(id: Long) {
        val propositionDao = getById(id).toDao()
        propositionDao.accepted = true;
        propositionRepository.save(propositionDao).toUserDto()
    }



    override fun delete(id: Long){
        propositionRepository.deleteById(id);
    }

}