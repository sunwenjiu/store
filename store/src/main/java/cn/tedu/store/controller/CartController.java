package cn.tedu.store.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.tedu.store.entity.Cart;
import cn.tedu.store.service.ICartService;
import cn.tedu.store.util.ResponseResult;
import cn.tedu.store.vo.CartVO;

@RestController
@RequestMapping("carts")
public class CartController extends BaseController{
	
	@Autowired
	private ICartService cartService;
	
	@RequestMapping("add_to_cart")
	public ResponseResult<Void> addToCart(Cart cart,HttpSession session){
		//获取uid和username
		Integer uid=getUidFromSession(session);
		String username=session.getAttribute("username").toString();
		//将uid封装到cart
		cart.setUid(uid);
		//调用业务层 对象执行加入购物车
		cartService.addToCart(cart, username);
		//响应成功
		
		return  new ResponseResult<>(SUCCESS);
	}
	
	@GetMapping("/")
	public ResponseResult<List<CartVO>>  getByUid(HttpSession session){
		//获取uid
		Integer uid=getUidFromSession(session);
		//执行查询
		List<CartVO> data=cartService.getByUid(uid);
		//响应成功与查询结果
		return  new ResponseResult<>(SUCCESS,data);
		
	}
	
	@RequestMapping("/{cid}/add_num")
	public ResponseResult<Integer> addNum(@PathVariable("cid") Integer cid,HttpSession session){
		//获取uid和用户名
		Integer uid=getUidFromSession(session);
		String username= session.getAttribute("username").toString();
		//调用业务层对象执行增加并获取结果
		Integer num=cartService.addNum(cid, uid, username);
		
		//返回成功和新的数量
		
		
		
		return new ResponseResult<>(SUCCESS, num);
	}
	
@GetMapping("get_by_cids")
public ResponseResult<List<CartVO>>  getByCids(Integer[] cids){

	//执行查询
	List<CartVO> data=cartService.getByCids(cids);
	//响应成功与查询结果
	return  new ResponseResult<>(SUCCESS,data);
	
}
	
}
