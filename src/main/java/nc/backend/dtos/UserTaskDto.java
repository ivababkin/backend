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
    private BigDecimal progress;

    @Getter
    @Setter
    private String time;

    public UserTaskDto(BigDecimal progress,
                       String time) {
        this.progress = progress;
        this.time = time;
    }
}
