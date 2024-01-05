package com.example.techcardservice.controller

import com.example.techcardservice.dto.CardDto
import com.example.techcardservice.service.CardService
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.web.bind.annotation.*
import java.util.logging.Logger

@RestController
@CrossOrigin(origins = ["*"])
@RequestMapping("/api/v1/cards")
class CardController(val cardService: CardService) {

    companion object {
        val logger = Logger.getLogger(CardController::class.java.name)
    }

    @PostMapping
    fun addNewCard(@RequestBody cardDto: CardDto): Long? {
        logger.info("new card $cardDto")
        return cardService.addCard(cardDto)
    }

    @GetMapping
    fun getCards(
            @RequestParam(required = false, defaultValue = "") name: String?,
            pageable: Pageable
    )
            : Page<CardDto> {
        val entity = cardService.getList(name, pageable)
        logger.info("entity $entity")
        return entity;
    }

    @GetMapping("/{id}")
    fun getCardsById(
            @PathVariable id: Long,
    )
            : CardDto {
        val entity = cardService.getById(id)
        logger.info("entity $entity")
        return entity;
    }

    @DeleteMapping
    fun deleteCard(id: Long) {
        cardService.deleteCard(id)
    }
}