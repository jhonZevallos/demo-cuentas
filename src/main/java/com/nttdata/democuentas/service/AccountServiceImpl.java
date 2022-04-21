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
    private ReactiveMongoTemplate mongoTemplate;

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
        Query query = new Query(Criteria.where("typeAccount").is(typeAccount));
        return mongoTemplate.find(query,Account.class);
    }

    @Override
    public Mono<Account> findByDni(int dni){
        Query query = new Query(Criteria.where("dni").is(dni));
        return mongoTemplate.findOne(query,Account.class);
    }

}
