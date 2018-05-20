package DAO;

import model.BLL.IDAO;
import model.Comment;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import javax.persistence.Query;
import java.util.List;

public class CommentsIDAO implements IDAO {
    public int create(Object o) {
        Comment e = (Comment)o;
        Session session = getSessionFactory().openSession();
        session.beginTransaction();
        session.save(e);
        session.getTransaction().commit();
        session.close();
        System.out.println("Successfully created Comment" + e.toString());
        return e.getId();
    }

    private SessionFactory getSessionFactory() {
        Configuration configuration = new Configuration().configure();
        configuration.addAnnotatedClass(Comment.class);
        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
                .applySettings(configuration.getProperties());
        return configuration
                .buildSessionFactory(builder.build());
    }

    public List read(int showId) {
        Session session = getSessionFactory().openSession();
        // @SuppressWarnings("unchecked")
        Query q = session.createQuery("FROM Comment where showId =:id");
        q.setParameter("id",showId);
        List <Comment> commentsList = q.getResultList();
        session.close();
        System.out.println("Found " + commentsList.size() + " model.Comment");
        return  commentsList;
    }

}
