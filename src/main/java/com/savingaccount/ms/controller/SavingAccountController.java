package com.savingaccount.ms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.savingaccount.ms.model.Account;
import com.savingaccount.ms.model.SavingAccount;
import com.savingaccount.ms.service.SavingAccountService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
@RestController
public class SavingAccountController {
	
	@Autowired
	private SavingAccountService service;
	
	@GetMapping("/savingaccount/{savingaccount}")
	public Flux<SavingAccount> findByAccount(@PathVariable("savingaccount") String id){
		return service.findByAccountId(id);
	}
	
	/*@PostMapping("/insert")
	public Mono<SavingAccount> insertBankSavingAccount (@RequestBody SavingAccount account){
		return service.saveSavingAccount(account);
	}*/
	
	@PostMapping("/savingaccount/insert")
	public Mono<SavingAccount> insertSavingAccount(@RequestBody SavingAccount savingAccount){
		Account account = new Account();
		account.setNumberAccount(savingAccount.getNumber());
		account.setCurrentBalance(savingAccount.getBalance());
		return service.saveSavingAccount(savingAccount);	
	}
	
	/*@PostMapping("/insert")
	public Mono<SavingAccount> insertBankSavingAccount (@RequestBody SavingAccount savingAccount){
		Account account = new Account() ;
		account.setNumberAccount(savingAccount.getAccountNumber());
		insertBankAccount(account).subscribe();
		return service.saveAccount(savingAccount);
	}*/
	


}
