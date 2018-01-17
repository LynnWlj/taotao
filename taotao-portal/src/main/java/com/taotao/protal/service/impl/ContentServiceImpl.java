package com.taotao.protal.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.taotao.common.pojo.TaotaoResult;
import com.taotao.common.utils.HttpClientUtil;
import com.taotao.common.utils.JsonUtils;
import com.taotao.pojo.TbContent;
import com.taotao.protal.service.ContentService;
@Service
/**
 * 内容管理
* 项目名称：taotao-portal
* 类名称：ContentServiceImpl
* 类描述：
* @author:Lynn Wang
* @createdTime:2018年1月17日 下午11:37:38
* @修改人:Lynn Wang
* @updateTime:2018年1月17日 下午11:37:38
* @version:
 */
public class ContentServiceImpl implements ContentService {
	
	@Value("${REST_BASE_URL}")
	private String REST_BASE_URL;
	@Value("${REST_INDEX_AD_URL}")
	private String REST_INDEX_AD_URL;
	
	@Override
	public String getContentList() {
		// 调用服务层的服务
		String result = HttpClientUtil.doGet(REST_BASE_URL+ REST_INDEX_AD_URL);
		try {
			
			//把字符串转化为TaotaoResult
			TaotaoResult taotaoResult = TaotaoResult.formatToList(result, TbContent.class);
			//取内容列表
			List<TbContent> list = (List<TbContent>) taotaoResult.getData();
			List<Map> resultList = new ArrayList<>();
			//创建一个jsp页码要求的pojo列表
			for (TbContent item : list) {
				Map map = new HashMap<>();
				map.put("src", item.getPic());
				map.put("height", 240);
				map.put("width", 670);
				map.put("srcB", item.getPic2());
				map.put("widthB", 550);
				map.put("heightB", 240);
				map.put("href", item.getUrl());
				map.put("alt", item.getSubTitle());
				resultList.add(map);
			}
			return JsonUtils.objectToJson(resultList);
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return null;
	}

}
