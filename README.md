# OffersAPI

## Description

This is an API built with Java and Spring that utilises JPA and a H2 database to store and retrieve Offers.

An offer consists of a description, currency and price, and each offer has unique id that is automatically generated.

To run this application using IntelliJ, first run `OffersApiApplication` and then run the tests by running `OffersApiApplicationTests`.

In order to access the H2 Database, run the application and visit `http://localhost:8080/h2-console`, then, connect to JDBC URL `jdbc:h2:mem:testdb` with the username `sa`

## Specification
You are required to create a simple RESTful software service that will allow a merchant to create a new simple offer. Offers, once created, may be queried. After the period of time defined on the offer it should expire and further requests to query the offer should reflect that somehow. Before an offer has expired users may cancel it.

## User Stories

``` 
As a Merchant,
So I can propse to sell my products,
I would like to be able to create an offer
```

```$xslt
As a Merchant,
So customers can see details of my offer,
I would like to be able to provide a description, price and currency with my offer
```

```$xslt
As a Merchant,
So I can see my active Offers,
I would like to be able to get details of a single Offer
```

```$xslt
As a Merchant,
So I can see my active Offers,
I would like to be able to get details of all Offers
```

```$xslt
As a Merchant,
So I can remove my Offers,
I would like to be able to delete my Offers
```

## Next Steps
The next steps for this API would be to add the time-based attribute to an offer. This could be achieved with DateTime class or something similar.
After that predefined time had expired, there could have been an expired attribute that sets to true, this would then make any interaction void and could delete the entry.