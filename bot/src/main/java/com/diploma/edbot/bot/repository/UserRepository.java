package com.diploma.edbot.bot.repository;

import com.diploma.edbot.bot.core.model.domain.DomainUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository extends JpaRepository<DomainUser, String> {

    DomainUser findUserByGuid(UUID guid);
    DomainUser findUserByGradeBookNumber(String gradeBookNumber);
    DomainUser findDomainUserByViberId(String viberId);
}
