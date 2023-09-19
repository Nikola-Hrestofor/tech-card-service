package com.example.techcardservice.repository.entity

import jakarta.persistence.*
import java.math.BigDecimal

@Entity
@Table(name = "card_relation_component")
class CardRelationComponentEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,
    @ManyToOne
    @JoinColumn(name = "card_id")
    var card: CardEntity = CardEntity(),
    @ManyToOne
    @JoinColumn(name = "component_id")
    var component: ComponentEntity = ComponentEntity(),
    var qty: BigDecimal = BigDecimal.ZERO
){
    override fun toString(): String {
        return "CardRelationComponentEntity(id=$id, card=$card, component=$component, qty=$qty)"
    }
}