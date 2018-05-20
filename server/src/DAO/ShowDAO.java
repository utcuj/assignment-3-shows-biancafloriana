package DAO;

import model.Movie;
import model.Show;
import model.SportEvent;
import model.Theatre;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import javax.persistence.Query;
import java.util.List;

public class ShowDAO {
    public int create(Show s) {
        Session session = getSessionFactory(s.getClass()).openSession();
        session.beginTransaction();
        session.save(s);
        session.getTransaction().commit();
        session.close();
        System.out.println("Successfully created Show" + s.toString());
        return s.getId();
    }

    private SessionFactory getSessionFactory(Class s) {
        Configuration configuration = new Configuration().configure();
        configuration.addAnnotatedClass(s);
        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
                .applySettings(configuration.getProperties());
        return configuration
                .buildSessionFactory(builder.build());
    }

    public List<Show> readMovies() {
        Session session = getSessionFactory( new Movie().getClass()).openSession();
        // @SuppressWarnings("unchecked")
        List<Show> Show = session.createQuery("FROM Movie").getResultList();
        session.close();
        System.out.println("Found " + Show.size() + " model.Movie");
        return Show;
    }

    public List<Show> readTheatre() {
        Session session = getSessionFactory( new Theatre().getClass()).openSession();
        // @SuppressWarnings("unchecked")
        List<Show> Show = session.createQuery("FROM Theatre").getResultList();
        session.close();
        System.out.println("Found " + Show.size() + " model.Theatre");
        return Show;
    }

    public List<Show> readSportEvent() {
        Session session = getSessionFactory( new SportEvent().getClass()).openSession();
        // @SuppressWarnings("unchecked")
        List<Show> Show = session.createQuery("FROM SportEvent ").getResultList();
        session.close();
        System.out.println("Found " + Show.size() + " model.SpotEvent");
        return Show;
    }


    public void update(Show s) {
        Session session = getSessionFactory(s.getClass()).openSession();
        session.beginTransaction();
        Show sm = session.load(s.getClass(), s.getId());
            System.out.println(s.getClass().toString());
        try {
            sm.setName(s.getName());
            sm.setDescription(s.getDescription());
            switch (s.getClass().toString()) {

                case "class model.Movie":
                    ((Movie) sm).setActors( ((Movie) s).getActors());
                    ((Movie) sm).setRating( ((Movie) s).getRating());
                    break;
                case "class model.Theatre":
                    ((Theatre) sm).setActors( ((Theatre) s).getActors());
                    break;
                default:
                    ((SportEvent) sm).setTeam1( ((SportEvent) s).getTeam1());
                    ((SportEvent) sm).setTeam2( ((SportEvent) s).getTeam2());
            }
        } catch (Exception e1) {
           // e1.printStackTrace();
            System.out.println("Datele nu au putut fi incarcate!");

        }


        session.getTransaction().commit();
        session.close();
        System.out.println("Successfully updated " + s.toString());

    }

     public void delete(Show s) {
        Session session = getSessionFactory(s.getClass()).openSession();
        session.beginTransaction();
       // Show ss = findByID(s);
        session.delete(s);
        session.getTransaction().commit();
        session.close();
        System.out.println("Successfully deleted " + s.toString());

    }

    public Show findByID(Show s) {
        Session session = getSessionFactory(s.getClass()).openSession();
        try{s = session.load(s.getClass(), s.getId());}catch (Exception e){s =null;}
               System.out.println(s.getName());

        session.close();
        return s;
    }

   /* private List<Show> findBy(String query) {
        Session session = getSessionFactory().openSession();
        @SuppressWarnings("unchecked")
        List<Show> Show = session.createQuery(query).list();
        session.close();
        System.out.println("Found " + Show.size() + " model.Show");
        return Show;
    }

   */ public Show findByTitle(Show s) {

       Session session = getSessionFactory(s.getClass()).openSession();
       Query query = session.createQuery("FROM Show where name =:name");
       query.setParameter("name", s.getName());

      try {
          s = (Show) query.getSingleResult();
      }
      catch (Exception e ){
          s = null;
      }
       session.close();
       System.out.println("Found  model.Medication");
        return  s;

    }

    public List read() {
        Session session = getSessionFactory( new Show().getClass()).openSession();
        // @SuppressWarnings("unchecked")
        List<Show> Show = session.createQuery("FROM Show").getResultList();
        session.close();
        System.out.println("Found " + Show.size() + " model.Movie");
        return Show;
    }
}
