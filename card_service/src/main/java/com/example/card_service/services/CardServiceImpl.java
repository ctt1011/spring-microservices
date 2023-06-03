package com.example.card_service.services;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.card_service.entities.Card;
import com.example.card_service.repositories.CardRepository;

@Service
public class CardServiceImpl implements CardService {

    @Autowired
    private CardRepository cardRepository;

    @Override
    public List<Card> getCardDetails(long customerId) {
        List<Card> cards = cardRepository.findByCustomerId(customerId);
        if (cards != null) {
            return cards;
        } else {
            return Collections.emptyList();
        }
    }

}
