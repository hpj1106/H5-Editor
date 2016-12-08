package H5Editor.Model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by MrCJ on 2016/12/8.
 */


@Setter
@Getter
@Entity
public class Admin {

    @Id
    private String username;
    private String password;
    private String email;
    private String tel;

    @Override
    public String toString() {
        return "username = " + username;
    }
}
