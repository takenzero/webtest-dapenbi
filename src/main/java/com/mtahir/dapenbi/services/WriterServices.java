package com.mtahir.dapenbi.services;

import com.mtahir.dapenbi.dto.WriterDto;
import com.mtahir.dapenbi.utilities.FileCsvUtility;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/*
This class is Writer Service and will be called by Writer Reader Job to continue process
*/
@Service
public class WriterServices {
    
    @Autowired
    FileCsvUtility fileCsvUtility;

    public void writeCsv(WriterDto writerDto) {
        //Call utility class to append the row to CSV file
        fileCsvUtility.writeFile(writerDto);
    }

}
