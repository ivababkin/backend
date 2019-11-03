package nc.backend.services;

import nc.backend.common.utils.ValidationException;
import nc.backend.daos.UserTaskDao;
import nc.backend.dtos.TaskDto;
import nc.backend.dtos.UserTaskDto;
import nc.backend.entities.UserTask;
import nc.backend.entities.UserTaskPK;
import org.springframework.stereotype.Service;

import static nc.backend.common.utils.ValidationUtils.validateIsNotNull;
import static nc.backend.dtos.TaskDto.buildTaskDtoFromTask;

@Service
public class UserTaskService {
    private final UserTaskDao userTaskDao;

    public UserTaskService(UserTaskDao userTaskDao) {
        this.userTaskDao = userTaskDao;
    }

    public UserTaskDto get(UserTaskPK userTaskPK) throws ValidationException {
        validateIsNotNull(userTaskPK, "No userTaskPK is provided");

        UserTask userTask = userTaskDao.findById(userTaskPK).get();
        validateIsNotNull(userTask, "No userTask with id" + userTaskPK);

        return buildUserTaskDtoFromUserTask(userTask);
    }

    private UserTaskDto buildUserTaskDtoFromUserTask(UserTask userTask) {
        TaskDto taskDto = buildTaskDtoFromTask(userTask.getTask());

        return new UserTaskDto(userTask.getUserTaskPK(), userTask.getProgress(),
                userTask.getAttempt_number(), userTask.getTime(), userTask.getLog(), userTask.getCode(),
                taskDto);
    }
}
