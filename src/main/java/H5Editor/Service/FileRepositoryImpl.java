package H5Editor.Service;

import H5Editor.Model.File.File;
import H5Editor.Model.File.FileRepo;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by MrCJ on 2016/12/19.
 */
public class FileRepositoryImpl implements FileRepo {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<File> getAllFilesForAdmin() {
        String selectForAdmin = "select * from file";
        return (List<File>) em.createQuery(selectForAdmin);
    }

    @Override
    public List<File> getAllFilesForUser(int userId) {
        String selectForUser = "select * from file where user_id =:userId";
        return (List<File>) em.createQuery(selectForUser);
    }
}
