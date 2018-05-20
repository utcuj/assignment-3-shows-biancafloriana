package DAO;

import model.BLL.IDAO;
import model.Activity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import javax.persistence.Query;
import java.util.List;

public class ActivityIDAO implements IDAO {

    public int create(Object o) {
        Activity e = (Activity)o;
        System.out.println(e.getShowId()+" "+e.getUserId());
        Session session = getSessionFactory().openSession();
        session.beginTransaction();
        session.save(e);
        session.getTransaction().commit();
        session.close();
        System.out.println("Successfully created Activity" + e.toString());
        return e.getId();
    }

    private SessionFactory getSessionFactory() {
        Configuration configuration = new Configuration().configure();
        configuration.addAnnotatedClass(Activity.class);
        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
                .applySettings(configuration.getProperties());
        return configuration
                .buildSessionFactory(builder.build());
    }

    public List read(int userId) {
        Session session = getSessionFactory().openSession();
        // @SuppressWarnings("unchecked")
        Query q = session.createQuery("FROM Activity where userId =:id");
        q.setParameter("id",userId);
        List <Activity> ActivitysList = q.getResultList();
        session.close();
        System.out.println("Found " + ActivitysList.size() + " model.Activity");
        return  ActivitysList;
    }
}
