package com.techelevator.user;

public class UserOut {

    public static void displayHomePerformer(){
        String home = "******** Welcome Local Performer!! ********";
        System.out.println(home);
    }

    public static void displayPerformerOptions(){
        String performerOptions = "\nPlease choose an option below" +
                                  "\n1) Enter yourself into our database" +
                                  "\n2) Update your profile";
        System.out.println(performerOptions);
    }

    public static void displayMessage(String message){
        System.out.println("\n******** " + message + " ********");
    }

}
