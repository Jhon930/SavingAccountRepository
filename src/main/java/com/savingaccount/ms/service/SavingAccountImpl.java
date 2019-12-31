package com.savingaccount.ms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import static org.springframework.http.MediaType.*;

import java.math.BigDecimal;
import java.net.URI;

import com.savingaccount.ms.model.PersonClient;
import com.savingaccount.ms.model.SavingAccount;
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
		return repository.save(savingAccount);
		
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

	/*@Override
	public Mono<SavingAccount> insertDeposit(SavingAccount savingaccount) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Mono<SavingAccount> insertWithdraw(SavingAccount savingaccount) {
		// TODO Auto-generated method stub
		return null;
	}*/

	/*@Override
	public Mono<SavingAccount> insertDeposit(SavingAccount savingaccount) {
		// TODO Auto-generated method stub

	    BigDecimal balance = savingaccount.getBalance();
	    BigDecimal amount = savingaccount.getAmount();
	    
	    BigDecimal currentBalance = balance.add(amount);
	    
		return repository.findByNumberAccount(savingaccount.getNumber()).flatMap(a-> {
			 a.setBalance(currentBalance);
			 return repository.save(a);
		});
	}

	@Override
	public Mono<SavingAccount> insertWithdraw(SavingAccount savingaccount) {
		// TODO Auto-generated method stub
		BigDecimal balance = savingaccount.getBalance();
	    BigDecimal amount = savingaccount.getAmount();
	    
	    BigDecimal currentBalance = balance.subtract(amount);
	    
	    //validar si saldo es menor al monto para que devuelva mensaje 'no hay saldo'
	    
		return repository.findByNumberAccount(savingaccount.getNumber()).flatMap(a-> {
			 a.setBalance(currentBalance);
			 return repository.save(a);
		});
	}
	*/
}
