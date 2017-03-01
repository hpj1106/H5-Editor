package H5Editor.Service.Json;

import H5Editor.Model.File.File;
import H5Editor.Model.File.FileRepository;
import H5Editor.common.Constant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by MrCJ on 2016/12/22.
 * 与素材文件相关的Service
 */

@Service
public class FileJsonService implements FileJson {

    private FileRepository fileRepository;

    private static final Logger LOGGER = LoggerFactory.getLogger(FileJsonService.class);

    @Autowired
    public FileJsonService(FileRepository fileRepository) {
        this.fileRepository = fileRepository;
    }

    // 为管理员提供的接口
    @Override
    public Object getFileListForAdmin() {
        List<File> fileList = fileRepository.findAvailableFiles();
        if (fileList.isEmpty()) {
            Constant.RES_SUCCESS_WITH_DATA.setData(fileList);
            return Constant.RES_SUCCESS_WITH_DATA;
        } else {
            Constant.RES_FAIL.setInfo("No File");
            return Constant.RES_FAIL;
        }
    }

    @Override
    public Object removeFileByFileIdForAdmin(long fileId) {
        try {
            fileRepository.delete(fileId);
            return Constant.RES_SUCCESS_NO_DATA;
        } catch (Exception e) {
            Constant.RES_FAIL.setInfo("Remove Error");
            return Constant.RES_FAIL;
        }
    }

    @Override
    public Object modifyFileByFileIdForAdmin(File file) {
        try {
            fileRepository.modifyFileByFileId(file.getFileId(), file.getUserId(), file.getFilename(),
                    file.getLocation(), file.getType(), file.isAvailable(), file.isPublic());
            return Constant.RES_SUCCESS_NO_DATA;
        } catch (Exception e) {
            LOGGER.debug("exception", e);
            Constant.RES_FAIL.setInfo("Modify Error");
            return Constant.RES_FAIL;
        }
    }

    @Override
    public Object getFileByIdForAdmin(long fileId) {
        File file = fileRepository.findOne(fileId);
        if (file != null) {
            Constant.RES_SUCCESS_WITH_DATA.setData(file);
            return Constant.RES_SUCCESS_WITH_DATA;
        } else {
            Constant.RES_FAIL.setInfo("No File");
            return Constant.RES_FAIL;
        }
    }

    // 为用户提供的接口
    @Override
    public Object getFileListForUser(long userId) {
        List<Long> userIdList = new ArrayList<>();
        userIdList.add(userId);
        return null;
        //return new Response("true", "success", fileRepository.findByuserId(userId));
        //return Response.getResponse("true", "success", fileRepository.findByuserId(userId));
    }
}
