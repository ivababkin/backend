package nc.backend.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import nc.backend.entities.Task;

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
    private String task_name;

    public TaskDto(Long id, Integer number, String section, String description, Integer attempts_max, String task_name) {
        this.id = id;
        this.number = number;
        this.section = section;
        this.description = description;
        this.attempts_max = attempts_max;
        this.task_name = task_name;
    }

    public static TaskDto buildTaskDtoFromTask(Task task){
        TaskDto taskDto = new TaskDto();
        taskDto.setAttempts_max(task.getAttempts_max());
        taskDto.setDescription(task.getDescription());
        taskDto.setNumber(task.getNumber());
        taskDto.setTask_name(task.getTask_name());
        taskDto.setSection(task.getSection());

        return taskDto;
    }

}


