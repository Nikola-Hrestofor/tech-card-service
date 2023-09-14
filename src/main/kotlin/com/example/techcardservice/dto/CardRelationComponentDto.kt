package com.example.techcardservice.dto

import java.math.BigDecimal

data class CardRelationComponentDto(
    val id:Long,
    val component: ComponentDto,
    val qty: BigDecimal
)
