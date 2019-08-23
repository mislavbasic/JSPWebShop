package com.mbasic.paypal;

import com.paypal.core.PayPalEnvironment;
import com.paypal.core.PayPalHttpClient;

public class PayPalClient {

    private PayPalEnvironment environment = new PayPalEnvironment.Sandbox(
            "Ad1nzMjMbq3iaKuO2FZJzZlLBxLTjfPA1V6DrqCC1hPHUEtH_4QnjiYo6AvFmAkyarqnaWlVHIjVjHYl",
            "EChMWfu4etNvCEaEGQeFdWsj7RAbevp9WQItlUPHjkfObDXQGuGrKbAPjPZZd1F8zs535kLjQpqyXaRM"
    );

    private PayPalHttpClient client = new PayPalHttpClient(environment);

    public PayPalHttpClient getClient() {
        return client;
    }
}
