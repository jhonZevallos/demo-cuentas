package com.nttdata.democuentas.service;


import com.nttdata.democuentas.model.Account;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface AccountService {

    Flux<Account> getAllAccounts();

    Mono<Account> addAccount(Account account);

    Mono<Account> updateAccount(Account account);

    void deleteAccount(Long id);

    Flux<Account> findByTypeAccount(String typeAccount);

    Mono<Account> findByDni(int dni);

}
