package web.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import web.model.User;

import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;


@Repository
public class UserDaoImpl implements UserDao{

    private List<User> users;

  @Autowired
   private SessionFactory sessionFactory;

    @Override
    public List<User> showAllUsers() {
        TypedQuery<User> query=sessionFactory.getCurrentSession().createQuery("from User");
        return query.getResultList();
    }

    @Override
    public User showUser(Integer id){
        TypedQuery<User> query=sessionFactory.getCurrentSession().createQuery("FROM User e where e.id = :id");
        query.setParameter("id", id);

        return query.getSingleResult();
    }

    @Override
    public void createUser(User user) {
        sessionFactory.getCurrentSession().save(user);
    }

    @Override
    public void updateUser(Integer id, User updatedUser) {
        User userToBeUpdated = showUser(id);
        userToBeUpdated.setName(updatedUser.getName());
        userToBeUpdated.setLastName(updatedUser.getLastName());
        userToBeUpdated.seteMail(updatedUser.geteMail());

        sessionFactory.getCurrentSession().update(userToBeUpdated);
    }

    @Override
    public void deleteUser(Integer id){

        User deletedUser;

        TypedQuery<User> query=sessionFactory.getCurrentSession().createQuery("FROM User e where e.id = :id");
        query.setParameter("id", id);

        deletedUser = query.getSingleResult();
        sessionFactory.getCurrentSession().delete(deletedUser);
    }
}
