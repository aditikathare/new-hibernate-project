package com.capg.paymentwallet.dao;

import com.capg.paymentwallet.bean.AccountBean;

public interface IAccountDao {


    public boolean createAccount(AccountBean accountBean) throws Exception ;
    public boolean updateAccount(AccountBean accountBean) throws Exception;
    public AccountBean findAccount(int accountId) throws Exception;
    public double deposit(AccountBean accountBean, double depositAmount) throws Exception;
	public double withdraw(AccountBean accountBean, double withdrawAmount) throws Exception;
	public double fundTransfer(AccountBean transferingAccountBean,
			AccountBean beneficiaryAccountBean, double transferAmount)
			throws Exception;
  
  
	
	 
    
}
