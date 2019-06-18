package cn.tedu.store.mapper;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.tedu.store.entity.Cart;
import cn.tedu.store.vo.CartVO;

/**
 * 购物车持久化接口
 * @author soft01
 *
 */
public interface CartMapper {
	
	/**
	 * 新增购物车数据
	 * @param cart
	 * @return
	 */
	Integer addnew(Cart cart);
	
	/**
	 * 更新购物车数据
	 * @param cid
	 * @param num
	 * @param modifiedUser
	 * @param modifiedTime
	 * @return
	 */
	Integer updateNum(@Param("cid") Integer cid,
			@Param("num") Integer num,
			@Param("modifiedUser") String modifiedUser,
			@Param("modifiedTime") Date modifiedTime);
	
	/**
	 * 通过UId和gid查找购物车数据
	 * @param uid
	 * @param gid
	 * @return
	 */
	Cart findByUidAndGid(@Param("uid") Integer uid,@Param("gid") Long gid);
	
	/**
	 * 通过uid查找购物车VO list
	 * @param uid
	 * @return
	 */
	List<CartVO> findByUid(Integer uid);
	
	/**
	 * 通过cid查找
	 * @param cid
	 * @return
	 */
	Cart fingByCid(Integer cid);
	
	/**
	 * 购物车确认列表
	 * @param cids
	 * @return
	 */
	List<CartVO> findByCids(Integer[] cids);

}
