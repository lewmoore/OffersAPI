package com.offers.api.OffersAPI;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.*;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.assertj.core.api.Assertions;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.BeforeClass;
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

    @BeforeClass
    public static void init() throws IOException {
        CloseableHttpClient client = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost("http://localhost:8080/offers");
        httpPost.setHeader("Accept", "application/json");
        httpPost.setHeader("Content-type", "application/json");

        ObjectMapper mapper = new ObjectMapper();
        ObjectNode node = mapper.createObjectNode();
        node.put("description", "First Test Setup");
        node.put("currency", "GBP");
        node.put("price", "5000");
        String JSON_STRING = node.toString();
        StringEntity requestEntity = new StringEntity(
                JSON_STRING,
                ContentType.APPLICATION_JSON);
        httpPost.setEntity(requestEntity);

        client.execute(httpPost);

        CloseableHttpClient client2 = HttpClients.createDefault();
        HttpPost httpPost2 = new HttpPost("http://localhost:8080/offers");
        httpPost2.setHeader("Accept", "application/json");
        httpPost2.setHeader("Content-type", "application/json");

        ObjectMapper mapper2 = new ObjectMapper();
        ObjectNode node2 = mapper2.createObjectNode();
        node2.put("description", "Second Test Setup");
        node2.put("currency", "GBP");
        node2.put("price", "5000");
        String JSON_STRING2 = node.toString();
        StringEntity requestEntity2 = new StringEntity(
                JSON_STRING2,
                ContentType.APPLICATION_JSON);
        httpPost2.setEntity(requestEntity2);

        client2.execute(httpPost2);

    }

    @Test
    public void getAllOffers() throws IOException {
        HttpUriRequest request = new HttpGet("http://localhost:8080/offers");
        HttpResponse httpResponse = HttpClientBuilder.create().build().execute(request);

        Assertions.assertThat(httpResponse.getStatusLine().getStatusCode()).isEqualTo(200);
    }

    @Test
    public void postOffer() throws IOException {
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

    @Test
    public void getSingleOffer() throws IOException, JSONException {
        HttpUriRequest request = new HttpGet("http://localhost:8080/offers/2");
        HttpResponse httpResponse = HttpClientBuilder.create().build().execute(request);
        String json = EntityUtils.toString(httpResponse.getEntity());
        JSONObject object = new JSONObject(json);

        Assertions.assertThat(httpResponse.getStatusLine().getStatusCode()).isEqualTo(200);
        Assertions.assertThat(object.get("id")).isEqualTo(2);
    }

    @Test
    public void deleteSingleOffer() throws IOException, JSONException {
        HttpUriRequest request = new HttpDelete("http://localhost:8080/offers/1");
        HttpClientBuilder.create().build().execute(request);

        HttpUriRequest getAllRequest = new HttpGet("http://localhost:8080/offers");
        HttpResponse getAllResponse = HttpClientBuilder.create().build().execute(getAllRequest);

        String json = EntityUtils.toString(getAllResponse.getEntity());
        JSONArray array = new JSONArray(json);

        Assertions.assertThat(getAllResponse.getStatusLine().getStatusCode()).isEqualTo(200);
        JSONObject element = (JSONObject) array.get(0);
        Assertions.assertThat(element.get("id")).isNotEqualTo(1);
    }
}
