package com.patika.kredinbizdenservice.service;

import com.patika.kredinbizdenservice.mockRepo.MockApplicationRepo;
import com.patika.kredinbizdenservice.mockRepo.MockUserRepo;
import com.patika.kredinbizdenservice.model.Application;

import java.time.LocalDateTime;
import java.util.List;

public class ApplicationService {
    private final MockApplicationRepo mockApplicationRepo;

    public ApplicationService(MockUserRepo mockUserRepo) {
        this.mockApplicationRepo = new MockApplicationRepo(mockUserRepo);
    }

    public List<Application> getAllApplicationsInOneMonth(){
        return mockApplicationRepo.getAll().stream()
                .filter(application -> application.getLocalDateTime()
                        .isAfter(LocalDateTime.now().minusMonths(1))).toList();
    }
}
