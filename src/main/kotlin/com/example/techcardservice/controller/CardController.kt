package com.example.techcardservice.controller

import com.example.techcardservice.dto.CardDto
import com.example.techcardservice.service.CardService
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.web.bind.annotation.*
import java.util.LinkedList
import java.util.logging.Logger

@RestController
@RequestMapping("/api/v1/cards")
class CardController(val cardService: CardService) {

    companion object {
        val logger = Logger.getLogger(CardController::class.java.name)
    }

    @PostMapping
    fun addNewCard(@RequestBody cardDto: CardDto): Long {
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
//        val list = LinkedList<Pair<String, String>>()
//        list.add(Pair("sasas", "sasa"))
//        list.add(Pair("reer", "gfv"))
//        list.add(Pair("dfcx", "cvcv"))
//        return CardDto(12, "someName", list)
    }

    @DeleteMapping
    fun deleteCard(id: Long){
        cardService.deleteCard(id)
    }
}