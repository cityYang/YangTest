package com.shiyang.test;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
@Controller
@RequestMapping("/shiyang")
public class SpringTest {
	private final static Logger log = LoggerFactory.getLogger(SpringTest.class); 
	@RequestMapping(value = "/testSpring.json", method = RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> Test(){
		String str ="hello world!";
		Map<String,Object> map =new HashMap<String,Object>();
		map.put("str",str);
		System.out.println("成功！");
		log.debug("测试log：{}",map.get("str"));
		log.info("测试2log：{}",map.get("str"));
		return map;
	}
}
