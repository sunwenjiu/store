package cn.tedu.mybatis;

import java.util.List;

public interface DepartmentMapper {
	
List<DepartmentVO> findAll();
	
	DepartmentVO findById(Integer id);

}
