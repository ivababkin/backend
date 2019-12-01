package nc.backend.Service;

import nc.backend.daos.UserDao;
import nc.backend.dtos.UserRegistrationDto;
import nc.backend.services.UserDataService;
import nc.backend.services.UserRegistrationService;
import nc.backend.services.UserService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest

public class RegistrationServiceTest {
    private static Logger logger = LoggerFactory.getLogger(RegistrationServiceTest.class);

    @Autowired
    private UserDao userDao;
    //@Autowired
    //private UserDataService userDataService;
    //@Autowired
    //private UserService userService;
    @Autowired
    private UserRegistrationService userRegistrationService;

    @Before
    public void setUp(){
        logger.info("----------setUp tester-----------");
        this.userRegistrationService = new UserRegistrationService(userDao);
    }

    @Test
    public void registerUserTest(){
        UserRegistrationDto userRegistrationDto = new UserRegistrationDto
                ("testPass1", "testLogin1", "testEmail1", "testName1", "testSurname1", false);
        userRegistrationService.registerUser(userRegistrationDto);
    }
}
