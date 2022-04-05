package org.pavelmaslov.Repository;

import org.pavelmaslov.Entity.AccountHolder;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountHolderRepository extends CrudRepository<AccountHolder, String> {
}
