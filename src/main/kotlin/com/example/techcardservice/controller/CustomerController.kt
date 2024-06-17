package com.example.techcardservice.controller

import com.example.techcardservice.dto.CustomerDto
import com.example.techcardservice.service.CustomerService
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.web.bind.annotation.*

@RestController
@CrossOrigin(origins = ["*"])
@RequestMapping("/api/v1/customer")
class CustomerController(private val customerService: CustomerService) {

    @PostMapping
    fun addCustomer(@RequestBody customerDto: CustomerDto): Long? =
        customerService.addCustomer(customerDto)

    @DeleteMapping("/{id}")
    fun deleteCustomer(@PathVariable id: Long) =
        customerService.deleteCustomer(id)

    @GetMapping("/{id}")
    fun getCustomer(
        @PathVariable id: Long,
        @RequestParam(required = false, defaultValue = "false") showBalance: Boolean,
    ) =
        customerService.getCustomer(id, showBalance)

    @GetMapping("/meta")
    fun getCustomers(
        @RequestParam(required = false, defaultValue = "false") showBalance: Boolean,
    ): List<CustomerDto> =
        customerService.getCustomersMeta(showBalance)

    @GetMapping
    fun getCustomers(
        @RequestParam(required = false, defaultValue = "false") showBalance: Boolean,
        pageable: Pageable,
    ): Page<CustomerDto> =
        customerService.getCustomers(showBalance, pageable)
}