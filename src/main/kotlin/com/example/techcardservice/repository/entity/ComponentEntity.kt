package com.example.techcardservice.repository.entity

import jakarta.persistence.*
import lombok.AllArgsConstructor
import lombok.NoArgsConstructor
import java.math.BigDecimal

@Entity
@Table(name = "component")
@NoArgsConstructor
@AllArgsConstructor
class ComponentEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,
    var name: String = "",
    var unit: String = "",

//    var categoryId: Long? = null,

    @ManyToOne
    @JoinColumn(name = "category_id")
    var category: CategoryEntity = CategoryEntity(),
    var code: String = "",

    @OneToMany(
        mappedBy = "component",
        fetch = FetchType.LAZY,
        orphanRemoval = true,
        cascade = [CascadeType.ALL]
    )
    var relation: MutableList<CardRelationComponentEntity> = mutableListOf()
) {
    override fun toString(): String {
        return "ComponentEntity(id=$id, name='$name', unit='$unit', category=$category, code='$code')"
    }
}

