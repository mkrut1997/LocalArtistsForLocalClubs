package com.techelevator.user;

import java.util.Scanner;

public class UserIn {

    private final Scanner sc = new Scanner(System.in);

    public String getPerformerOptionInput(){
        String action = "";
        while(true) {
            UserOut.displayPerformerOptions();
            int input = Integer.parseInt(sc.nextLine());
            if(input==1){
                action = "create performer";
                break;
            }
            else if(input==2){
                action = "update performer";
                break;
            }
            else{
                UserOut.displayMessage("INVALID SELECTION, TRY AGAIN");
            }
        }
        return action;
    }




}
