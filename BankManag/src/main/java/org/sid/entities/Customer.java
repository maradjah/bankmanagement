package org.sid.entities;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Customer implements Serializable {

	private static final long serialVersionUID = -3809679211424599252L;

	private Long customerId;
	private String lastName;
	private String firstName;
	private String street;
	private String city;
	private String zip;
	private String phone;
	private String email;
	private List<Account> accounts;

	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Customer(String lastName, String firstName, String street,
			String city, String zip, String phone, String email) {
		super();
		this.lastName = lastName;
		this.firstName = firstName;
		this.street = street;
		this.city = city;
		this.zip = zip;
		this.phone = phone;
		this.email = email;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "CUSTOMER_ID", unique = true, nullable = false)
	public Long getCustomerId() {
		return customerId;
	}

	@Column(name = "LAST_NAME")
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Column(name = "FIRST_NAME")
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

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "cust_acc", joinColumns = { @JoinColumn(name = "CUSTOMER_ID", nullable = false, updatable = false) }, inverseJoinColumns = @JoinColumn(name = "ACCOUNT_ID", nullable = false, updatable = false))
	public List<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	@Override
	public String toString() {
		return "Customer [lastName=" + lastName + ", firstName=" + firstName
				+ "]";
	}

	/******************************************************************************/
	public void removeAccount(Account account) {

		if (account != null) {
			/* account non null */
			/* no endless loop */
			if (this.getAccounts().contains(account)) {
				/* Account Found, Deleting Cutomer from Account first */
				account.getCustomers().remove(this);
				/* Deleting account from customer */
				this.getAccounts().remove(account);
			}

			// else {
			// /* this Customer is not associated with this Account */
			// }
		}

	}

	public void addAccount(Account account) {
		if (account != null) {
			/* account non null */
			/* no endless loop */
			if (this.getAccounts().contains(account)) {
				/*
				 * account exists already, checking account's customer
				 * existence...
				 */if (!account.getCustomers().contains(this)) {
					/* no existence -> adding... */
					account.getCustomers().add(this);
				}
			} else {
				/* adding account to customer... */
				this.getAccounts().add(account);

			}
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((customerId == null) ? 0 : customerId.hashCode());
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
		Customer other = (Customer) obj;
		if (customerId == null) {
			if (other.customerId != null)
				return false;
		} else if (!customerId.equals(other.customerId))
			return false;
		return true;
	}

}
