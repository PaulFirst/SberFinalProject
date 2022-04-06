package org.pavelmaslov.Controller;

import org.pavelmaslov.Service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @Autowired
    AccountService accountService;

    @GetMapping("/atm")
    public int getAccounts() {
        return 0;
    }
}
