package H5Editor.Service.Json;

import H5Editor.Model.File.File;
import H5Editor.Model.File.FileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by MrCJ on 2016/12/22.
 */

@Service
public class FileJsonImpl implements FileJson {

    private FileRepository fileRepository;

    @Autowired
    public FileJsonImpl(FileRepository fileRepository) {
        this.fileRepository = fileRepository;
    }

    @Override
    public Object getFileListForAdmin() {
        return new Response("true", "success", fileRepository.findAll());
    }

    @Override
    public Object getFileListForUser(int userId) {
        List<Integer> userIdList = new ArrayList<>();
        userIdList.add(userId);
        return new Response("true", "success", fileRepository.findByuserId(userId));
    }
}
