package com.epam.mjc.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;


public class FileReader {

    public Profile getDataFromFile(File file) {
        String[][] myStr = new String[4][2];
        try(BufferedReader r = new BufferedReader(new java.io.FileReader(file.getName()))){
            String delimeter = " ";
            String[] subStr;
            String line = r.readLine();
            int i = 0;
            while (line != null){
                subStr = line.split(delimeter);
                for(int j= 0; j < subStr.length; j++){
                    myStr[i][j]= subStr[j];
                }
                line = r.readLine();
                i++;
            }

        }
        catch (FileNotFoundException e){
            e.printStackTrace();
        }
        catch (IOException e){
            e.printStackTrace();
        }

        int age = 0;
        String name = null;
        String email = null;
        long phone = 0;

        for(int i = 0; i <myStr.length; i++){
            for(int j = 0; j < myStr[i].length; j++){
                if(myStr[i][j].equals("Name:"))
                    name = myStr[i][j+1];
                if(myStr[i][j].equals("Age:"))
                    age = Integer.parseInt((myStr[i][j+1]));
                if(myStr[i][j].equals("Email:"))
                    email = myStr[i][j+1];
                if(myStr[i][j].equals("Phone:"))
                    phone = Long.parseLong(myStr[i][j+1]);
            }
        }

        return new Profile(name, age, email, phone);
    }
}
