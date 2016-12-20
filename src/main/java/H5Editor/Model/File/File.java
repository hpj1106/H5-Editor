package H5Editor.Model.File;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by MrCJ on 2016/12/19.
 */
@Data
@Entity
public class File {
    @Id
    private long fileId;
    private int userId;
    private String filename;
    private int type;
    private boolean available;
    private boolean isPublic;

    public String toString() {
        return "file = " + this.filename;
    }
}
