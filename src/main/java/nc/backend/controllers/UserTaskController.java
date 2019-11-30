package nc.backend.controllers;

import nc.backend.common.utils.ValidationException;
import nc.backend.dtos.TaskDto;
import nc.backend.dtos.UserTaskDto;
import nc.backend.entities.UserTaskPK;
import nc.backend.services.UserTaskService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.NoSuchFileException;


@RestController
@RequestMapping("/tasks")
public class UserTaskController {

    private UserTaskService userTaskService;

    public UserTaskController(UserTaskService userTaskService) {
        this.userTaskService = userTaskService;
    }


    @GetMapping("/task")
    public UserTaskDto getUserTask(@RequestParam(value = "userId", required = false) Long userId,
                                   @RequestParam(value = "taskId", required = false) Long taskId) throws ValidationException {
        return userTaskService.get(new UserTaskPK(userId, taskId));
    }

    //todo answer image
    @PostMapping("/upload")
    public ResponseEntity<Object> uploadFile(@RequestParam("file") MultipartFile file,
                                             @RequestParam(value = "userId", required = false) Long userId,
                                             @RequestParam(value = "taskId", required = false) Long taskId)
            throws ValidationException, NoSuchFileException {

        this.userTaskService.uploadFile(file, userId, taskId);
        return new ResponseEntity<>("Success upload" + file.getOriginalFilename(), HttpStatus.OK);
    }
}
