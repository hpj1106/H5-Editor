package h5editor.service;

import org.springframework.web.multipart.MultipartFile;

/**
 * Created by MrCJ on 2016/12/22.
 */
public interface FileStorage {
    void store(MultipartFile file);

    //Path load(String filename);

    //Resource loadAsResource(String filename);
}
