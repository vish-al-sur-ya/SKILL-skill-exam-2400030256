package com.klef.soa.service;

import java.util.List;

import com.klef.soa.entity.BankAccount;

public interface BankAccountService 
{
	BankAccount addBankAccount(BankAccount b);

	BankAccount updateBankAccount(BankAccount b);

	List<BankAccount> displayAllBankAccounts();

	BankAccount displayBankAccountById(Long id);

	String deleteBankAccountById(Long id);

	List<BankAccount> displayBankAccountsByBranch(String branch);

	List<BankAccount> displayBankAccountsByAccountType(String accountType);

	Long bankAccountCount();

}