package com.muchiri.resource;

import com.muchiri.payment.Asynchronous;
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
@Path("")
@ApplicationScoped
public class RestApplication extends Application {
    @Inject
    @Synchronous
    PaymentProcessor syncProcessor;

    @Inject
    @Asynchronous
    PaymentProcessor asynProcessor;

    @Inject // injects the defult paymentProcessor
    PaymentProcessor paymentProcessor;

    @GET
    @Path("sync")
    public String sync(@QueryParam(value = "name") @DefaultValue("World") String name) {
        var pp = syncProcessor.processPayment();
        return "Hello %s\n%s\n".formatted(name, pp);
    }

    @GET
    @Path("async")
    public String async(@QueryParam(value = "name") @DefaultValue("World") String name) {
        var pp = asynProcessor.processPayment();
        return "Hello %s\n%s\n".formatted(name, pp);
    }

    @GET
    @Path("default")
    public String defolt(@QueryParam(value = "name") @DefaultValue("World") String name) {
        var pp = paymentProcessor.processPayment();
        return "Hello %s\n%s\n".formatted(name, pp);
    }

}