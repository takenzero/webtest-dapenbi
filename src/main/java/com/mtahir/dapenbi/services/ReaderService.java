package com.mtahir.dapenbi.services;

import com.mtahir.dapenbi.dto.SimRegistrationDto;
import com.mtahir.dapenbi.utilities.FileTxtUtility;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/*
This class is Reader Service and will be called by Registration Reader Job to continue Valid Data process
*/
@Service
public class ReaderService {
    
    @Autowired
    FileTxtUtility fileTxtUtility;

    public void writeTxt(SimRegistrationDto simRegistrationDto) {
        //Call utility class to write valid data to txt file
        fileTxtUtility.writeFile(simRegistrationDto);
    }
}
