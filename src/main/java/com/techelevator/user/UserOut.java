package com.techelevator.user;

import com.techelevator.Models.Equipment;
import com.techelevator.Models.Genre;
import com.techelevator.Models.Type;

import java.util.List;

public class UserOut {

    public static void displayHomePerformer(){
        String home = "******** Welcome Local Performer!! ********";
        System.out.println(home);
    }

    public static void displayPerformerOptions(){
        String performerOptions = "\nPlease choose an option below" +
                                  "\n1) Enter yourself into our database" +
                                  "\n2) Update your profile" +
                                  "\n3) Exit";
        System.out.println(performerOptions);
    }

    public static void promptForGenres(){
        String genrePrompt = "Would you like to add a genre or genres to your profile? This will make you more visible to venues. (Y/N)";
        System.out.println(genrePrompt);
    }



    public static void displayEquipmentOptions(List<Equipment> equipments){
        for(Equipment equipment : equipments){
            System.out.println(equipment.toString());
        }
    }

    public static void displayTypeOptions(List<Type> types){
        for(Type type : types){
            System.out.println(type.toString());
        }
    }

    public static void displayMessage(String message){
        System.out.println("\n******** " + message + " ********");
    }

    public static void displayGenreOptions(List<Genre> genres){
        System.out.println("Please select the number corresponding with the genre." +
                            "\nIf selecting multiple, enter a space between each number.\n");
        for(Genre genre : genres){
            System.out.println(genre.toString());
        }
    }

    public static void displayUpdateOptions(){
        String updateOptions = "\nWhat would you like to update?" +
                "\n1) Email address" +
                "\n2) Phone number" +
                "\n3) Equipment" +
                "\n4) Genres";
        System.out.println(updateOptions);
    }


}
