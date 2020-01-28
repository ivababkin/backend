package nc.backend.services;

import com.google.gson.Gson;
import nc.backend.jsonParser.BackstopClass;
import org.springframework.stereotype.Service;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

@Service
public class BackstopTestService {

    private static String readUsingFiles(String fileName) throws IOException {
        return new String(Files.readAllBytes(Paths.get(fileName)));
    }

    public void prepareBackstopJson(Long userId, Long taskId) throws IOException {
        Gson gson = new Gson();
        BackstopClass backstop = gson.fromJson(new FileReader("/home/ivan/Рабочий стол/backend/backstop.json"), BackstopClass.class);
        backstop.scenarios.get(0).setUrl("/upload/" + userId + "/" + taskId + "/" + "testhtml.html");
        FileWriter writer = new FileWriter("/home/ivan/Рабочий стол/backend/backstop.json");
        gson.toJson(backstop, writer);
        writer.flush();
    }

    public void runTest(Long userId, Long taskId) throws IOException {

        prepareBackstopJson(userId, taskId);

        try{
            Process pr = Runtime.getRuntime().exec("backstop reference");
            try(BufferedReader input = new BufferedReader(new InputStreamReader(pr.getInputStream()))) {
                String line;
                while ((line = input.readLine()) != null) {
                    System.out.println(line);
                }
            }
        } catch(Exception e){
            System.out.println("e: "+ e.toString());
        }

        try{
            Process pr = Runtime.getRuntime().exec("backstop test");
            try(BufferedReader input = new BufferedReader(new InputStreamReader(pr.getInputStream()))) {
                String line;
                while ((line = input.readLine()) != null) {
                    System.out.println(line);
                }
            }
        } catch(Exception e){
            System.out.println("e: "+ e.toString());
        }
    }
}
