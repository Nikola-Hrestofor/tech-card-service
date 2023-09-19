package com.example.techcardservice.repository

import com.example.techcardservice.repository.entity.CategoryEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.repository.PagingAndSortingRepository

interface CategoryRepository : PagingAndSortingRepository<CategoryEntity, Long>, JpaRepository<CategoryEntity, Long> {
    fun findByName(name: String) : CategoryEntity?
}