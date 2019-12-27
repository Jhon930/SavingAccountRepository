package com.savingaccount.ms.service;

import com.savingaccount.ms.model.SavingAccount;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface SavingAccountService {
	
	 public Flux<SavingAccount> findAll();
	
	 public Mono<SavingAccount> saveSavingAccount(SavingAccount savingAccount);
	 
	 public Mono<SavingAccount> findByAccountId(String id);
	 
	 public Mono<SavingAccount> findByDni(String dni);
	 
	 public Mono<SavingAccount> findByNumberAccount(String number);
	 
	 
	
	
}
