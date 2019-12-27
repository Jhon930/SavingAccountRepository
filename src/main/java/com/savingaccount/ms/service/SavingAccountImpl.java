package com.savingaccount.ms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import static org.springframework.http.MediaType.*;

import com.savingaccount.ms.model.Client;
import com.savingaccount.ms.model.SavingAccount;
import com.savingaccount.ms.repository.ClientRepository;
import com.savingaccount.ms.repository.SavingAccountRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class SavingAccountImpl implements SavingAccountService{
	
	@Autowired
	private SavingAccountRepository repository;
	
	@Autowired
    private WebClient client;

	@Override
	public Mono<SavingAccount> saveSavingAccount(SavingAccount savingAccount) {
		// TODO Auto-generated method stub
		return client.post()
				.uri("/insert")
				.accept(MediaType.APPLICATION_JSON_UTF8)
				.body(BodyInserters.fromObject(savingAccount))
				.retrieve()
				.bodyToMono(SavingAccount.class);
		
	}

	@Override
	public Mono<SavingAccount> findByAccountId(String id) {
		// TODO Auto-generated method stub
		return repository.findById(id);
	}

	@Override
	public Flux<SavingAccount> findAll() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Override
	public Mono<SavingAccount> findByDni(String dni) {
		// TODO Auto-generated method stub
		return repository.findByClientDni(dni);
	}

	@Override
	public Mono<SavingAccount> findByNumberAccount(String number) {
		// TODO Auto-generated method stub
		return repository.findByNumberAccount(number);
	}

}
