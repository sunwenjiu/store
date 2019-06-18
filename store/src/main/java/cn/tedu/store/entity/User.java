package cn.tedu.store.entity;

import java.util.Date;

/**
 * 用户数据实体类
 * @author soft01
 *@see BaseEntity
 */
public class User extends BaseEntity{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5724461452813919335L;
	private Integer uid  ;
	private String username ; // '用户名',
	private String	password ; // '密码',
	private String	salt ;// '盐值',
	private String	avatar ; // '头像',
	private String	phone; // '电话',
	private String	email ; // '邮箱',
	private Integer	gender ; // '性别,0女,1男',
	private Integer isDelete ; // '是否删除,0未删除,1已删除',
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public User(String createdUser, Date createdTime, String modifiedUser, Date modifiedTime) {
		super(createdUser, createdTime, modifiedUser, modifiedTime);
		// TODO Auto-generated constructor stub
	}
	
	public User(Integer uid, String username, String password, String salt, String avatar, String phone, String email,
			Integer gender, Integer isDelete) {
		super();
		this.uid = uid;
		this.username = username;
		this.password = password;
		this.salt = salt;
		this.avatar = avatar;
		this.phone = phone;
		this.email = email;
		this.gender = gender;
		this.isDelete = isDelete;
	}
	
	public Integer getUid() {
		return uid;
	}
	public void setUid(Integer uid) {
		this.uid = uid;
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
	public String getSalt() {
		return salt;
	}
	public void setSalt(String salt) {
		this.salt = salt;
	}
	public String getAvatar() {
		return avatar;
	}
	public void setAvatar(String avatar) {
		this.avatar = avatar;
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
	public Integer getGender() {
		return gender;
	}
	public void setGender(Integer gender) {
		this.gender = gender;
	}
	public Integer getIsDelete() {
		return isDelete;
	}
	public void setIsDelete(Integer isDelete) {
		this.isDelete = isDelete;
	}
	
	@Override
	public String toString() {
		return "User [uid=" + uid + ", username=" + username + ", password=" + password + ", salt=" + salt + ", avatar="
				+ avatar + ", phone=" + phone + ", email=" + email + ", gender=" + gender + ", isDelete=" + isDelete
				+ "]";
	}

	
	
}
