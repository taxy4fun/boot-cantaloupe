package com.taxy4fun;

import com.taxy4fun.model.Taxy4FunModel;
import com.taxy4fun.services.LoginService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Springuers.
 */
@RestController
public class Taxy4FunController {

    private static final Logger LOGGER = LoggerFactory.getLogger(Taxy4FunController.class);

    @Autowired
    private LoginService loginService;

    @PostMapping("/login")
    public String login(@ModelAttribute Taxy4FunModel model) {
        return loginService.login(model.getUsername(), model.getPassword());
    }

}
