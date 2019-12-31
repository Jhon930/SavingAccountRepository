package com.savingaccount.ms.repository;

import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import com.savingaccount.ms.model.SavingAccount;

import reactor.core.publisher.Mono;

@Repository
public interface SavingAccountRepository extends ReactiveMongoRepository<SavingAccount, String>{

    @Query(value="{'personClients.dni': ?0}", fields="{'personClients.dni':1}")	
	Mono<SavingAccount> findByClientDni(String dni); 
    
	//Mono<SavingAccount> findByNumberAccount(String number);

}
