package com.example.vendorTask.Domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Vendor {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "Name should not be empty")
    private String name;
    @NotEmpty(message = "Bank account number should not empty")
    @Size(max = 16 , min = 10,message = "Enter valid account number or Check Account number")
    private String bankAccountNumber;
    @NotEmpty(message = "Bank Name Should not be empty")
    private String bankName;
    @NotEmpty
    @Size(max = 50 , message = "Address Line 1 Should Not be Exceed more than 50 characters")
    private String addressLine1;
    @Size(max = 50 , message = "Address Line 2 Should Not be Exceed more than 50 characters")
    private String addressLine2;
    @Size(min = 3 , message = "Enter valid city name")
    private String city;
    @Size(min = 4 , max = 30)
    private String country;
    @Size(min = 4,max = 7)
    private int zipCode;

    public Vendor(){
    }

    public Vendor(Long id,String name, String bankAccountNumber, String bankName, String addressLine1, String addressLine2, String city, String country, int zipCode) {
        this.id = id;
        this.name = name;
        this.bankAccountNumber = bankAccountNumber;
        this.bankName = bankName;
        this.addressLine1 = addressLine1;
        this.addressLine2 = addressLine2;
        this.city = city;
        this.country = country;
        this.zipCode = zipCode;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBankAccountNumber() {
        return bankAccountNumber;
    }

    public void setBankAccountNumber(String bankAccountNumber) {
        this.bankAccountNumber = bankAccountNumber;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getAddressLine1() {
        return addressLine1;
    }

    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    public String getAddressLine2() {
        return addressLine2;
    }

    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getZipCode() {
        return zipCode;
    }

    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }
}
