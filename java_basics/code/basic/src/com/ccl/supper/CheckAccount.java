/**
 * 
 */
package com.ccl.supper;

/**
 * 
 * @author chencl
 */
public class CheckAccount extends Account {
	private double overdraft; // 可透支的额度
	
	public CheckAccount(int id, double balance, double annuallnteresRate,double overdraft) {
		super(id, balance, annuallnteresRate);
		this.overdraft = overdraft;
	}
	
	
	/**
	 * @return the overdraft
	 */
	public double getOverdraft() {
		return overdraft;
	}


	@Override
	public void withdraw(double amount) {
		if(getBalance()>=amount) { // 还有钱
			super.withdraw(amount);			
		}else if(overdraft>=(amount-getBalance())) { // 钱不够了，但在可以透支的范围内
			overdraft -= (amount -getBalance());
			setBalance(0);
		}else {
			System.out.println("超出可透支范围！");
		}
	}
}
