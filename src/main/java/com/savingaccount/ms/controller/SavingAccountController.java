package com.savingaccount.ms.controller;

import java.math.BigDecimal;
import java.net.URI;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.savingaccount.ms.model.Account;
import com.savingaccount.ms.model.Client;
import com.savingaccount.ms.model.SavingAccount;
import com.savingaccount.ms.service.SavingAccountService;
import com.thoughtworks.xstream.converters.javabean.JavaBeanConverter.DuplicateFieldException;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
@RestController
@RequestMapping("/api/savingaccounts")
public class SavingAccountController {
	
	@Autowired
	private SavingAccountService service;
	
	@GetMapping
	public Mono<ResponseEntity<Flux<SavingAccount>>> findAllSavingAccounts(){
		
		return Mono.just(ResponseEntity.ok()
						.contentType(MediaType.APPLICATION_JSON_UTF8)
						.body(service.findAll())
				);
		
	}
	
	@GetMapping("/{id}")
	public Mono<SavingAccount> findById(@PathVariable("id") String id) {
		
		return service.findByAccountId(id);
	}
	
	@PostMapping("/insert")
	public Mono<SavingAccount> insertSavingAccount(@RequestBody SavingAccount savingAccount){
			
		return service.saveSavingAccount(savingAccount);
		
	}
	
	public Mono<SavingAccount> findByDni(@PathVariable String dni){
		
		return service.findByDni(dni);
	}
	
	@PutMapping("/updatebalance1/{id}")
	public Mono<ResponseEntity<SavingAccount>> insertDeposit(@Valid @RequestBody SavingAccount savingAccount){
		
	    BigDecimal balance = savingAccount.getBalance();
	    BigDecimal amount = savingAccount.getAmount();
	    
	    BigDecimal currentBalance = balance.add(amount);
	    
		return service.findByNumberAccount(savingAccount.getNumber()).flatMap(a-> {
			 a.setBalance(currentBalance);
			 return service.saveSavingAccount(a);
		}).map(a-> ResponseEntity.created(URI.create("/api/savingaccounts/".concat(a.getId())))
				.contentType(MediaType.APPLICATION_JSON_UTF8)
				.body(a))
		.defaultIfEmpty(ResponseEntity.notFound().build());
			
	}
	
	@PutMapping("/updatebalance2/{id}")
	public Mono<ResponseEntity<SavingAccount>> insertWithdraw(@Valid @RequestBody SavingAccount savingAccount){
		
	    BigDecimal balance = savingAccount.getBalance();
	    BigDecimal amount = savingAccount.getAmount();
	    
	    BigDecimal currentBalance = balance.subtract(amount);
	    
		return service.findByNumberAccount(savingAccount.getNumber()).flatMap(a-> {
			 a.setBalance(currentBalance);
			 return service.saveSavingAccount(a);
		}).map(a-> ResponseEntity.created(URI.create("/api/savingaccounts/".concat(a.getId())))
				.contentType(MediaType.APPLICATION_JSON_UTF8)
				.body(a))
		.defaultIfEmpty(ResponseEntity.notFound().build());
			
	}

}
