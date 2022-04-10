package org.pavelmaslov.server.repository;

import org.pavelmaslov.server.entity.Account;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountRepository extends CrudRepository<Account, Integer> {

    List<Account> findByUser(String user);
}
