package nc.backend.services;

import nc.backend.daos.UserDao;
import nc.backend.dtos.UserDto;
import nc.backend.dtos.UserRegistrationDto;
import nc.backend.entities.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class UserRegistrationService {
    private UserDataService userDataService;
    @Autowired
    private PasswordEncoder bCryptPasswordEncoder;
    private UserDao userDao;

    private static Logger logger = LoggerFactory.getLogger(UserRegistrationService.class);


    public UserRegistrationService(UserDao userDao){
        logger.info("----------UserRegistrationService created-----------");
        this.userDao = userDao;
        bCryptPasswordEncoder = new BCryptPasswordEncoder();
        userDataService = new UserDataService();
    }

    public UserDto registerUser(UserRegistrationDto userRegistrationDto) {
        logger.info("----------try to save user-----------");
        User user = this.userDataService.buildUserFromUserRegistrationDto(userRegistrationDto);
        String encodedPassword = bCryptPasswordEncoder.encode(userRegistrationDto.getPassword());
        logger.info("----------2-----------" + userRegistrationDto.getPassword());
        user.setPassword(encodedPassword);
        userDao.save(user);
        logger.info("----------User saved-----------", user);

        return userDataService.buildUserDtoFromUser(user);
    }
}
