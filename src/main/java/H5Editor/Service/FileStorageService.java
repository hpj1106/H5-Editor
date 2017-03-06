package h5editor.service;

import h5editor.model.file.FileRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;

/**
 * Created by MrCJ on 2016/12/22.
 */
@Service
public class FileStorageService implements FileStorage {

    private static final Logger log = LoggerFactory.getLogger(FileStorageService.class);

    private String location = "files";

    private final Path rootLocation = Paths.get(location);

    private FileRepository fileRepository;

    @Autowired
    public FileStorageService(FileRepository fileRepository) {
        this.fileRepository = fileRepository;
    }

    @Override
    public void store(MultipartFile file) {
        try {
            if (file.isEmpty()) {
                throw new IOException("Failed to store empty file " + file.getOriginalFilename());
            }
            Files.copy(file.getInputStream(), this.rootLocation.resolve(file.getOriginalFilename()));
            //File newfile = new File(userId, file.getOriginalFilename(), )
            //fileRepository.save();
        } catch (IOException e) {
            log.error("Failed to store file " + file.getOriginalFilename(), e);
        }
    }

    /*
    @Override
    public Path load(String filename) {
        return rootLocation.resolve(filename);
    }

    @Override
    public Resource loadAsResource(String filename) {
        System.out.println("filename = " + filename);
        try {
            Path file = load(filename);
            System.out.println("path = " + file.toString());
            //Resource resource = new UrlResource(file.toUri());
            Resource resource = new FileSystemResource(file.toFile());
            if(resource.exists() || resource.isReadable()) {
                return resource;
            }
            else {
                throw new MalformedURLException("Could not read file: " + filename);
            }
        } catch (MalformedURLException e) {
            //log.error("Could not read file: " + filename, e);
            throw new RuntimeException("Could not read file: " + filename, e);
        }
    }
    */
}
