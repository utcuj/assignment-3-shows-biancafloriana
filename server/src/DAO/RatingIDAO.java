package DAO;

import model.BLL.IDAO;
import model.Rating;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import javax.persistence.Query;
import java.util.List;

public class RatingIDAO implements IDAO {

    public int create(Object o) {
        Rating e = (Rating)o;
        Session session = getSessionFactory().openSession();
        session.beginTransaction();
        session.save(e);
        session.getTransaction().commit();
        session.close();
        System.out.println("Successfully created Rating" + e.toString());
        return e.getId();
    }

    private SessionFactory getSessionFactory() {
        Configuration configuration = new Configuration().configure();
        configuration.addAnnotatedClass(Rating.class);
        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
                .applySettings(configuration.getProperties());
        return configuration
                .buildSessionFactory(builder.build());
    }

    public List read(int showId) {
        Session session = getSessionFactory().openSession();
        // @SuppressWarnings("unchecked")
        Query q = session.createQuery("FROM Rating where showId =:id");
        q.setParameter("id",showId);
        List <Rating> RatingsList = q.getResultList();
        session.close();
        System.out.println("Found " + RatingsList.size() + " model.Rating");
        return  RatingsList;
    }

}
