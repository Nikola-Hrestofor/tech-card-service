package com.example.techcardservice.repository.entity

import jakarta.persistence.*
import lombok.AllArgsConstructor
import lombok.NoArgsConstructor

@Entity
@Table(name = "customer")
@NoArgsConstructor
@AllArgsConstructor
class CustomerEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    var id: Long? = 0,

    @Column(name = "title")
    var title: String = "",

    @Column(name = "name")
    var name: String = "",

    @Column(name = "lastname")
    var lastName: String = "",

    @Column(name = "phone")
    var phone: String = "",
) {
}