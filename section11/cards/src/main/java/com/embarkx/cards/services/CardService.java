package com.embarkx.cards.services;

import com.embarkx.cards.dto.CardDto;

public interface CardService {
    void createCard(String mobileNumber);

    CardDto fetchCard(String mobileNumber);

    boolean updateCard(CardDto cardDto);

    boolean deleteCard(String mobileNumber);
}
