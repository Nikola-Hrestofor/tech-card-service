package com.example.techcardservice.api

import com.example.techcardservice.api.dto.WarehouseRequest
import com.example.techcardservice.config.FeignConfig
import com.example.warehouseservice.dto.enums.UnitType
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam

@FeignClient(name = "warehouse", path = "/api/v1/warehouse", url = "\${spring.services.warehouse.host}", configuration = [FeignConfig::class])
interface WarehouseService {
    @GetMapping("/unit")
    fun getUnit(@RequestParam unitType: UnitType, @RequestParam childId: Long?): WarehouseRequest

}