package com.savingaccount.ms.repository;

import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.savingaccount.ms.model.SavingAccount;

import reactor.core.publisher.Mono;

public interface SavingAccountRepository extends ReactiveMongoRepository<SavingAccount, String>{

    @Query(value="{'clients.dni': ?0}", fields="{'clients.dni':1}")	
	Mono<SavingAccount> findByClientDni(String dni); 
    
    @Query(value="{'number': ?0}", fields="{'number':1}")	
	Mono<SavingAccount> findByNumberAccount(String number);

}
