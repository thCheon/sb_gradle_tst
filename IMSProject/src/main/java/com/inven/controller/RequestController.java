package com.inven.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.inven.service.RequestServiceImpl;


@Controller
@RequestMapping(value = "/req/*")
public class RequestController {

	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Resource(name="requestService")
	RequestServiceImpl reqService = new RequestServiceImpl();
	
	@RequestMapping(value = "/list" , method = RequestMethod.GET)
	public ModelAndView moevPageMain(@RequestParam Map<String, Object> map) {
		log.info("Request Parameter : " + map);
		ModelAndView mv = new ModelAndView("/request_fd/request_main");
		
		List<Map<String, Object>> list = reqService.selectAll(map);
		
		mv.addObject("list", list);
		
		return mv;
	}
	

}
