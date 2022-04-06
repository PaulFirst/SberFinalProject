package org.pavelmaslov.Service;

import org.pavelmaslov.Entity.Account;
import org.pavelmaslov.Repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AccountService {

    @Autowired
    AccountRepository accountRepository;

    public List<Account> getAllAccountsByUserLogin(String login) {
        List<Account> accounts = new ArrayList<>();
        accountRepository.findAll().forEach(account -> {
            if (account.getUserLogin().equals(login)) {
                accounts.add(account);
            }
        });
        return accounts;
    }
}
