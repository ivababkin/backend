package nc.backend.entities;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "tasks")
@ToString
@NoArgsConstructor
public class Task {
    @Id
    @Column(name  = "ID")
    private Long id;

    @Column(name = "NUMBER")
    @NotNull
    private Integer number;

    @Column(name = "SECTION")
    @NotNull
    private String section;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "FILE_PATH")
    private String file_path;

    @Column(name = "ATTEMPTS_MAX")
    private Integer attempts_max;

    @Column(name = "TASK_NAME")
    private String task_name;

    public Task(Long id, Integer number, String section, String description, String file_path, Integer attempts_max, String task_name) {
        this.id = id;
        this.number = number;
        this.section = section;
        this.description = description;
        this.file_path = file_path;
        this.attempts_max = attempts_max;
        this.task_name = task_name;
    }
}
