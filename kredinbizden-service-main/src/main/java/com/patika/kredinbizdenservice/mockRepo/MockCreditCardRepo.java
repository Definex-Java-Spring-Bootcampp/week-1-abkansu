package com.patika.kredinbizdenservice.mockRepo;

import com.patika.kredinbizdenservice.enums.SectorType;
import com.patika.kredinbizdenservice.model.Campaign;
import com.patika.kredinbizdenservice.model.CreditCard;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class MockCreditCardRepo {

    public static List<CreditCard> getAll(){
        List<CreditCard> creditCardList = new ArrayList<>();

        for(int i = 0; i < 10; i++){
            List<Campaign> campaignList = new ArrayList<>();
            int random = 3 + (int)(Math.random() * ((15 - 3) + 1));
            for(int j = 0; j < random; j++){
                campaignList.add(
                        new Campaign("campaign" + j, "content" + j, LocalDate.now(), LocalDate.now(), LocalDate.now(), SectorType.OTHERS)
                );
            }
            creditCardList.add(
                    new CreditCard(BigDecimal.TEN, campaignList)
            );
        }
        return creditCardList;
    }
}
