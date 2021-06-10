package org.isep.homeexchange.core.services.impl

import org.isep.homeexchange.core.dto.PropositionDto
import org.isep.homeexchange.core.dto.toDao
import org.isep.homeexchange.core.services.HousingService
import org.isep.homeexchange.core.services.PropositionService
import org.isep.homeexchange.infrastructure.dao.PropositionDao
import org.isep.homeexchange.infrastructure.dao.toPropositionDto
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

    override fun create(dto: PropositionDto
    ): PropositionDto {
        val proposedHousingDto = housingService.getById(dto.proposedHousing.id)
        val requestedHousingDto = housingService.getById(dto.requestedHousing.id)
        val propositionDao = dto.toDao()
        propositionDao.proposedHousing = proposedHousingDto.toDao()
        propositionDao.requestedHousing = requestedHousingDto.toDao()

        return propositionRepository.save(propositionDao).toPropositionDto()
    }

    override fun getById(id: Long): PropositionDto {
        val proposition: Optional<PropositionDao> = propositionRepository.findById(id)

        if (proposition.isEmpty) {
            throw ResponseStatusException(HttpStatus.NOT_FOUND, "Proposition doesn't exist")
        }


        return proposition.get().toPropositionDto()
    }

    override fun getAllPropositionsByAccepted(accepted: Boolean): List<PropositionDto> {
        val propositionDao: List<PropositionDao> = propositionRepository.findAllByAccepted(accepted);

        return propositionDao.toPropositionDto()
    }

    override fun acceptExchange(id: Long) {
        val propositionDao = getById(id).toDao()
        propositionDao.accepted = true;
        propositionRepository.save(propositionDao).toPropositionDto()
    }

    override fun delete(id: Long){
        propositionRepository.deleteById(id);
    }

}