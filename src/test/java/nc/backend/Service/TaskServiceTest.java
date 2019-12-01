package nc.backend.Service;


import nc.backend.daos.TaskDao;
import nc.backend.daos.UserDao;
import nc.backend.services.TaskService;
import nc.backend.services.UserDataService;
import nc.backend.services.UserService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TaskServiceTest {
    private static Logger logger = LoggerFactory.getLogger(nc.backend.Service.TaskServiceTest.class);

    @Autowired
    private TaskDao taskDao;
    @Autowired
    private TaskService taskService;

    @Before
    public void setUp() {
        logger.info("----------setUp tester-----------");
        this.taskService = new TaskService(taskDao);
    }

    @Test
    public void getTaskByIDTest() {
        if (taskService.getTask(1L).getNumber() == 1L) {
            logger.info("----------getTaskByIDTest OK----------");
        }
        if (taskService.getTask(132L) == null) {
            logger.info("----------incorrectTaskIDTest OK----------");
        }
    }
}
