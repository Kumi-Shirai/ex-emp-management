package jp.co.sample.form;

import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class UpdateEmployeeForm {
	
	private String id;
	@NotBlank(message="名前を入力してください")
	private String name;
	private Date hireDate;
	@NotBlank(message="メールアドレスを入力してください")
	private String mailAddress;
	@NotBlank(message="郵便番号を入力してください")
	private String zipCode;
	@NotBlank(message="住所を入力してください")
	private String address;
	@NotBlank(message="電話番号を入力してください")
	private String telephone;
	@NotNull(message="給料を入力してください")
	private Integer salary;
	@NotBlank(message="特徴を入力してください")
	private String characteristics;
	@NotBlank(message="扶養人数を入力してください")
	private String dependentsCount;
	
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getHireDate() {
		return hireDate;
	}
	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
	}
	public String getMailAddress() {
		return mailAddress;
	}
	public void setMailAddress(String mailAddress) {
		this.mailAddress = mailAddress;
	}
	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public Integer getSalary() {
		return salary;
	}
	public void setSalary(Integer salary) {
		this.salary = salary;
	}
	public String getCharacteristics() {
		return characteristics;
	}
	public void setCharacteristics(String characteristics) {
		this.characteristics = characteristics;
	}
	public String getDependentsCount() {
		return dependentsCount;
	}
	public void setDependentsCount(String dependentsCount) {
		this.dependentsCount = dependentsCount;
	}
	@Override
	public String toString() {
		return "UpdateEmployeeForm [id=" + id + ", name=" + name + ", hireDate=" + hireDate + ", mailAddress="
				+ mailAddress + ", zipCode=" + zipCode + ", address=" + address + ", telephone=" + telephone
				+ ", salary=" + salary + ", characteristics=" + characteristics + ", dependentsCount=" + dependentsCount
				+ "]";
	}
	
	

}
