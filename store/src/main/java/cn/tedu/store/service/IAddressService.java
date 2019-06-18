package cn.tedu.store.service;

import java.util.List;

import cn.tedu.store.entity.Address;
import cn.tedu.store.service.ex.AccessDeniedExcption;
import cn.tedu.store.service.ex.AddressNotFoundException;
import cn.tedu.store.service.ex.DeleteExcption;
import cn.tedu.store.service.ex.InsertException;
import cn.tedu.store.service.ex.UpdateException;

/**
 * 处理收货地址的业务层接口
 * @author soft01
 *
 */
public interface IAddressService {
	
	/**
	 * 添加新的收货地址
	 * @param address 地址数据对象
	 * @param username 当前登录的用户的用户名
	 * @throws InsertException  
	 */
	void addnew(Address address,String username) throws InsertException;
	
	/**
	 * 通过uid找到用户地址
	 * @param uid
	 * @return
	 */
	List<Address> getByUid(Integer uid);
	
	/**
	 * 将指定的收货地址设置为默认
	 * @param aid 收货地址的id
	 * @param uid 当前的用户名的UId
	 * @param username
	 * @throws AddressNotFoundException
	 * @throws UpdateException
	 */
	void setDefault(Integer aid,Integer uid,String username)throws AddressNotFoundException,UpdateException,AccessDeniedExcption;
	
	/**
	 * 删除地址数据
	 * @param aid  将要删除的数据的id
	 * @param uid 当前登录的用户的uid
	 * @param username 当前登录的用户的用户名
	 * @throws DeleteExcption
	 * @throws UpdateException
	 * @throws AccessDeniedExcption
	 * @throws AddressNotFoundException
	 */
	void delete(Integer aid,Integer uid,String username)throws DeleteExcption,UpdateException,AccessDeniedExcption,AddressNotFoundException;
	
	/**
	 * 通过uid找到用户地址单个
	 * @param aid
	 * @return
	 */
	Address getByAid(Integer aid);
	
}
