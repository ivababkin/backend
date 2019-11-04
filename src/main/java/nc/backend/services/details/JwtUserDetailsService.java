package nc.backend.services.details;

import nc.backend.common.utils.ValidationException;
import nc.backend.common.utils.ValidationUtils;
import nc.backend.daos.UserDao;
import nc.backend.entities.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;


@Service
public class JwtUserDetailsService implements UserDetailsService {
    private UserDao userDao;
    private PasswordEncoder bCryptEncoder;

    public JwtUserDetailsService(UserDao userDao, PasswordEncoder bCryptEncoder) {
        this.userDao = userDao;
        this.bCryptEncoder = bCryptEncoder;
    }

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        User user = userDao.findByUserLogin(login);

        try {
            ValidationUtils.validateIsNotNull(user, "No such user with provided login");
        } catch (ValidationException e) {
            e.printStackTrace();
        }



        return new UserDetailsPrinciple(user.getLogin(),
                user.getPassword_hash(), new ArrayList<>());
    }
}
