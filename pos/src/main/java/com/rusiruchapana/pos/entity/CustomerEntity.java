package com.rusiruchapana.pos.entity;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.vladmihalcea.hibernate.type.json.JsonType;
import jakarta.persistence.*;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

import java.util.ArrayList;


@Entity
@Table(name = "customer")
//@TypeDefs(
//        @TypeDef(name="json", typeClass= JsonType.class)
//)
public class CustomerEntity {

    @Id
    @Column(name = "customer_id",length = 45)
    private Long customerId;
    @Column(name = "customer_name",nullable = false,length = 100)
    private String customerName;
    @Column(name = "customer_adress",length = 100)
    private String customerAdress;
    @Column(name = "customer_salary",length = 10)
    private Double customerSalary;
    @Column(name = "nic_number",unique = true, length=12)
    private String nicNumber;
    @Convert(converter = ContactNumbersConverter.class)
    private ArrayList<String> contactNumbers;
    @Column(name = "active_status", columnDefinition = "TINYINT default 1")
    private Boolean activeStatus;

    //No Args constructor.
    public CustomerEntity() {
    }

    //All args constructor.
    public CustomerEntity(Long customerId, String customerName, String customerAdress, Double customerSalary, String nicNumber, ArrayList<String> contactNumbers, Boolean activeStatus) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.customerAdress = customerAdress;
        this.customerSalary = customerSalary;
        this.nicNumber = nicNumber;
        this.contactNumbers = contactNumbers;
        this.activeStatus = activeStatus;
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
