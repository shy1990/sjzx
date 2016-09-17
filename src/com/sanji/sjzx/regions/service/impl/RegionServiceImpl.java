/**  
* @Title: RegionServiceImpl.java
* @Package com.sanji.sjzx.regions.service.impl
* @Description: TODO(用一句话描述该文件做什么)
* @author ZhouZhangbao  
* @date 2015-2-5 上午11:22:18
* @version V1.0  
*/
package com.sanji.sjzx.regions.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sanji.sjzx.model.Regions;
import com.sanji.sjzx.regions.dao.RegionsMapper;
import com.sanji.sjzx.regions.service.RegionService;

/**
 * @ClassName: RegionServiceImpl
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author ZhouZhangbao
 * @date 2015-2-5 上午11:22:18
 */
@Service("regionService")
@Transactional(rollbackFor=Exception.class)
public class RegionServiceImpl implements RegionService {

	@Resource
	private RegionsMapper regionsMapper;
	
	/* (非 Javadoc)
	 * <p>Title: gainRegionByPid</p>
	 * <p>Description: </p>
	 * @param pid
	 * @return
	 * @see com.sanji.sjzx.regions.service.RegionService#gainRegionByPid(java.lang.String)
	 */

	public List<Regions> gainRegionByPid(String pid) {
		// TODO Auto-generated method stub
		Regions regions = new Regions();
		regions.setPid(pid);
		return regionsMapper.gainRegionByPid(regions);
	}
	
	/* (非 Javadoc)
	 * <p>Title: gainRegionByPid</p>
	 * <p>Description: </p>
	 * @param pid
	 * @return
	 * @see com.sanji.sjzx.regions.service.RegionService#gainRegionByPid(java.lang.String)
	 */

	public List<Regions> gainRegionByPid2(Regions regions) {
		return regionsMapper.gainRegionByPid2(regions);
	}

	/* (非 Javadoc)
	* <p>Title: gainReionById</p>
	* <p>Description: </p>
	* @param string
	* @return
	* @see com.sanji.sjzx.regions.service.RegionService#gainReionById(java.lang.String)
	*/
	
	public List<Regions> gainReionById(String id) {
		try {
			Regions regions = new Regions();
			regions.setId(id);
			return regionsMapper.gainReionById(regions);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	/**
	 * 获取省市区信息树
	 */
	public List<Regions> gainRegionsList(Regions regions) {
		return regionsMapper.gainRegionsList(regions);
	}

	public List<Regions> gainRegionsListByPid(Regions regions) {
		return regionsMapper.gainRegionByPid2(regions);
	}

	public Long gainRegionsForExsitChild(String id) {
		// TODO Auto-generated method stub
		return regionsMapper.gainCountForRegainsChild(id);
	}


}
