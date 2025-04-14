package com.muchiri.resource;

import com.muchiri.payment.Asynchronous;
import com.muchiri.payment.PayBy;
import com.muchiri.payment.PaymentMethod;
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

    // For the below it will work like the above injected processors.
    // Why? Because of the multiple qualifiers used on the beans(PayBy &
    // Sy/Asynchronous).
    // You can use all, one or any number of qualifiers you want when injecting the
    // bean.
    // The case below I am using also one of the qualifiers used on the beans. Using
    // all would look as below:
    // @Inject
    // @PayBy(PaymentMethod.CHEQUE)
    // @Synchronized
    // PaymentProcessor chequePaymentProcessor;

    @Inject
    @PayBy(PaymentMethod.CHEQUE)
    PaymentProcessor chequePaymentProcessor;

    @Inject
    @PayBy(PaymentMethod.CREDIT_CARD)
    PaymentProcessor cardPaymentProcessor;

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

    @GET
    @Path("cheque")
    public String cheque(@QueryParam(value = "name") @DefaultValue("World") String name) {
        var pp = chequePaymentProcessor.processPayment();
        return "Hello %s\n%s\n".formatted(name, pp);
    }

    @GET
    @Path("card")
    public String card(@QueryParam(value = "name") @DefaultValue("World") String name) {
        var pp = cardPaymentProcessor.processPayment();
        return "Hello %s\n%s\n".formatted(name, pp);
    }

}