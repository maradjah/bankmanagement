package accountTest;

import org.junit.Before;
import org.junit.Test;
import org.sid.metier.IAccountMetier;
import org.sid.metier.ICustomerMetier;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AccountTest {
	private IAccountMetier accountMetier;
	private ICustomerMetier customerMetier;

	@Before
	public void setUp() throws Exception {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				new String[] { "applicationContext.xml" });
		accountMetier = (IAccountMetier) context.getBean("metier");
		customerMetier = (ICustomerMetier) context.getBean("metierc");
	}

	@Test
	public void test1() {

		customerMetier.test();

//		Account acc = new Account("compte 1", 120, new Date());
//		Customer cust = new Customer("amine", "erradja", "lille", "clermont",
//				"6300", "00", "mail");
//		accountMetier.createAccount(acc);
//		customerMetier.createCustomer(cust);
//		
//		customerMetier.addCustomertoAccount(cust, acc);
//		
//		accountMetier.updateAccount(acc);
//		customerMetier.updateCustomer(cust);
//
//		customerMetier.removeCustomerFromAccount(cust, acc);
//
//		customerMetier.updateCustomer(cust);
//		accountMetier.updateAccount(acc);

		// accountMetier.updateAccount(acc);
		// customerMetier.updateCustomer(cust);

		//
		// Customer cust2 = new Customer("marwane", "erradja", "lille",
		// "clermont", "6300", "00", "mail");
		// customerMetier.createCustomer(cust2);
		// cust2.getAccounts().add(acc);
		// acc.getCustomers().add(cust2);
		// customerMetier.updateCustomer(cust2);
		// accountMetier.updateAccount(acc);
		//
		// cust.getAccounts().remove(acc);
		// acc.getCustomers().remove(cust);
		// customerMetier.updateCustomer(cust);
		// accountMetier.updateAccount(acc);
		//

	}

	// @Test
	// public void test2() {
	//
	// }

	// @Test
	// public void test3() {
	// Account account = new Account("Epargne", 400, new Date());
	// accountMetier.createAccount(account);
	// Customer cust1 = new Customer("Erradja", "Marwane", "rue des plats",
	// "clermont", "6300", "06", "marwane@gmail.com");
	// cust1.addAccount(account);
	// customerMetier.createCustomer(cust1);
	// Customer cust2 = new Customer("Erradja", "Amine", "rue 22", "Lille",
	// "5700", "06", "amine@gmail.com");
	//
	// cust2.addAccount(account);
	// customerMetier.createCustomer(cust2);
	//
	// Account account2 = new Account("Assurance", 6000, new Date());
	// accountMetier.createAccount(account2);
	// cust2.addAccount(account2);
	// customerMetier.updateCustomer(cust2);
	//
	// }

	// @Test
	// public void test5() {
	// /* create 1 account */
	// Account account = new Account("Epargne", 400, new Date());
	// accountMetier.createAccount(account);
	//
	// /* create 2 customers */
	// Customer cust = new Customer("Hamid", "hamada", "rue", "mdina", "2020",
	// "06", "mail");
	// // Customer cust2 = new Customer("jmaila", "bounka", "rue", "salé",
	// // "454",
	// // "06", "mail");
	// customerMetier.createCustomer(cust);
	// // customerMetier.createCustomer(cust2);
	//
	// /* add the 2 customers to the 1 account */
	// accountMetier.addCustomertoAccount(cust, account);
	// // accountMetier.addCustomertoAccount(cust2, account);
	// System.out.println(cust.getAccounts());
	// System.out.println(account.getCustomers());
	//
	// accountMetier.removeCustomerFromAccount(cust, account);
	// // cust.removeAccount(account);
	// // account.removeCustomer(cust);
	// // customerMetier.updateCustomer(cust);
	// // accountMetier.updateAccount(account);
	//
	// System.out.println(cust.getAccounts());
	// System.out.println(account.getCustomers());
	//
	// customerMetier.deleteCustomer(cust);
	// // accountMetier.removeAccount(account);
	//
	// /* remove customer 1 from account */
	// // accountMetier.removeCustomerFromAccount(cust, account);
	// // customerMetier.deleteCustomer(cust);
	// }
	//
	// @Test
	// public void test6() {
	//
	// }

	// @Test
	// public void test4() {
	//
	// Customer cust2 = new Customer("Erradja", "Amine", "rue 22", "Lille",
	// "5700", "06", "amine@gmail.com");
	// Account account = accountMetier.getAccountById(1L);
	// cust2.addAccount(account);
	// customerMetier.createCustomer(cust2);
	//
	// }

	/* test getAccountById */
	// @Test
	// public void test4() {
	// double balance = 400L;
	// Account account = accountMetier.getAccountById(1L);
	// System.out.println(account.getBalance());
	// assertTrue((account != null));
	// assertTrue(balance == account.getBalance());
	//
	// }

}
