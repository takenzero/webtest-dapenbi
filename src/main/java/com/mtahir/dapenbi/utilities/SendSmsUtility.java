package com.mtahir.dapenbi.utilities;

import java.util.HashMap;
import java.util.Map;

import com.mtahir.dapenbi.dto.SimRegistrationDto;

/*
This class to simulate SMS Service
*/
public class SendSmsUtility {

    private static Map<String, String> title = new HashMap<>();
    private static final String MESSAGE = "Selamat <TITLE> <NAME>, registrasi SIM Anda berhasil."; // Set SMS pattern

    // this cunstructor to mapping the title according to gender
    public SendSmsUtility() {
        title.put("M", "Bapak");
        title.put("F", "Ibu");
    }

    // Simulate send sms process
    public void sendMessage(SimRegistrationDto simRegistrationDto) {
        System.out.println("==========================================\nREGISTRATION SUCCESS");
        System.out.println("SEND SMS TO : "+simRegistrationDto.getPhone()); //set destination number
        System.out.println(MESSAGE.replace("<TITLE>", title.get(simRegistrationDto.getGender())).replace("<NAME>", simRegistrationDto.getName())); //generate sms text based on gender
    }

}
