package com.example.techcardservice.service

import com.example.techcardservice.api.WarehouseService
import com.example.techcardservice.dto.CardDto
import com.example.techcardservice.repository.CardRepository
import com.example.techcardservice.repository.entity.CardEntity
import com.example.techcardservice.repository.mapper.CardMapper
import com.example.warehouseservice.dto.enums.UnitType
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.math.BigDecimal
import java.util.*
import java.util.logging.Logger

@Service
class CardService(
    val cardRepository: CardRepository,
    val cardMapper: CardMapper,
    val warehouseService: WarehouseService,
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

    fun getById(id: Long): CardDto {

        val toCardModel = cardMapper.toCardModel(cardRepository.findById(id).orElse(null));

        toCardModel.components.forEach() {
            it.component.stock =
                Optional.ofNullable(warehouseService.getUnit(UnitType.COMPONENT, it.component.id).amount)
                    .orElse(BigDecimal.ZERO)
        }

        return toCardModel
    }

    fun deleteCard(id: Long) {
        logger.info("delete by id $id")
        cardRepository.deleteById(id)
    }

    @Transactional
    fun addCard(cardDto: CardDto): Long? {
        val entity = cardMapper.toCardEntity(cardDto)

        logger.info(
            "dto $cardDto; \n" +
                    "| entity $entity"
        )

        val cardId = cardRepository.save(CardEntity(id = cardDto.id)).id
        entity.id = cardId
        entity.components.map { cardRelationComponentEntity -> cardRelationComponentEntity.card.id = cardId }
        return cardRepository.save(entity).id

    }
}