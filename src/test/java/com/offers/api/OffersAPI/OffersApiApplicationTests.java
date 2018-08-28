package com.offers.api.OffersAPI;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
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

    @Test
    public void postOffer() throws ClientProtocolException, IOException {
        CloseableHttpClient client = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost("http://localhost:8080/offers");
        httpPost.setHeader("Accept", "application/json");
        httpPost.setHeader("Content-type", "application/json");

        ObjectMapper mapper = new ObjectMapper();
        ObjectNode node = mapper.createObjectNode();
        node.put("description", "Test Description");
        node.put("currency", "GBP");
        node.put("price", "500");
        String JSON_STRING = node.toString();

        StringEntity requestEntity = new StringEntity(
                JSON_STRING,
                ContentType.APPLICATION_JSON);

        httpPost.setEntity(requestEntity);

        CloseableHttpResponse response = client.execute(httpPost);

        Assertions.assertThat(response.getStatusLine().getStatusCode()).isEqualTo(201);
    }
}
