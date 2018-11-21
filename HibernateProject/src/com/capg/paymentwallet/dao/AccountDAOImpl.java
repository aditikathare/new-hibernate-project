package com.capg.paymentwallet.dao;

import javax.persistence.EntityManager;

import com.capg.paymentwallet.bean.AccountBean;

public class AccountDAOImpl implements IAccountDao {

	
	EntityManager em;
	
	@Override
	public boolean createAccount(AccountBean accountBean) throws Exception {
		try{
			
			this.em=JPAManager.createEntityManager();
			em.getTransaction().begin();
			
			em.persist(accountBean);
			System.out.println("hi");
			
			
			em.getTransaction().commit();
			JPAManager.closeResources(em);
			
			return true;
		}catch(Exception e){
			
			return false;
		}
	
	}

	@Override
	public boolean updateAccount(AccountBean accountBean) throws Exception {
		try{
			this.em=JPAManager.createEntityManager();
			em.getTransaction().begin();
			
			em.merge(accountBean);
			
			em.getTransaction().commit();
			JPAManager.closeResources(em);
			return true;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
	
	}

	@Override
	public AccountBean findAccount(int accountId) throws Exception {
		try{
			em=JPAManager.createEntityManager();
			AccountBean accountBean2=em.find(AccountBean.class,accountId);
			JPAManager.closeResources(em);
			return accountBean2;
			
		}catch(Exception e){
			return null;
		}
	}

	@Override
	public double deposit(AccountBean accountBean,double depositAmount) throws Exception {
		accountBean.setBalance(accountBean.getBalance() + depositAmount);
		updateAccount(accountBean);
			return accountBean.getBalance();

		
	}

	@Override
	public double withdraw(AccountBean accountBean,double withdrawAmount) throws Exception {
		accountBean.setBalance(accountBean.getBalance() - withdrawAmount);
		updateAccount(accountBean);
		return accountBean.getBalance();
	

	
	}


	@Override
	
	public double fundTransfer(AccountBean transferingAccountBean, AccountBean beneficiaryAccountBean,double transferAmount) throws Exception
	{
		transferingAccountBean.setBalance(transferingAccountBean.getBalance()
				- transferAmount);
		beneficiaryAccountBean.setBalance(beneficiaryAccountBean.getBalance()
				+ transferAmount);

		updateAccount(transferingAccountBean);
		return transferingAccountBean.getBalance();
	}
}

	

	


