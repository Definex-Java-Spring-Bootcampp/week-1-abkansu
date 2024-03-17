package com.patika.kredinbizdenservice.mockRepo;

import com.patika.kredinbizdenservice.model.Application;
import com.patika.kredinbizdenservice.model.User;


import java.util.List;

public class MockApplicationRepo {
    private final MockUserRepo mockUserRepo;

    public MockApplicationRepo(MockUserRepo mockUserRepo) {
        this.mockUserRepo = mockUserRepo;
    }

    public List<Application> getAll(){
        return mockUserRepo.getAll().stream().map(User::getApplicationList).flatMap(List::stream).toList();
    }
}
