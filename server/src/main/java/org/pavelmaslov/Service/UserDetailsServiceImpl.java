package org.pavelmaslov.Service;


import org.pavelmaslov.Entity.User;
import org.pavelmaslov.Repository.UserRepository;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    UserRepository userRepository;

    public UserDetailsServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String login) {
        Optional<User> optionalUser = userRepository.findById(login);
        User user = optionalUser.orElseThrow(() ->
                new RuntimeException());

        return org.springframework.security.core.userdetails.User
                .builder()
                .username(user.getLogin())
                .password(user.getPassword())
                .roles()
                .build();
    }

}
