package cn.tedu.store.service;

import java.util.List;

import cn.tedu.store.entity.Goods;

public interface IGoodsService {
	/**
	 * 找到热销商品前4个
	 * @return
	 */
	List<Goods> getHotList();
	
	/**
	 * 通过ID查找商品详情
	 * @param id
	 * @return
	 */
	Goods  getById(long id);


}
