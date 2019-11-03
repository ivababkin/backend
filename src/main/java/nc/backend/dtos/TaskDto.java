package nc.backend.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

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
    private String file_path;

    @Getter
    @Setter
    private Integer attempts_max;

    @Getter
    @Setter
    private String task_name;

    public TaskDto(Long id, Integer number, String section, String description, String file_path, Integer attempts_max, String task_name) {
        this.id = id;
        this.number = number;
        this.section = section;
        this.description = description;
        this.file_path = file_path;
        this.attempts_max = attempts_max;
        this.task_name = task_name;
    }
}


