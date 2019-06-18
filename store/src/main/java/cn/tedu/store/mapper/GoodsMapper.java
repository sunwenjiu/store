package cn.tedu.store.mapper;

import java.util.List;

import cn.tedu.store.entity.Goods;

/**
 * 商品持久层
 * @author soft01
 *
 */
public interface GoodsMapper {
	
	/**
	 * 找到热销商品前4个
	 * @return
	 */
	List<Goods> findHotList();
	
	/**
	 * 通过ID查找商品详情
	 * @param id
	 * @return
	 */
	Goods  findById(long id);

}
