package com.example.card_service.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.card_service.entities.Card;
import com.example.card_service.services.CardService;

@RestController
@RequestMapping("/api/v1/cards")
public class CardController {
    @Autowired
    private CardService cardService;

    @GetMapping("/customers/{customerId}")
    public List<Card> getCardDetails(@PathVariable long customerId) {
        return cardService.getCardDetails(customerId);
    }
}
