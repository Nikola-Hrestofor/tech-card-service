package com.example.techcardservice.dto

import java.math.BigDecimal

class CustomerDto(
    val id: Long,
    val name: String,
    val balance: BigDecimal?
)