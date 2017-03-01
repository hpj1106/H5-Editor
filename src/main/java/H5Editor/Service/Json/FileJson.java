package H5Editor.Service.Json;

import H5Editor.Model.File.File;

/**
 * Created by MrCJ on 2016/12/22.
 * 素材相关的JSON接口
 */
public interface FileJson {
    Object getFileListForAdmin();
    Object getFileListForUser(long userId);
    Object removeFileByFileIdForAdmin(long fileId);
    Object modifyFileByFileIdForAdmin(File file);
    Object getFileByIdForAdmin(long fileId);
}
