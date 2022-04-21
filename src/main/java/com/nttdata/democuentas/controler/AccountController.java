package com.nttdata.democuentas.controler;

import com.nttdata.democuentas.model.Account;
import com.nttdata.democuentas.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@RestController
@RequestMapping("/api/v1")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @GetMapping("/account")
    public ResponseEntity<Flux<Account>> getAccounts(){
        return new ResponseEntity<>(accountService.getAllAccounts(), HttpStatus.OK);
    }

    @GetMapping("/accounts/{typeAccount}")
    public ResponseEntity<Flux<Account>> getByTypeAccount(@PathVariable String typeAccount){
        return new ResponseEntity<>(accountService.findByTypeAccount(typeAccount),HttpStatus.OK);
    }

    @GetMapping("/account/{dni}")
    public ResponseEntity<Mono<Account>> getAccountByDni(@PathVariable int dni){
        return new ResponseEntity<>(accountService.findByDni(dni),HttpStatus.OK);
    }

    @PostMapping("/account")
    public ResponseEntity<Mono<Account>> addAccount(@RequestBody Account account) {
        return new ResponseEntity<>(accountService.addAccount(account), HttpStatus.OK);
    }

    @PutMapping("/account")
    public ResponseEntity<Mono<Account>> updateAccount(@RequestBody Account account){
        return new ResponseEntity<>(accountService.updateAccount(account), HttpStatus.OK);
    }

    @DeleteMapping("/account/{id}")
    public void deleteAccount(@PathVariable Long id){
       accountService.deleteAccount(id);
    }



}
