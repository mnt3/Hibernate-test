package com.HibernateDemo.hibernateDemo.model;

import com.HibernateDemo.hibernateDemo.dao.BDUderDAOimp;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by JP17-2 on 2018.03.06.
 */
@Repository
public class BDUserDAO implements BDUderDAOimp  {
    @PersistenceContext private EntityManager entityManager;

    //@Override
    public List<User> getUsers() {
        return entityManager.createQuery("SELECT u from User u", User.class).getResultList();

    }


   // @Override
    public void createUser(User user) {
        entityManager.persist(user);

    }
    //@Override
    public void deleteUser(String username) {
        User user = entityManager.createQuery("SELECT u from User u where username = :un",User.class).setParameter("un", username).getSingleResult();
        if (entityManager.contains(user)){entityManager.remove(user);}
        else {entityManager.remove(entityManager.merge(user));}

    }

    //@Override
    public void updateUser(User user, String userName) {
        User user1 = entityManager.createQuery("SELECT u from User u where username = :un",User.class).setParameter("un", userName).getSingleResult();
    if (entityManager.contains(user1)){

    user1.setUsername(user.getUsername());
    user1.setEmail(user.getEmail());
    user1.setFirstName(user.getFirstName());
    user1.setLastName(user.getLastName());
        //entityManager.merge(user);
    }
    else {System.out.print("negalima updeitinti");}
    }

}
