package nc.backend.services;

import nc.backend.daos.UserDao;
import nc.backend.dtos.UserRegistrationDto;
import nc.backend.entities.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class UserAuthorizationService {
    private UserDataService userDataService;
    @Autowired
    private PasswordEncoder bCryptPasswordEncoder;
    private UserDao userDao;

    private static Logger logger = LoggerFactory.getLogger(UserAuthorizationService.class);


    public UserAuthorizationService(UserDao userDao){
        this.userDao = userDao;
        bCryptPasswordEncoder = new BCryptPasswordEncoder();
        userDataService = new UserDataService();
    }

    public User registerUser(UserRegistrationDto userRegistrationObject) {
        User user = this.userDataService.buildUserFromUserRegistrationDto(userRegistrationObject);
        String encodedPassword = bCryptPasswordEncoder.encode(userRegistrationObject.getPassword());
        user.setPassword(encodedPassword);
        userDao.save(user);
        logger.info("----------User saved-----------", user);

        return user;
    }
}
