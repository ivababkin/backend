package nc.backend.service;

import nc.backend.common.utils.ValidationException;
import nc.backend.daos.UserDao;
import nc.backend.services.UserDataService;
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
public class UserServiceTest {
    private static Logger logger = LoggerFactory.getLogger(UserServiceTest.class);

    @Autowired
    private UserDao userDao;
    @Autowired
    private UserDataService userDataService;
    @Autowired
    private UserService userService;

    @Before
    public void setUp(){
        logger.info("----------setUp tester-----------");
        this.userService = new UserService(userDao, userDataService);
     }

    @Test
    public void getUserByIDTest(){
        if (userService.getUser(1L).getUser_id() == 1L) {
            logger.info("----------getByIDTest OK----------");
        }
        if (userService.getUser(132L) == null) {
            logger.info("----------incorrectIDTest OK----------");
        }
    }

    @Test
    public void getUserByLoginTest() throws ValidationException{
        if (userService.findByUserLogin("lalal").getId() == 1L) {
            logger.info("----------getUserByLoginTest OK----------");
        }
        if (userService.findByUserLogin("ascasca") == null) {
            logger.info("----------incorrectLoginTest OK----------");
        }
    }

    @Test
    public void getUserByEmail(){
        if (userService.getUserByEmail("email").getUser_id() == 1L) {
            logger.info("----------getUserByEmailTest OK----------");
        }
        if (userService.getUserByEmail("ewfwefwef") == null) {
            logger.info("----------incorrectEmailTest OK----------");
        }
    }

}