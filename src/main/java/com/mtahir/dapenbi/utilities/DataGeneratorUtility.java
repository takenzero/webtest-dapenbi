package com.mtahir.dapenbi.utilities;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.Random;

import com.github.javafaker.Faker;
import com.mtahir.dapenbi.dto.WriterDto;

/*
This class will be used to Generate Random data by Faker Library
*/

public class DataGeneratorUtility {
    
    public WriterDto generateData() {
        WriterDto simRegistration = new WriterDto();
        Faker faker = new Faker(new Locale("id-ID"));

        simRegistration.setNip(faker.regexify("[0-9]{12}")); //Generate 12 random number as NIP
        simRegistration.setName(faker.name().fullName()); // Get random name
        simRegistration.setBrithdate(pickRandomDate(faker)); //Generate random date of birth
        simRegistration.setGender(pickRandomGender()); //Generate random Gender
        simRegistration.setAddress(faker.address().fullAddress()); // Get random address
        simRegistration.setIdnumber(faker.regexify("[0-9A-Z]{12,}")); //Generate 12 or more alphanumeric as an ID Number
        simRegistration.setPhone(faker.regexify("+[0-9]{8,12}")); //Genetate phone number

        return simRegistration; //return all of random data as WriterDto object
    }

    //this method to pickup random Gender
    private String pickRandomGender() {
        String[] gender = {"M", "F", "X"}; //M=Male, F=Female, X=Simulate invalid Gender
        int idx = new Random().nextInt(gender.length);
        return gender[idx];
    }

    //This method to pickup random date that started from 5 years past and ended to 5 years latter.
    private String pickRandomDate(Faker faker) {
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        Calendar from = new GregorianCalendar(currentYear - 5, 0, 1);
        Calendar to = new GregorianCalendar(currentYear + 5, 11, 31);
        
        SimpleDateFormat dateformater = new SimpleDateFormat("yyyy-MM-dd");
        return dateformater.format(faker.date().between(from.getTime(), to.getTime()));
    }

}
