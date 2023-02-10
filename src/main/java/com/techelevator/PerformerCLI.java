package com.techelevator;

import com.techelevator.Dao.*;
import com.techelevator.Models.Performer;
import com.techelevator.user.UserIn;
import com.techelevator.user.UserOut;
import org.apache.commons.dbcp2.BasicDataSource;

import javax.sql.DataSource;
import java.util.Scanner;

public class PerformerCLI {

    private final Scanner scan = new Scanner(System.in);

    private final PerformerDao performerDao;
    private final EquipmentDao equipmentDao;
    private final TypeDao typeDao;
    private final GenreDao genreDao;
    private final UserIn in = new UserIn();

    public static void main(String[] args){
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setUrl("jdbc:postgresql://localhost:5432/LocalPerformers");
        dataSource.setUsername("postgres");
        dataSource.setPassword("postgres1");
        PerformerCLI application = new PerformerCLI(dataSource);
        application.run();


    }

    public PerformerCLI(DataSource dataSource){
        performerDao = new JdbcPerformerDao(dataSource);
        equipmentDao = new JdbcEquipmentDao(dataSource);
        typeDao = new JdbcTypeDao(dataSource);
        genreDao = new JdbcGenreDao(dataSource);
    }

    public void run(){
        while(true) {
            UserOut.displayHomePerformer();
            String action = in.getPerformerOptionInput();
            if (action.equals("create performer")) {
                option1();
            }
            else if(action.equals("update performer")){
                option2();
            }
            else {
                break;
            }
        }

    }

    public void option1(){
        Performer performer = new Performer();
        UserOut.displayMessage("Please select a performer type");
        UserOut.displayTypeOptions(typeDao.getAllTypes());
        performer.setType_id(in.getTypeIdFromUser(typeDao.getAllTypes()));
        UserOut.displayMessage("Please enter your name or your group's name");
        performer.setPerformerName(in.getNameFromUser());
        UserOut.displayMessage("Please enter your email address");
        performer.setEmail(in.getEmailFromUser());
        UserOut.displayMessage("Please enter your phone number (optional)");
        performer.setPhoneNumber(in.getPhoneFromUser());
        UserOut.displayMessage("Please choose the equipment desired for your act");
        UserOut.displayEquipmentOptions(equipmentDao.getAllEquipment());
        performer.setEqId(in.getEquipmentIdFromUser(equipmentDao.getAllEquipment()));
        UserOut.displayMessage("Please enter a Soundcloud or Youtube playlist link of your music");
        performer.setSoundcloudUrl(in.getLinkFromUser());
        Performer createdPerformer = performerDao.createPerformer(performer);
        UserOut.displayMessage("Congrats " + createdPerformer.getPerformerName() + "! You are added to our database!");
        UserOut.promptForGenres();
        String genreAction = in.getGenreOptionInput();
        if (genreAction.equals("add genres")) {
            UserOut.displayGenreOptions(genreDao.getAllGenres());
            int[] genreKeys = in.getAllGenresFromUser();
            for(int key : genreKeys){
                performerDao.addGenreToPerformer(createdPerformer.getPerformerId(), key);
            }
            UserOut.displayMessage("Genre(s) added! Returning to home screen");
        }
        else{
            UserOut.displayMessage("Returning to home screen!");
        }

    }

    public void option2(){
        UserOut.displayMessage("Please enter your email address");
        Performer performer = performerDao.getPerformerByEmail(in.getEmailFromUser());
        if(performer == null){
            UserOut.displayMessage("Email not in system, re-routing to Create Profile");
            option1();
        }
        UserOut.displayMessage("Welcome back " + performer.getPerformerName() + "!");

    }

}
