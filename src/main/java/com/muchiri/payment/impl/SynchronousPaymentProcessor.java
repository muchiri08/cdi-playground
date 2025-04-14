package com.muchiri.payment.impl;

import com.muchiri.payment.PayBy;
import com.muchiri.payment.PaymentMethod;
import com.muchiri.payment.PaymentProcessor;
import com.muchiri.payment.Synchronous;

import jakarta.enterprise.inject.Default;

@Synchronous
@Default
@PayBy(PaymentMethod.CHEQUE)
public class SynchronousPaymentProcessor implements PaymentProcessor {

    @Override
    public String processPayment() {
        return "Processing payment from Synchronous processor!\nPayment method is by Cheque.";
    }

}
