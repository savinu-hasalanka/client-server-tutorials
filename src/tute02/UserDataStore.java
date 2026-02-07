package tute02;

import java.util.ArrayList;
import java.util.List;

public class UserDataStore {
    private List<User> users;

    public UserDataStore() {
        users = new ArrayList<>();
    }

    public void addUser(User user) {
        users.add(user);
    }

    public List<User> getAllUsers() {
        return users;
    }
}
