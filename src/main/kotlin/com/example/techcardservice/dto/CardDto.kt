package com.example.techcardservice.dto

data class CardDto(
    val id: Long,
    val name: String,
    val components: List<CardRelationComponentDto>
)

