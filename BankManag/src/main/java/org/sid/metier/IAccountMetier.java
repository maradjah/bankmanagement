package org.sid.metier;

import java.util.List;

import org.sid.entities.Account;
import org.sid.entities.Customer;

public interface IAccountMetier {
	/* Create remove accounts */
	public void createAccount(Account account);
	public void removeAccount(Account account);
	public void updateAccount(Account account);
	
	
	/* Getting account info*/
	public Account getAccountById(Long accountId);
	public List<Account> getAccountsOfCustomer(Customer customer);
	public List<Account> getAllAccounts();

}
