package com.klef.soa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.klef.soa.entity.BankAccount;
import com.klef.soa.repository.BankAccountRepository;

@Service
public class BankAccountServiceImpl implements BankAccountService {

	@Autowired
	private BankAccountRepository repo;


	@Override
	public BankAccount addBankAccount(BankAccount b) {
		return repo.save(b);
	}


	@Override
	public BankAccount updateBankAccount(BankAccount b) {

		Optional<BankAccount> optional = repo.findById(b.getBankAccountId());

		if(optional.isPresent()) {

			BankAccount account = optional.get();

			account.setAccountHolderName(b.getAccountHolderName());
			account.setBranch(b.getBranch());
			account.setAccountType(b.getAccountType());
			account.setBalance(b.getBalance());
			account.setIfscCode(b.getIfscCode());

			return repo.save(account);
		}
		else {
			return null;
		}
	}


	@Override
	public List<BankAccount> displayAllBankAccounts() {
		return repo.findAll();
	}


	@Override
	public BankAccount displayBankAccountById(Long id) {
		return repo.findById(id).orElse(null);
	}


	@Override
	public String deleteBankAccountById(Long id) {

		boolean flag = repo.existsById(id);

		if(flag) {
			repo.deleteById(id);
			return "Bank Account Deleted Successfully";
		}
		else {
			return "Bank Account Id Not Found";
		}
	}


	@Override
	public List<BankAccount> displayBankAccountsByBranch(String branch) {
		return repo.findByBranch(branch);
	}


	@Override
	public List<BankAccount> displayBankAccountsByAccountType(String accountType) {
		return repo.findByAccountType(accountType);
	}


	@Override
	public Long bankAccountCount() {
		return repo.count();
	}

}