package cn.tedu.store.entity;

import java.util.Date;

/**
 * 收货地址数据的实体类
 * @author soft01
 *
 */
public class Address extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7971492678962498679L;

private Integer	aid ;//'收货地址',
private Integer	uid ;// '归属用户的id',
private String	name ;// '收货人',
private String		province ;// '省',
private String	city ;// '市',
private String	area ;//'区',
private String		district ;// '省市区的汉子名称',
private String		zip ;// '邮编',
private String		address ;// '详细地址',
private String		tel ;// '固话',
private String	phone;// '手机',
private String	tag ;// '地址类型',
private Integer isDefault ;// '是否默认:0-非默认,1-默认',
public Address() {
	super();
	// TODO Auto-generated constructor stub
}
public Address(String createdUser, Date createdTime, String modifiedUser, Date modifiedTime) {
	super(createdUser, createdTime, modifiedUser, modifiedTime);
	// TODO Auto-generated constructor stub
}
public Address(Integer aid, Integer uid, String name, String province, String city, String area, String district,
		String zip, String address, String tel, String phone, String tag, Integer isDefault) {
	super();
	this.aid = aid;
	this.uid = uid;
	this.name = name;
	this.province = province;
	this.city = city;
	this.area = area;
	this.district = district;
	this.zip = zip;
	this.address = address;
	this.tel = tel;
	this.phone = phone;
	this.tag = tag;
	this.isDefault = isDefault;
}
public Integer getAid() {
	return aid;
}
public void setAid(Integer aid) {
	this.aid = aid;
}
public Integer getUid() {
	return uid;
}
public void setUid(Integer uid) {
	this.uid = uid;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getProvince() {
	return province;
}
public void setProvince(String province) {
	this.province = province;
}
public String getCity() {
	return city;
}
public void setCity(String city) {
	this.city = city;
}
public String getArea() {
	return area;
}
public void setArea(String area) {
	this.area = area;
}
public String getDistrict() {
	return district;
}
public void setDistrict(String district) {
	this.district = district;
}
public String getZip() {
	return zip;
}
public void setZip(String zip) {
	this.zip = zip;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public String getTel() {
	return tel;
}
public void setTel(String tel) {
	this.tel = tel;
}
public String getPhone() {
	return phone;
}
public void setPhone(String phone) {
	this.phone = phone;
}
public String getTag() {
	return tag;
}
public void setTag(String tag) {
	this.tag = tag;
}
public Integer getIsDefault() {
	return isDefault;
}
public void setIsDefault(Integer isDefault) {
	this.isDefault = isDefault;
}
public static long getSerialversionuid() {
	return serialVersionUID;
}
@Override
public String toString() {
	return "Address [aid=" + aid + ", uid=" + uid + ", name=" + name + ", province=" + province + ", city=" + city
			+ ", area=" + area + ", district=" + district + ", zip=" + zip + ", address=" + address + ", tel=" + tel
			+ ", phone=" + phone + ", tag=" + tag + ", isDefault=" + isDefault + "]";
}


	
}
