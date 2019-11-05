package nc.backend.entities;

import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Getter
@Setter
@Entity
@Table(name = "users")
@ToString
@NoArgsConstructor
public class User {

    @Id
    @Column(name  = "ID")
    private Long id;

    @Column(name = "LOGIN")
    @NotNull
    private String login;

    @Column(name = "PASSWORD")
    @NotNull
    private String password;

    @Column(name = "EMAIL")
    @NotNull
    private String email;

    @Column(name = "NAME")
    @NotNull
    private String name;

    @Column(name = "SURNAME")
    @NotNull
    private String surname;

    @Column(name = "ADMIN")
    @NotNull
    private Boolean admin;

    public User(String email, String name, String surname, Boolean admin) {
        this.email = email;
        this.name = name;
        this.surname = surname;
        this.admin = admin;
    }

    public User(String password, String login, String email, String name, String surname, boolean i) {
        this.password = password;
        this.login = login;
        this.email = email;
        this.name = name;
        this.surname = surname;
        this.admin = admin;
    }

}
