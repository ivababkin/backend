package nc.backend.controllers;

import nc.backend.common.utils.ValidationException;
import nc.backend.dtos.TaskDto;
import nc.backend.dtos.UserTaskAttemptsDto;
import nc.backend.dtos.UserTaskDto;
import nc.backend.entities.UserTaskPK;
import nc.backend.services.BackstopTestService;
import nc.backend.services.UserTaskService;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.NoSuchFileException;
import java.util.List;


@RestController
@RequestMapping("/user-tasks")
public class UserTaskController {

    private UserTaskService userTaskService;
    @Autowired
    private BackstopTestService backstopTestService;

    public UserTaskController(UserTaskService userTaskService) {
        this.userTaskService = userTaskService;
    }


    @GetMapping("/task")
    public UserTaskAttemptsDto getUserTasks(@RequestParam(value = "userId", required = false) Long userId,
                                            @RequestParam(value = "taskId", required = false) Long taskId) throws ValidationException {
        return userTaskService.getUserTasks(userId, taskId);
    }

    //todo answer image
    @PostMapping("/upload")
    public ResponseEntity<Object> uploadFile(@RequestParam("file") MultipartFile file,
                                             @RequestParam(value = "userId", required = false) Long userId,
                                             @RequestParam(value = "taskId", required = false) Long taskId)
            throws ValidationException, IOException, JSONException {

        this.userTaskService.uploadFile(file, userId, taskId);

        this.backstopTestService.runTest(userId, taskId);

        return new ResponseEntity<>("Success upload" + file.getOriginalFilename(), HttpStatus.OK);
    }
}
