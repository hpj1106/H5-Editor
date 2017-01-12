package H5Editor.Service;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;
import java.nio.file.Path;

/**
 * Created by MrCJ on 2016/12/22.
 */
public interface FileStorage {
    void store(MultipartFile file);

    //Path load(String filename);

    //Resource loadAsResource(String filename);
}
