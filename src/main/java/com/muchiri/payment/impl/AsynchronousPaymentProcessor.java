package com.muchiri.payment.impl;

import com.muchiri.payment.Asynchronous;
import com.muchiri.payment.PayBy;
import com.muchiri.payment.PaymentMethod;
import com.muchiri.payment.PaymentProcessor;

@Asynchronous
@PayBy(PaymentMethod.CREDIT_CARD)
public class AsynchronousPaymentProcessor implements PaymentProcessor {

    @Override
    public String processPayment() {
        return "Processing payment from Asynchronous processor!\nPayment method is Credit Card";
    }

}
