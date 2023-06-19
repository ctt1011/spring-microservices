package com.example.card_service.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.card_service.configs.CardServiceConfig;
import com.example.card_service.entities.Card;
import com.example.card_service.entities.Property;
import com.example.card_service.services.CardService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

@RestController
@RequestMapping("/api/v1/cards")
public class CardController {
    @Autowired
    private CardService cardService;

    @Autowired
    private CardServiceConfig cardServiceConfig;

    @GetMapping("/customers/{customerId}")
    public List<Card> getCardDetails(@PathVariable long customerId) {
        return cardService.getCardDetails(customerId);
    }

    @GetMapping("/properties")
    public String getProperties() throws JsonProcessingException {
        ObjectWriter objectWriter = new ObjectMapper().writer().withDefaultPrettyPrinter();
        Property property = Property.builder()
                .msg(cardServiceConfig.getMsg())
                .buildVersion(cardServiceConfig.getBuildVersion())
                .mailDetails(cardServiceConfig.getMailDetails())
                .activeBranches(cardServiceConfig.getActiveBranches())
                .build();
        return objectWriter.writeValueAsString(property);
    }
}
