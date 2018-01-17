package com.taotao.rest.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 * 
* 项目名称：taotao-rest
* 类名称：ContentServiceImpl
* 类描述：
* @author:Lynn Wang
* @createdTime:2018年1月15日 下午7:45:06
* @修改人:Lynn Wang
* @updateTime:2018年1月15日 下午7:45:06
* @version:
 */

import com.taotao.mapper.TbContentMapper;
import com.taotao.pojo.TbContent;
import com.taotao.pojo.TbContentExample;
import com.taotao.pojo.TbContentExample.Criteria;
import com.taotao.rest.service.ContentService;
@Service
public class ContentServiceImpl implements ContentService{

	@Autowired
	private TbContentMapper tbcontentmapper;
	@Override
	public List<TbContent> getContentList(long categoryId) {
		//根据内容分类id查询内容列表
		TbContentExample example = new TbContentExample();
		Criteria criteria = example.createCriteria();
		criteria.andCategoryIdEqualTo(categoryId);
		//执行查询
		List<TbContent> list = tbcontentmapper.selectByExample(example);
		
		return list;

	}
}
