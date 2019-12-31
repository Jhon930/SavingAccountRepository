package com.savingaccount.ms.model;

import java.math.BigDecimal;
import java.util.Date;

public class Transaction {

	private String id;
	private Date dateTransaction;
	private BigDecimal amount;
	private Account account;
	private BigDecimal balance;
	private String type;
	
	private SavingAccount savingaccount;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Date getDateTransaction() {
		return dateTransaction;
	}
	public void setDateTransaction(Date dateTransaction) {
		this.dateTransaction = dateTransaction;
	}
	public BigDecimal getAmount() {
		return amount;
	}
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}
	public BigDecimal getBalance() {
		return balance;
	}
	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public SavingAccount getSavingaccount() {
		return savingaccount;
	}
	public void setSavingaccount(SavingAccount savingaccount) {
		this.savingaccount = savingaccount;
	}
	
	
	

}
