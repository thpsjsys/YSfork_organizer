package scene.login;

import resources.database.DB;
import resources.database.UserAccess;
import scene.login.entity.User;

import javax.sql.rowset.CachedRowSet;
import java.sql.SQLException;

/**
 * Created by Liu Woon Kit on 5/7/2017.
 */
public class LoginController {
    private DB db;
    public boolean verify(String userID, String password) {
        CachedRowSet rs = db.read("SELECT userID, name, birthDate, email, hpNumber, gender FROM User WHERE userID='" + userID + "' && password='" + password + "'");

        if(rs.size() == 0)
            return false;

        try {
            if(rs.next()) {
                new UserAccess(new User(rs.getString("userID"), rs.getString("name"), rs.getDate("birthDate"), rs.getString("email"), rs.getInt("hpNumber"), (rs.getString("gender")).charAt(0)));
            }
        } catch (SQLException e) {e.printStackTrace();}

        return true;
    }
}