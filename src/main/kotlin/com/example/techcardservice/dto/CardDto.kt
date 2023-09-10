package com.example.techcardservice.dto

data class CardDto(
    val id: Long?,
    val name: String,
    val attributes: List<CardAttribute>?
)

data class CardAttribute(
    var id: Long?,
    var cardId: Long?,
    var key:String,
    var value: String
)
