package com.example.techcardservice.repository

import com.example.techcardservice.repository.entity.ComponentEntity
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.PagingAndSortingRepository

interface ComponentRepository : PagingAndSortingRepository<ComponentEntity, Long>,
    JpaRepository<ComponentEntity, Long> {

    @Query(
        "" +
                "select c from ComponentEntity c " +
                "where 1 = 1 " +
                "   and (:#{#code} is null or :#{#code} = c.code or :#{#code} = c.name ) " +
                "   and (:#{#categoryId} is null or :#{#categoryId} = c.category.id)"
    )
    fun getComponentsByFilter(code: String?, categoryId: Long?, pageable: Pageable): Page<ComponentEntity>
    fun getByNameAndCode(name: String, code: String): ComponentEntity?

    fun getByCategoryId(categoryId: Long): List<ComponentEntity>
}