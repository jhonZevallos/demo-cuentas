package com.nttdata.democuentas.repository;

import com.nttdata.democuentas.model.Account;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface AccountRepository extends ReactiveMongoRepository<Account,Long> {


}
