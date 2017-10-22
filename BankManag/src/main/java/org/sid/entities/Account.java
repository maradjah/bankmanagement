package org.sid.entities;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

@Entity
public class Account implements Serializable {

	private static final long serialVersionUID = -7190897014357672054L;

	private Long accountId;
	private String description;
	private double balance;
	private Date creationDate;
	
	private List<Customer> customers ;
	private Collection<Tx> transactions;

	public Account() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Account(String description, double balance, Date creationDate) {
		super();
		this.description = description;
		this.balance = balance;
		this.creationDate = creationDate;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "ACCOUNT_ID", unique = true, nullable = false)
	public Long getAccountId() {
		return accountId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	
	@ManyToMany(mappedBy = "accounts", fetch = FetchType.EAGER)
	@Transient
	public List<Customer> getCustomers() {
		return customers;
	}

	public void setCustomers(List<Customer> customers) {
		this.customers = customers;
	}

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "account")
	@Transient
	public Collection<Tx> getTransactions() {
		return transactions;
	}

	public void setTransactions(Collection<Tx> transactions) {
		this.transactions = transactions;
	}

	public void setAccountId(Long accountId) {
		this.accountId = accountId;
	}

	/*******************************************************************************/
	public void removeCustomer(Customer customer) {

		if (customer != null) {
			/* Customer non null */
			/* No endless loop */
			if (this.getCustomers().contains(customer)) {
				/* Customer Found, Deleting Account from Customer first */
				customer.getAccounts().remove(this);
				/* Deleting Customer from Account */
				this.getCustomers().remove(customer);

			}
			// else {
			// /* this Customer is not associated with this Account */
			// }
		}

	}

	public void addCustomer(Customer customer) {
		
		
		this.getCustomers().add(customer);
//		if (customer != null) {
//			/* account non null */
//			/* no endless loop */
//			if (this.getCustomers().contains(customer)) {
//				
//				/*
//				 * account exists already, checking account's customer
//				 * existence...
//				 */if (!customer.getAccounts().contains(this)) {
//					/* no existence -> adding... */
//					customer.getAccounts().add(this);
//				}
//			} else {
//				/* adding account to customer... */
//				this.getCustomers().add(customer);
//				if (!customer.getAccounts().contains(this)) {
//					/* addinG customer to account... */
//					customer.getAccounts().add(this);
//				}
//			}
//		}
		
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((accountId == null) ? 0 : accountId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Account other = (Account) obj;
		if (accountId == null) {
			if (other.accountId != null)
				return false;
		} else if (!accountId.equals(other.accountId))
			return false;
		return true;
	}

		
	

}
