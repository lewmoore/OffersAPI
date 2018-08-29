# OffersAPI

## Description

This is an API built with Java and Spring that utilises JPA and a H2 database to store and retrieve Offers.

An offer consists of a description, currency and price, and each offer has unique id that is automatically generated.

To run this application using IntelliJ, first run `OffersApiApplication` and then run the tests by running `OffersApiApplicationTests`.

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