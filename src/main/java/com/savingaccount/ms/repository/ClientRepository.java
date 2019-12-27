package com.savingaccount.ms.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.savingaccount.ms.model.Client;

public interface ClientRepository extends ReactiveMongoRepository<Client, String> {

}
