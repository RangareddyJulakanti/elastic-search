package com.example.elasticsearch.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName = "address_index")
public class Address {
    @Id
    private String houseKey;
    private Object addressLine1;
    private Object addressLine2;

    public String getHouseKey() {
        return houseKey;
    }

    public void setHouseKey(String houseKey) {
        this.houseKey = houseKey;
    }

    public Object getAddressLine1() {
        return addressLine1;
    }

    public void setAddressLine1(Object addressLine1) {
        this.addressLine1 = addressLine1;
    }

    public Object getAddressLine2() {
        return addressLine2;
    }

    public void setAddressLine2(Object addressLine2) {
        this.addressLine2 = addressLine2;
    }

    @Override
    public String toString() {
        return "Address{" +
                "houseKey='" + houseKey + '\'' +
                ", addressLine1=" + addressLine1 +
                ", addressLine2=" + addressLine2 +
                '}';
    }
}
