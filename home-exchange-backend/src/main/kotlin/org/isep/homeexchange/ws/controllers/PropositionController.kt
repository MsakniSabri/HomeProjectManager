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
    fun createProposition(@PathVariable housing1Id: Long,
                          @PathVariable housing2Id: Long,
                          @PathVariable startingDate: LocalDate,
                          @PathVariable endingDate: LocalDate,
                          @RequestBody dto: PropositionDto
    ): PropositionDto = propositionService.create(housing1Id,housing2Id,startingDate,endingDate,dto)
}