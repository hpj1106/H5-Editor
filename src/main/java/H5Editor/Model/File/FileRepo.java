package H5Editor.Model.File;

import java.util.List;

/**
 * Created by MrCJ on 2016/12/19.
 */
public interface FileRepo {
    List<File> getAllFilesForAdmin();
    List<File> getAllFilesForUser(int userId);
}
