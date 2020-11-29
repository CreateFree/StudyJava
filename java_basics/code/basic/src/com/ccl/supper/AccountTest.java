/**
 * 
 */
package com.ccl.supper;

/**
 * @author chencl
 *
 */
public class AccountTest {
	public static void main(String[] args) {
		Account account = new Account(110, 2000, 0.3);
		
		System.out.println("当前余额为: "+ account.getBalance());
		System.out.println("***************************");
		account.withdraw(10);
		account.deposit(100);
	}
}
