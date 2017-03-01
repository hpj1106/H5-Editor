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

    @Query("select * from file f where f.available = 1")
    List<File> findAvailableFiles();

    @Modifying
    @Transactional
    @Query("update file f set f.fileName = ?3, f.location = ?4, f.type = ?5, " +
            "f.available = ?6, f.is_public = ?7 where f.fileId = ?1")
    void modifyFileByFileId(long fileId, long userId, String fileName, String location,
                            int type, boolean available, boolean is_public);
}
