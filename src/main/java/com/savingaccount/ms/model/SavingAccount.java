package com.savingaccount.ms.model;

import java.math.BigDecimal;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="savingaccounts")
public class SavingAccount {
	
	@Id
	private String id;
	private String number;
	private BigDecimal balance;
	private BigDecimal deposit;
	private BigDecimal withdraw;
	private String status;
	
	public SavingAccount() {
		
	}
	
	public SavingAccount(String id, String number, BigDecimal balance, BigDecimal deposit, BigDecimal withdraw, String status) {
		this.id = id;
		this.number = number;
		this.balance = balance;
		this.deposit = deposit;
		this.withdraw = withdraw;
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

	public BigDecimal getDeposit() {
		return deposit;
	}

	public void setDeposit(BigDecimal deposit) {
		this.deposit = deposit;
	}

	public BigDecimal getWithdraw() {
		return withdraw;
	}

	public void setWithdraw(BigDecimal withdraw) {
		this.withdraw = withdraw;
	}
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
