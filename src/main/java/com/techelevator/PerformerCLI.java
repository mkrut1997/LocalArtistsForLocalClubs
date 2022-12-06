package com.techelevator;

import com.techelevator.Dao.*;
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
        UserOut.displayHomePerformer();
        String action = in.getPerformerOptionInput();


    }

}
