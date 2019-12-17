package com.savingaccount.ms.service;

import com.savingaccount.ms.model.SavingAccount;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface SavingAccountService {
	
	 public Mono<SavingAccount> saveSavingAccount(SavingAccount savingAccount);
	 
	 public Flux<SavingAccount> findByAccountId(String id);

}
