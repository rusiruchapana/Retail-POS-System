package com.rusiruchapana.pos.dto;

import com.rusiruchapana.pos.entity.ContactNumbersConverter;
import jakarta.persistence.Column;
import jakarta.persistence.Convert;

import java.util.ArrayList;

public class CustomerDTO {

    private Long customerId;
    private String customerName;
    private String customerAdress;
    private Double customerSalary;
    private String nicNumber;
    private ArrayList<String> contactNumbers;
    private Boolean activeStatus;

    public CustomerDTO() {
    }
    public CustomerDTO(Long customerId, String customerName, String customerAdress, Double customerSalary, String nicNumber, ArrayList<String> contactNumbers, Boolean activeStatus) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.customerAdress = customerAdress;
        this.customerSalary = customerSalary;
        this.nicNumber = nicNumber;
        this.contactNumbers = contactNumbers;
        this.activeStatus = activeStatus;
    }

    @Override
    public String toString() {
        return "CustomerDTO{" +
                "customerId=" + customerId +
                ", customerName='" + customerName + '\'' +
                ", customerAdress='" + customerAdress + '\'' +
                ", customerSalary=" + customerSalary +
                ", nicNumber='" + nicNumber + '\'' +
                ", contactNumbers=" + contactNumbers +
                ", activeStatus=" + activeStatus +
                '}';
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerAdress() {
        return customerAdress;
    }

    public void setCustomerAdress(String customerAdress) {
        this.customerAdress = customerAdress;
    }

    public Double getCustomerSalary() {
        return customerSalary;
    }

    public void setCustomerSalary(Double customerSalary) {
        this.customerSalary = customerSalary;
    }

    public String getNicNumber() {
        return nicNumber;
    }

    public void setNicNumber(String nicNumber) {
        this.nicNumber = nicNumber;
    }

    public ArrayList<String> getContactNumbers() {
        return contactNumbers;
    }

    public void setContactNumbers(ArrayList<String> contactNumbers) {
        this.contactNumbers = contactNumbers;
    }

    public Boolean getActiveStatus() {
        return activeStatus;
    }

    public void setActiveStatus(Boolean activeStatus) {
        this.activeStatus = activeStatus;
    }
}
