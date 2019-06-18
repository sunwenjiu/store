package cn.tedu.store.mapper;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.tedu.store.entity.Address;

/**
 * 处理收货地址的持久层接口
 * @author soft01
 *
 */
public interface AddressMapper {
	
	/**
	 * 新增收货地址
	 * @param address 收货地址数据
	 * @return 受影响的行数
	 */
	Integer insert(Address address);
	
	/**
	 * 统计某用户的收货地址的数量
	 * @param uid
	 * @return
	 */
	Integer countByUid( Integer uid);
	
	/**
	 * 通过uid找到用户地址
	 * @param uid
	 * @return
	 */
	List<Address> findByUid(Integer uid);
	
	/**
	 * 修改地址是否默认,通过aid
	 * @param aid
	 * @param modifiedUser
	 * @param modifiedTime
	 * @return
	 */
	Integer updateDefault(
			@Param("aid") Integer aid,
			@Param("modifiedUser") String modifiedUser,
			@Param("modifiedTime") Date modifiedTime );
	
	/**
	 * 设置所有的都为非默认.,通过UI的
	 * @param uid
	 * @return
	 */
	Integer updateNonDefault(Integer uid);
	
	/**
	 * 通过aid找是否有数据
	 * @param aid
	 * @return Address对象
	 */
	Address findByAid(Integer aid);
	
	
	/**
	 * 通过aid删除收货地址
	 * @param aid
	 * @return
	 */
	Integer deleteByAid(Integer aid); 
	
	/**
	 * 通过uid找到最后一次修改的收货地址
	 * @param uid
	 * @return
	 */
	Address findLastModified(Integer uid);

}
