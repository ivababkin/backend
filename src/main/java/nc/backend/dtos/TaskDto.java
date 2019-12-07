package nc.backend.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import nc.backend.entities.Task;

import java.time.ZonedDateTime;

@NoArgsConstructor
@EqualsAndHashCode
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TaskDto {
    @Getter
    @Setter
    private Long id;

    @Getter
    @Setter
    private Integer number;

    @Getter
    @Setter
    private String section;

    @Getter
    @Setter
    private String description;

    @Getter
    @Setter
    private Integer attempts_max;

    @Getter
    @Setter
    private String name;

    @Getter
    @Setter
    private ZonedDateTime deadline;

    public TaskDto(Long id, Integer number,
                   String section, String description,
                   Integer attempts_max, String task_name,
                   ZonedDateTime deadline) {
        this.id = id;
        this.number = number;
        this.section = section;
        this.description = description;
        this.attempts_max = attempts_max;
        this.name = task_name;
        this.deadline = deadline;
    }
}


