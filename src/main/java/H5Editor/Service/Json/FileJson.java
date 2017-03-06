package h5editor.service.json;

import h5editor.model.file.File;

/**
 * Created by MrCJ on 2016/12/22.
 * 素材相关的JSON接口
 */
public interface FileJson {

    // 为管理员提供的接口
    Object getFileListForAdmin();
    Object getFileListForAdmin(int page, int size);
    Object removeFileByFileIdForAdmin(long fileId);
    Object modifyFileByFileIdForAdmin(File file);
    Object getFileByIdForAdmin(long fileId);

    // 为用户提供的接口
    Object getFileListForUser(long userId);
}
