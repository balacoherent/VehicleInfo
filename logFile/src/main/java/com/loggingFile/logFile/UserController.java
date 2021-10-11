package com.loggingFile.logFile;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

   private static final Logger logger= LoggerFactory.getLogger(UserController.class);

    @GetMapping("/user")
    public String getMessage(){
        logger.info("this is info msg");
        logger.error("this is error msg");
        logger.debug("this is debug msg");
      //  logger.trace("this is trace msg");

        return "This is logging...";
    }
}
