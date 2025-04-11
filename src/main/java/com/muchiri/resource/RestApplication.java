package com.muchiri.resource;

import com.muchiri.payment.PaymentProcessor;
import com.muchiri.payment.Synchronous;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.DefaultValue;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.Application;

@ApplicationPath("/api")
@Path("hello")
@ApplicationScoped
public class RestApplication extends Application {
    @Inject
    @Synchronous
    PaymentProcessor paymentProcessor;

    @GET
    public String hello(@QueryParam(value = "name") @DefaultValue("World") String name) {
        var pp = paymentProcessor.processPayment();
        return "Hello %s\n%s\n".formatted(name, pp);
    }
}