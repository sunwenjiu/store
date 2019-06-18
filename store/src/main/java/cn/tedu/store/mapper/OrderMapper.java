package cn.tedu.store.mapper;

import cn.tedu.store.entity.Order;
import cn.tedu.store.entity.OrderItem;

/**
 * 订单数据持久层
 * @author soft01
 *
 */
public interface OrderMapper {
	
	/**
	 * 新增到订单数据表
	 * @param order
	 * @return
	 */
	Integer insertOrder(Order order);
	
	/**
	 * 新增到订单商品表
	 * @param orderItem
	 * @return
	 */
	Integer insertOrderItem(OrderItem orderItem);

	
}
