package com.offers.api.OffersAPI;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Offer {
    @Id
    @GeneratedValue
    private Long id;
    private String description;
    private String currency;
    private int price;

    public Offer(String description, String currency, int price){
        this.description = description;
    }

    public String getDescription(){
        return description;
    }

    public void setDescription(String desc){
        this.description = desc;
    }

}
