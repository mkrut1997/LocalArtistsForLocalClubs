package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ArtistDirectory {
    private String path;
    private List<Artist> localArtists = new ArrayList<>();

    public ArtistDirectory(String path) throws FileNotFoundException{
        this.path = path;
        localArtists = scanArtists();
    }

    private List<Artist> scanArtists(){
        File artistsToLoad = new File(path);
        try(Scanner scan = new Scanner(artistsToLoad)){
            while(scan.hasNextLine()){
                String artistFromFile = scan.nextLine();
                createArtist(artistFromFile);
            }
        }catch(FileNotFoundException e){
            System.out.println("File could not be found");
        }
        return localArtists;
    }

    private void createArtist(String artistFromFile){
        String[] artistArray = artistFromFile.split(",");
        if(artistArray[0].equals("DJ")){
            String[] styles = new String[artistArray.length-7];
            int count = 0;
            for (int i = 7; i < artistArray.length; i++) {
                styles[count] = artistArray[i];
                count++;
            }
            DJ addDJ = new DJ(artistArray[2], artistArray[1], artistArray[3],artistArray[4],artistArray[6], styles,artistArray[5]);
            localArtists.add(addDJ);
        }
        else if(artistArray[0].equals("Band")){
            String[] equipment = artistArray[5].split(" ");
            String[] styles = new String[artistArray.length-7];
            int count = 0;
            for (int i = 7; i < artistArray.length; i++) {
                styles[count] = artistArray[i];
                count++;
            }
            Band addBand = new Band(artistArray[2], artistArray[1], artistArray[3],artistArray[4],artistArray[6], styles,equipment);
            localArtists.add(addBand);
        }
    }


}
