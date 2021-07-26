package com.mtahir.dapenbi.schedular;

import java.text.ParseException;
import java.util.List;
import com.mtahir.dapenbi.dto.SimRegistrationDto;
import com.mtahir.dapenbi.services.ReaderService;
import com.mtahir.dapenbi.utilities.FileCsvUtility;
import com.mtahir.dapenbi.utilities.SendSmsUtility;
import com.mtahir.dapenbi.utilities.ValidationUtility;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/*
This Class will simulate Cron Job
*/

@Component
public class RegistrtionReader {

    @Autowired
    ReaderService readerService;

    @Autowired
    ValidationUtility validationUtility;

    //This task will be executed every 1mnt
    @Scheduled(fixedDelay = 60000, initialDelay = 60000)
    public void doRead() throws ParseException, InterruptedException {
        //Call utility class and send a filename as an argument
        List<SimRegistrationDto> simRegistrationDtos = new FileCsvUtility().readFile("DATA.csv");

        //Check if file is not empty
        if (!simRegistrationDtos.isEmpty()) {
            for (SimRegistrationDto simRegistrationDto : simRegistrationDtos) {
                //Call utility class to validate every row data
                List<String> checks = validationUtility.doValidate(simRegistrationDto);
                
                //Check if row has error message
                if (!checks.isEmpty()) {
                    //Once the row has error message (invalid row), print every error message to console log
                    System.out.println("==========================================\nFAILED REGISTRATION FOR : "+simRegistrationDto.getNip());
                    for (String check : checks) {
                        System.out.println(check);
                    }
                } else {
                    //But, once the row has np error message, call reader service class to continue the process and send welcome SMS
                    readerService.writeTxt(simRegistrationDto);
                    new SendSmsUtility().sendMessage(simRegistrationDto);
                }

                Thread.sleep(150);
            }
        }
    }

}
