package nc.backend.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class FileStorageService {
    Logger log = LoggerFactory.getLogger(this.getClass().getName());
    private Path rootLocation = Paths.get("upload");

    public Resource loadFile(String filename) {
        try {
            Path file = rootLocation.resolve(filename);
            Resource resource = new UrlResource(file.toUri());
            if (resource.exists() || resource.isReadable()) {
                return resource;
            } else {
                throw new RuntimeException("FAIL!");
            }
        } catch (MalformedURLException e) {
            throw new RuntimeException("FAIL!");
        }
    }

    public void init() {
        try {
            if (!Files.exists(this.rootLocation)){
                Files.createDirectory(this.rootLocation);
            }
        } catch (IOException e) {
            throw new RuntimeException("Could not initialize storage!");
        }
    }
}
