package org.pavelmaslov.server.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@Getter
@Setter
public class UserDTO {
    private final String login;
    private final String password;
    private final List<AccountDTO> accountDTOs;
}
