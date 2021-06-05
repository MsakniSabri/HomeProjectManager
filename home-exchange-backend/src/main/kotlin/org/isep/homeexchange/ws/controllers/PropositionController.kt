package org.isep.homeexchange.ws.controllers

import org.isep.homeexchange.core.dto.PropositionDto
import org.isep.homeexchange.core.services.PropositionService
import org.springframework.web.bind.annotation.*
import java.time.LocalDate

@RestController
@RequestMapping("propositions")
class PropositionController(
    private val propositionService: PropositionService
){

    @PostMapping
    fun createProposition(@RequestBody dto: PropositionDto): PropositionDto = propositionService.create(dto)


}