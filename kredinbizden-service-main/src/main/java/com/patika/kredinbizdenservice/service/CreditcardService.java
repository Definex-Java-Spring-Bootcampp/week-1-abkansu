package com.patika.kredinbizdenservice.service;

import com.patika.kredinbizdenservice.mockRepo.MockCreditCardRepo;
import com.patika.kredinbizdenservice.model.CreditCard;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CreditcardService {
    private final List<CreditCard> creditCardList;

    public CreditcardService(){
        this.creditCardList = MockCreditCardRepo.getAll();
    }

    public List<CreditCard> listCampaigns(){
        List<CreditCard> sorted = new java.util.ArrayList<>(creditCardList.stream().sorted(Comparator.comparing(creditCard -> creditCard.getCampaignList().size())).toList());
        Collections.reverse(sorted);
        sorted.forEach(creditCard -> System.out.println(creditCard.toString()));
        return sorted;
    }
}
