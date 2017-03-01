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
    @Query(value = "update File f set f.filename = ?1, f.location = ?2, f.type = ?3, " +
            "f.available = ?4, f.is_public = ?5 where f.file_id = ?6", nativeQuery = true) // 不配置nativeQuery会报错
    void modifyFileByFileId(String fileName, String location, int type, boolean available,
                            boolean is_public, long fileId);
}
