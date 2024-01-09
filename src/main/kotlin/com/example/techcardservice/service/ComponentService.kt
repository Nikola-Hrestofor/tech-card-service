package com.example.techcardservice.service

import com.example.techcardservice.api.WarehouseService
import com.example.techcardservice.dto.ComponentDto
import com.example.techcardservice.repository.ComponentRepository
import com.example.techcardservice.repository.entity.CategoryEntity
import com.example.techcardservice.repository.entity.ComponentEntity
import com.example.techcardservice.repository.mapper.CardMapper
import com.example.warehouseservice.dto.enums.UnitType
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import java.math.BigDecimal
import java.util.*
import java.util.logging.Logger

@Service
class ComponentService(
    val componentRepository: ComponentRepository,
    val categoryService: CategoryService,
    val cardMapper: CardMapper,
    val warehouseService: WarehouseService
) {
    companion object {
        val logger = Logger.getLogger(ComponentService::class.java.name)
    }

    fun getComponent(code: String?, categoryId: Long?, pageable: Pageable): Page<ComponentDto> {
        val entity = componentRepository.getComponentsByFilter(code, categoryId, pageable)
        val dto = entity.map { componentEntity ->
            cardMapper.toComponentModel(componentEntity)
        }
        logger.info("dto ${dto.content}")
        val unit = warehouseService.getUnit(UnitType.COMPONENT, 2)
        logger.info("unit $unit")
        dto.content.forEach {
            it.stock =
                Optional.ofNullable(warehouseService.getUnit(UnitType.COMPONENT, it.id).amount).orElse(BigDecimal.ZERO)
        }
        return dto
    }

    fun addComponent(componentDto: ComponentDto): Long? {
        val id = componentRepository.getByNameAndCode(componentDto.name, componentDto.code)?.id
        if (id !== null) {
            return id
        }
        var categoryId = componentDto.category.id
        val entity = cardMapper.toComponentEntity(componentDto)
        if (categoryId == null || categoryId == 0L) {
            categoryId = categoryService.addCategory(componentDto.category)
            entity.category.id = categoryId
        }
        logger.info("component entity $entity")

        return componentRepository.save(entity).id
    }

    fun deleteComponent(id: Long) {
        componentRepository.deleteById(id)
    }

    fun getComponentById(id: Long): ComponentDto {
        val entity = componentRepository.findById(id).orElse(null);
        val dto = cardMapper.toComponentModel(entity)

        logger.info("dto ${dto}")
        val unit = warehouseService.getUnit(UnitType.COMPONENT, 2)
        logger.info("unit $unit")

        return dto
    }


}