package com.mtahir.dapenbi.utilities;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;

import com.mtahir.dapenbi.dto.SimRegistrationDto;

/*
This class is TXT utility class
*/
public class FileTxtUtility {
    private static final String PATH_FILES  = "uploads/files/valid_nip"; //Set the txt file directory

    // this method to check file <NIP>.txt is exists or not
    public boolean isNipExists(String nip) {
        return Files.exists(Paths.get(PATH_FILES+"/"+nip+".txt"));
    }

    // This method is write txt file process
    public void writeFile(SimRegistrationDto simRegistrationDto) {
        try {

            // Check txt file directory is exists or not
            if (!Files.exists(Paths.get(PATH_FILES))) { //once directory is not exists
                Files.createDirectories(Paths.get(PATH_FILES)); //Create the directory
            }

            //Write TXT file process
            FileWriter fileWriter = new FileWriter(PATH_FILES+"/"+simRegistrationDto.getNip()+".txt");
            PrintWriter printWriter = new PrintWriter(fileWriter);
            printWriter.println("NIP : "+simRegistrationDto.getNip());
            printWriter.println("NAME : "+simRegistrationDto.getName());
            printWriter.println("DATE OF BIRTH : "+simRegistrationDto.getBrithdate());
            printWriter.println("GENDER : "+simRegistrationDto.getGender());
            printWriter.println("ADDRESS : "+simRegistrationDto.getAddress());
            printWriter.println("ID NUMBER : "+simRegistrationDto.getIdnumber());
            printWriter.println("PHONE NUMBER : "+simRegistrationDto.getPhone());
            printWriter.close();
        } catch (IOException ex) {
            throw new RuntimeException("==================FAILED CREATE FILE "+simRegistrationDto.getNip()+".txt => "+ex.getMessage());
        }
    }
}
