package com.savingaccount.ms.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.savingaccount.ms.model.SavingAccount;

public interface SavingAccountRepository extends ReactiveMongoRepository<SavingAccount, String>{

}
