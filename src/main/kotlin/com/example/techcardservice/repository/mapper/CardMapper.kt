package com.example.techcardservice.repository.mapper

import com.example.techcardservice.dto.CardDto
import com.example.techcardservice.dto.CategoryDto
import com.example.techcardservice.dto.ComponentDto
import com.example.techcardservice.repository.entity.CardEntity
import com.example.techcardservice.repository.entity.CategoryEntity
import com.example.techcardservice.repository.entity.ComponentEntity
import org.mapstruct.Mapper
import org.mapstruct.Mapping

@Mapper
interface CardMapper {
    fun toCardModel(entity: CardEntity): CardDto
    fun toCardModels(entity: List<CardEntity>): List<CardDto>

    fun toCardEntity(model: CardDto): CardEntity

    fun toComponentModels(entities: List<ComponentEntity>): List<ComponentDto>

    @Mapping(target = "stock", constant = "74")
    fun toComponentModel(entities: ComponentEntity): ComponentDto

    fun toComponentEntity(componentDto: ComponentDto): ComponentEntity

    fun toCategoriesModels(entities: List<CategoryEntity>): List<CategoryDto>

    @Mapping(target = "qty", expression = "java(entities.getComponents().size())")
    fun toCategoryModel(entities: CategoryEntity?): CategoryDto?
    fun toCategoryEntity(categoryDto: CategoryDto): CategoryEntity

}