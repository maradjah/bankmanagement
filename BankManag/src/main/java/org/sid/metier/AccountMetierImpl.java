package org.sid.metier;

import java.util.List;
import java.util.Set;

import org.sid.dao.IAccountDAO;
import org.sid.entities.Account;
import org.sid.entities.Customer;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class AccountMetierImpl implements IAccountMetier {

	private IAccountDAO dao;

	public IAccountDAO getDao() {
		return dao;
	}

	public void setDao(IAccountDAO dao) {
		this.dao = dao;
	}

	@Override
	public void createAccount(Account account) {
		dao.createAccount(account);

	}

	@Override
	public void removeAccount(Account account) {
		dao.removeAccount(account);

	}

	@Override
	public List<Account> getAllAccounts() {
		return dao.getAllAccounts();
	}

	@Override
	public Account getAccountById(Long accountId) {
		return dao.getAccountById(accountId);
	}

	@Override
	public void updateAccount(Account account) {
		dao.updateAccount(account);

	}

	@Override
	public List<Account> getAccountsOfCustomer(Customer customer) {
		// TODO Auto-generated method stub
		return dao.getAccountsOfCustomer(customer);
	}

}
