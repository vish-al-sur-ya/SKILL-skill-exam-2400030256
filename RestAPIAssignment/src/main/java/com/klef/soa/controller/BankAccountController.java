package com.klef.soa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.klef.soa.entity.BankAccount;
import com.klef.soa.service.BankAccountService;

@RestController
@RequestMapping("/bankaccount")
public class BankAccountController
{
	@Autowired
	private BankAccountService service;

	@GetMapping("/")
	public String demo()
	{
		return "Spring Boot Project";
	}

	@PostMapping("/add")
	public ResponseEntity<BankAccount> addBankAccount(@RequestBody BankAccount b)
	{
		BankAccount bankAccount = service.addBankAccount(b);
		return ResponseEntity.status(201).body(bankAccount);
	}

	@GetMapping("/displayall")
	public ResponseEntity<List<BankAccount>> displayAllBankAccounts()
	{
		List<BankAccount> accounts = service.displayAllBankAccounts();
		return ResponseEntity.status(200).body(accounts);
	}

	@GetMapping("/display")
	public ResponseEntity<?> displayBankAccountById(@RequestParam Long id)
	{
		BankAccount account = service.displayBankAccountById(id);

		if(account != null)
		{
			return ResponseEntity.status(200).body(account);
		}
		else
		{
			return ResponseEntity.status(404).body("Bank Account ID Not Found");
		}
	}

	@PutMapping("/update")
	public ResponseEntity<?> updateBankAccount(@RequestBody BankAccount account)
	{
		BankAccount b = service.updateBankAccount(account);

		if(b != null)
		{
			return ResponseEntity.ok(b);
		}
		else
		{
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Bank Account ID Not Found");
		}
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteBankAccountById(@PathVariable Long id)
	{
		String message = service.deleteBankAccountById(id);
		return new ResponseEntity<>(message, HttpStatus.OK);
	}

	@GetMapping("/displaybybranch/{branch}")
	public ResponseEntity<List<BankAccount>> displayBankAccountsByBranch(@PathVariable String branch)
	{
		List<BankAccount> accounts = service.displayBankAccountsByBranch(branch);
		return ResponseEntity.status(200).body(accounts);
	}

	@GetMapping("/displaybytype/{accountType}")
	public ResponseEntity<List<BankAccount>> displayBankAccountsByAccountType(@PathVariable String accountType)
	{
		List<BankAccount> accounts = service.displayBankAccountsByAccountType(accountType);
		return ResponseEntity.status(200).body(accounts);
	}

	@GetMapping("/count")
	public ResponseEntity<String> bankAccountCount()
	{
		long count = service.bankAccountCount();
		String msg = "Total Bank Accounts = " + count;
		return ResponseEntity.status(200).body(msg);
	}
}