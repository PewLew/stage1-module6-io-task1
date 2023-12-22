package com.epam.mjc.io;

import java.io.BufferedReader;
import java.io.File;
import java.util.Scanner;


public class FileReader {

    public Profile getDataFromFile(File file) {
        String[][] myStr = new String[4][2];
        try(Scanner sca = new Scanner(file)){
            String delimeter = " ";
            String[] subStr;
            int i = 0;

            while(sca.hasNextLine()){
                String line = sca.nextLine();
                subStr = line.split(delimeter);
                for(int j = 0; j< subStr.length; j++){
                    myStr[i][j] = subStr[j];
                }
                i++;
            }
        }
        catch (Exception e){
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
