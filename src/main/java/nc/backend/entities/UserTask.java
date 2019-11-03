package nc.backend.entities;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.ZonedDateTime;

@Entity
@Table(name = "USERS_TASKS")
@ToString(exclude = {"user", "task"})
@NoArgsConstructor
public class UserTask {

    @EmbeddedId
    @Getter
    @Setter
    private UserTaskPK userTaskPK = new UserTaskPK();

    @Column(name = "PROGRESS")
    @NotNull
    @Getter
    @Setter
    private BigDecimal progress;

    @Column(name = "PATH_RESULT")
    @NotNull
    @Getter
    @Setter
    private String path_result;

    @Column(name = "ATTEMPTS_NUMBER")
    @NotNull
    @Getter
    @Setter
    private Integer attempts_number;

    //todo time not null

    @Column(name = "TIME")
    @Getter
    @Setter
    private ZonedDateTime time;

    @Column(name = "LOG")
    @NotNull
    @Getter
    @Setter
    private String log;

    @Column(name = "CODE")
    @NotNull
    @Getter
    @Setter
    private String code;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USED_ID", insertable = false, updatable = false)
    @Setter
    @Getter
    private User user;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "TASK_ID", insertable = false, updatable = false)
    @Setter
    @Getter
    private Task task;
}
