package nc.backend.services;

import lombok.extern.slf4j.Slf4j;
import nc.backend.daos.UserDao;
import nc.backend.dtos.UserDto;
import nc.backend.entities.User;
import org.springframework.stereotype.Service;


@Service
@Slf4j
public class UserService {

    private UserDao userDao;
    private UserDataService userDataService;

    public UserService(UserDao userDao, UserDataService userDataService) {
        this.userDao = userDao;
        this.userDataService = userDataService;
    }

    public UserDto getUser(Long userId){
        User user = userDao.findByID(userId);
        return this.userDataService.buildUserDtoFromUser(user);
    }

    public UserDto getUserByEmail(String userEmail){
        User user = userDao.findByEmail(userEmail);
        return this.userDataService.buildUserDtoFromUser(user);
    }

    public User findByUserLogin(String login){
        User user = this.userDao.findByUserLogin(login);

        System.out.println(user.getLogin());
        log.info("IN findByUserLogin - user: {} found by login: {}", user, login);
        return user;
    }

}