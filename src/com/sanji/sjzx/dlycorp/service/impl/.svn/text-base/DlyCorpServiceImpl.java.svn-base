package com.sanji.sjzx.dlycorp.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sanji.sjzx.dlycorp.dao.DlyCorpMapper;
import com.sanji.sjzx.dlycorp.service.DlyCorpService;
import com.sanji.sjzx.model.DlyCorp;
import com.sanji.sjzx.pojo.DataGrid;

/**
 * @ClassName: DlyCorpServiceImpl
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author ZhouZhangbao
 * @date 2014-9-6 下午15:11
 */
@Service("dlyCorpService")
@Transactional(rollbackFor=Exception.class)
public class DlyCorpServiceImpl implements DlyCorpService {
	@Resource
	private DlyCorpMapper dlyCorpMapper;
	/**
	 * (non-Javadoc)
	 * @Title:gainDlyCorpList
	 * @Description: TODO(获取物流公司列表(分页))
	 * @param dlyCorp
	 * @return
	 */
	public DataGrid gainDlyCorpList(DlyCorp dlyCorp) {
		DataGrid j = new DataGrid();
		j.setRows( dlyCorpMapper.gainDlyCorpList(dlyCorp));
		j.setTotal(dlyCorpMapper.gainDlyCorpCount(dlyCorp));
		return j;
	}
	/**
	 * (non-javadoc)
	 * @Title:addDlyCorp
	 * @Description: TODO(增加物流公司)
	 * @param dlyCorp
	 * @return void
	 */
	public void addDlyCorp(DlyCorp dlyCorp) {
		dlyCorpMapper.insertSelective(dlyCorp);
		
	}
	/**
	 * (non-javadoc)
	 * @Title:deleteDlyCorpById
	 * @Description: TODO(根据主键id单条或批量删除物流公司(逻辑删除))
	 * @param ids
	 * @return void
	 */
	public void deleteDlyCorpById(List<String> ids) {
			dlyCorpMapper.deleteDlyCorpByIds(ids);
	}
	/**
	 * (non-javadoc)
	 * @Title:dropDlyCorpById
	 * @Description: TODO(根据主键id单条或批量删除物流公司(物理删除))
	 * @param ids
	 * @return void
	 */
	public void dropDlyCorpById(List<String> ids) {
		dlyCorpMapper.dropDlyCorpByIds(ids);
		
	}
	/**
	 * (non-javadoc)
	 * @Title:modifyDlyCorp
	 * @Description:TODO(修改物流公司)
	 * @param dlyCorp
	 * @return void
	 */
	public void modifyDlyCorp(DlyCorp dlyCorp) {
		dlyCorpMapper.modifyDlyCorp(dlyCorp);
		
	}
	
	/**
	 * (non-javadoc)
	 * @Title:gainIsExistName
	 * @Description:TODO(根据名称和主键验证物流公司是否存在)
	 * @param name and id
	 * @return boolean
	 */
	@SuppressWarnings("unchecked")
	public boolean gainIsExistName(String name ,String id) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("name", name);
		map.put("id", id);
		Long dnum = (Long)dlyCorpMapper.existDlyCorpByMap(map);
		if(dnum >= 1){
			return false;
		}
		return true;
	}
	
	/**
	 * (non-javadoc)
	 * @Title:getMaxId
	 * @Description:TODO(获得最大排行数)
	 * @param name
	 * @return boolean
	 */	
	public int getMaxOrderNum(){
		int maxId = dlyCorpMapper.gainLastDlyCorp();
		if(maxId > 0){
			return maxId;
		}
		return 0;
	}
	
	/**
	 * (non-javadoc)
	 * @Title:danDlyCorpById
	 * @Description:TODO(单条或批量禁用)
	 * @param name
	 * @return boolean
	 */	
	public void danDlyCorpById(List<String> ids) {
		dlyCorpMapper.danDlyCorpById(ids);
		
	}
	/**
	 * (non-javadoc)
	 * @Title:openDlyCorpById
	 * @Description:TODO(单条或批量启用)
	 * @param ids
	 * @return boolean
	 */	
	public void openDlyCorpById(List<String> ids) {
		// TODO Auto-generated method stub
		dlyCorpMapper.openDlyCorpById(ids);
	}
	/**
	 * (non-javadoc)
	 * @Title:openDlyCorpById
	 * @Description:TODO(单条或批量启用)
	 * @param ids
	 * @return boolean
	 */	
	@SuppressWarnings("unchecked")
	public List<DlyCorp> gainDlyCorpListAll(DlyCorp dlyCorp) {
		List<DlyCorp>	DList = dlyCorpMapper.gainDlyCorpList(dlyCorp);
	     if(DList != null && !"".equals(DList)){
	    	 return DList;
	     }
		return null;
	}

}
