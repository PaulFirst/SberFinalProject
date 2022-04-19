package org.pavelmaslov.server.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.pavelmaslov.server.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;


@SpringBootTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;



    @Test
    public void findByLoginSuccess() {
        final String login = "bb1";
        User user = userRepository.findByLogin(login).orElseThrow(() -> new RuntimeException("User not found"));
        Assertions.assertEquals("$2a$10$yXiqM776jT1h58BkdxMKIuYF4la3KPKrFHBzFK8l7vbFyopdj9CyO",
                user.getPassword());

        List<Integer> balanceList = Arrays.asList(99, 176);
        for (int i = 0; i < balanceList.size(); i++) {
            Assertions.assertEquals(balanceList.get(i), user.getAccounts().get(i).getBalance());
        }
    }
}
