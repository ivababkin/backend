package nc.backend.dtos.jwt;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;

import java.io.Serializable;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class JwtResponseDto implements Serializable {
    @Getter
    private final String jwtToken;

    public JwtResponseDto(String jwtToken) {
        this.jwtToken = jwtToken;
    }
}
