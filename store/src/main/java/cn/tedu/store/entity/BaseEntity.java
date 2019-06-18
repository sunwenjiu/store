package cn.tedu.store.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 实体类的基类
 * @author soft01
 *
 */
 abstract class BaseEntity  implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5951530283194014299L;
	
	private String createdUser;
	private Date createdTime;
	private String modifiedUser;
	private Date modifiedTime;
	
	public BaseEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	public BaseEntity(String createdUser, Date createdTime, String modifiedUser, Date modifiedTime) {
		super();
		this.createdUser = createdUser;
		this.createdTime = createdTime;
		this.modifiedUser = modifiedUser;
		this.modifiedTime = modifiedTime;
	}
	public String getCreatedUser() {
		return createdUser;
	}
	public void setCreatedUser(String createdUser) {
		this.createdUser = createdUser;
	}
	public Date getCreatedTime() {
		return createdTime;
	}
	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}
	public String getModifiedUser() {
		return modifiedUser;
	}
	public void setModifiedUser(String modifiedUser) {
		this.modifiedUser = modifiedUser;
	}
	public Date getModifiedTime() {
		return modifiedTime;
	}
	public void setModifiedTime(Date modifiedTime) {
		this.modifiedTime = modifiedTime;
	}
	
	@Override
	public String toString() {
		return "BaseEntity [createdUser=" + createdUser + ", createdTime=" + createdTime + ", modifiedUser="
				+ modifiedUser + ", modifiedTime=" + modifiedTime + "]";
	}
	

}
