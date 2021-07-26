package com.mtahir.dapenbi.dto;

/*
This class is a model for Writer File process
*/
public class WriterDto {
    private String nip;
    private String name;
    private String brithdate;
    private String gender;
    private String address;
    private String idnumber;
    private String phone;

    public String getNip() {
        return nip;
    }
    public void setNip(String nip) {
        this.nip = nip;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getBrithdate() {
        return brithdate;
    }
    public void setBrithdate(String brithdate) {
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
    
}
