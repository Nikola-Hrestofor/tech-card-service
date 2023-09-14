package com.example.techcardservice.repository

import com.example.techcardservice.repository.entity.CategoryEntity
import com.example.techcardservice.repository.entity.ComponentEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.repository.PagingAndSortingRepository

interface ComponentRepository : PagingAndSortingRepository<ComponentEntity, Long>, JpaRepository<ComponentEntity, Long> {
    fun getByNameAndCode(name: String, code: String) : ComponentEntity?
}