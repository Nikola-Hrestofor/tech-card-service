package com.example.techcardservice.api.dto

import com.example.warehouseservice.dto.enums.UnitType
import java.math.BigDecimal

data class WarehouseRequest(
        var amount: BigDecimal?,
        var cost: BigDecimal?,
        var type: UnitType,
        var childId: Long,
        var orderNumber: String?
)
