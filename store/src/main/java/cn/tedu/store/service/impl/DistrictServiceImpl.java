package cn.tedu.store.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.tedu.store.entity.District;
import cn.tedu.store.mapper.DistrictMapper;
import cn.tedu.store.service.IDistrictService;

@Service
public class DistrictServiceImpl implements IDistrictService {
	
	@Autowired
	private DistrictMapper districtMapper;

	@Override
	public List<District> getByParent(String parent) {
		

		return findByParent(parent);
	}
	
	@Override
	public District getByCode(String code) {
		
		return findByCode(code);
	}
	
	
	
	//私有方法开始
	
	 private District findByCode(String code){
		
		 return districtMapper.findByCode(code);
	}
	
	private List<District> findByParent(String parent){
		return districtMapper.findByParent(parent);
	}

	

}
