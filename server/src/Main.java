package DAO;


import model.Movie;
import model.Show;
import org.junit.jupiter.api.Test;

public class Main {

    Show movie = new Movie();


    @Test
    public void test(){

        movie.setId(1);
        Show m =new ShowDAO().findByID(movie);


        assert(m.getId() == movie.getId());
        System.out.println("Test correct!");

    }
}
