package com.epam.mjc.io;

import java.io.File;


public class FileReader {

    public Profile getDataFromFile(File file) {
        int ch;
        String myString = "";
        try(java.io.FileReader reader = new java.io.FileReader(file.getName())){
            while ((ch = reader.read())!=-1){
                myString += (char)ch;
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        String name = null;
        int age = 0;
        String email = null;
        long phone = 0;

        myString = myString.replace(System.getProperty("line.separator"), " ");
        String[] arr = myString.split(" ");
        for(int i = 0; i < arr.length; i++){
            if(arr[i].equals("Name:")){
                name = arr[i+1];
            }
            if(arr[i].equals("Age:")){
                age = Integer.parseInt(arr[i+1]);
            }
            if(arr[i].equals("Email:")){
                email = arr[i+1];
            }
            if(arr[i].equals("Phone:")){
                phone = Long.parseLong(arr[i+1]);
            }
        }

        return new Profile(name, age, email, phone);
    }
}
