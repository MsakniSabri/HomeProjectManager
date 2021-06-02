package org.isep.homeexchange.core.services.impl

import org.isep.homeexchange.core.dto.ExchangedDto
import org.isep.homeexchange.core.dto.toDao
import org.isep.homeexchange.core.services.ExchangedService
import org.isep.homeexchange.core.services.HousingService
import org.isep.homeexchange.core.services.UserService
import org.isep.homeexchange.infrastructure.dao.ExchangedDao
import org.isep.homeexchange.infrastructure.dao.toUserDto
import org.isep.homeexchange.infrastructure.repository.ExchangedRepository
import org.springframework.stereotype.Service

@Service
class ExchangedServiceImpl(
    private val exchangedRepository: ExchangedRepository,
    private val housingService: HousingService,
    private val userService: UserService
) : ExchangedService {

    override fun create(housingId: Long, userId: Long, dto: ExchangedDto): ExchangedDto {
        val housingDto = housingService.getById(housingId)
        val userDto = userService.getById(userId)
        val exchangedDao = dto.toDao()
        exchangedDao.housing = housingDto.toDao()
        exchangedDao.user = userDto.toDao()

        return exchangedRepository.save(exchangedDao).toUserDto()
    }

    override fun getByUsers(userId: Long): List<ExchangedDto> {
        val exchangedDao: List<ExchangedDao> = exchangedRepository.findByUserId(userId)

        return exchangedDao.toUserDto()
    }

    override fun delete(id: Long){
        exchangedRepository.deleteById(id);
    }

}