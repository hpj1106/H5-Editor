package H5Editor.Service;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Path;
import java.util.stream.Stream;

/**
 * Created by MrCJ on 2016/12/22.
 */
public interface FileStorageService {

    void store(MultipartFile file);

    Path load(String filename);

    Resource loadAsResource(String filename);

    Stream<Path> loadAll();
}
