package com.muchiri.payment.impl;

import com.muchiri.payment.PaymentProcessor;
import com.muchiri.payment.Synchronous;

@Synchronous
public class SynchronousPaymentProcessor implements PaymentProcessor {

    @Override
    public String processPayment() {
        return "Processing payment from Synchronous processor!";
    }
    
}
