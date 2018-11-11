package com.diploma.edbot.metadata;

import com.diploma.edbot.EdbotTestHelper;
import com.diploma.edbot.IntegrationTest;
import com.diploma.edbot.bot.core.model.User;
import com.diploma.edbot.bot.core.model.domain.DomainUser;
import com.diploma.edbot.bot.core.service.UserService;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Ignore
@IntegrationTest
@RunWith(SpringJUnit4ClassRunner.class)
public class UserServiceIT {

    @Autowired
    private UserService userService;

    @Test
    @Commit
    public void save_user() {
        DomainUser domainUser = new DomainUser();

        domainUser.setCreatedAt(LocalDate.now());
        domainUser.setUpdatedAt(LocalDate.now());
        domainUser.setGradeBookNumber(RandomStringUtils.randomAlphabetic(10));
        domainUser.setSubscribed(true);
        domainUser.setGuid(UUID.randomUUID());

        User user = new User();
        user.setApiVersion(RandomStringUtils.randomAlphabetic(3));
        user.setAvatar(RandomStringUtils.randomAlphabetic(5));
        user.setCountry("Ukraine");
        user.setId(RandomStringUtils.randomAlphabetic(10));
        user.setLanguage("Ukrainian");
        user.setName("John McClane");

        domainUser.setUser(user);

        userService.saveOrUpdate(domainUser);

        domainUser.setGradeBookNumber("new");
        userService.saveOrUpdate(domainUser);

        domainUser.setGuid(UUID.randomUUID());
        userService.saveOrUpdate(domainUser);
    }

    @Test
    public void find_all_users() {
        userService.saveOrUpdate(EdbotTestHelper.nextDomainUser());
        userService.saveOrUpdate(EdbotTestHelper.nextDomainUser());
        userService.saveOrUpdate(EdbotTestHelper.nextDomainUser());

        List<DomainUser> allUsers = userService.findAllUsers();

        Assert.assertNotNull(allUsers);
        Assert.assertEquals(allUsers.size(), 3);
    }

    @Test
    public void find_user_by_guid() {
        DomainUser domainUser = EdbotTestHelper.nextDomainUser();
        userService.saveOrUpdate(domainUser);
        userService.saveOrUpdate(EdbotTestHelper.nextDomainUser());

        DomainUser userByGuid = userService.findUserByGuid(domainUser.getGuid());

        Assert.assertNotNull(userByGuid);
        Assert.assertEquals(userByGuid.getGradeBookNumber(), domainUser.getGradeBookNumber());
        Assert.assertEquals(userByGuid.getViberId(), domainUser.getViberId());
    }


    @Test
    public void find_user_by_viber_id() {
        DomainUser domainUser = EdbotTestHelper.nextDomainUser();
        userService.saveOrUpdate(domainUser);
        userService.saveOrUpdate(EdbotTestHelper.nextDomainUser());

        DomainUser userByGuid = userService.findUserById(domainUser.getViberId());

        Assert.assertNotNull(userByGuid);
        Assert.assertEquals(userByGuid.getGradeBookNumber(), domainUser.getGradeBookNumber());
        Assert.assertEquals(userByGuid.getGuid(), domainUser.getGuid());
    }

    @Test
    public void find_user_by_grade_book() {
        DomainUser domainUser = EdbotTestHelper.nextDomainUser();
        userService.saveOrUpdate(domainUser);
        userService.saveOrUpdate(EdbotTestHelper.nextDomainUser());

        DomainUser userByGuid = userService.findUserDyGradeBookNumber(domainUser.getGradeBookNumber());

        Assert.assertNotNull(userByGuid);
        Assert.assertEquals(userByGuid.getGuid(), domainUser.getGuid());
        Assert.assertEquals(userByGuid.getViberId(), domainUser.getViberId());
    }


}
