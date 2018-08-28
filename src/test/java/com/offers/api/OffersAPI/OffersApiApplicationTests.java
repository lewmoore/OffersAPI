package com.offers.api.OffersAPI;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.HttpClientBuilder;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

@RunWith(SpringRunner.class)
@WebMvcTest(value = OfferController.class)
public class OffersApiApplicationTests {

    @MockBean
    private OfferRepository offerRepository;

    @Test
    public void getAllOffers() throws ClientProtocolException, IOException {

        HttpUriRequest request = new HttpGet("http://localhost:8080/offers");

        HttpResponse httpResponse = HttpClientBuilder.create().build().execute(request);
        Assertions.assertThat(httpResponse.getStatusLine().getStatusCode()).isEqualTo(200);

    }
}
