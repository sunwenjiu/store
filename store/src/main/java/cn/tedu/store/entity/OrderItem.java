package cn.tedu.store.entity;

/**
 * 订单商品的实体类
 * @author soft01
 *
 */
public class OrderItem extends BaseEntity {

	 /**
	 * 
	 */
	private static final long serialVersionUID = -2769333087755252052L;
	private Integer id ;// '自动递增的数据id',
	private Integer  oid ;// '归属的订单的id',
	private Long gid ;// '商品id',
	private String goodsTitle ;// '商品标题',
	private String  goodsImage ;// '商品图片',
	private Long goodsPrice ;// '商品价格',
	private Integer goodsNum ; //'商品数量',
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getOid() {
		return oid;
	}
	public void setOid(Integer oid) {
		this.oid = oid;
	}
	public Long getGid() {
		return gid;
	}
	public void setGid(Long gid) {
		this.gid = gid;
	}
	public String getGoodsTitle() {
		return goodsTitle;
	}
	public void setGoodsTitle(String goodsTitle) {
		this.goodsTitle = goodsTitle;
	}
	public String getGoodsImage() {
		return goodsImage;
	}
	public void setGoodsImage(String goodsImage) {
		this.goodsImage = goodsImage;
	}
	public Long getGoodsPrice() {
		return goodsPrice;
	}
	public void setGoodsPrice(Long goodsPrice) {
		this.goodsPrice = goodsPrice;
	}
	public Integer getGoodsNum() {
		return goodsNum;
	}
	public void setGoodsNum(Integer goodsNum) {
		this.goodsNum = goodsNum;
	}
	@Override
	public String toString() {
		return "OrderItem [id=" + id + ", oid=" + oid + ", gid=" + gid + ", goodsTitle=" + goodsTitle + ", goodsImage="
				+ goodsImage + ", goodsPrice=" + goodsPrice + ", goodsNum=" + goodsNum + "]";
	}
	 
	 
	 
}
