package com.savingaccount.ms.model;

import java.math.BigDecimal;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="savingaccounts")
public class SavingAccount {
	
	@Id
	private String id;
	private BigDecimal amount;
	
	public SavingAccount() {
		
	}
	
	public SavingAccount(String id, BigDecimal amount) {
		this.id = id;
		this.amount = amount;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public BigDecimal getAmount() {
		return amount;
	}
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	

}
