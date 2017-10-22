package org.sid.metier;

import java.util.List;

import org.sid.entities.Account;
import org.sid.entities.Customer;

public interface ICustomerMetier {
	public void createCustomer(Customer customer);

	public void deleteCustomer(Customer customer);
	
	public void deleteCustomerById(Long customerId);

	public void updateCustomer(Customer customer);

	/* Managing account-customer relationship */
	public void addCustomertoAccount(Customer customer, Account account);

	public void removeCustomerFromAccount(Customer customer, Account account);

	public Customer getCustomerById(Long customerId);

	public List<Customer> getAllCustomers();

	public void test();
}
