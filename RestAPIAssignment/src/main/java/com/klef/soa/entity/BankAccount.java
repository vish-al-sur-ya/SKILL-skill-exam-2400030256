package com.klef.soa.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "bankaccount_table")
public class BankAccount
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "bankaccountid")
	private Long bankAccountId;

	@Column(name = "accountholdername", length = 100, nullable = false)
	private String accountHolderName;

	@Column(name = "branch", length = 100, nullable = false)
	private String branch;

	@Column(name = "accounttype", length = 30, nullable = false)
	private String accountType;

	@Column(name = "balance", nullable = false)
	private double balance;

	@Column(name = "ifsccode", length = 20, nullable = false, unique = true)
	private String ifscCode;

	@CreationTimestamp
	@Column(name = "createdat", updatable = false)
	private LocalDateTime createdAt;

	@UpdateTimestamp
	@Column(name = "updatedat")
	private LocalDateTime updatedAt;

	public Long getBankAccountId() {
		return bankAccountId;
	}

	public void setBankAccountId(Long bankAccountId) {
		this.bankAccountId = bankAccountId;
	}

	public String getAccountHolderName() {
		return accountHolderName;
	}

	public void setAccountHolderName(String accountHolderName) {
		this.accountHolderName = accountHolderName;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public String getIfscCode() {
		return ifscCode;
	}

	public void setIfscCode(String ifscCode) {
		this.ifscCode = ifscCode;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}

	@Override
	public String toString() {
		return "BankAccount [bankAccountId=" + bankAccountId + ", accountHolderName=" + accountHolderName
				+ ", branch=" + branch + ", accountType=" + accountType + ", balance=" + balance
				+ ", ifscCode=" + ifscCode + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + "]";
	}
}