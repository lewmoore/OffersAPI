package com.offers.api.OffersAPI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class OfferController {

    @Autowired
    private OfferRepository offerRepository;

    @GetMapping("/offers")
    public List<Offer> getAllOffers() {
        return offerRepository.findAll();
    }

    @PostMapping("/offers")
    public ResponseEntity<Object> createOffer(@RequestBody Offer offer) {
        Offer savedOffer = offerRepository.save(offer);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(savedOffer.getId()).toUri();

        return ResponseEntity.created(location).build();

    }

}
