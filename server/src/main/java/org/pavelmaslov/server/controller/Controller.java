package org.pavelmaslov.server.controller;

import org.pavelmaslov.server.Service.UserService;
import org.pavelmaslov.server.dto.AccountDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class Controller {

    @Autowired
    UserService userService;

    @GetMapping("/atm")
    public String getAccount(Authentication auth) {
        return auth.getName();
    }

    @GetMapping("/user/accounts/")
    public String getAccountsForUser(Authentication auth) {
        List<String> userAccounts = new ArrayList<>();
        userService.getUser(auth.getName()).getAccountDTOs().forEach(accountDTO -> {
            userAccounts.add(Integer.toString(accountDTO.getAccountId()));
        });

        if (userAccounts.size() != 0) {
            String result = userAccounts.toString();
            return result;
        } else {
            return "Not found accounts for current user";
        }
    }

    @GetMapping("/user/accounts/balance/")
    public String getUserAccountBalance(@RequestParam int accountId, Authentication auth) {
        List<String> userAccounts = new ArrayList<>();
        List<AccountDTO> result = userService.getUser(auth.getName()).getAccountDTOs().stream().filter(accountDTO -> {
            return accountDTO.getAccountId() == accountId;
        }).collect(Collectors.toList());
        if (result.size() != 1) {
            return "Error when getting account balance";
        }
        return Integer.toString(result.get(0).getAccountBalance());
    }

}
