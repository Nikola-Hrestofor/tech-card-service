package com.example.techcardservice.service

import com.example.techcardservice.api.ManagementApiService
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
    private val managementApiService: ManagementApiService
) {
    fun getCustomers(showBalance: Boolean, pageable: Pageable): Page<CustomerDto> {
        val customers = customerRepository.findAll(pageable)
            .map { customerEntity -> customerMapper.toCustomerModel(customerEntity) }
        if (showBalance) {
            customers.map { it.balance = managementApiService.getBalanceByCustomer(it.id) }
        }
        return customers
    }

    fun getCustomersMeta(showBalance: Boolean): List<CustomerDto> {
        val customers = customerMapper.toCustomerModel(customerRepository.findAll())
        if (showBalance) {
            customers.map { it.balance = managementApiService.getBalanceByCustomer(it.id) }
        }
        return customers
    }

    fun getCustomer(id: Long, showBalance: Boolean) : CustomerDto {
        val customer = customerMapper.toCustomerModel(customerRepository.findById(id).orElseThrow())

        if (showBalance) {
            customer.balance = managementApiService.getBalanceByCustomer(customer.id)
        }

        return customer
    }

    fun addCustomer(customerDto: CustomerDto): Long? =
        customerRepository.save(customerMapper.toCustomerEntity(customerDto)).id

    fun deleteCustomer(id: Long) = customerRepository.deleteById(id)
}