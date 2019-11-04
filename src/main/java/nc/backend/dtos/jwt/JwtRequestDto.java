package nc.backend.dtos.jwt;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@JsonInclude(JsonInclude.Include.NON_NULL)
@NoArgsConstructor
public class JwtRequestDto implements Serializable {
    @Getter
    @Setter
    private String login;

    @Getter
    @Setter
    private String password;

    public JwtRequestDto(String login, String password) {
        this.login = login;
        this.password = password;
    }
}
