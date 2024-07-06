package com.example.techcardservice.dto

import java.math.BigDecimal

class CustomerDto(
    val id: Long,
    val title: String,
    val name: String?,
    val lastName: String?,
    val phone: String,
    var balance: BigDecimal?
)