package com.savingaccount.ms.model;

import java.math.BigDecimal;

public class Account {

	private String id;
	private String numberAccount;
	private BigDecimal currentBalance;
	private String  createdAt;
	private SavingAccount savingAccount;
	
	public Account() {

	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNumberAccount() {
		return numberAccount;
	}

	public void setNumberAccount(String numberAccount) {
		this.numberAccount = numberAccount;
	}

	public BigDecimal getCurrentBalance() {
		return currentBalance;
	}

	public void setCurrentBalance(BigDecimal currentBalance) {
		this.currentBalance = currentBalance;
	}

	public String getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}

	public SavingAccount getSavingAccount() {
		return savingAccount;
	}

	public void setSavingAccount(SavingAccount savingAccount) {
		this.savingAccount = savingAccount;
	}

	
	
	
}
