package org.pavelmaslov.server.Service;

import org.pavelmaslov.server.entity.User;
import org.pavelmaslov.server.repository.UserRepository;

import org.pavelmaslov.server.dto.AccountDTO;
import org.pavelmaslov.server.dto.UserDTO;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class UserService implements UserDetailsService {

    UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String login) {
        Optional<User> optionalUser = userRepository.findByLogin(login);
        User user = optionalUser.orElseThrow(() ->
                new RuntimeException("User with current login not found"));

        return org.springframework.security.core.userdetails.User
                .builder()
                .username(user.getLogin())
                .password(user.getPassword())
                .roles()
                .build();
    }

    public UserDTO getUserByLogin(String login) {
        Optional<User> optionalUser = userRepository.findByLogin(login);
        User rawUser = optionalUser.orElseThrow(() ->
                new RuntimeException("User with current login not found"));

        List<AccountDTO> accounts = new ArrayList<>();
        rawUser.getAccounts().forEach(account -> {
            AccountDTO accountDTO = new AccountDTO(account.getId(), account.getBalance());
            accounts.add(accountDTO);
        });

        return new UserDTO(rawUser.getLogin(), rawUser.getPassword(), accounts);
    }

}
