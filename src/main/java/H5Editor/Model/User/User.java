package H5Editor.Model.User;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by MrCJ on 2016/12/8.
 */


@Data
@Entity
public class User {

    @Id
    private long userId;
    private String username;
    private String password;
    private String email;
    private String tel;
    private int type;
    private boolean available;

    @Override
    public String toString() {
        return "username = " + username;
    }
}
