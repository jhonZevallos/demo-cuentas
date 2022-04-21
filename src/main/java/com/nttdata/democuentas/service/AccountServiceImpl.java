package com.nttdata.democuentas.service;

import com.nttdata.democuentas.model.Account;
import com.nttdata.democuentas.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;


@Service
public class AccountServiceImpl implements AccountService{

    @Autowired
    private AccountRepository accountRepository;

    @Override
    public Flux<Account> getAllAccounts() {
        return accountRepository.findAll();
    }

    @Override
    public Mono<Account> addAccount(Account account) {
        account.setCreationAccount(LocalDateTime.now());
        return accountRepository.save(account);
    }

    @Override
    public Mono<Account> updateAccount(Account account){
        account.setModificationAccount(LocalDateTime.now());
        return accountRepository.save(account);
    }

    @Override
    public void deleteAccount(Long id){
        accountRepository.deleteById(id);
    }

    @Override
    public Flux<Account> findByTypeAccount(String typeAccount){
       return accountRepository.findByTypeAccount(typeAccount);
    }

    @Override
    public Mono<Account> findByDni(int dni){
        return accountRepository.findByDni(dni);
    }

}
