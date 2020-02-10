package nc.backend.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class FileStorageService {
    Logger log = LoggerFactory.getLogger(this.getClass().getName());
    private Path rootLocation = Paths.get("");

    public Resource loadFile(String filename) {
        try {
            if (filename.contains("basic") || filename.contains("levelUp")
                    || filename.contains("advanced")){
                this.rootLocation = Paths.get("TaskReferences");
            }

            else if (filename.contains("backstop")){
                this.rootLocation = Paths.get("backstop_data");
            }

            else{
                throw new NoSuchFileException("Attempt to retrieve wrong file");
            }

            Path file = this.rootLocation.resolve(filename);
            Resource resource = new UrlResource(file.toUri());
            if (resource.exists() || resource.isReadable()) {
                return resource;
            } else {
                throw new RuntimeException("File doesn't exist");
            }
        } catch (MalformedURLException | NoSuchFileException e) {
            throw new RuntimeException("Can't load asked file");
        }
    }

    public void init() {
        try {
            if (!Files.exists(this.rootLocation)){
                Files.createDirectory(this.rootLocation);
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't initialize storage");
        }
    }
}
