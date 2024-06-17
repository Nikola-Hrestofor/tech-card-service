package com.example.techcardservice.repository

import com.example.techcardservice.repository.entity.CustomerEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.repository.PagingAndSortingRepository

interface CustomerRepository : PagingAndSortingRepository<CustomerEntity, Long>, JpaRepository<CustomerEntity, Long> {
}