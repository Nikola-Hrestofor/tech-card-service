package com.example.techcardservice.service

import com.example.techcardservice.dto.CategoryDto
import com.example.techcardservice.repository.CategoryRepository
import com.example.techcardservice.repository.mapper.CardMapper
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import java.util.logging.Logger

@Service
class CategoryService(val categoryRepository: CategoryRepository,
    val cardMapper: CardMapper) {
    companion object {
        val logger = Logger.getLogger(CategoryService::class.java.name)
    }
    fun getCategory(pageable: Pageable): Page<CategoryDto> {
        logger.info("get all category")
        return categoryRepository.findAll(pageable).map { categoryEntity ->
            cardMapper.toCategoryModel(categoryEntity)
        }
    }

    fun addCategory(categoryDto: CategoryDto): Long? {
        logger.info("add category $categoryDto")
        val id = cardMapper.toCategoryModel(categoryRepository.findByName(categoryDto.name))?.id
        if (id != null && id > 0)
            return id
        return categoryRepository.save(cardMapper.toCategoryEntity(categoryDto)).id
    }

    fun deleteCategory(id: Long) {
        logger.info("delete category with id $id")
        categoryRepository.deleteById(id)
    }

}