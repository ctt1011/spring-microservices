package com.example.card_service.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.card_service.entities.Card;

public interface CardRepository extends CrudRepository<Card, Long> {

    List<Card> findByCustomerId(long customerId);

}
