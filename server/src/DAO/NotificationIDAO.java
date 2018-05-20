package DAO;

import model.BLL.IDAO;
import model.Notification;
import model.Notification;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import javax.persistence.Query;
import java.util.List;

public class NotificationIDAO implements IDAO {
    public int create(Object o) {
        Notification e = (Notification)o;
        Session session = getSessionFactory().openSession();
        session.beginTransaction();
        session.save(e);
        session.getTransaction().commit();
        session.close();
        System.out.println("Successfully created noti" + e.toString());
        return e.getTo();
    }

    private SessionFactory getSessionFactory() {
        Configuration configuration = new Configuration().configure();
        configuration.addAnnotatedClass(Notification.class);
        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
                .applySettings(configuration.getProperties());
        return configuration
                .buildSessionFactory(builder.build());
    }

    public List read(int showId) {
        Session session = getSessionFactory().openSession();
        // @SuppressWarnings("unchecked")
        Query q = session.createQuery("FROM Notification where to=:id");
        q.setParameter("id",showId);
        List <Notification> commentsList = q.getResultList();
        session.close();
        System.out.println("Found " + commentsList.size() + " model.Notification");
        return  commentsList;
    }

}
