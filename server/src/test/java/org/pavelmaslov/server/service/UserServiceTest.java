package org.pavelmaslov.server.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.pavelmaslov.server.Service.UserService;
import org.pavelmaslov.server.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

@SpringBootTest
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @Test
    public void getUserSuccess() {
        final String login = "bb1";
        UserDTO userDTO = userService.getUserByLogin(login);
        Assertions.assertEquals("$2a$10$yXiqM776jT1h58BkdxMKIuYF4la3KPKrFHBzFK8l7vbFyopdj9CyO",
                userDTO.getPassword());

        List<Integer> balanceList = Arrays.asList(99, 176);

        for (int i = 0; i < balanceList.size(); i++) {
            Assertions.assertEquals(balanceList.get(i), userDTO.getAccountDTOs().get(i).getAccountBalance());
        }
    }
}
