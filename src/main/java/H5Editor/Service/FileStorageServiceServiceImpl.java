package H5Editor.Service;

import H5Editor.Model.File.FileRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.util.stream.Stream;

/**
 * Created by MrCJ on 2016/12/22.
 */
@Service
public class FileStorageServiceServiceImpl implements FileStorageService {

    private static final Logger LOGGER = LoggerFactory.getLogger(FileStorageServiceServiceImpl.class);

    private String location = "files";

    private final Path rootLocation = Paths.get(location);

    private FileRepository fileRepository;

    @Autowired
    public FileStorageServiceServiceImpl(FileRepository fileRepository) {
        this.fileRepository = fileRepository;
    }

    @Override
    public void store(MultipartFile file) {
        try {
            init();
            if (file.isEmpty()) {
                throw new IOException("Failed to store empty file " + file.getOriginalFilename());
            }
            Files.copy(file.getInputStream(), this.rootLocation.resolve(file.getOriginalFilename()));
            //File newfile = new File(userId, file.getOriginalFilename(), )
            //fileRepository.save();
        } catch (IOException e) {
            LOGGER.error("Failed to store file " + file.getOriginalFilename(), e);
        }
    }

    private void init() {
        try {
            Files.createDirectories(rootLocation);
        } catch (IOException e) {
            LOGGER.error("Create Directories Failed!", e);
        }
    }

    @Override
    public Path load(String filename) {
        return rootLocation.resolve(filename);
    }

    @Override
    public Resource loadAsResource(String filename) {
        try {
            Path file = load(filename);
            Resource resource = new UrlResource(file.toUri());
            if (resource.exists() || resource.isReadable()) {
                return resource;
            }
            else {
                LOGGER.error("Not found file: " + filename);
            }
        } catch (MalformedURLException e) {
            LOGGER.error("Could not read file: " + filename, e);
        }
        return null;
    }

    @Override
    public Stream<Path> loadAll() {
        try {
            return Files.walk(this.rootLocation, 1)
                    .filter(path -> !path.equals(this.rootLocation))
                    .map(path1 -> this.rootLocation.relativize(path1));
        } catch (IOException e) {
            LOGGER.error("Failed to read stored files", e);
            throw new RuntimeException("Failed to read stored files", e);
        }
    }
}
