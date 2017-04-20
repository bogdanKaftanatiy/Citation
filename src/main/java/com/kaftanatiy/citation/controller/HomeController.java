package com.kaftanatiy.citation.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Base controller that handle request to the main page
 */
@Controller
@RequestMapping("/")
public class HomeController {
    private final static Logger logger = Logger.getLogger(HomeController.class);

    @RequestMapping(method = RequestMethod.GET)
    public String home() {
        logger.debug("Get request for main page");
        return "home";
    }
}
