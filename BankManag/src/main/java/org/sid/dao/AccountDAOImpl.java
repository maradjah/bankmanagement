package org.sid.dao;

import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.sid.entities.Account;
import org.sid.entities.Customer;

public class AccountDAOImpl implements IAccountDAO {

	@PersistenceContext
	private EntityManager em;

	@Override
	public void createAccount(Account account) {
		try {
			em.persist(account);
			em.flush();
			//mergeAndCloseEM(em);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void removeAccount(Account account) {
		for (Customer customer : account.getCustomers()) {
			if (customer.getAccounts().contains(account)) {
				customer.removeAccount(account);
				em.persist(customer);
			}
		}
		em.remove(account);
		mergeAndCloseEM(em);

	}

	@Override
	public List<Account> getAccountsOfCustomer(Customer customer) {
		return customer.getAccounts();
	}

	@Override
	public List<Account> getAllAccounts() {
		Query query = em.createQuery("select ac from Account ac");
		return query.getResultList();
	}

	@Override
	public Account getAccountById(Long accountId) {
		Query query = em
				.createQuery("select ac from Account ac where ac.accountId =:x");
		query.setParameter("x", accountId);
		return (Account) query.getSingleResult();
	}

	@Override
	public void updateAccount(Account account) {
		em.merge(account);
		mergeAndCloseEM(em);

	}

	void mergeAndCloseEM(EntityManager em) {
		em.flush();
		em.clear();
		em.close();
	}

}
