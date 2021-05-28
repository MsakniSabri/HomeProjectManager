package org.isep.homeexchange.ws.controllers

import org.isep.homeexchange.core.dto.ConstraintDto
import org.isep.homeexchange.core.services.ConstraintService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("constraints")
class ConstraintController(private val constraintService: ConstraintService) {

    @PostMapping
    fun createConstraint(@RequestBody dto: ConstraintDto): ConstraintDto = constraintService.create(dto)

    @GetMapping("/{id}")
    fun getConstraintById(@PathVariable id: Long): ConstraintDto = constraintService.getById(id)
}