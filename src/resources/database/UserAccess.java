package resources.database;

import scene.login.entity.User;

/**
 * Created by Liu Woon Kit on 5/7/2017.
 */
public class UserAccess {
    // This class stores user object
    private static User user;

    public UserAccess(resources.database.entity.User user) {
    }

    public UserAccess(User user) {
    this.user = user;
}

    public static User getUser() {
        return user;
    }

    public void logout() {
        user = null;
    }
}