package com.patika.kredinbizdenservice.mockRepo;

import com.patika.kredinbizdenservice.model.Application;
import com.patika.kredinbizdenservice.model.HouseLoan;
import com.patika.kredinbizdenservice.model.Loan;
import com.patika.kredinbizdenservice.model.User;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class MockUserRepo {

    private static List<User> userList = new ArrayList<>();
    private static MockUserRepo instance;

    private MockUserRepo() {
        populateUsers();
    }
    public static synchronized MockUserRepo getInstance() {
        if (instance == null) {
            instance = new MockUserRepo();
        }
        return instance;
    }

    public List<User> getAll(){
        return this.userList;
    }

    private void populateUsers(){
        for(int i = 0; i < 10; i++){
            User user = new User("Bera" + i,
                    "Kansu" + i,
                    "abkansu" + i + "@gmail.com",
                    "password" + i,
                    "555 999 656" + i,
                    true);
            List<Application> applications = new ArrayList<>();
            int random = 3 + (int)(Math.random() * ((15 - 3) + 1));
            for(int j = 0; j < random; j++){
                Loan loan = new HouseLoan(BigDecimal.TEN.add(BigDecimal.valueOf(random)), 10, (double) (10 + i));
                applications.add(new Application(
                        loan,
                        user,
                        LocalDateTime.now()
                ));
            }
            user.setApplicationList(applications);
            userList.add(user);
        }
    }

    public void add(User user){
        this.userList.add(user);
    }
}
