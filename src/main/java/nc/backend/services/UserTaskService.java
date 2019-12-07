package nc.backend.services;

import nc.backend.common.utils.ValidationException;
import nc.backend.daos.TaskDao;
import nc.backend.daos.UserDao;
import nc.backend.daos.UserTaskDao;
import nc.backend.dtos.UserTaskAttemptsDto;
import nc.backend.dtos.UserTaskDto;
import nc.backend.entities.Task;
import nc.backend.entities.User;
import nc.backend.entities.UserTask;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.NoSuchFileException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static nc.backend.common.utils.ValidationUtils.validateIsNotNull;

@Service
public class UserTaskService {
    private final UserTaskDao userTaskDao;
    private final TaskService taskService;
    private final UserDao userDao;
    private final TaskDao taskDao;

    private static Logger logger = LoggerFactory.getLogger(UserRegistrationService.class);
    private final String UPLOAD_PATH = "upload";


    public UserTaskService(UserTaskDao userTaskDao, TaskService taskService, UserDao userDao, TaskDao taskDao) {
        this.userTaskDao = userTaskDao;
        this.taskService = taskService;
        this.userDao = userDao;
        this.taskDao = taskDao;
    }

    public UserTaskAttemptsDto getUserTasks(Long userId, Long taskId) throws ValidationException {
        validateIsNotNull(userId, "No user is provided");
        validateIsNotNull(taskId, "No task provided");

        List<UserTask> userTasks = userTaskDao.findByUserIdAndTaskId(userId, taskId);
        validateIsNotNull(userTasks, "No userTasks with userId & taskId");

        List<UserTaskDto> userTaskDtoList = buildUserTaskDtoListFromUserTaskList(userTasks);
        Task task = this.taskDao.findByID(taskId);
        User user = this.userDao.findByID(userId);
        validateIsNotNull(user, "There is no user with such id");
        validateIsNotNull(task, "There is no task with such id");

        //todo bestCode
        String deadline = task.getDeadline().toString();
        String bestCode = "Sorry there is no any realization :(";
        String description = task.getDescription();
        String name = task.getTask_name();

        return new UserTaskAttemptsDto(userTaskDtoList, deadline, bestCode, description, name);
    }


    //todo permitted file types
    public void uploadFile(MultipartFile file, Long userId, Long taskId) throws ValidationException, NoSuchFileException {
        validateIsNotNull(file.getOriginalFilename(), "Uploaded file has null name");

        if (!Objects.equals(file.getContentType(), "text/html")) {
            throw new NoSuchFileException("Wrong file type");
        }

        User user = this.userDao.findByID(userId);
        Task task = this.taskDao.findByID(taskId);
        validateIsNotNull(user, "There is no user with such id");
        validateIsNotNull(task, "There is no task with such id");

        File uploadFolder = createFolder("", this.UPLOAD_PATH);
        File userFolder= createFolder(this.UPLOAD_PATH, String.valueOf(userId));
        File userTaskFolder = createFolder(this.UPLOAD_PATH + "/" + userFolder.getName(), String.valueOf(taskId));


        File uploadedFile = new File(this.UPLOAD_PATH + "/" + userFolder.getName()
                + "/" + userTaskFolder.getName(), file.getOriginalFilename());

        try {
            uploadedFile.createNewFile();
            FileOutputStream fileOutputStream = new FileOutputStream(uploadedFile);
            fileOutputStream.write(file.getBytes());
            fileOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        logger.info("File has uploaded" + " " + file.getOriginalFilename());
    }

    //todo recording user tasks into db
    private UserTask recordUserTask(){
        return null;
    }


    private File createFolder(String path, String name) throws NoSuchFileException {
        File folder = new File(path, name);
        if(!folder.exists()){
            folder.mkdir();
        }

        return folder;
    }

    private UserTaskDto buildUserTaskDtoFromUserTask(UserTask userTask) {
        return new UserTaskDto(userTask.getProgress(),
                userTask.getTime().toString());
    }

    private List<UserTaskDto> buildUserTaskDtoListFromUserTaskList(List<UserTask> userTasks){
        List<UserTaskDto> userTaskDtoList = new ArrayList<>();
        userTasks.forEach(userTask -> userTaskDtoList.add(buildUserTaskDtoFromUserTask(userTask)));
        return userTaskDtoList;
    }
}
