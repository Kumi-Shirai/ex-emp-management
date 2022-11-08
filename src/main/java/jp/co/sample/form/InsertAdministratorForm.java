package jp.co.sample.form;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class InsertAdministratorForm {
	
	@NotBlank(message="氏名を入力してください")
	private String name;
	@NotBlank(message="メールアドレスを入力してください")
	@Email(message="メールアドレスの形式で入力してください")
	private String mailAddress;
	@NotBlank(message="パスワードを入力してください")
	private String password;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMailAddress() {
		return mailAddress;
	}
	public void setMailAddress(String mailAddress) {
		this.mailAddress = mailAddress;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "AdministratorForm [name=" + name + ", mailAddress=" + mailAddress + ", password=" + password + "]";
	}
	
	

}
