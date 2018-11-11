package com.diploma.edbot.bot.core.service;

import com.diploma.edbot.bot.core.model.domain.DomainUser;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface UserService {

    DomainUser findUserByGuid(UUID guid);
    DomainUser findUserById(String id);
    DomainUser findUserDyGradeBookNumber(String gradeBookNumber);
    DomainUser saveOrUpdate(DomainUser domainUser);
    List<DomainUser> findAllUsers();
}
