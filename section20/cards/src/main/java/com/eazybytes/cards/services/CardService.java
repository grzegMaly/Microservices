package com.eazybytes.cards.services;

import com.eazybytes.cards.dto.CardDto;

public interface CardService {
    void createCard(String mobileNumber);

    CardDto fetchCard(String mobileNumber);

    boolean updateCard(CardDto cardDto);

    boolean deleteCard(String mobileNumber);
}
