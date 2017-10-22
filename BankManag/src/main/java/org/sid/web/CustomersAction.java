package org.sid.web;

import java.util.Date;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.sid.entities.Account;
import org.sid.entities.Customer;
import org.sid.metier.IAccountMetier;
import org.sid.metier.ICustomerMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;
import com.opensymphony.xwork2.ActionSupport;

@Component
public class CustomersAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	@Autowired
	private ICustomerMetier customerMetier;
	@Autowired
	private IAccountMetier accountMetier;

	private static Long selecedCustomerId = 0L;
	private Long customerId;
	private String lastName;
	private String firstName;
	private String street;
	private String city;
	private String zip;
	private String phone;
	private String email;
	private List<Customer> customers;
	private List<Account> accounts;
	private int customersTotalnumber = 0;

	private Long accountId;
	private String description;
	private double balance;
	private List<Customer> data;
	private List<Account> accountData;
	private String message;

	public String index() {

		return SUCCESS;
	}

	public String loadCustomerData() {
		setCustomers(customerMetier.getAllCustomers());
		customersTotalnumber = customers.size();
		return SUCCESS;
	}

	/***** get Customers Accounts when DataTable row selected *****/
	public String execute() {
		setAccounts(null);
		Customer cust = customerMetier.getCustomerById(customerId);
		setSelecedCustomerId(customerId);
		setAccounts(cust.getAccounts());

		return SUCCESS;
	}

	public String addCustomer() {
		try {
			customerMetier.createCustomer(new Customer(getData().get(0)
					.getLastName(), getData().get(0).getFirstName(), getData()
					.get(0).getStreet(), getData().get(0).getCity(), getData()
					.get(0).getZip(), getData().get(0).getPhone(), getData()
					.get(0).getEmail()));
			setMessage("Customer Added Succefully.");

		} catch (Exception e) {
			setMessage("Error Creating Customer.");
			e.printStackTrace();
		}

		return SUCCESS;
	}

	public String editCustomer() {
		Customer customer = customerMetier.getCustomerById(getData().get(0).getCustomerId());
		customer.setFirstName(getData().get(0).getFirstName());
		customer.setLastName(getData().get(0).getLastName());
		customer.setCity(getData().get(0).getCity());
		customer.setStreet(getData().get(0).getStreet());
		customer.setZip(getData().get(0).getZip());
		customer.setPhone(getData().get(0).getPhone());
		customer.setEmail(getData().get(0).getEmail());
		
		try {
			customerMetier.updateCustomer(customer);
			setMessage("Customer Edited Succefully.");

		} catch (Exception e) {
			setMessage("Error Editing Customer.");
			e.printStackTrace();
		}

		return SUCCESS;
	}

	public String deleteCustomer() {
		try {
			customerMetier.deleteCustomerById(customerId);
			setMessage("Customer Deleted Succefully.");
		} catch (Exception e) {
			setMessage("Error Deleting Customer.");
			e.printStackTrace();
		}
		return SUCCESS;
	}

	public String addAccount() {
		try {
			Account acc = new Account(getAccountData().get(0).getDescription(),
					getAccountData().get(0).getBalance(), new Date());

			Customer cust = customerMetier
					.getCustomerById(getSelecedCustomerId());
			accountMetier.createAccount(acc);
			cust.addAccount(acc);

			accountMetier.updateAccount(acc);
			customerMetier.updateCustomer(cust);

			setMessage("Account Added Succefully.");

		} catch (Exception e) {
			setMessage("Error Creating Account.");
			e.printStackTrace();
		}

		return SUCCESS;
	}

	public String getCustomerAccounts() {
		customers = customerMetier.getAllCustomers();
		customersTotalnumber = customers.size();
		return SUCCESS;
	}

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Customer> getCustomers() {
		return customers;
	}

	public void setCustomers(List<Customer> customers) {
		this.customers = customers;
	}

	public int getCustomersTotalnumber() {
		return customersTotalnumber;
	}

	public void setCustomersTotalnumber(int customersTotalnumber) {
		this.customersTotalnumber = customersTotalnumber;
	}

	public List<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}

	public Long getAccountId() {
		return accountId;
	}

	public String getDescription() {
		return description;
	}

	public double getBalance() {
		return balance;
	}

	public void setAccountId(Long accountId) {
		this.accountId = accountId;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public List<Customer> getData() {
		return data;
	}

	public void setData(List<Customer> data) {
		this.data = data;
	}

	public List<Account> getAccountData() {
		return accountData;
	}

	public void setAccountData(List<Account> accountData) {
		this.accountData = accountData;
	}

	public static Long getSelecedCustomerId() {
		return selecedCustomerId;
	}

	public static void setSelecedCustomerId(Long selecedCustomerId) {
		CustomersAction.selecedCustomerId = selecedCustomerId;
	}

}
