package com.example.user.client;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "payment", url = "${external-api.payment.url}")
public interface PaymentClient {
}
