package com.patika.kredinbizdenservice.service;

import com.patika.kredinbizdenservice.enums.OutputStatus;
import com.patika.kredinbizdenservice.mockRepo.MockApplicationRepo;
import com.patika.kredinbizdenservice.mockRepo.MockUserRepo;
import com.patika.kredinbizdenservice.model.Application;
import com.patika.kredinbizdenservice.model.Loan;
import com.patika.kredinbizdenservice.model.User;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

import static java.util.Map.entry;
import static java.util.stream.Collectors.groupingBy;

public class UserService {
    private final MockUserRepo mockUserRepo;

    public UserService(MockUserRepo mockUserRepo) {
        this.mockUserRepo = mockUserRepo;
    }

    // WITH BIRTHDATE
    public OutputStatus saveUser(String name, String surname, LocalDate birthDate, String email, String password, String phoneNumber, Boolean isActive) {
        boolean emailExists = mockUserRepo.getAll().stream().filter(User::getActive).map(User::getEmail).anyMatch(userEmail -> userEmail.equals(email));

        if (emailExists) {
            System.out.println(OutputStatus.ERROR.name());
            return OutputStatus.ERROR;
        }
        User user = new User(name, surname, birthDate, email, password, phoneNumber, isActive);
        mockUserRepo.add(user);

        System.out.println(OutputStatus.SUCCESS.name());
        return OutputStatus.SUCCESS;
    }

    // NO BIRTHDATE OVERRIDE
    public OutputStatus saveUser(String name, String surname, String email, String password, String phoneNumber, Boolean isActive) {
        boolean emailExists = mockUserRepo.getAll().stream().filter(User::getActive).map(User::getEmail).anyMatch(userEmail -> userEmail.equals(email));

        if (emailExists) {
            System.out.println(OutputStatus.ERROR.name());

            return OutputStatus.ERROR;
        }
        User user = new User(name, surname, email, password, phoneNumber, isActive);
        mockUserRepo.add(user);

        System.out.println(OutputStatus.SUCCESS.name());
        return OutputStatus.SUCCESS;
    }

    public User getMostAppliedUser() {
        Map<Integer, List<User>> userMapWithApplicationSize = mockUserRepo.getAll().stream()
                .filter(User::getActive)
                .collect(groupingBy(user -> user.getApplicationList().size()));
        User user = userMapWithApplicationSize.get(
                userMapWithApplicationSize.keySet().stream().max(Integer::compareTo).get()
        ).get(0);

        System.out.println(user.toString() + " Times applied: "  + user.getApplicationList().size());
        return user;
    }

    public Map<User, BigDecimal> getMostLoanedUser() {

        Map<User, BigDecimal> userLoanMap = new HashMap<>();
        mockUserRepo.getAll().forEach(user -> {
            BigDecimal allLoan = user.getApplicationList().stream().map(Application::getLoan).map(Loan::getAmount).reduce(BigDecimal.ZERO, BigDecimal::add);
            userLoanMap.put(user, allLoan);
        });

        Map<User, BigDecimal> maxValues = new HashMap<>();
        Optional<BigDecimal> max = userLoanMap.values().stream().max(BigDecimal::compareTo);
        if (max.isPresent()){
            userLoanMap.entrySet().forEach(userBigDecimalEntry -> {
                if (userBigDecimalEntry.getValue().equals(max.get())){
                    maxValues.put(userBigDecimalEntry.getKey(), userBigDecimalEntry.getValue());
                }
            }
            );
        }
        maxValues.forEach((key, value) -> System.out.println("User: " + key.getName() + " " + key.getSurname() + " Loan Amount: " + value.toString()));
        return maxValues;
    }

    public List<Application> listApplicationsByEmail(String email){
        List<Application> applicationList = mockUserRepo.getAll().stream().filter(user -> user.getEmail().equals(email)).findFirst().get().getApplicationList();
        applicationList.forEach(application -> System.out.println(application.toString()));
        return applicationList;
    }
}
