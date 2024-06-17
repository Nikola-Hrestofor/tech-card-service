package com.example.techcardservice.repository.mapper

import com.example.techcardservice.dto.CustomerDto
import com.example.techcardservice.repository.entity.CustomerEntity
import org.mapstruct.Mapper

@Mapper
interface CustomerMapper {
    fun toCustomerModel(customerEntity: CustomerEntity): CustomerDto
    fun toCustomerModel(customerEntity: List<CustomerEntity>): List<CustomerDto>

    fun toCustomerEntity(customerDto: CustomerDto): CustomerEntity
}