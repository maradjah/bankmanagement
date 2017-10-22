package org.sid.dao;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.sid.entities.Account;
import org.sid.entities.Customer;

public class CustomerDAOImpl implements ICustomerDAO {

	@PersistenceContext
	private EntityManager em;

	@Override
	public void createCustomer(Customer customer) {
		try {
			em.persist(customer);
			// mergeAndCloseEM(em);
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	@Override
	public void updateCustomer(Customer customer) {
		em.merge(customer);
		// mergeAndCloseEM(em);

	}

	@Override
	public List<Customer> getAllCustomers() {
		Query query = em.createQuery("select c from Customer c");
		return query.getResultList();
	}

	@Override
	public void deleteCustomer(Customer customer) {

		for (Account account : customer.getAccounts()) {
			account.getCustomers().remove(customer);
			em.merge(account);
		}
		em.merge(customer);
		em.remove(customer);
		// em.flush();

	}

	@Override
	public void addCustomertoAccount(Customer customer, Account account) {
		customer.addAccount(account);
		account.addCustomer(customer);
		em.persist(account);
		em.persist(customer);
		// mergeAndCloseEM(em);
	}

	@Override
	public void removeCustomerFromAccount(Customer customer, Account account) {
		customer.removeAccount(account);
		account.removeCustomer(customer);
		em.persist(account);
		em.persist(customer);
		// mergeAndCloseEM(em);

	}

	void mergeAndCloseEM(EntityManager em) {
		em.flush();
		em.clear();
		em.close();
	}

	@Override
	public Customer getCustomerById(Long customerId) {
		Query query = em
				.createQuery("select c from Customer c where c.customerId =:x");
		query.setParameter("x", customerId);
		return (Customer) query.getSingleResult();
	}

	@Override
	public void test() {
		Account acc = new Account("compte 1", 111, new Date());
		Account acc2 = new Account("compte 2", 222, new Date());
		Account acc3 = new Account("compte 3", 333, new Date());
		Account acc4 = new Account("compte 4", 444, new Date());

		Customer cust = new Customer("amine", "erradja", "lille", "clermont",
				"6300", "00", "mail");
		Customer cust2 = new Customer("marwane", "erradja", "lille",
				"clermont", "6300", "00", "mail");

		em.persist(acc);
		em.persist(acc2);
		em.persist(acc3);
		em.persist(acc4);
		em.persist(cust);
		em.flush();

		cust.addAccount(acc);
		cust.addAccount(acc2);
		cust2.addAccount(acc3);
		cust2.addAccount(acc4);
		cust2.addAccount(acc2);

		em.persist(acc);
		em.persist(acc2);
		em.persist(acc3);
		em.persist(acc4);
		em.persist(cust);
		em.persist(cust2);
		em.flush();

		List<Customer> listCustomers = getAllCustomers();
		for (Customer customer : listCustomers)
			System.out.println(" nom : " + customer.getLastName()
					+ " SoldeTotal : " + totalSolde(customer.getAccounts()));

		System.out.println(" getCustomerById : "
				+ getCustomerById(1L).getLastName());

		deleteCustomer(cust);
		//deleteCustomer(cust2);
		em.flush();
		removeCustomerFromAccount(cust2, acc2);
		removeCustomerFromAccount(cust2, acc2);
	}

	double totalSolde(List<Account> accounts) {
		double totalSolde = 0.0;
		for (Account account : accounts) {
			totalSolde += account.getBalance();
		}
		return totalSolde;

	}

	@Override
	public void deleteCustomerById(Long customerId) {
		em.remove(getCustomerById(customerId));
		
	}

}
