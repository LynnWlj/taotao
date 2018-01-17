package com.taotao.rest.controller;

import javax.print.attribute.standard.Media;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.stereotype.Controller;
/**
 * 
* 项目名称：taotao-rest
* 类名称：ItemCatController
* 类描述：商品分类列表
* @author:Lynn Wang
* @createdTime:2018年1月12日 下午6:24:39
* @修改人:Lynn Wang
* @updateTime:2018年1月12日 下午6:24:39
* @version:
 */
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.taotao.common.utils.JsonUtils;
import com.taotao.rest.pojo.CatResult;
import com.taotao.rest.service.ItemCatService;
@Controller
public class ItemCatController {
	@Autowired
	ItemCatService itemCatService;
	
//	@RequestMapping(value="/itemcat/list",
//			produces=MediaType.APPLICATION_JSON_VALUE+ ";charset=utf-8")
//	@ResponseBody
//	public String getItemCatList(String callback){
//		CatResult catResult = itemCatService.getItemCatList();
//		//pojo转化为json
//		String json = JsonUtils.objectToJson(catResult);
//		//拼装返回值
//		String result = callback + "(" + json + ");";
//		return result;
//	}
	
	@RequestMapping(value="/itemcat/list")
	@ResponseBody
	public Object getItemCatList(String callback){
		CatResult catResult = itemCatService.getItemCatList();
		MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(catResult);
		mappingJacksonValue.setJsonpFunction(callback);
		return mappingJacksonValue;
	
	}
	
	
	
}
