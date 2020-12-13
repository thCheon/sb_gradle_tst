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

import com.inven.service.ProductServiceImpl;


@Controller
@RequestMapping(value = "/prod/*")
public class ProductController {

	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Resource(name="productService")
	ProductServiceImpl prodService = new ProductServiceImpl();
	
	@RequestMapping(value = "/list" , method = RequestMethod.GET)
	public ModelAndView moevPageMain(@RequestParam Map<String, Object> map) {
		log.debug("Request Parameter : " + map);
//		ModelAndView mv = new ModelAndView("/product_fd/product_main");
		ModelAndView mv = new ModelAndView("/layout/write");
		
		List<Map<String, Object>> list = prodService.selectAll(map);
		
		mv.addObject("list", list);
		
		return mv;
	}
	

}
