package org.isep.homeexchange.infrastructure.dao

import org.isep.homeexchange.core.dto.ConstraintDto
import javax.persistence.*

@Entity
@Table(name = "constraints")
data class ConstraintDao(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id: Long = 0,

        @Column
        var description: String,

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "housing_id")
        var housing: HousingDao?
)

fun ConstraintDao.toDto() = ConstraintDto(
        id,
        description,
        housingId = housing!!.id
)

fun List<ConstraintDao>.toDto() = map { it.toDto() }