package nc.backend.entities;


import com.sun.istack.NotNull;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import java.io.Serializable;

@EqualsAndHashCode
@NoArgsConstructor
public class UserTaskPK implements Serializable {
    @Getter
    @Setter
    @Column(name = "USER_ID")
    @NotNull
    private Long userId;

    @Getter
    @Setter
    @Column(name = "TASK_ID")
    @NotNull
    private Long taskId;

    public UserTaskPK(Long userId, Long taskId) {
        this.userId = userId;
        this.taskId = taskId;
    }
}
