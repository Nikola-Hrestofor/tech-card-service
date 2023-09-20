package com.example.techcardservice.repository.entity

import jakarta.persistence.*
import lombok.AllArgsConstructor
import lombok.NoArgsConstructor

@Entity
@Table(name = "card")
@NoArgsConstructor
@AllArgsConstructor
class CardEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    var id: Long? = 0,

    @Column(name = "name")
    var name: String = "",

    @OneToMany(
        mappedBy = "card",
        fetch = FetchType.LAZY,
        orphanRemoval = true,
        cascade = [CascadeType.ALL]
    )
    var components: List<CardRelationComponentEntity> = mutableListOf()

) {
    override fun toString(): String {
        return "CardEntity(id=$id, name='$name', components=$components)"
    }
}

