package org.pavelmaslov.server.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@RequiredArgsConstructor
@Entity
@Table(name = "users")
public class User {

    @Id
    private String login;

    @Column(nullable = false)
    private String password;

    @OneToMany(mappedBy = "user")
    private List<Account> accounts;
}
