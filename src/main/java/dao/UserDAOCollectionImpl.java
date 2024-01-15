package dao;

import entities.User;

import java.util.ArrayList;
import java.util.List;


public class UserDAOCollectionImpl {
    private static final List<User> userList = new ArrayList<>();
    public List<User> getUsersList() {
        return userList;
    }
    public User getUser(User user) {
        return user;
    }

    public void addUser(User user) {
        userList.add(user);
    }

    public void deleteUser(String username) {
        userList.removeIf(user -> user.getUsername().equals(username));
    }

    public void updateUser(User updateUser) {
        for (User user : userList) {
            if (user.getId()==updateUser.getId()) {
                user.setUsername(updateUser.getUsername());
                user.setFirstName(updateUser.getFirstName());
                user.setLastName(updateUser.getLastName());
                user.setPassword(updateUser.getPassword());
                user.setAge(updateUser.getAge());
                user.setEmail(updateUser.getEmail());
                break;
            }
        }
    }
}
