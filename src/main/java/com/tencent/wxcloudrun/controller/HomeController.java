package com.tencent.wxcloudrun.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tencent.wxcloudrun.config.ApiResponse;

@RestController
public class HomeController {
    final Logger logger = LoggerFactory.getLogger(CounterController.class);

    @GetMapping(value = "/api/home")
    ApiResponse get() {
      logger.info("/api/count get request");
      
      return ApiResponse.ok("home");
    }
}
