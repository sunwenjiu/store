package cn.tedu.store.mapper;

import java.util.List;

import cn.tedu.store.entity.District;

/**
 *c处理省市区持久层
 * @author soft01
 *
 */
public interface DistrictMapper {
	
	/**
	 *  根据父集代号查询
	 * @param parent
	 * @return
	 */
	List<District> findByParent(String parent);
	
	/**
	 * 根据省市区代号查询详情
	 * @param code
	 * @return
	 */
	District findByCode(String code);

}
