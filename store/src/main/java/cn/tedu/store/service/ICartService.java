package cn.tedu.store.service;

import java.util.List;

import cn.tedu.store.entity.Cart;
import cn.tedu.store.service.ex.AccessDeniedExcption;
import cn.tedu.store.service.ex.CartNotFoundException;
import cn.tedu.store.service.ex.InsertException;
import cn.tedu.store.service.ex.UpdateException;
import cn.tedu.store.vo.CartVO;

/**
 * 购物车业务层
 * @author soft01
 *
 */
public interface ICartService {
	/**
	 * 新增加购物车数据
	 * @param cart
	 * @param username
	 * @throws InsertException
	 * @throws UpdateException
	 */
	void addToCart(Cart cart, String username) throws InsertException, UpdateException;

	/**
	 * 通过uid获取购物车VO list
	 * @param uid
	 * @return
	 */
	List<CartVO> getByUid(Integer uid);
	
	/**
	 * 增加购物车中商品的数量
	 * @param cid
	 * @param uid
	 * @param username
	 * @return
	 */
	Integer addNum(Integer cid ,Integer uid,String username) throws CartNotFoundException,AccessDeniedExcption,UpdateException;
	
	/**
	 * 购物车确认列表
	 * @param cids
	 * @return
	 */
	List<CartVO> getByCids(Integer[] cids);
	
	
}
