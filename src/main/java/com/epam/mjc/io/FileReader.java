package com.epam.mjc.io;

import java.io.BufferedReader;
import java.io.File;


public class FileReader {

    public Profile getDataFromFile(File file) {
        String[][] myStr = new String[4][2];
        try(BufferedReader r = new BufferedReader(new java.io.FileReader(file.getName()))){
            String delimeter = " ";
            String[] subStr;
            String line = r.readLine();
            int i = 0;
            int j = 0;
            while (line != null){
                subStr = line.split(delimeter);
                myStr[i][j] = subStr[0];
                myStr[i][j+1] = subStr[1];
                line = r.readLine();
                i++;
                j = 0;
            }

        } catch (NullPointerException e){
            e.getMessage();
        } catch (Exception e){
            e.getMessage();
        }

        int age = 0;
        String name = null;
        String email = null;
        long phone = 0;

        for (String[] strings : myStr) {
            for (int j = 0; j < strings.length; j++) {
                if (strings[j].equals("Name:"))
                    name = strings[j + 1];
                if (strings[j].equals("Age:"))
                    age = Integer.parseInt((strings[j + 1]));
                if (strings[j].equals("Email:"))
                    email = strings[j + 1];
                if (strings[j].equals("Phone:"))
                    phone = Long.parseLong(strings[j + 1]);
            }
        }

        return new Profile(name, age, email, phone);
    }
}
