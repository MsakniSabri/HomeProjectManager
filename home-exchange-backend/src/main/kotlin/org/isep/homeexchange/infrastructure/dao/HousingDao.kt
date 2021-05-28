package org.isep.homeexchange.infrastructure.dao

import org.isep.homeexchange.core.dto.HousingDto
import javax.persistence.*

@Entity
@Table(name = "housings")
data class HousingDao(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0,

    @Column
    var description: String,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    var user: UserDao?,

    //ajout 2 lignes suivantes
    @OneToMany(mappedBy = "id", orphanRemoval = true)
    var constraints: List<ConstraintDao>
)

fun HousingDao.toDto() = HousingDto(
    id,
    description,
    userId = user!!.id,
    // ajout de la ligne suivante
    constraints = constraints.toDto()
)

fun List<HousingDao>.toDto() = map { it.toDto() }