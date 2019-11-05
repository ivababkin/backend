package nc.backend.services;

import nc.backend.daos.UserDao;
import nc.backend.dtos.UserRegistrationDto;
import nc.backend.entities.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class UserAuthorizationService {
    private UserDataService userDataService;
    private BCryptPasswordEncoder encoder;
    private UserDao userDao;

    private static Logger logger = LoggerFactory.getLogger(UserAuthorizationService.class);


    public UserAuthorizationService(UserDao userDao){
        this.userDao = userDao;
        encoder = new BCryptPasswordEncoder();
        userDataService = new UserDataService();
    }

    /*
    public UserDto getUser(Long userId){
        User user = userDao.findByID(userId);
        return UserDataService.buildUserDtoFromUser(user);
    }
*/
    public User registerUser(UserRegistrationDto userRegistrationObject) {
        User user = this.userDataService.buildUserFromUserRegistrationDto(userRegistrationObject);
        userDao.save(user);

        logger.info("----------User saved-----------", user);

        return user;
    }
}
