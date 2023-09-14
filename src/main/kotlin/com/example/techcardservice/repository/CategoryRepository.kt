package com.example.techcardservice.repository

import com.example.techcardservice.repository.custom.CategoryRepositoryCustom
import com.example.techcardservice.repository.entity.CategoryEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.repository.PagingAndSortingRepository

interface CategoryRepository : PagingAndSortingRepository<CategoryEntity, Long>, JpaRepository<CategoryEntity, Long>, CategoryRepositoryCustom {
    fun findByName(name: String) : CategoryEntity?
}