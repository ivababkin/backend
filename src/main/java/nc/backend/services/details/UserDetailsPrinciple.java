package nc.backend.services.details;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.EqualsAndHashCode;
import nc.backend.entities.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@EqualsAndHashCode
public class UserDetailsPrinciple implements UserDetails {
    private Long id;
    private String name;
    private String username;
    private String email;

    @JsonIgnore
    private String password;

    //todo authorities
    private Collection<? extends GrantedAuthority> authorities = new ArrayList<>();

    public UserDetailsPrinciple(Long id, String name, String username, String email, String password, List<GrantedAuthority> authorities) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.email = email;
        this.password = password;
        this.authorities = authorities;
    }

    public UserDetailsPrinciple(String username, String password, Collection<? extends GrantedAuthority> authorities) {
        this.username = username;
        this.password = password;
        this.authorities = authorities;
    }

    public static UserDetailsPrinciple build(User user){
        //todo authorities
        List<GrantedAuthority> authorities = new ArrayList<>();

        return new UserDetailsPrinciple(user.getId(), user.getName(),
                user.getLogin(), user.getEmail(),
                user.getPassword_hash(), authorities);
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.authorities;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    //todo Account expired, etc.
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
