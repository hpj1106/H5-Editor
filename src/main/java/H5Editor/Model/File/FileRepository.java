package H5Editor.Model.File;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by MrCJ on 2016/12/19.
 */
public interface FileRepository extends CrudRepository<File, Long> {

}
