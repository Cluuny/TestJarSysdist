package co.edu.uptc.testsistdist.service;

import co.edu.uptc.testsistdist.model.People;
import co.edu.uptc.testsistdist.model.Root;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

@Service
public class JsonService {

    @Autowired
    private ResourceLoader resourceLoader;

    public Root getPeoplerFromJson() {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            Resource resource = resourceLoader.getResource("classpath:static/db.json");
            String jsonContent = new String(Files.readAllBytes(Paths.get(resource.getURI())));
            return objectMapper.readValue(jsonContent, Root.class);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
