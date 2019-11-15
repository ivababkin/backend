package nc.backend.controllers;

import nc.backend.dtos.UserDto;
import nc.backend.services.UserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping("/users")
public class UserController {

    private UserService userService;


    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("/{userId}")
    public UserDto getUser(@PathVariable Long userId) {
        return userService.getUser(userId);
    }


    @GetMapping("/email/{userEmail}")
    public UserDto getUser(@PathVariable String userEmail) {
        return userService.getUserByEmail(userEmail);
    }

}
