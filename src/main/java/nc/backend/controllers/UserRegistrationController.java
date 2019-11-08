package nc.backend.controllers;

import nc.backend.dtos.UserRegistrationDto;
import nc.backend.services.UserAuthorizationService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import nc.backend.services.UserAuthorizationService;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/")
public class UserRegistrationController {


    private UserAuthorizationService userAuthorizationService;

    public UserRegistrationController(UserAuthorizationService userAuthorizationService) {
        this.userAuthorizationService = userAuthorizationService;
    }
    @RequestMapping(value = "/register", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void Register(@RequestBody UserRegistrationDto userRegistrationObject) {
        this.userAuthorizationService.registerUser(userRegistrationObject);
    }
}
