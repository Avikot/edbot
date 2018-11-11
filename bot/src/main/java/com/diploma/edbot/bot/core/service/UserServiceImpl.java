package com.diploma.edbot.bot.core.service;

import com.diploma.edbot.bot.core.model.domain.DomainUser;
import com.diploma.edbot.bot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private UserRepository userRepository;

    @Override
    public DomainUser findUserByGuid(UUID guid) {
        return userRepository.findUserByGuid(guid);
    }

    @Override
    public DomainUser findUserById(String id) {
        return userRepository.findDomainUserByViberId(id);
    }

    @Override
    public DomainUser findUserDyGradeBookNumber(String gradeBookNumber) {
        return userRepository.findUserByGradeBookNumber(gradeBookNumber);
    }

    @Override
    public DomainUser saveOrUpdate(DomainUser domainUser) {
        return userRepository.save(domainUser);
    }

    @Override
    public List<DomainUser> findAllUsers() {
        return userRepository.findAll();
    }
}
