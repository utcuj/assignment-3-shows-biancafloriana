package controller;

import model.*;
import model.BLL.ShowServices;
import model.BLL.UserServices;
import view.DetailsView;

import java.awt.event.ActionListener;
import java.util.List;
import java.util.Vector;

public class ControllerDetails {
    private final int idUser;
    private DetailsView detailsView;
    private int id;
    private  String type;

    ControllerDetails(String type,int id,int idUser) {
        this.id = id;
        this.type=type;
        this.idUser =idUser;
        detailsView = new DetailsView(type);
        listDetails();
        addListenerComment();
        addListenerRating();
        addActivity();

    }

    private void addActivity() {
        UserServices.addActivity(idUser,id);
    }

    private void addListenerComment() {

        ActionListener addButtonL = arg0 -> {

            String date = detailsView.getComment();
            Comment c =new Comment(idUser,id,date);
            ShowServices.addComment(c);
            detailsView.addComment(c.getUserId() + ":" + c.getText());
            
            
            
        };
        detailsView.addListenerComment(addButtonL);
    }


    private void addListenerRating() {

        ActionListener ButtonL = arg0 -> {
            int date = detailsView.getRating();
            Rating r = new Rating(idUser,id,date);
            ShowServices.addRating(r);
            detailsView.addRating(r.getUserId() + ":" + r.getRating());
        };

        detailsView.addListenerRating(ButtonL);
    }



    private void listDetails() {
        
        //detailsView.clear(type);
        Show s ;
         s = ShowServices.findById(id,type);

         Vector cols = new Vector();

        cols.add(s.getId());
        cols.add(s.getName());
        cols.add(s.getDescription());
        cols.add(s.getType());

        switch (type){

            case "movie":
                cols.add(((Movie)s).getActors());
                cols.add(((Movie)s).getRating());
                break;
            case "theatre":
                cols.add(((Theatre)s).getActors());
                break;
            case "sport":
                cols.add(((SportEvent)s).getTeam1());
                cols.add(((SportEvent)s).getTeam2());
                break;
        }

         detailsView.addShow(cols);
         List<Comment> commentList = ShowServices.getComments(id);
         
         for(Comment c : commentList){
             
             detailsView.addComment(c.getUserId() + ":" + c.getText());
         }
       
        List<Rating> ratings = ShowServices.getRatings(id);

        for(Rating r : ratings){

            detailsView.addRating(r.getUserId() + ":" + r.getRating());
        }



    }



}
