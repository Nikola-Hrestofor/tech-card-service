package com.example.techcardservice.dto

data class ComponentDto(
    val id:Long?,
    val name: String,
    val unit: String,
    val category: CategoryDto,
    val code: String
)
