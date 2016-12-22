package H5Editor.Service.Json;

/**
 * Created by MrCJ on 2016/12/22.
 */
public interface FileJson {
    Object getFileListForAdmin();
    Object getFileListForUser(int userId);
}
