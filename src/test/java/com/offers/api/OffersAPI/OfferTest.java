package com.offers.api.OffersAPI;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class OfferTest {

    @Test
    public void GetOfferDescription(){
    Offer offer = new Offer("Test Description", "GBP", 100);

    Assertions.assertThat("Test Description").isEqualTo(offer.getDescription());
    }

    @Test
    public void GetOfferCurrency(){
        Offer offer = new Offer("Test Description", "GBP", 100);

        Assertions.assertThat("GBP").isEqualTo(offer.getCurrency());

    }

    @Test
    public void GetOfferPrice() {
        Offer offer = new Offer("Test Description", "GBP", 100);

        Assertions.assertThat(100).isEqualTo(offer.getPrice());
    }
}
