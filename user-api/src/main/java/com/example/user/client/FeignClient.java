package com.example.user.client;

@org.springframework.cloud.openfeign.FeignClient(name = "test", url = "http://localhost:8080")
public interface FeignClient {
}
