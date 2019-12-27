package com.savingaccount.ms.model;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="savingaccounts")
public class SavingAccount {
	
	@Id
	private String id;
	private String number;
	private BigDecimal balance;
	private String status;
	private BigDecimal amount;
	
	private List<Client> clients;
	
	
	public SavingAccount() {
		
	}
	
	public SavingAccount(String id, String number, BigDecimal balance, String status) {
		this.id = id;
		this.number = number;
		this.balance = balance;
		this.status = status;
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public BigDecimal getBalance() {
		return balance;
	}

	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<Client> getClients() {
		return clients;
	}

	public void setClients(List<Client> clients) {
		this.clients = clients;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	
	
	
	
}
