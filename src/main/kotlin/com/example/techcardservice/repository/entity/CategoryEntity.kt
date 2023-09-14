package com.example.techcardservice.repository.entity

import jakarta.persistence.*
import lombok.AllArgsConstructor
import lombok.NoArgsConstructor
import lombok.RequiredArgsConstructor

@Entity
@Table(name = "category")
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
class CategoryEntity (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,
    @Column(unique=true)
    var name: String = "",

    @OneToMany(
    mappedBy = "category",
    fetch = FetchType.LAZY,
    orphanRemoval = true,
    cascade = [CascadeType.ALL]
    )
    var components: MutableList<ComponentEntity> = mutableListOf()
) {
    override fun toString(): String {
        return "CategoryEntity(id=$id, name='$name', components=$components)"
    }
}