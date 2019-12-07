package nc.backend.dtos;


import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.util.List;

@NoArgsConstructor
@EqualsAndHashCode
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TaskListDto {
    @Getter
    @Setter
    private List<TaskDto> taskDtoList;

    public TaskListDto(List<TaskDto> taskDtoList) {
        this.taskDtoList = taskDtoList;
    }
}
