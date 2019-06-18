package cn.tedu.store.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.tedu.store.entity.Address;
import cn.tedu.store.entity.Order;
import cn.tedu.store.entity.OrderItem;
import cn.tedu.store.mapper.OrderMapper;
import cn.tedu.store.service.IAddressService;
import cn.tedu.store.service.ICartService;
import cn.tedu.store.service.IOrderService;
import cn.tedu.store.service.ex.InsertException;
import cn.tedu.store.vo.CartVO;

@Service
public class OrderServiceImpl implements IOrderService{
	
	@Autowired
	private OrderMapper orderMapper;
	@Autowired
	private IAddressService addressService;

	@Autowired
	private ICartService cartService;
	
	@Override
	@Transactional
	public Order create(Integer aid, Integer[] cids, Integer uid, String username) throws InsertException {
		// 创建当前时间对象：Date now = new Date();
		Date now = new Date();

				// 定义总价变量totalPrice = 0
		Long  totalPrice = 0l;
				// 基于参数cids查询得到List<CartVO>：cartService.getByCids(cids)
		List<CartVO> list =cartService.getByCids(cids);
				// 遍历集合
		for (CartVO cartVO : list) {
			// -- 遍历过程中基于商品单价和数量，得到该样商品的总价，并累加到totalPrice
		totalPrice +=	cartVO.getNum()*cartVO.getPrice();
			
		}
				// 创建对象：Order order = new Order();
		Order order = new Order();
				// 封装order属性：基于参数uid
		order.setUid(uid);
				// 封装order属性：基于aid查询得到3个收货相关数据：addressService.getByAid(aid)
		Address address=addressService.getByAid(aid);
		order.setRecvName(address.getName());
		order.setRecvPhone(address.getPhone());
		order.setRecvAddress(address.getDistrict()+address.getAddress());
		
				// 封装order属性：total_price
		order.setTotalPrice(totalPrice);
				// 封装order属性：status -> 0
		order.setStatus(0);
				// 封装order属性：order_time -> now
		order.setOrderTime(now);
				// 封装order属性：基于参数username和now封装4项日志
		order.setCreatedTime(now);
		order.setCreatedUser(username);
		order.setModifiedTime(now);
		order.setModifiedUser(username);
				// 插入订单数据：insertOrder(order);
		insertOrder(order);

				// 遍历List<CartVO>
		for (CartVO cartVO : list) {
			// -- 创建订单商品数据：OrderItem orderItem = new OrderItem();
			OrderItem orderItem = new OrderItem();
			// -- 封装orderItem属性：oid -> order.getOid();
			orderItem.setOid(order.getOid());
			// -- 封装orderItem属性：基于遍历到的对象，封装商品相关数据
			orderItem.setGid(cartVO.getGid());
			orderItem.setGoodsTitle(cartVO.getTitle());
			orderItem.setGoodsImage(cartVO.getImage());
			orderItem.setGoodsPrice(cartVO.getPrice());
			orderItem.setGoodsNum(cartVO.getNum());
			// -- 封装orderItem属性：基于参数username和now封装4项日志
			orderItem.setCreatedTime(now);
			orderItem.setCreatedUser(username);
			orderItem.setModifiedTime(now);
			orderItem.setModifiedUser(username);
			// -- 循环插入订单商品数据：insertOrderItem(orderItem)
			insertOrderItem(orderItem);
			
			
		}
		
		return order;
	}
	
	
	
	
	// TODO ==== 私有方法 =====
	
	/**
	 * 新增到订单数据表
	 * @param order
	 * @return
	 */
	private void insertOrder(Order order) {
		Integer row= orderMapper.insertOrder(order);
		if (row!=1) {
			throw new InsertException("创建订单失败,新增订单数据发生未知错误");
		}
	};
	
	/**
	 * 新增到订单商品表
	 * @param orderItem
	 * @return
	 */
	private void insertOrderItem(OrderItem orderItem) {
		
		Integer row= orderMapper.insertOrderItem(orderItem);
		if (row!=1) {
			throw new InsertException("新增订单商品数据失败,发生未知错误");
		}
	}



}
