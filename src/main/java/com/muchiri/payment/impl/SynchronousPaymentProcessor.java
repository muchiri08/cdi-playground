package com.muchiri.payment.impl;

import com.muchiri.payment.PaymentProcessor;
import com.muchiri.payment.Synchronous;

import jakarta.enterprise.inject.Default;

@Synchronous
// Makes this the default processor whenever PaymentProcessor injection is made
// but no qualifier provided! You can use producer method for this also.
@Default
public class SynchronousPaymentProcessor implements PaymentProcessor {

    @Override
    public String processPayment() {
        return "Processing payment from Synchronous processor!";
    }

}
