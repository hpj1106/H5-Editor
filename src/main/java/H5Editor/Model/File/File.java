package h5editor.model.file;

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
    private long userId;
    private String filename;
    private String location;
    private int type;
    private boolean available;
    private boolean isPublic;

    public File() {

    }

    public File(long userId, String filename, String location, int type, boolean available, boolean isPublic) {
        this.userId = userId;
        this.filename = filename;
        this.location = location;
        this.type = type;
        this.available = available;
        this.isPublic = isPublic;
    }

    public String toString() {
        return "file = " + this.filename;
    }
}
