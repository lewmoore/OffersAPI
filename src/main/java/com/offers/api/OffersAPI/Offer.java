package com.offers.api.OffersAPI;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Offer {
    @Id
    @GeneratedValue
    private long id;
    private String description;
    private String currency;
    private int price;

    public Offer(){
        super();
    }

    public Offer(long id, String description, String currency, int price){
        super();
        this.id = id;
        this.description = description;
        this.currency = currency;
        this.price = price;
    }

    public long getId(){
        return id;
    }

    public void setId(long id){
        this.id = id;
    }

    public String getDescription(){
        return description;
    }

    public void setDescription(String desc){
        this.description = desc;
    }

    public String getCurrency(){
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public int getPrice(){
        return price;
    }

    public void setPrice(){
        this.price = price;
    }
}
