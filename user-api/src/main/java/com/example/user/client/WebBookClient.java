package com.example.user.client;

import com.example.user.client.dto.RegisterWebBookChapterRequestClientDto;
import com.example.user.client.dto.RegisterWebBookRequestClientDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "webbook", url = "${external-api.webbook.url}")
public interface WebBookClient {
    @PostMapping("/writer/webBook")
    Long registerWebBook(@RequestBody RegisterWebBookRequestClientDto request);

    @PostMapping("/writer/webBook/{webBookId}")
    Long registerWebBookClient(
            @PathVariable(name = "webBookId") Long webBookId,
            @RequestBody RegisterWebBookChapterRequestClientDto request);
}

