package com.capg.paymentwallet.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.Date;

import org.junit.BeforeClass;
import org.junit.Test;

import com.capg.paymentwallet.bean.AccountBean;
import com.capg.paymentwallet.bean.CustomerBean;
import com.capg.paymentwallet.exception.CustomerException;
import com.capg.paymentwallet.service.AccountServiceImpl;
import com.capg.paymentwallet.service.IAccountService;

public class Test2 {
	private static IAccountService service = null;

	@BeforeClass
	public static void createInstance() {
		service = new AccountServiceImpl();
	}

	@Test
	public void testCreateAccountPositive() throws Exception {
		CustomerBean customer = new CustomerBean();
		customer.setFirstName("aditi");
		customer.setLastName("kathare");
		customer.setPhoneNo("8121198399");
		customer.setEmailId("adi@gmail.com");
		customer.setAddress("hyderabad");
		customer.setPanNum("DVBPK9214B");
		AccountBean bean = new AccountBean();
		bean.setCustomerBean(customer);
		bean.setBalance(5000.00);
		bean.setDateOfOpening(new Date());
		bean.setInitialDeposit(5000.00);
		boolean result = service.createAccount(bean);
		assertTrue(result);

	}

	@Test(expected = CustomerException.class)
	public void testCreateAccountForFirstName() throws Exception {
		CustomerBean bean = new CustomerBean();
		bean.setFirstName("ri");
		bean.setLastName("Thunuguntla");
		bean.setPhoneNo("9059900989");
		bean.setPanNum("ASDF12345S");
		bean.setAddress("vijayawada");
		bean.setEmailId("rohini6rani@gmail.com");
		AccountBean bean1 = new AccountBean();
		bean1.setBalance(5000);
		bean1.setInitialDeposit(500);
		bean1.setCustomerBean(bean);
		bean1.setDateOfOpening(new Date());
		System.out.println(service.createAccount(bean1));
	}

	@Test(expected = CustomerException.class)
	public void testCreateAccountForLastName() throws Exception {
		CustomerBean bean = new CustomerBean();
		bean.setFirstName("rohini");
		bean.setLastName("T");
		bean.setPhoneNo("9059900989");
		bean.setPanNum("ASDF12345S");
		bean.setAddress("vijayawada");
		bean.setEmailId("rohini6rani@gmail.com");
		AccountBean bean1 = new AccountBean();
		bean1.setBalance(5000);
		bean1.setInitialDeposit(500);
		bean1.setCustomerBean(bean);
		bean1.setDateOfOpening(new Date());
		service.createAccount(bean1);
	}

	@Test(expected = CustomerException.class)
	public void testCreateAccountForPhnNoLength() throws Exception {
		CustomerBean bean = new CustomerBean();
		bean.setFirstName("rohini");
		bean.setLastName("Thunuguntla");
		bean.setPhoneNo("905990989");
		bean.setPanNum("ASDF12345S");
		bean.setAddress("vijayawada");
		bean.setEmailId("rohini6rani@gmail.com");
		AccountBean bean1 = new AccountBean();
		bean1.setBalance(5000);
		bean1.setInitialDeposit(500);
		bean1.setCustomerBean(bean);
		bean1.setDateOfOpening(new Date());
		service.createAccount(bean1);
	}

	@Test(expected = CustomerException.class)
	public void testCreateAccountForPhnNoStarting() throws Exception {
		CustomerBean bean = new CustomerBean();
		bean.setFirstName("rohini");
		bean.setLastName("Thunuguntla");
		bean.setPhoneNo("2059900989");
		bean.setPanNum("ASDF12345S");
		bean.setAddress("vijayawada");
		bean.setEmailId("rohini6rani@gmail.com");
		AccountBean bean1 = new AccountBean();
		bean1.setBalance(5000);
		bean1.setInitialDeposit(500);
		bean1.setCustomerBean(bean);
		bean1.setDateOfOpening(new Date());
		service.createAccount(bean1);
	}

	@Test(expected = CustomerException.class)
	public void testCreateAccountForPanNoLength() throws Exception {
		CustomerBean bean = new CustomerBean();
		bean.setFirstName("rohini");
		bean.setLastName("Thunuguntla");
		bean.setPhoneNo("9059900989");
		bean.setPanNum("ASDF1234");
		bean.setAddress("vijayawada");
		bean.setEmailId("rohini6rani@gmail.com");
		AccountBean bean1 = new AccountBean();
		bean1.setBalance(5000);
		bean1.setInitialDeposit(500);
		bean1.setCustomerBean(bean);
		bean1.setDateOfOpening(new Date());
		service.createAccount(bean1);
	}

	@Test(expected = CustomerException.class)
	public void testCreateAccountForAddressLength() throws Exception {
		CustomerBean bean = new CustomerBean();
		bean.setFirstName("rohini");
		bean.setLastName("Thunuguntla");
		bean.setPhoneNo("9059900989");
		bean.setPanNum("ASDF12345S");
		bean.setAddress("v");
		bean.setEmailId("rohini6rani@gmail.com");
		AccountBean bean1 = new AccountBean();
		bean1.setBalance(5000);
		bean1.setInitialDeposit(500);
		bean1.setCustomerBean(bean);
		bean1.setDateOfOpening(new Date());
		service.createAccount(bean1);
	}

	@Test(expected = CustomerException.class)
	public void testCreateAccountForEmail() throws Exception {
		CustomerBean bean = new CustomerBean();
		bean.setFirstName("rohini");
		bean.setLastName("Thunuguntla");
		bean.setPhoneNo("9059900989");
		bean.setPanNum("ASDF12345S");
		bean.setAddress("vijayawada");
		bean.setEmailId("rohini6ranigmail.com");
		AccountBean bean1 = new AccountBean();
		bean1.setBalance(5000);
		bean1.setInitialDeposit(500);
		bean1.setCustomerBean(bean);
		bean1.setDateOfOpening(new Date());
		service.createAccount(bean1);
	}

	@Test(expected = CustomerException.class)
	public void testCreateAccountForEmailcom() throws Exception {
		CustomerBean bean = new CustomerBean();
		bean.setFirstName("rohini");
		bean.setLastName("Thunuguntla");
		bean.setPhoneNo("9059900989");
		bean.setPanNum("ASDF12345S");
		bean.setAddress("vijayawada");
		bean.setEmailId("rohini6rani@gmail");
		AccountBean bean1 = new AccountBean();
		bean1.setBalance(5000);
		bean1.setInitialDeposit(500);
		bean1.setCustomerBean(bean);
		bean1.setDateOfOpening(new Date());
		service.createAccount(bean1);
	}

	@Test(expected = CustomerException.class)
	public void testCreateAccountForinitialDepositNegative() throws Exception {
		CustomerBean bean = new CustomerBean();
		bean.setFirstName("rohini");
		bean.setLastName("Thunuguntla");
		bean.setPhoneNo("9059900989");
		bean.setPanNum("ASDF12345S");
		bean.setAddress("vijayawada");
		bean.setEmailId("rohini6ranigmail.com");
		AccountBean bean1 = new AccountBean();
		bean1.setBalance(5000);
		bean1.setInitialDeposit(-500);
		bean1.setCustomerBean(bean);
		bean1.setDateOfOpening(new Date());
		service.createAccount(bean1);
	}

	@Test
	public void testDeposit() throws Exception {
		AccountBean bean = new AccountBean();
		bean.setBalance(5000);
		double depositAmount = 500;
		service.deposit(bean, depositAmount);

	}

	@Test(expected = CustomerException.class)
	public void testDepositNegative() throws Exception {
		AccountBean bean = new AccountBean();
		bean.setBalance(5000);
		double depositAmount = -100;
		System.out.println(service.deposit(bean, depositAmount));

	}

	@Test
	public void testWithDraw() throws Exception {
		AccountBean bean = new AccountBean();
		bean.setBalance(5000);
		double withdrawAmount = 100;
		service.withdraw(bean, withdrawAmount);

	}

	@Test(expected = CustomerException.class)
	public void testWithDrawNegative() throws Exception {
		AccountBean bean = new AccountBean();
		bean.setBalance(5000);
		double withdrawAmount = -100;
		service.withdraw(bean, withdrawAmount);

	}

	@Test
	public void testFundTransfer() throws Exception {
		AccountBean bean = new AccountBean();
		bean.setBalance(5000);
		AccountBean bean1 = new AccountBean();
		bean1.setBalance(3000);
		double transferAmount = 500;
		service.fundTransfer(bean, bean1, transferAmount);

	}

	@Test(expected = CustomerException.class)
	public void testFundTransferNegative() throws Exception {
		AccountBean bean = new AccountBean();
		bean.setBalance(5000);
		AccountBean bean1 = new AccountBean();
		bean1.setBalance(3000);
		double transferAmount = -500;
		service.fundTransfer(bean, bean1, transferAmount);

	}

	@Test
	public void findAccount() throws Exception {
		int accountid = 1;
		AccountBean bean = service.findAccount(accountid);
		assertNotNull(bean);

	}

	@Test
	public void findAccountNegative() throws Exception {
		int accountid = 111;
		AccountBean bean = service.findAccount(accountid);
		assertNull(bean);

	}

}
