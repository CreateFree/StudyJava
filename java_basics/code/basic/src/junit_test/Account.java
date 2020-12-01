/**  
* @文件名 Account.java
* @版权 Copyright 2009-2020 
* @描述 Account.java
* @修改人 chencl
* @修改时间 2020年12月1日 下午2:28:54
* @修改内容 新增
*/
package junit_test;

/**
 * 编写一个类实现银行账户的概念，包含的属性有“帐号”、“密
码”、“存款余额”、“利率”、“最小余额”，定义封装这些
属性的方法。账号要自动生成。
 * @aothor chencl
 * @date 2020年12月1日下午2:28:54
 */
public class Account {
	
	// 账号
	private int id;
	// 密码
	private String password = "000000";
	// 余额
	private double balance;
	// 年利率
	private static double annuallnteresRate;
	// 最小余额
	private static double minBalance = 1.0;
	
	private static int init = 1001;
	

	public Account() {
		// 自动生成账号
		id = init++;
	}
	
	public Account(String password,double balance) {
		id = init++;
		this.password = password;
		this.balance = balance;
	}
	
	
	/**
	 * <p>Title toString</p>
	 * <p>Author chencl</p>
	 * <p>Description </p>
	 * @return
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Account [id=" + id + ", password=" + password + ", balance=" + balance + "]";
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * @return the balance
	 */
	public double getBalance() {
		return balance;
	}
	/**
	 * @param balance the balance to set
	 */
	public void setBalance(double balance) {
		this.balance = balance;
	}
	/**
	 * @return the annuallnteresRate
	 */
	public double getAnnuallnteresRate() {
		return annuallnteresRate;
	}
	/**
	 * @return the minBalance
	 */
	public double getMinBalance() {
		return minBalance;
	}

	
	
	
	
}
