package nc.backend.controllers;

import nc.backend.common.utils.ValidationException;
import nc.backend.dtos.TaskDto;
import nc.backend.dtos.UserTaskDto;
import nc.backend.entities.UserTaskPK;
import nc.backend.services.UserTaskService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users+tasks")
public class UserTaskController {

    private UserTaskService userTaskService;

    public UserTaskController(UserTaskService userTaskService) {
        this.userTaskService = userTaskService;
    }

    //todo

    /* @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<TaskDto>> getAll(){
        return ResponseEntity.ok(userTaskService.getAll());
    } */

    @RequestMapping("/task")
    public UserTaskDto getUserTask(@RequestParam(value = "userId", required = false) Long userId,
                                   @RequestParam(value = "taskId", required = false) Long taskId) throws ValidationException {
        return userTaskService.get(new UserTaskPK(userId, taskId));
    }
}
