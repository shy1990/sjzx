package com.sanji.sjzx.system.friendlylink.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.sanji.sjzx.model.FriendlyLink;
import com.sanji.sjzx.pojo.DataGrid;
import com.sanji.sjzx.system.friendlylink.dao.FriendlyLinkMapper;
import com.sanji.sjzx.system.friendlylink.service.FriendlyLinkService;

/**
 * @ClassName: FriendlyLinkServiceImpl
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author ZhouZhangbao
 * @date 2014-9-6 下午15:11
 */
@Service("friendlyLinkService")
@Transactional(rollbackFor=Exception.class)
public class FriendlyLinkServiceImpl implements FriendlyLinkService {
	@Resource
	private FriendlyLinkMapper friendlyLinkMapper;
	/**
	 * (non-Javadoc)
	 * @Title:gainFriendlyLinkList
	 * @Description: TODO(获取友情链接公司列表(分页))
	 * @param riendlyLink
	 * @return	DataGrid
	 */
	public DataGrid gainFriendlyLinkList(FriendlyLink friendlyLink) {
		DataGrid j = new DataGrid();
		j.setRows( friendlyLinkMapper.gainFriendlyLinkList(friendlyLink));
		j.setTotal(friendlyLinkMapper.gainFriendlyLinkCount(friendlyLink));
		return j;
	}
	/**
	 * (non-javadoc)
	 * @Title:addFriendlyLink
	 * @Description: TODO(增加友情链接公司)
	 * @param friendlyLink
	 * @return void
	 */
	public void addFriendlyLink(FriendlyLink friendlyLink) {
		friendlyLinkMapper.insertSelective(friendlyLink);
		
	}
	/**
	 * (non-javadoc)
	 * @Title:deleteFriendlyLinkById
	 * @Description: TODO(根据主键id单条或批量删除友情链接公司(逻辑删除))
	 * @param ids
	 * @return void
	 */
	public void deleteFriendlyLinkById(List<String> ids) {
			friendlyLinkMapper.deleteFriendlyLinkByIds(ids);
	}
	/**
	 * (non-javadoc)
	 * @Title:dropFriendlyLinkById
	 * @Description: TODO(根据主键id单条或批量删除友情链接公司(物理删除))
	 * @param ids
	 * @return void
	 */
	public void dropFriendlyLinkById(List<String> ids) {
		friendlyLinkMapper.dropFriendlyLinkByIds(ids);
		
	}
	/**
	 * (non-javadoc)
	 * @Title:modifyFriendlyLink
	 * @Description:TODO(修改友情链接公司)
	 * @param friendlyLink
	 * @return void
	 */
	public void modifyFriendlyLink(FriendlyLink friendlyLink) {
		friendlyLinkMapper.modifyFriendlyLink(friendlyLink);
		
	}

	
	/**
	 * (non-javadoc)
	 * @Title:gainIsExistName
	 * @Description:TODO(根据名称和主键验证友情链接公司公司是否存在)
	 * @param name
	 * @return boolean
	 */
	@SuppressWarnings("unchecked")
	public boolean gainIsExistName(String name , String id) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("name", name);
		map.put("id", id);
		Long fnum = (Long)friendlyLinkMapper.existFriendlyLinkByMap(map);
		if(fnum >= 1){
			return false;
		}else{
			return true;
		}
		
	}
	
	/**
	 * (non-javadoc)
	 * @Title:getMaxOrderNum
	 * @Description:TODO(获得最大排行数)
	 * @param name
	 * @return boolean
	 */	
	public int getMaxOrderNum(){
		int maxId = friendlyLinkMapper.gainLastFriendlyLink();
		if(maxId > 0){
			return maxId;
		}
		return 0;
	}
	/**
	 * (non-javadoc)
	 * @Title:gainFriendlyLinkById
	 * @Description:TODO(根据主键查询友情链接公司，返回imageUrl)
	 * @param name
	 * @return boolean
	 */	
	public String gainFriendlyLinkByIdForImageUrl(String id) {
		String img = friendlyLinkMapper.gainFriendlyLinkByIdForImageUrl(id);
		if(null != img && !"".equals(img)){
			return img;
		}
		return null;
	}
	

}
