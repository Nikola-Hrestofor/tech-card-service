package com.example.techcardservice.service

import com.example.techcardservice.dto.CustomerDto
import com.example.techcardservice.repository.CustomerRepository
import com.example.techcardservice.repository.mapper.CustomerMapper
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service

@Service
class CustomerService(
    private val customerRepository: CustomerRepository,
    private val customerMapper: CustomerMapper,
) {
    fun getCustomers(showBalance: Boolean, pageable: Pageable): Page<CustomerDto> {
        return customerRepository.findAll(pageable)
            .map { customerEntity -> customerMapper.toCustomerModel(customerEntity) }
    }

    fun getCustomersMeta(showBalance: Boolean): List<CustomerDto> {
        return customerMapper.toCustomerModel(customerRepository.findAll())
    }

    fun getCustomer(id: Long, showBalance: Boolean) : CustomerDto =
        customerMapper.toCustomerModel(customerRepository.findById(id).orElseThrow())

    fun addCustomer(customerDto: CustomerDto): Long? =
        customerRepository.save(customerMapper.toCustomerEntity(customerDto)).id

    fun deleteCustomer(id: Long) = customerRepository.deleteById(id)
}