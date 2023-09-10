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
    var id: Long = 0,

    @Column(name = "name")
    var name: String = "",

    @OneToMany
    @JoinColumn(name="card_id")
    var attributes: List<CardFillingEntity> = listOf()

)

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "card_filling")
class CardFillingEntity(
    @Id
    @Column(name = "id")
    var id: Long = 0,
    @Column(name = "card_id")
    var cardId: Long = 0,
    @Column(name = "key")
    var key: String = "",
    @Column(name = "value")
    var value: String = ""
)
