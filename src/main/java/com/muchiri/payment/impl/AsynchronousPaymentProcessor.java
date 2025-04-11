package com.muchiri.payment.impl;

import com.muchiri.payment.Asynchronous;
import com.muchiri.payment.PaymentProcessor;

@Asynchronous
public class AsynchronousPaymentProcessor implements PaymentProcessor {

    @Override
    public String processPayment() {
        return "Processing payment from Asynchronous processor!";
    }

}
