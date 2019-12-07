package nc.backend.dtos;


import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.util.List;

@NoArgsConstructor
@EqualsAndHashCode
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserTaskAttemptsDto {
    @Getter
    @Setter
    private List<UserTaskDto> attempts;

    @Getter
    @Setter
    private String deadline;

    @Setter
    @Getter
    private String bestCode;

    @Getter
    @Setter
    private String description;

    @Getter
    @Setter
    private String name;

    public UserTaskAttemptsDto(List<UserTaskDto> attempts, String deadline,
                               String bestCode, String description, String name) {
        this.attempts = attempts;
        this.deadline = deadline;
        this.bestCode = bestCode;
        this.description = description;
        this.name = name;
    }
}
