package cn.tedu.store.entity;

import java.util.Date;

/**
 * 订单数据实体类
 * @author soft01
 *
 */
public class Order extends BaseEntity{

	 /**
	 * 
	 */
	private static final long serialVersionUID = -5199978099098896799L;
	private Integer oid ;// '订单id',
	private Integer  uid;// '归属用户',
	private String recvName ;// '收货人姓名',
	private String recvPhone;// '收货人电话',
	private String  recvAddress ;// '收货人详情地址',
	private Long totalPrice ;// '总价',
	private Integer status ;//'状态:0-未支付,1-已支付,2-已取消',
	private Date orderTime ;// '下单时间',
	private Date payTime ;
	public Integer getOid() {
		return oid;
	}
	public void setOid(Integer oid) {
		this.oid = oid;
	}
	public Integer getUid() {
		return uid;
	}
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	public String getRecvName() {
		return recvName;
	}
	public void setRecvName(String recvName) {
		this.recvName = recvName;
	}
	public String getRecvPhone() {
		return recvPhone;
	}
	public void setRecvPhone(String recvPhone) {
		this.recvPhone = recvPhone;
	}
	public String getRecvAddress() {
		return recvAddress;
	}
	public void setRecvAddress(String recvAddress) {
		this.recvAddress = recvAddress;
	}
	public Long getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(Long totalPrice) {
		this.totalPrice = totalPrice;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Date getOrderTime() {
		return orderTime;
	}
	public void setOrderTime(Date orderTime) {
		this.orderTime = orderTime;
	}
	public Date getPayTime() {
		return payTime;
	}
	public void setPayTime(Date payTime) {
		this.payTime = payTime;
	}
	@Override
	public String toString() {
		return "Order [oid=" + oid + ", uid=" + uid + ", recvName=" + recvName + ", recvPhone=" + recvPhone
				+ ", recvAddress=" + recvAddress + ", totalPrice=" + totalPrice + ", status=" + status + ", orderTime="
				+ orderTime + ", payTime=" + payTime + "]";
	}
	 
	 
}
