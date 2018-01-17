package com.taotao.protal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.taotao.common.pojo.TaotaoResult;
import com.taotao.protal.service.ContentService;

@Controller
public class IndexController {
	@Autowired ContentService contentService;
	
	@RequestMapping("/index")
	public String showIndex(Model model ){
		String adJson = contentService.getContentList();
		model.addAttribute("ad1", adJson);
		return "index";
	}
	
	@RequestMapping("/cart")
	public String showCart(){
		return "cart";
	}
	
//	@RequestMapping(value="/httpclient/post" , method=RequestMethod.POST)
//	@ResponseBody
//	public String PostTest(){
//		return "ok";
//	}
	
	@RequestMapping(value="/httpclient/post" , method=RequestMethod.POST)
	@ResponseBody
	public String PostTest(String name,String password){
		return "name:" + name + ";password:" + password;
	}
}
