package cn.tedu.store.service;

import cn.tedu.store.entity.Order;
import cn.tedu.store.service.ex.InsertException;

/**
 * 处理订单相关业务处接口
 * @author soft01
 *
 */
public interface IOrderService {
	
	/**
	 * 创建订单
	 * @param aid
	 * @param cids
	 * @param uid
	 * @param username
	 * @return
	 * @throws InsertException
	 */
	Order create(Integer aid ,Integer[] cids,Integer uid , String username)throws InsertException;

}
