package org.isep.homeexchange.ws.controllers

import org.isep.homeexchange.core.dto.ExchangedDto
import org.isep.homeexchange.core.services.ExchangedService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("exchanged")
class ExchangedController(private val exchangedService: ExchangedService) {
    @PostMapping //✔️
    fun createExchange(@RequestBody housing_id: Long, user_id: Long, dto: ExchangedDto): ExchangedDto = exchangedService.create(housing_id,user_id,dto)
}