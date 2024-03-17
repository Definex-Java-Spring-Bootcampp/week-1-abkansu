package com.patika.kredinbizdenservice;

import com.patika.kredinbizdenservice.mockRepo.MockApplicationRepo;
import com.patika.kredinbizdenservice.mockRepo.MockUserRepo;
import com.patika.kredinbizdenservice.service.ApplicationService;
import com.patika.kredinbizdenservice.service.CreditcardService;
import com.patika.kredinbizdenservice.service.UserService;
import com.patika.onlineshop.bill.service.BillService;
import com.patika.onlineshop.customer.repo.MockCustomerRepo;
import com.patika.onlineshop.customer.service.CustomerService;

import java.math.BigDecimal;

public class Main {

    public static void main(String[] args) {
        // REPO CREATION
        MockCustomerRepo mockCustomerRepo = new MockCustomerRepo();
        MockUserRepo mockUserRepo = MockUserRepo.getInstance(); // Singleton
        MockApplicationRepo mockApplicationRepo = new MockApplicationRepo(mockUserRepo);

        // ALL PRINT
        System.out.println("ALL APPLICATIONS");
        mockApplicationRepo.getAll().forEach(application -> System.out.println(application.toString()));

        System.out.println("ALL USERS");
        mockUserRepo.getAll().forEach(user -> System.out.println(user.toString()));

        System.out.println("ALL CUSTOMERS");
        mockCustomerRepo.getAll().forEach(customer -> System.out.println(customer.toString()));

        // SERVICE CREATION
        UserService userService = new UserService(mockUserRepo);
        CreditcardService creditcardService = new CreditcardService();
        CustomerService customerService = new CustomerService();
        BillService billService = new BillService(mockCustomerRepo);

        // TESTS
        System.out.println("QUESTION 1 - MOST APPLIED USER");
        userService.getMostAppliedUser();
        System.out.println("QUESTION 2 - MOST LOANED USER");
        userService.getMostLoanedUser();
        System.out.println("QUESTION 3 - LIST APPPLICATIONS BY MAIL");
        userService.listApplicationsByEmail("abkansu1@gmail.com");
        System.out.println("QUESTION 4 - CREDIT CARDS BY CREDIT CAMPAIGNS");
        creditcardService.listCampaigns();
        System.out.println("QUESTION 5 - SAVE USER WITH SAME EMAIL");
        userService.saveUser("new", "user", "abkansu0@gmail.com", "1234", "555 050 0505", true);
        mockUserRepo.getAll().forEach(user -> System.out.println(user.toString()));
        System.out.println("QUESTION 6 - SAVE USER WITH DIFFERENT EMAIL");
        userService.saveUser("new", "user", "abkansu99@gmail.com", "1234", "555 050 0505", true);
        mockUserRepo.getAll().forEach(user -> System.out.println(user.toString()));
        System.out.println("QUESTION 7 - CUSTOMER COUNT");
        customerService.getCustomersSize();
        System.out.println("QUESTION 8 - CUSTOMER BILL SIZE");
        customerService.getCustomerBillSizeByNameAndAge("Bera0", 0, 35);
        System.out.println("QUESTION 9 - CUSTOMER PRODUCTS BY NAME");
        customerService.listCustomerProductsSizeByName("Bera0");
        System.out.println("QUESTION 10 - BILLS GREATER THAN");
        billService.listBillsGreaterThan(BigDecimal.valueOf(156));

    }
}
