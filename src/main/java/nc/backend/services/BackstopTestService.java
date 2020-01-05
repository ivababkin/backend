package nc.backend.services;

import com.google.gson.Gson;
import com.google.gson.JsonParser;
import nc.backend.BackstopClass;
import nc.backend.dtos.UserDto;
import nc.backend.entities.UserTask;
import org.apache.tomcat.util.json.JSONParser;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.boot.json.JsonParserFactory;
import org.springframework.stereotype.Service;
import springfox.documentation.spring.web.json.Json;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;


@Service
public class BackstopTestService {

    private static String readUsingFiles(String fileName) throws IOException {
        return new String(Files.readAllBytes(Paths.get(fileName)));
    }

    public void prepareBackstopJson(Long userId, Long taskId) throws IOException {
        Gson gson = new Gson();
        BackstopClass backstop = gson.fromJson(new FileReader("/home/ivan/Рабочий стол/backend/textfile"), BackstopClass.class);
        System.out.println(backstop.id);
        System.out.println(backstop.scenarios.get(0).getUrl());
        System.out.println(backstop.scenarios.get(0).getReferenceUrl());
        System.out.println(backstop.scenarios.size());
        //  /home/ivan/Рабочий стол/backend/upload/4/1

        FileWriter writer = new FileWriter("/home/ivan/Рабочий стол/backend/textfile");
        gson.toJson(backstop, writer);
        writer.flush();
    }

    public void runTest(Long userId, Long taskId) throws IOException {

        prepareBackstopJson(userId, taskId);

        /*try{
            Process pr = Runtime.getRuntime().exec("backstop init");
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
        }*/
    }
}
