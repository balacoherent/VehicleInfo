package com.springboot.sleuth_server.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/hello")
public class HelloResource {

    private static final Logger logger = LoggerFactory.getLogger(HelloResource.class);

    @GetMapping(value = "/server")
    public String hello(){
        logger.info("Reached Server");
        return "helloWorld";
    }
}
