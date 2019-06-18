package cn.tedu.spring;

public class User {
	
	String username;
	String password;
	Integer age;
	String phone;
	String email;
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(String username, String password, Integer age, String phone, String email) {
		super();
		this.username = username;
		this.password = password;
		this.age = age;
		this.phone = phone;
		this.email = email;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + ", age=" + age + ", phone=" + phone
				+ ", email=" + email + "]";
	}
	

	
	

}
