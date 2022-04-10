package org.client.controller;

import org.client.dto.UserDTO;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
public class Controller {

    //TODO:autowired?
    RestTemplate restTemplate = new RestTemplate();

    @PostMapping("/my/accounts/")
    public String getMyAccounts(@RequestBody UserDTO user) {
        HttpHeaders headers = new HttpHeaders();
        headers.setBasicAuth(user.getLogin(), user.getPassword());
        //TODO:when wrong credentials
        HttpEntity<Void> request = new HttpEntity<>(headers);
        String address = "http://localhost:8090/user/accounts/";
        String accounts = restTemplate.exchange(address, HttpMethod.GET, request, String.class).getBody();
        return "Numbers of accounts, acceptable for you: " + accounts;
    }

    @PostMapping("/my/accounts/balance/")
    public String getMyAccountBalance(@RequestBody UserDTO user, @RequestParam int accountId) {
        HttpHeaders headers = new HttpHeaders();
        headers.setBasicAuth(user.getLogin(), user.getPassword());
        HttpEntity<Void> request = new HttpEntity<>(headers);
        String address = "http://localhost:8090/user/accounts/balance/?accountId=" + accountId;
        String balance = restTemplate.exchange(address, HttpMethod.GET, request, String.class).getBody();
        return "Balance for account \"" + accountId + "\": " + balance;
    }
}
