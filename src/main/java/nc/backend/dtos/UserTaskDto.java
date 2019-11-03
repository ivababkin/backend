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
    private Integer attempts_number;

    @Getter
    @Setter
    private ZonedDateTime time;

    @Getter
    @Setter
    private String log;

    @Getter
    @Setter
    private String code;

    @Getter
    @Setter
    private TaskDto taskDto;

    public UserTaskDto(UserTaskPK userTaskPK, BigDecimal progress, Integer attempts_number, ZonedDateTime time, String log, String code) {
        this.userTaskPK = userTaskPK;
        this.progress = progress;
        this.attempts_number = attempts_number;
        this.time = time;
        this.log = log;
        this.code = code;
    }

    public UserTaskDto(UserTaskPK userTaskPK, BigDecimal progress,
                       Integer attempts_number, ZonedDateTime time, String log, String code, TaskDto taskDto) {
        this.userTaskPK = userTaskPK;
        this.progress = progress;
        this.attempts_number = attempts_number;
        this.time = time;
        this.log = log;
        this.code = code;
        this.taskDto = taskDto;
    }
}
