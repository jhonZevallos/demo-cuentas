package com.nttdata.democuentas.repository;

import com.nttdata.democuentas.model.Account;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface AccountRepository extends ReactiveMongoRepository<Account,Long> {

    Flux<Account> findByTypeAccount(String typeAccount);

    Mono<Account> findByDni(int dni);
}
