package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
//import web.dao.UserDaoImpl;
import web.model.User;
import web.repository.UserRepository;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService{

    private UserRepository userRepository;

    @Autowired
    public void setUserDao(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    //@Transactional
    @Override
    public List<User> showAllUsers() {
        return userRepository.getAllUsers();
    }

    //@Transactional
    @Override
    public User showUser(Integer id){
        return userRepository.getUserById(id);
    }

    //@Transactional
    @Override
    public void createUser(User user) {
        userRepository.addUser(user);
    }

    //@Transactional
    @Override
    public void updateUser(User user) {
        userRepository.editUser(user);
    }

    //@Transactional
    @Override
    public void deleteUser(Integer id) {
        userRepository.deleteUser(id);
    }
}
