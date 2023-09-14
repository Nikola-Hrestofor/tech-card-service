package com.example.techcardservice.repository.entity

import jakarta.persistence.*
import lombok.AllArgsConstructor
import lombok.NoArgsConstructor

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
    var code: String = ""
){
    override fun toString(): String {
        return "ComponentEntity(id=$id, name='$name', unit='$unit', category=$category, code='$code')"
    }
}

