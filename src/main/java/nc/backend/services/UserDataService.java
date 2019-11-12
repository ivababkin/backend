package nc.backend.services;


import nc.backend.dtos.UserDto;
import nc.backend.dtos.UserRegistrationDto;
import nc.backend.entities.User;
import org.springframework.stereotype.Service;

@Service
public class UserDataService {

    public UserDto buildUserDtoFromUser(User user){
        UserDto userDto = new UserDto();
        userDto.setAdmin(user.getAdmin());
        userDto.setSurname(user.getSurname());
        userDto.setUser_id(user.getId());
        userDto.setEmail(user.getEmail());
        userDto.setName(user.getName());

        return userDto;
    }

    //todo public User buildUserFromUserRegistrationDto(UserRegistrationDto userRegistrationObject)
    public User buildUserFromUserRegistrationDto(UserRegistrationDto userRegistrationObject){
        //User(String login,  String password, String email, String name, String surname, Boolean admin, List<UserTask> userTasks)
        return new User(userRegistrationObject.getLogin(), userRegistrationObject.getPassword(),
                userRegistrationObject.getEmail(), userRegistrationObject.getName(), userRegistrationObject.getSurname(), false, null);
    }
}
