package com.example.techcardservice.repository

import com.example.techcardservice.repository.entity.CardEntity
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.repository.PagingAndSortingRepository
import org.springframework.stereotype.Repository

@Repository
interface CardRepository : PagingAndSortingRepository<CardEntity, Long>, JpaRepository<CardEntity, Long> {
    fun findAllByName(name: String?, pageable: Pageable): Page<CardEntity>

}