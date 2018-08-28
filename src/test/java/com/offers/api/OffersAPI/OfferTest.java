package com.offers.api.OffersAPI;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class OfferTest {

    @Test
    public void GetOfferDescription(){
    Offer offer = new Offer("Test Description", "GBP", 100);

    Assertions.assertThat("Test Description").isEqualTo(offer.getDescription());
    }
}
