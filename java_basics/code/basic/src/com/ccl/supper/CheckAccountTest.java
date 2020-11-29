/**
 * 
 */
package com.ccl.supper;

/**
 * 创建一个账号为 1122、余额为 20000、年利率 4.5%，可透支限额为 5000 元的 CheckAccount 对象
 * @author chencl
 */
public class CheckAccountTest {
	public static void main(String[] args) {
		CheckAccount checkAccount = new CheckAccount(1112, 20000, 0.045, 5000);
		
		checkAccount.withdraw(5000);
		System.out.println("余额为："+checkAccount.getBalance());
		System.out.println("可透支额度为："+checkAccount.getOverdraft());
		checkAccount.withdraw(18000);
		System.out.println("余额为："+checkAccount.getBalance());
		System.out.println("可透支额度为："+checkAccount.getOverdraft());
		checkAccount.withdraw(3000);
		System.out.println("余额为："+checkAccount.getBalance());
		System.out.println("可透支额度为："+checkAccount.getOverdraft());
	}
}
