package com.inven.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface RequestMapper {
	
	public List<Map<String, Object>> selectAll(Map<String, Object> map);
	
}
