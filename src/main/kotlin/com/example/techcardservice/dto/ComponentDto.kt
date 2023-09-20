package com.example.techcardservice.dto

import java.math.BigDecimal

data class ComponentDto(
    val id:Long?,
    val name: String,
    val unit: String,
    val category: CategoryDto,
    val code: String,
    val stock: BigDecimal = BigDecimal(75)
)
