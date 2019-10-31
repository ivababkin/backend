package nc.backend.services;

import nc.backend.daos.UserDao;
import nc.backend.dtos.UserDto;
import nc.backend.entities.User;
import org.springframework.stereotype.Service;


@Service
public class UserService {

    private UserDao userDao;

    public UserService(UserDao userDao){
        this.userDao = userDao;
    }

    public UserDto getUser(Long userId){
        User user = userDao.findByID(userId);
        return buildUserDtoFromUser(user);
    }

    private UserDto buildUserDtoFromUser(User user){
        UserDto userDto = new UserDto();
        userDto.setAdmin(user.getAdmin());
        userDto.setSurname(user.getSurname());
        userDto.setUser_id(user.getId());
        userDto.setEmail(user.getEmail());
        userDto.setName(user.getName());

        return userDto;
    }

    public UserDto getUserByEmail(String userEmail){
        User user = userDao.findByEmail(userEmail);
        return buildUserDtoFromUser(user);
    }
}