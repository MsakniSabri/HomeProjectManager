package org.isep.homeexchange.infrastructure.dao

import org.isep.homeexchange.core.dto.PropositionDto
import java.time.LocalDate
import javax.persistence.*

@Entity
@Table(name = "proposition")
data class PropositionDao(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id: Long = 0,

        @Column
        var accepted: Boolean,

        @Column
        var pending: Boolean,

        @Column
        var startingDate: LocalDate,

        @Column
        var endingDate: LocalDate,

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "housing_id")
        var proposedHousing: HousingDao?,

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "housing_id")
        var requestedHousing: HousingDao?,
)

fun PropositionDao.toPropositionDto() = PropositionDto(
        id,
        accepted,
        pending,
        startingDate,
        endingDate,
        proposedHousing = proposedHousing!!.toHousingDto(),
        requestedHousing = requestedHousing!!.toHousingDto(),
)

fun List<PropositionDao>.toPropositionDto() = map { it.toPropositionDto() }