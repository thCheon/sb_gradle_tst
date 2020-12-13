package com.inven.service;

import java.util.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inven.mapper.ProductMapper;
import com.inven.service.inter.ProductService;

@Service("productService")
public class ProductServiceImpl implements ProductService{
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private ProductMapper prodMapper;
	
	public List<Map<String, Object>> selectAll(Map<String, Object> map){ return prodMapper.selectAll(map); }
}
