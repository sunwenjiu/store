package cn.tedu.store.service.impl;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.tedu.store.entity.Cart;
import cn.tedu.store.mapper.CartMapper;
import cn.tedu.store.service.ICartService;
import cn.tedu.store.service.ex.AccessDeniedExcption;
import cn.tedu.store.service.ex.CartNotFoundException;
import cn.tedu.store.service.ex.InsertException;
import cn.tedu.store.service.ex.UpdateException;
import cn.tedu.store.vo.CartVO;

/**
 *  购物车业务层实现类
 * @author soft01
 *
 */
@Service
public class CartServiceImpl implements ICartService {

	@Autowired 
	private CartMapper cartMapper;
	
	@Override
	
	public void addToCart(Cart cart, String username) throws InsertException, UpdateException {
		// 根据参数cart中的uid和gid执行查询
		Integer uid=cart.getUid();
		Long gid=cart.getGid();
		Cart result=findByUidAndGid(uid, gid);
		Date now= new Date();
		// 判断查询结果是否为null
		if (result == null) {
			// 是：表示当前用户并没有将当前商品添加到购物车，则执行增加
			cart.setCreatedUser(username);
			cart.setCreatedTime(now);
			cart.setModifiedUser(username);
			cart.setModifiedTime(now);
			addnew(cart);
		}else {
			// 否：表示当前用户的购物车中已有该商品，则取出该数据的cid和num
			Integer Cid=result.getCid();
			Integer Num=result.getNum();
			// 根据参数cart中的num和刚才查询结果中取出的num，计算得到新的num
			Integer newNum=cart.getNum()+Num;
			
			// 执行更新
			updateNum(Cid, newNum, username, now);
		}

		
		
	}
	
	
	@Override
	public List<CartVO> getByUid(Integer uid) {
		
		return findByUid(uid);
	}
	
	@Override
	public Integer addNum(Integer cid, Integer uid, String username)
			throws CartNotFoundException, AccessDeniedExcption, UpdateException {
		//根据参数cid查询数据
		Cart result=fingByCid(cid);
		//检查查询结果是否为null
		if (result==null) {
			//是  cartNotfound
			throw new CartNotFoundException("增加失败,没有找到数据");
		}
		
		//检查参数uid与查询结果中的UId是否不同
		if (result.getUid()!=uid) {
			//是 access
			throw new AccessDeniedExcption("增加失败,没有访问权限");
		}
		
		// 取出查询结果中的商品数量，增加1，得到新的数量
		Integer num=result.getNum()+1;
		
				// 更新商品数量：updateNum(Integer cid, Integer num, 
			//	String modifiedUser, Date modifiedTime)
		updateNum(cid, num, username, new Date());
				// 返回新的数量
		
		return num;
	}
	
	/**
	 * 购物车确认列表
	 */
	@Override
	public List<CartVO> getByCids(Integer[] cids) {
		// TODO Auto-generated method stub
		return findByCids(cids);
	}


	
	// TODO =====私有方法开始 ===
	
	/**
	 * 购物车确认列表
	 * @param cids
	 * @return
	 */
	private List<CartVO> findByCids(Integer[] cids){
		
		return cartMapper.findByCids(cids);
	}
	
	/**
	 * 通过cid查找
	 * @param cid
	 * @return
	 */
	private Cart fingByCid(Integer cid) {
		
		return cartMapper.fingByCid(cid);
	};
	
	/**
	 * 通过uid查找购物车VO list
	 * @param uid
	 * @return
	 */
	private List<CartVO> findByUid(Integer uid){
		
		return cartMapper.findByUid(uid);
	}
	
	
	
	/**
	 * 新增购物车数据
	 * @param cart
	 * @return
	 */
	private void addnew(Cart cart) {
		Integer row=cartMapper.addnew(cart);
		
		if (row !=1) {
			throw new  InsertException("插入购物车数据失败,发生未知错误");
			
		}
		
	}
	
	/**
	 * 更新购物车数据
	 * @param cid
	 * @param num
	 * @param modifiedUser
	 * @param modifiedTime
	 * @return
	 */
	private void updateNum( Integer cid,			Integer num,	 String modifiedUser,
			Date modifiedTime) {
		
		Integer rows=cartMapper.updateNum(cid, num, modifiedUser, modifiedTime);
		if (rows !=1) {
			throw new UpdateException("更新购物车数据失败,发生未知错误");
		}
	}
	
	/**
	 * 通过UId和gid查找购物车数据
	 * @param uid
	 * @param gid
	 * @return
	 */
	private Cart findByUidAndGid( Integer uid, Long gid) {
		
		return cartMapper.findByUidAndGid(uid, gid);
	}








	

}
