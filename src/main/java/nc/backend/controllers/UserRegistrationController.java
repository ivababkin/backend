package nc.backend.controllers;

import nc.backend.dtos.UserRegistrationDto;
import nc.backend.services.UserAuthorizationService;
import org.springframework.web.bind.annotation.*;
import nc.backend.services.UserAuthorizationService;


@RestController
@RequestMapping("/")
public class UserRegistrationController {


    private UserAuthorizationService userAuthorizationService;

    public UserRegistrationController(UserAuthorizationService userAuthorizationService) {
        this.userAuthorizationService = userAuthorizationService;
    }
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public void register(@RequestBody UserRegistrationDto userRegistrationObject) {
        this.userAuthorizationService.registerUser(userRegistrationObject);
    }
}
