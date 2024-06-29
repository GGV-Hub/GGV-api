package com.ggv.system;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SystemController {

    @GetMapping("/v1/system/health")
    public String health() {
        return "ok";
    }
}
