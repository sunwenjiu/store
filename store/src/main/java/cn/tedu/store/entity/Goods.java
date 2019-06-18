package cn.tedu.store.entity;

import java.util.Date;

/**
 * 商品数据的实体类
 * @author soft01
 *
 */
public class Goods extends BaseEntity {

	private	  long     id;   //'商品id',
	private 	long     categoryId ;// '分类id',
	private	  String   itemType ;// '商品系列',
	private 	String   title ;//'商品标题',
	private 	String   sellPoint;// '商品卖点',
	private	  long     price;// '商品单价',
	private	  Integer  num;//'库存数量',
	private	  String   barcode;// '条形码',
	private	  String   image;// '图片路径',
	private  Integer  status;// '商品状态  1：上架   2：下架   3：删除',
	private  Integer  priority; //显示优先级
	public Goods() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Goods(String createdUser, Date createdTime, String modifiedUser, Date modifiedTime) {
		super(createdUser, createdTime, modifiedUser, modifiedTime);
		// TODO Auto-generated constructor stub
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(long categoryId) {
		this.categoryId = categoryId;
	}
	public String getItemType() {
		return itemType;
	}
	public void setItemType(String itemType) {
		this.itemType = itemType;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getSellPoint() {
		return sellPoint;
	}
	public void setSellPoint(String sellPoint) {
		this.sellPoint = sellPoint;
	}
	public long getPrice() {
		return price;
	}
	public void setPrice(long price) {
		this.price = price;
	}
	public Integer getNum() {
		return num;
	}
	public void setNum(Integer num) {
		this.num = num;
	}
	public String getBarcode() {
		return barcode;
	}
	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Integer getPriority() {
		return priority;
	}
	public void setPriority(Integer priority) {
		this.priority = priority;
	}
	@Override
	public String toString() {
		return "Goods [id=" + id + ", categoryId=" + categoryId + ", itemType=" + itemType + ", title=" + title
				+ ", sellPoint=" + sellPoint + ", price=" + price + ", num=" + num + ", barcode=" + barcode + ", image="
				+ image + ", status=" + status + ", priority=" + priority + "]";
	}
	
	
}
