package cn.tedu.store.service.impl;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.tedu.store.entity.Address;
import cn.tedu.store.entity.District;
import cn.tedu.store.mapper.AddressMapper;
import cn.tedu.store.service.IAddressService;
import cn.tedu.store.service.IDistrictService;
import cn.tedu.store.service.ex.AccessDeniedExcption;
import cn.tedu.store.service.ex.AddressNotFoundException;
import cn.tedu.store.service.ex.DeleteExcption;
import cn.tedu.store.service.ex.InsertException;
import cn.tedu.store.service.ex.UpdateException;

/**
 * 处理收货地址的业务层实现类
 * @author soft01
 *
 */
@Service
public class AddressServiceImpl implements  IAddressService{

	@Autowired
	private AddressMapper addressMapper;

	@Override
	public void addnew(Address address,String username) throws InsertException {
		// 
		//根据参数Address中的uid执行查询数量
		Integer uid =address.getUid();
		Integer count=	countByUid(uid);
		//判断收货地址数量是否为0,
		//是isdefault 是>1
		//否 is_default >0
		Integer isDefault = count == 0 ? 1 : 0;

		//将is_default封装到Address
		address.setIsDefault(isDefault);
		
		//获取省市区名称
		String district=getDistrict(address.getProvince(),address.getCity(),address.getArea());
		address.setDistrict(district);

		//四项日志数据
		Date now =new Date();
		address.setCreatedUser(username);
		address.setCreatedTime(now);
		address.setModifiedUser(username);
		address.setModifiedTime(now);

		//执行增加
		insert(address);
	}
	
	/**
	 * 通过uid找到用户地址
	 */
	@Override
	public List<Address> getByUid(Integer uid) {
		
		return findByUid( uid);
	}
	
	
	/**
	 * 设置默认地址
	 */
	@Override
	@Transactional
	public void setDefault(Integer aid, Integer uid, String username) throws AddressNotFoundException, UpdateException ,AccessDeniedExcption{
		// 
		//根据参数aid查找数据
		Address result=findByAid(aid);
		
		//判断查询结果是否为null
		if (result==null) {
			//是Add异常
				throw new AddressNotFoundException("设置出错,数据未找到");
		}
		//判断查询结果中的UID和参数的uid是否不一致
		if (result.getUid() != uid) {
			throw new AccessDeniedExcption("设置默认收货地址失败,访问被拒绝");
		}
				
		//根据参数uid将全部地址设置为非默认
		updateNonDefault(uid);
		
		//创建当前时间对象
		
		Date modifiedTime= new Date();
		//根据aid将指定地址设置为默认
	updateDefault(aid, username, modifiedTime);
	
		
	}
	@Override
	@Transactional
	public void delete(Integer aid, Integer uid, String username)
			throws DeleteExcption, UpdateException, AccessDeniedExcption, AddressNotFoundException {
		// TODO Auto-generated method stub
		// 根据参数aid查询即将删除的数据：findByAid(aid)
		Address result=findByAid(aid);
				// 判断查询结果是否为null
		if (result == null) {
			// 是：AddressNotFoundException
			throw new AddressNotFoundException("删除数据失败,未找到对应数据");
		}

				// 判断查询结果中的uid与参数uid是否不同
		if (result.getUid()!=uid) {
			// 是：AccessDeniedException
			throw new AccessDeniedExcption("删除数据失败,没有访问权限");
		}

				// 执行删除：deleteByAid(aid)
		deleteByAid(aid);

				// 判断查询结果的isDefault是否为1：需要在findByAid的SQL查询中补充查询is_default字段
		if (result.getIsDefault()==1) {
			// 是：表示删除了默认收货地址，则统计收货地址数量：countByUid(uid)
			Integer rows=countByUid(uid);
			// 判断数量是否大于0
			if (rows>0) {
				// 找出最后修改的收货地址：findLastModified(uid)
				Address lastModifiedAddress=findLastModified(uid);
				// 获取该收货地址数据的aid：Integer lastModifiedAid = xx.getAid()
				Integer lastModifiedAid=lastModifiedAddress.getAid();
				// 创建当前时间对象
				Date now= new Date();
				// 将该收货地址设置为默认：updateDefault(lastModifiedAid, username, now)
				updateDefault(lastModifiedAid, username, now);
			}
			
		}
	}
	@Override
	public Address getByAid(Integer aid) {
		// TODO Auto-generated method stub
		return findByAid(aid);
	}
	
	//   TODO      ==================     私有开始     ================
	
	
	/**
	 * 通过aid删除收货地址
	 * @param aid
	 * @return
	 */
	private void deleteByAid(Integer aid) {
		Integer rows = addressMapper.deleteByAid(aid);
		if (rows != 1) {
			throw new DeleteExcption("删除数据失败,出现未知错误");
		}
		
	}; 
	
	/**
	 * 通过uid找到最后一次修改的收货地址
	 * @param uid
	 * @return
	 */
	private Address findLastModified(Integer uid) {
		return addressMapper.findLastModified(uid);
	};
	
	
	
	/**
	 * 修改地址是否默认,通过aid
	 * @param aid
	 * @param modifiedUser
	 * @param modifiedTime
	 * @return
	 */
	private void updateDefault(
			 Integer aid,
			 String modifiedUser,
		 Date modifiedTime ) {
		Integer rows=	addressMapper.updateDefault(aid, modifiedUser, modifiedTime);
		if (rows!=1) {
			throw new UpdateException("设置默认失败,发送未知错误");
		}
	}
	
	/**
	 * 设置所有的都为非默认.,通过UI的
	 * @param uid
	 * @return
	 */
	private void updateNonDefault(Integer uid) {
		Integer rows=addressMapper.updateNonDefault(uid);
		if (rows==0) {
			throw new UpdateException("设置默认失败,发送未知错误");
		}
	};
	
	/**
	 * 通过aid找是否有数据
	 * @param aid
	 * @return Address对象
	 */
	private Address findByAid(Integer aid) {
		
		return addressMapper.findByAid(aid);
	};
	
	
	
	/**
	 * 通过uid找到用户地址
	 * @param uid
	 * @return
	 */
	private List<Address> findByUid(Integer uid){
		
		return addressMapper.findByUid(uid);
	}
	

	/**
	 * 新增收货地址
	 * @param address 收货地址数据
	 * 
	 */
	private void insert(Address address) {
		Integer rows=		addressMapper.insert(address);
		if (rows != 1) {
			throw new InsertException("增加收货地址失败,插入数据出现未知错误");
		}
	}
	
	/**
	 * 统计某用户的收货地址的数量
	 * @param uid
	 * @return 受影响的行数
	 */
	private Integer countByUid( Integer uid) {
		
		return addressMapper.countByUid(uid);
	}
	
	@Autowired
	private IDistrictService districtService;
	/**
	 * 
	 * @param provinceCode
	 * @param cityCode
	 * @param areaCode
	 * @return
	 */
	private String getDistrict(String provinceCode,String cityCode,String areaCode) {
		StringBuffer result= new StringBuffer();
		
		District province = districtService.getByCode(provinceCode);
		District city = districtService.getByCode(cityCode);
		District area = districtService.getByCode(areaCode);
		
		if (province !=null) {
			result.append(province.getName());
		}
		if (city !=null) {
			result.append(city.getName());
		}
		if (area !=null) {
			result.append(area.getName());
		}
		
		return result.toString();
	}








}
