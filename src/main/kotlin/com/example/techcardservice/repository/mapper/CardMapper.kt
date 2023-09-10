package com.example.techcardservice.repository.mapper

import com.example.techcardservice.dto.CardAttribute
import com.example.techcardservice.dto.CardDto
import com.example.techcardservice.repository.entity.CardEntity
import com.example.techcardservice.repository.entity.CardFillingEntity
import org.mapstruct.Mapper

@Mapper
interface CardMapper{
    fun toCardModel(entity: CardEntity): CardDto
    fun toCardModels(entity: List<CardEntity>): List<CardDto>

    fun toCardEntity(model: CardDto): CardEntity

    fun toCardAttributesEntity(models: List<CardAttribute>?): List<CardFillingEntity>
}