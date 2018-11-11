package com.diploma.edbot;

import com.diploma.edbot.bot.core.model.User;
import com.diploma.edbot.bot.core.model.domain.DomainUser;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;

import java.time.LocalDate;
import java.util.UUID;

public final class EdbotTestHelper {

    private EdbotTestHelper() {
    }

    public static DomainUser nextDomainUser() {
        DomainUser domainUser = new DomainUser();

        domainUser.setGuid(UUID.randomUUID());
        domainUser.setGradeBookNumber(RandomStringUtils.randomAlphabetic(10));
        domainUser.setUser(nextViberUser());
        domainUser.setSubscribed(RandomUtils.nextBoolean());
        domainUser.setCreatedAt(LocalDate.now());
        domainUser.setUpdatedAt(LocalDate.now());

        return domainUser;
    }

    public static User nextViberUser() {
        User user = new User();

        user.setName(RandomStringUtils.randomAlphabetic(10));
        user.setLanguage(RandomStringUtils.randomAlphabetic(2));
        user.setId(RandomStringUtils.randomAlphabetic(10));
        user.setCountry(RandomStringUtils.randomAlphabetic(2));
        user.setAvatar(RandomStringUtils.randomAlphabetic(10));
        user.setApiVersion(RandomStringUtils.randomAlphabetic(5));

        return user;
    }
}
