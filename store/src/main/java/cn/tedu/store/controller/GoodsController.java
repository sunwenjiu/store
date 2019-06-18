package cn.tedu.store.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.tedu.store.entity.Goods;
import cn.tedu.store.service.IGoodsService;
import cn.tedu.store.util.ResponseResult;

@RestController
@RequestMapping("goods")
public class GoodsController  extends BaseController{
	
	@Autowired
	private IGoodsService goodsService;
	
	@GetMapping("hot")
	public ResponseResult<List<Goods>> getHostList(){
		//调用业务层对象查询数据,获取返回结果
		List<Goods> data= goodsService.getHotList();
		
		//返回成功和以上查询结果
		return new ResponseResult<List<Goods>>(SUCCESS, data);
		
	}
	
	@GetMapping("{id}/details")
	public ResponseResult<Goods> getById( @PathVariable("id") long id){
		//调用业务层对象执行
		Goods data=goodsService.getById(id);
		//查询成功
		return new ResponseResult<>(SUCCESS, data);
		
	}

}
