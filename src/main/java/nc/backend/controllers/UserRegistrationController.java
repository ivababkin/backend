package nc.backend.controllers;

import nc.backend.dtos.UserRegistrationDto;
import nc.backend.services.UserAuthorizationService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import nc.backend.services.UserAuthorizationService;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/users")
public class UserRegistrationController {


    private UserAuthorizationService userAuthorizationService;

    public UserRegistrationController(UserAuthorizationService userAuthorizationService) {
        this.userAuthorizationService = userAuthorizationService;
    }
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public void Register(UserRegistrationDto userRegistrationObject) {
        this.userAuthorizationService.registerUser(userRegistrationObject);
    }
}
