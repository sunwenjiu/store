package cn.tedu.store.service;

import java.util.List;

import cn.tedu.store.entity.District;

/**
 * 省市区业务层接口
 * @author soft01
 *
 */
public interface IDistrictService {
	
	/**
	 *  根据父集代号查询
	 * @param parent
	 * @return
	 */
	List<District> getByParent(String parent);
	
	/**
	 * 根据省市区代号查询详情
	 * @param code
	 * @return
	 */
	District getByCode(String code);

}
