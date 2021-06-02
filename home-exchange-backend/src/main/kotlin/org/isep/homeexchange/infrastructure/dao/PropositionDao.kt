package org.isep.homeexchange.infrastructure.dao

import org.isep.homeexchange.core.dto.PropositionDto
import java.util.*
import javax.persistence.*

@Entity
@Table(name = "proposition")
data class PropositionDao(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id: Long = 0,

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "housing_id")
        var housing1: HousingDao?,

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "housing_id")
        var housing2: HousingDao?,
)

fun PropositionDao.toUserDto() = PropositionDto(
        id,
)

fun List<PropositionDao>.toUserDto() = map { it.toUserDto() }