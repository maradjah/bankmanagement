package org.sid.metier;

import java.util.List;
import java.util.Set;

import org.sid.dao.ICustomerDAO;
import org.sid.entities.Account;
import org.sid.entities.Customer;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class CustomerMetierImpl implements ICustomerMetier {

	private ICustomerDAO daoc;

	public ICustomerDAO getDaoc() {
		return daoc;
	}

	public void setDaoc(ICustomerDAO daoc) {
		this.daoc = daoc;
	}

	@Override
	public void createCustomer(Customer customer) {
		daoc.createCustomer(customer);

	}

	@Override
	public void updateCustomer(Customer customer) {
		daoc.updateCustomer(customer);

	}

	@Override
	public List<Customer> getAllCustomers() {
		return daoc.getAllCustomers();
	}

	@Override
	public void deleteCustomer(Customer customer) {
		daoc.deleteCustomer(customer);

	}

	@Override
	public void test() {
		daoc.test();

	}

	@Override
	public void addCustomertoAccount(Customer customer, Account account) {
		daoc.addCustomertoAccount(customer, account);

	}

	@Override
	public void removeCustomerFromAccount(Customer customer, Account account) {
		daoc.removeCustomerFromAccount(customer, account);

	}

	@Override
	public Customer getCustomerById(Long customerId) {
		return daoc.getCustomerById(customerId);
	}

	@Override
	public void deleteCustomerById(Long customerId) {
		daoc.deleteCustomerById(customerId);
		
	}

}
