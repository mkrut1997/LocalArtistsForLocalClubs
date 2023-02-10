package com.techelevator.user;

import com.techelevator.Models.Equipment;
import com.techelevator.Models.Genre;
import com.techelevator.Models.Performer;
import com.techelevator.Models.Type;

import java.util.List;
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
            else if(input==3){
                action = "";
                UserOut.displayMessage("Thank you!");
                break;
            }
            else{
                UserOut.displayMessage("INVALID SELECTION, TRY AGAIN");
            }
        }
        return action;
    }

    public String getPerformerUpdateInput(){
        String action = "";
        while(true) {
            UserOut.displayUpdateOptions();
            int input = Integer.parseInt(sc.nextLine());
            if(input==1){
                action = "email";
                break;
            }
            else if(input==2){
                action = "phone";
                break;
            }
            else if(input==3){
                action = "equipment";
                UserOut.displayMessage("Thank you!");
            }
            else if(input==4){
                action = "genre";
            }
            else{
                UserOut.displayMessage("INVALID SELECTION, TRY AGAIN");
            }
        }
        return action;
    }

    public String getGenreOptionInput(){
        String action = "";
        while(true) {
            String input = sc.nextLine();
            if(input.equalsIgnoreCase("Y")){
                action = "add genres";
                break;
            }
            else if(input.equalsIgnoreCase("N")){
                action = "return to home";
                break;
            }
            else{
                UserOut.displayMessage("INVALID RESPONSE, PLEASE CHOOSE EITHER Y OR N");
            }
        }
        return action;
    }

    public int[] getAllGenresFromUser(){
        String[] inputStrings = sc.nextLine().split(" ");
        int[] inputs = new int[inputStrings.length];
        for (int i = 0; i < inputStrings.length; i++) {
            inputs[i] = Integer.parseInt(inputStrings[i]);
        }
        return inputs;
    }

    public int getEquipmentIdFromUser(List<Equipment> equipments){
        int result = 0;
        while(result==0){
            int input = Integer.parseInt(sc.nextLine());
            for(Equipment equipment : equipments){
                if(input == equipment.getEqId()){
                    result = input;
                    break;
                }
            }
            if(result!=0){
                break;
            }else{
                UserOut.displayMessage("INVALID SELECTION, TRY AGAIN");
            }
        }
        return result;
    }

    public int getTypeIdFromUser(List<Type> types){
        int result = 0;
        while(result==0){
            int input = Integer.parseInt(sc.nextLine());
            for(Type type : types){
                if(input == type.getTypeId()){
                    result = input;
                    break;
                }
            }
            if(result!=0){
                break;
            }else{
                UserOut.displayMessage("INVALID SELECTION, TRY AGAIN");
            }
        }
        return result;
    }

    public String getNameFromUser(){
        String name = "";
        while(true){
            String input = sc.nextLine();
            if(input != null && !input.equals("")){
                name = input;
                break;
            }else{
                UserOut.displayMessage("NAME NOT ENTERED, TRY AGAIN");
            }
        }
        return name;
    }
    public String getEmailFromUser(){
        String email = "";
        while(true){
            String input = sc.nextLine();
            if(input != null && input.contains("@")){
                email = input;
                break;
            }else{
                UserOut.displayMessage("INVALID EMAIL ENTERED, TRY AGAIN");
            }
        }
        return email;
    }

    public String getPhoneFromUser(){
        String phone = sc.nextLine();

        return phone;
    }
    public String getLinkFromUser() {
        String link = "";
        while (true) {
            String input = sc.nextLine();
            if (input != null && input.contains(".com")) {
                link = input;
                break;
            } else {
                UserOut.displayMessage("VALID LINK IS REQUIRED, TRY AGAIN");
            }
        }
        return link;
    }






}
