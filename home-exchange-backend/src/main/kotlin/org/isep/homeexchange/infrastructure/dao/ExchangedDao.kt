package org.isep.homeexchange.infrastructure.dao

import org.isep.homeexchange.core.dto.ExchangedDto
import java.time.LocalDate
import java.util.*
import javax.persistence.*

@Entity
@Table(name = "exchanged")
data class ExchangedDao(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id: Long = 0,

        @Column
        var startingDate: LocalDate,

        @Column
        var endingDate: LocalDate,

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "housing_id")
        var housing: HousingDao?,

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "user_id")
        var user: UserDao?
)

fun ExchangedDao.toUserDto() = ExchangedDto(
        id,
        startingDate,
        endingDate,
)

fun List<ExchangedDao>.toUserDto() = map { it.toUserDto() }