package web.repository;

import web.model.User;

import java.util.List;

public interface UserRepository {
    void addUser(User user);

    void deleteUser(Integer id);

    void editUser(User user);

    User getUserById(Integer id);

    List<User> getAllUsers();
}
