package com.mtahir.dapenbi.utilities;

import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.mtahir.dapenbi.dto.SimRegistrationDto;
import com.mtahir.dapenbi.dto.WriterDto;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;

/*
This class is CSV utility class
*/

public class FileCsvUtility {

    private static final String PATH_FILES  = "uploads/files"; //define the root directory of file
    private static final String[] FILE_HEADER = {"NIP", "NAME", "DATE OF BIRTH", "GENDER", "ADDRESS", "ID NUMBER", "PHONE"}; //define header file

    //method for write CSV file
    public void writeFile(WriterDto writerDto) {

        try {
            Writer writer;
            CSVPrinter csvPrinter;
            Path pathfile = Paths.get(PATH_FILES+"/DATA.csv"); //set file path

            //check if the root directory already exists
            if (!Files.exists(Paths.get(PATH_FILES))){
                Files.createDirectories(Paths.get(PATH_FILES)); // once root file directory not exists, create a new one
            }

            //check the csv file is exists or not.
            if (!Files.exists(pathfile)) {
                writer = Files.newBufferedWriter(pathfile);
                csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT.withHeader(FILE_HEADER)); //Prepare the file header once file is not exists
            } else {
                writer = Files.newBufferedWriter(pathfile, StandardOpenOption.APPEND // Prepare to append a new row once the file is exists
                , StandardOpenOption.CREATE);
                csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT);
            }

            // print the data to csv
            csvPrinter.printRecord(Arrays.asList(writerDto.getNip(),
                                                writerDto.getName(),
                                                writerDto.getBrithdate(),
                                                writerDto.getGender(),
                                                writerDto.getAddress(),
                                                writerDto.getIdnumber(),
                                                writerDto.getPhone())
                                            );

            csvPrinter.flush();
            csvPrinter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //method for read CSV File
    public List<SimRegistrationDto> readFile(String filename) throws ParseException {
        List<SimRegistrationDto> simRegistrationDtos = new ArrayList<>();
        Path pathfile = Paths.get(PATH_FILES+"/"+filename); //set path file
        CSVParser csvParser;
        try {
            Reader reader = Files.newBufferedReader(pathfile);
            csvParser = new CSVParser(reader, CSVFormat.DEFAULT
                    .withFirstRecordAsHeader() // Tell the parser to make the first row as header
                    .withIgnoreHeaderCase() // Tell the parser to ignore header case
                    .withTrim()); // Tell the parser to trim every data

            Iterable<CSVRecord> csvRecords = csvParser.getRecords();
            
            //Read file process
            for(CSVRecord csvRecord : csvRecords) {
                SimRegistrationDto simRegistrationDto = new SimRegistrationDto();
                simRegistrationDto.setNip(csvRecord.get(FILE_HEADER[0]));
                simRegistrationDto.setName(csvRecord.get(FILE_HEADER[1]));
                simRegistrationDto.setBrithdate(new SimpleDateFormat("yyyy-MM-dd").parse(csvRecord.get(FILE_HEADER[2])));
                simRegistrationDto.setGender(csvRecord.get(FILE_HEADER[3]));
                simRegistrationDto.setAddress(csvRecord.get(FILE_HEADER[4]));
                simRegistrationDto.setIdnumber(csvRecord.get(FILE_HEADER[5]));
                simRegistrationDto.setPhone(csvRecord.get(FILE_HEADER[6]));

                simRegistrationDtos.add(simRegistrationDto);
            }
            csvParser.close();
            return simRegistrationDtos; //Return as SimRegistrationDto object

        } catch (IOException ex) {
            throw new RuntimeException("Failed to parse CSV file: "+ex.getMessage());
        }
    }

}
