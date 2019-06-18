package cn.tedu.pojo;

public class UserInfo {
	private String userInfoId;
	private Integer age;
	private String address;
	private String sex;
	
	public String getUserInfoId() {
		return userInfoId;
	}
	public void setUserInfoId(String userInfoId) {
		this.userInfoId = userInfoId;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	@Override
	public String toString() {
		return "UserInfo [userInfoId=" + userInfoId + ", age=" + age + ", address=" + address + ", sex=" + sex + "]";
	}
	
	
}
