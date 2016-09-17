package com.sanji.sjzx.goodsLabel.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sanji.sjzx.goodsLabel.dao.GoodsLabelMapper;
import com.sanji.sjzx.goodsLabel.service.GoodsLabelService;
import com.sanji.sjzx.model.GoodsLabel;
/**
 * @ClassName: GoodsLabelServiceImpl
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author ZhouZhangbao
 * @date 2014-9-6 下午15:11
 */
@Service("goodsLabelService")
@Transactional(rollbackFor = Exception.class)
public class GoodsLabelServiceImpl implements GoodsLabelService {
	@Resource
	private GoodsLabelMapper goodsLabelMapper;
	/**
	 * (non-Javadoc)
	 * @Title:existLabelIsused
	 * @Description: TODO(判断标签是否正在使用)
	 * @param ids
	 * @return void
	 */
	public boolean existLabelIsused(List<String> ids) {
		List<String> glList  = goodsLabelMapper.gainGoodsLabelByIds(ids);
		for(String glid : glList){
			if(glid != null && !"".equals(glid)){
				return false;
			}
		}
		return true;
	}

}
