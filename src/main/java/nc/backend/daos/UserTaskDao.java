package nc.backend.daos;

import nc.backend.entities.UserTask;
import nc.backend.entities.UserTaskPK;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserTaskDao extends CrudRepository<UserTask, UserTaskPK> {
    @Query("SELECT ut FROM UserTask ut")
    List<UserTask> findAllBy();
}
