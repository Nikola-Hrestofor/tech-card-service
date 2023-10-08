package com.example.techcardservice.dto

import java.math.BigDecimal

data class CardDto(
    val id: Long,
    val name: String,
    val code: String,
    val components: List<CardRelationComponentDto>,
    val stock: BigDecimal = BigDecimal(15)
)

