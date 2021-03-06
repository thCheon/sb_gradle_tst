package com.inven.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.inven.service.RequestServiceImpl;


/*
 * Class 에도 부모 annotation 설정 가능 
 * ex) 여기에 RequestMapping(value="common")
 * 해두면 이 밑에 맵핑들은 다 common/___ 으로 접근해야함
 */

@SuppressWarnings("unchecked")
@RequestMapping(value = "/prod/acyn/*")
@Controller
public class ProductAjaxController {

	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Resource(name="requestService")
	RequestServiceImpl reqService = new RequestServiceImpl();
	
	/* JSONObject Key => code
	 * value 의미
	 * 200 : Success
	 * 400 : Error */
	@ResponseBody
	@GetMapping("/prodTest.do")
//	@RequestMapping(value = "/index.do", method = RequestMethod.GET)
	public JSONObject test(@RequestParam Map<String, Object> map) {
		log.info("Request Parameter : " + map);
		
		JSONObject jobj = new JSONObject();
		jobj.put("code", 400); 

		List<Map<String, Object>> list = reqService.selectAll(map);
		if(list != null) {
			jobj.put("code", 200);
			jobj.put("list", list);
		}
		
		return jobj;
	}
	

}
