package org.pavelmaslov.server.repository;

import org.pavelmaslov.server.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User, String> {

    Optional<User> findByLogin(String login);

    boolean existsByLogin(String login);
}
