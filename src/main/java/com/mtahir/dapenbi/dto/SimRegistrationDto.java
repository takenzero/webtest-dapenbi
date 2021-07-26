package com.mtahir.dapenbi.dto;

import java.util.Date;

import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.mtahir.dapenbi.validator.NipUniqueConstraint;

/*
This class is a model for Reader File process
*/
public class SimRegistrationDto {
    
    @NotEmpty(message = "NIP is required") //Check if NIP is empty or not
    @Pattern(regexp = "^[0-9]*", message = "NIP must be in number format") //Check if NIP only has number format
    @NipUniqueConstraint(message = "NIP already exists") //Custom Anotation Validator to check this NIP already regitered
    private String nip;

    @NotEmpty(message = "Name is required") //Check if Name is empty or not
    @Pattern(regexp = "^[a-zA-Z ]*", message = "Name shouldn't have any special character") //Validating name shouldn't has any special character
    private String name;
    
    @NotNull(message = "Date of birth is required") // Check if DOB is empty or not 
    @FutureOrPresent(message = "Date of birth should be present or future") //Validating DOB should be a present date or the future date
    private Date brithdate;
    
    @NotEmpty(message = "Gender is required") // Check if Gender is empty or not 
    @Pattern(regexp = "^[MF]{1}", message = "Gender must be M or F") //Check if Gender must be M or F
    private String gender;
    
    @NotEmpty(message = "Address is required") // Check if Address is empty or not 
    @Size(min = 20, message = "Address must least 20 characters long") // Check if Address if minimum 20 chars or not
    private String address;
    
    @NotEmpty(message = "ID Number is required") // Check if ID Number is empty or not
    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-zA-Z]).*$", message = "ID Number should be a mix of character and number") // Check ID Number must be alphanumeric
    private String idnumber;
    
    @NotEmpty(message = "Phone number is required")  // Check if Phone is empty or not
    @Pattern(regexp = "^[+]{1}[1-9]{1,}[0-9]+$", message = "Phone number should comply to country standard, example +62") //Check phone format. This regex only check that the phone number should be started with '+' and not 0 after that.
    private String phone;

    //Above methods are Setters and Getters
    public String getNip() {
        return nip;
    }

    public void setNip(String nip) {
        this.nip = nip;
    }

    public Date getBrithdate() {
        return brithdate;
    }

    public void setBrithdate(Date brithdate) {
        this.brithdate = brithdate;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getIdnumber() {
        return idnumber;
    }

    public void setIdnumber(String idnumber) {
        this.idnumber = idnumber;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    
    
}
