package entities;

import java.util.Date;



public class Acc {
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public Boolean getGender() {
		return gender;
	}

	public void setGender(Boolean gender) {
		this.gender = gender;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	private int id;
	private String password;
	private String fullName;
	private Boolean gender;
	private Date birthday;
	private String address;
	private String email;
	private String phone;
	
	
	public Acc() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Acc(int id, String password, String fullName, Boolean gender, Date birthday, String address, String email,
			String phone) {
		super();
		this.id = id;
		this.password = password;
		this.fullName = fullName;
		this.gender = gender;
		this.birthday = birthday;
		this.address = address;
		this.email = email;
		this.phone = phone;
	}

	
	
	
}
