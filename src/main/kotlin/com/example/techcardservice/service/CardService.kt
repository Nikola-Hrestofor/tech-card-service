package com.example.techcardservice.service

import com.example.techcardservice.dto.CardDto
import com.example.techcardservice.repository.CardAttributeRepository
import com.example.techcardservice.repository.CardRepository
import com.example.techcardservice.repository.mapper.CardMapper
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import java.util.logging.Logger

@Service
class CardService(
    val cardRepository: CardRepository,
    val cardAttributeRepository: CardAttributeRepository,
    val cardMapper: CardMapper
) {
    companion object {
        val logger = Logger.getLogger(CardService::class.java.name)
    }

    fun getList(name: String?, pageable: Pageable): Page<CardDto> {
        logger.info("pageable $pageable")
        if (name == null || name == "") {
            return cardRepository.findAll(pageable).map { cardEntity -> cardMapper.toCardModel(cardEntity) }
        }
        return cardRepository.findAllByName(name, pageable).map { cardEntity -> cardMapper.toCardModel(cardEntity) }
    }

    fun deleteCard(id: Long) {
        logger.info("delete by id $id")
//        cardRepository.removeById(id)
        cardRepository.deleteById(id)
    }

    fun addCard(cardDto: CardDto): Long {
        logger.info("entity ${cardMapper.toCardModel(cardMapper.toCardEntity(cardDto))}")
//        return 1
val cardAttrib = cardDto.attributes
        val id = cardRepository.save(cardMapper.toCardEntity(cardDto)).id
        logger.info("id is $id")
        cardAttrib?.forEach { cardAttribute -> cardAttribute.cardId = id }
        logger.info("cardAttrib $cardAttrib")
        val attributes = cardMapper.toCardAttributesEntity(cardAttrib)
        cardAttributeRepository.saveAll(attributes)
        return id
    }
}