package com.savingaccount.ms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.savingaccount.ms.model.SavingAccount;
import com.savingaccount.ms.repository.SavingAccountRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class SavingAccountImpl implements SavingAccountService{
	
	@Autowired
	private SavingAccountRepository repository;

	@Override
	public Mono<SavingAccount> saveSavingAccount(SavingAccount savingAccount) {
		// TODO Auto-generated method stub
		return repository.save(savingAccount);
	}

	@Override
	public Flux<SavingAccount> findByAccountId(String id) {
		// TODO Auto-generated method stub
		return null;
	}

}
