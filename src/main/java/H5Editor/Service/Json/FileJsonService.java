package H5Editor.Service.Json;

import H5Editor.Model.File.FileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by MrCJ on 2016/12/22.
 * 与素材相关的Service
 */

@Service
public class FileJsonService implements FileJson {

    private FileRepository fileRepository;

    @Autowired
    public FileJsonService(FileRepository fileRepository) {
        this.fileRepository = fileRepository;
    }

    @Override
    public Object getFileListForAdmin() {
        return null;
        //return new Response("true", "success", fileRepository.findAll());
        //return Response.getResponse("true", "success", fileRepository.findAll());
    }

    @Override
    public Object getFileListForUser(int userId) {
        List<Integer> userIdList = new ArrayList<>();
        userIdList.add(userId);
        return null;
        //return new Response("true", "success", fileRepository.findByuserId(userId));
        //return Response.getResponse("true", "success", fileRepository.findByuserId(userId));
    }
}
