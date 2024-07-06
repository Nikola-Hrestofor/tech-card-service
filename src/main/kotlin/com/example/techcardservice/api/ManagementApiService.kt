package com.example.techcardservice.api

import com.example.techcardservice.config.FeignConfig
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import java.math.BigDecimal

@FeignClient(
    name = "management",
    path = "/api/v1",
    url = "\${spring.services.management.host}",
    configuration = [FeignConfig::class]
)
interface ManagementApiService {
    @GetMapping("/balance/{customerId}")
    fun getBalanceByCustomer(@PathVariable customerId: Long): BigDecimal
}