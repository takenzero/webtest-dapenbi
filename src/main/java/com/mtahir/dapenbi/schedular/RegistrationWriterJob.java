package com.mtahir.dapenbi.schedular;

import com.mtahir.dapenbi.dto.WriterDto;
import com.mtahir.dapenbi.services.WriterServices;
import com.mtahir.dapenbi.utilities.DataGeneratorUtility;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/*
This Class will simulate Cron Job
*/

@Component
public class RegistrationWriterJob {
    
    @Autowired
    WriterServices writerServices;

    //This task will be run every 1500ms after previous task is done and the first delay is 2000ms.
    @Scheduled(fixedDelay = 1500, initialDelay = 2000)
    public void doWrite() throws InterruptedException {
        DataGeneratorUtility dataGenerator = new DataGeneratorUtility();
        WriterDto writerDto = dataGenerator.generateData();

        //Call Writer Services
        writerServices.writeCsv(writerDto);

        Thread.sleep(100);
    }
}
