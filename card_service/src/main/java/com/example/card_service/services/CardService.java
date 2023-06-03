package com.example.card_service.services;

import java.util.List;

import com.example.card_service.entities.Card;

public interface CardService {
    public List<Card> getCardDetails(long customerId);
}
