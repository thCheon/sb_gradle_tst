package com.inven.service;

import java.util.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inven.mapper.RequestMapper;
import com.inven.service.inter.RequestService;


@Service("requestService")
public class RequestServiceImpl implements RequestService{
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private RequestMapper reqMapper;
	
	public List<Map<String, Object>> selectAll(Map<String, Object> map){ return reqMapper.selectAll(map); }
}
