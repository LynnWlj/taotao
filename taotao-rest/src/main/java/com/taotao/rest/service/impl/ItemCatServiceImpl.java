package com.taotao.rest.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taotao.mapper.TbItemCatMapper;
import com.taotao.pojo.TbItemCat;
import com.taotao.pojo.TbItemCatExample;
import com.taotao.pojo.TbItemCatExample.Criteria;
import com.taotao.rest.pojo.CatNode;
import com.taotao.rest.pojo.CatResult;
import com.taotao.rest.service.ItemCatService;
/**
 * 商品分类服务
 * @author Administrator
 *
 */
@Service
public class ItemCatServiceImpl implements ItemCatService {
	@Autowired
	TbItemCatMapper TbItemCatMapper;

	@Override
	public CatResult getItemCatList() {
		// TODO Auto-generated method stub
		CatResult catResult = new CatResult();
		catResult.setData(getCatList(0));
		return catResult;
	}

	public List<?> getCatList(long parentId){
		//创造查询条件
		TbItemCatExample example = new TbItemCatExample();
		Criteria criteria = example.createCriteria();
		criteria.andParentIdEqualTo(parentId);
		List<TbItemCat> list = TbItemCatMapper.selectByExample(example);
		
		List nodeList = new ArrayList<>();	
		int count = 0;
			//返回值list
			for (TbItemCat itemCat : list) {
				//判断是否为父节点
				if (itemCat.getIsParent()) {
					CatNode catNode = new CatNode();
					
					if (parentId == 0) {
						
						catNode.setName("<a href='/products/"+itemCat.getId()+".html'>"+itemCat.getName()+"</a>");
					} else {
						catNode.setName(itemCat.getName());
					}
					catNode.setUrl("/products/"+itemCat.getId()+".html");
					catNode.setItems(getCatList(itemCat.getId()));
					nodeList.add(catNode);
					count++;
					if (parentId == 0 && count >=14) {
						break;
					}
					//如果是叶子节点
				} else {
					nodeList.add("/products/"+itemCat.getId()+".html|" + itemCat.getName());
				}	
			}
		
		return nodeList;
	}
	
	
}







