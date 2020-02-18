package nc.backend.controllers;

import nc.backend.common.utils.ValidationException;
import nc.backend.dtos.UploadDto;
import nc.backend.dtos.UserTaskAttemptsDto;
import nc.backend.services.BackstopTestService;
import nc.backend.services.UserTaskService;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
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
    @PostMapping(value = "/upload")
    @ResponseBody
    public ResponseEntity<UploadDto> uploadFile(@RequestParam("file") MultipartFile file,
                                                @RequestParam(value = "fileCss", required = false) MultipartFile[] fileCss,
                                                @RequestParam(value = "userId", required = false) Long userId,
                                                @RequestParam(value = "taskId", required = false) Long taskId)
            throws ValidationException, IOException, JSONException {

        this.userTaskService.uploadFile(file, userId, taskId);

        System.out.println(file.getOriginalFilename());
        return new ResponseEntity<UploadDto>(new UploadDto("Success upload " + file.getOriginalFilename()), HttpStatus.OK);
    }
}