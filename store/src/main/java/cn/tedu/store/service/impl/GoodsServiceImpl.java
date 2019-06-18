package cn.tedu.store.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.tedu.store.entity.Goods;
import cn.tedu.store.mapper.GoodsMapper;
import cn.tedu.store.service.IGoodsService;

@Service
public class GoodsServiceImpl implements IGoodsService{
	
	@Autowired
	private GoodsMapper goodsMapper;


	@Override
	public List<Goods> getHotList() {
		
		return findHotList();
	}
	
	/**
	 * 通过ID查找商品详情
	 * @param id
	 * @return
	 */
	@Override
	public Goods getById(long id) {
		
		return findById(id);
	}

	
	
	//  =========   私有开始 ======== 
	
	/**
	 * 通过ID查找
	 * @param id
	 * @return
	 */
	private Goods  findById(long id) {
		
		return goodsMapper.findById(id);
	};

	
	/**
	 * 找到热销商品前4个
	 * @return
	 */

	private List<Goods> findHotList(){
	return	goodsMapper.findHotList();
		
	}








}
