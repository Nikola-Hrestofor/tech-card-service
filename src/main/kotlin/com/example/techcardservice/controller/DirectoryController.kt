package com.example.techcardservice.controller

import com.example.techcardservice.dto.CategoryDto
import com.example.techcardservice.dto.ComponentDto
import com.example.techcardservice.service.CategoryService
import com.example.techcardservice.service.ComponentService
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.web.bind.annotation.*
import java.util.logging.Logger

@RestController
@RequestMapping("/api/v1/directory")
class DirectoryController(val categoryService: CategoryService,
    val componentService: ComponentService) {

    companion object {
        val logger = Logger.getLogger(DirectoryController::class.java.name)
    }
    @GetMapping("/category")
    fun getCategory(pageable: Pageable): Page<CategoryDto> {
        return categoryService.getCategory(pageable)
    }

    @PostMapping("/category")
    fun addCategory(@RequestBody categoryDto: CategoryDto): Long? {
        logger.info("new category dto")
        return categoryService.addCategory(categoryDto)
    }

    @DeleteMapping("/category/{id}")
    fun deleteCategory(@PathVariable id: Long) {
        categoryService.deleteCategory(id)
    }

    @GetMapping("/component")
    fun getComponent(pageable: Pageable): Page<ComponentDto> {
        return componentService.getComponent(pageable)
    }

    @PostMapping("/component")
    fun addComponent(@RequestBody componentDto: ComponentDto): Long? {
        logger.info("new component dto $componentDto")
        return componentService.addComponent(componentDto)
    }

    @DeleteMapping("/component/{id}")
    fun deleteComponent(@PathVariable id: Long) {
        componentService.deleteComponent(id)
    }
}