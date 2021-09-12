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
    private static int PEOPLE_COUNT;
    private List<User> users;

//  @Autowired
//   private SessionFactory sessionFactory;

    //For List version

    {
        users = new ArrayList<>();

        users.add(new User(++PEOPLE_COUNT, "Anna", "Ivnova", "mail@google.com"));
        users.add(new User(++PEOPLE_COUNT, "Nikolai", "Ivanov", "mail@yandex.ru"));
        users.add(new User(++PEOPLE_COUNT, "Olga", "Petrova", "mail@mail.ru"));
        users.add(new User(++PEOPLE_COUNT, "Elena", "Sidorova", "mail@yahhoo.com"));

        //sessionFactory.getCurrentSession().save(new User("Anna", "Ivnova", "mail@google.com"));
    }



    @Override
    public List<User> showAllUsers() {

        return users;
//        TypedQuery<User> query=sessionFactory.getCurrentSession().createQuery("from User");
//        return query.getResultList();
    }

    @Override
    public User showUser(Integer id){
        return users.stream().filter(person ->person.getId() == id).findAny().orElse(null);

//        TypedQuery<User> query=sessionFactory.getCurrentSession().createQuery("FROM User e where e.id = :id");
//        query.setParameter("id", id);
//
//        return query.getSingleResult();
    }

    @Override
    public void createUser(User user) {
        user.setId(++PEOPLE_COUNT);
        users.add(user);
//        sessionFactory.getCurrentSession().save(user);

    }

    @Override
    public void updateUser(Integer id, User updatedUser) {
        User userToBeUpdated = showUser(id);
        userToBeUpdated.setName(updatedUser.getName());
        userToBeUpdated.setLastName(updatedUser.getLastName());
        userToBeUpdated.seteMail(updatedUser.geteMail());

//        sessionFactory.getCurrentSession().update(userToBeUpdated);
    }

    @Override
    public void deleteUser(Integer id){

//        User deletedUser;
//
//        TypedQuery<User> query=sessionFactory.getCurrentSession().createQuery("FROM User e where e.id = :id");
//        query.setParameter("id", id);
//
//        deletedUser = query.getSingleResult();
//        sessionFactory.getCurrentSession().delete(deletedUser);

        users.removeIf(p -> p.getId() == id);
    }
}
