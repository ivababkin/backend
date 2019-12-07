package nc.backend.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import nc.backend.entities.UserTaskPK;

import java.math.BigDecimal;
import java.time.ZonedDateTime;

@NoArgsConstructor
@EqualsAndHashCode
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserTaskDto {
    @Getter
    @Setter
    private UserTaskPK userTaskPK = new UserTaskPK();


    @Getter
    @Setter
    private BigDecimal progress;


    @Getter
    @Setter
    private String time;

    @Getter
    @Setter
    private String code;

    @Getter
    @Setter
    private String deadline;


    public UserTaskDto(UserTaskPK userTaskPK, BigDecimal progress,
                       String time, String code, String deadline) {
        this.userTaskPK = userTaskPK;
        this.progress = progress;
        this.time = time;
        this.code = code;
        this.deadline = deadline;
    }
}
