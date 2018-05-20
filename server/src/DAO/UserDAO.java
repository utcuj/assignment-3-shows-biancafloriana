package DAO;


import model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import javax.persistence.NoResultException;
import javax.persistence.Query;
import java.util.List;


public class UserDAO {

    public String create(User e) {
        Session session = getSessionFactory().openSession();
        session.beginTransaction();
        session.save(e);
        session.getTransaction().commit();
        session.close();
        System.out.println("Successfully created User" + e.toString());
        return e.getUsername();
    }

    private SessionFactory getSessionFactory() {
        Configuration configuration = new Configuration().configure();
        configuration.addAnnotatedClass(User.class);
        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
                .applySettings(configuration.getProperties());
        return configuration
                .buildSessionFactory(builder.build());
    }

    public List<User> read() {
        Session session = getSessionFactory().openSession();
        // @SuppressWarnings("unchecked")
        List<User> User = session.createQuery("FROM User").list();
        session.close();
        System.out.println("Found " + User.size() + " model.User");
        return User;
    }

    public void update(User e) {
        Session session = getSessionFactory().openSession();
        session.beginTransaction();
        User em = session.load(User.class, e.getId());

        try {
            em.setUsername(e.getUsername());
            em.setPassword(e.getPassword());
            em.setType(e.getType());
        } catch (Exception e1) {
            e1.printStackTrace();
            System.out.println("Datele nu au putut fi incarcate!");

        }


        session.getTransaction().commit();
        session.close();
        System.out.println("Successfully updated " + e.toString());

    }

    public void delete(User e) {
        Session session = getSessionFactory().openSession();
        session.beginTransaction();

        session.delete(e);
        session.getTransaction().commit();
        session.close();
        System.out.println("Successfully deleted " + e.toString());

    }

    public User findByID(int id) {
        Session session = getSessionFactory().openSession();
        User e = (User) session.load(User.class, id);
        session.close();
        return e;
    }

    public User findByUsername(String userName) {

        Session session = getSessionFactory().openSession();
        Query query = session.createQuery("FROM User where username =:userName");
        query.setParameter("userName", userName);
        User u=null;
        try{u = (User) query.getSingleResult();
        session.close();
        System.out.println("Found  model.User");}catch (NoResultException e){


        }
        return  u;
    }
}
