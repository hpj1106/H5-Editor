package H5Editor.Model.File;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by MrCJ on 2016/12/19.
 */
public interface FileRepository extends CrudRepository<File, Long> {

    @Query("select f from File f where f.available = 1") // File not file...
    List<File> findAvailableFiles();

    @Modifying
    @Transactional
    @Query(value = "update File f set f.filename = ?2, f.location = ?3, f.type = ?4, " +
            "f.available = ?5, f.is_public = ?6 where f.file_Id = ?1", nativeQuery = true) // 不配置nativeQuery会报错
    void modifyFileByFileId(long fileId, String fileName, String location, int type, boolean available, boolean is_public);
}
