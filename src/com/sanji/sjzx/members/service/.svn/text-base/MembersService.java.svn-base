package com.sanji.sjzx.members.service;


import java.io.InputStream;
import java.util.List;

import com.sanji.sjzx.model.Accessories;
import com.sanji.sjzx.model.Apps;
import com.sanji.sjzx.model.Members;
import com.sanji.sjzx.model.MembersGoodsShow;
import com.sanji.sjzx.pojo.DataGrid;

/**
 * 获取所有用户信息
 * @author Administrator
 *
 */
public interface MembersService {
	
	/**
	 * 获取会员列表
	 * @Title: gainMembersList
	 * @Description:TODO
	 * @param @param members
	 * @param @return
	 * @return DataGrid
	 * @author Administrator
	 */
	public DataGrid gainMembersList(Members members);
	
	/**
	 * 批量删除（逻辑删除）
	 * @Title: deleteMembers
	 * @Description:TODO
	 * @param @param ids
	 * @return void
	 * @author Administrator
	 */
	public void deleteMembers(List<String> ids);
	
	/**
	 * 批量删除HDFK用户（物理删除）
	 * @Title: deleteBlackMembers
	 * @Description:TODO
	 * @param @param ids
	 * @return void
	 * @author Administrator
	 */
	public void deleteBlackMembers(List<String> ids);
	
	/**
	 * 根据条件进行查询
	 * @param map
	 * @return
	 */
	//public Members gainListByCondition(Map<String, Object> map);
	
	/**
	 * 添加时根据用户名查询是否存在此用户
	 * @Title:gainMembersByName
	 * @Description:TODO(这里用一句话描述这个方法的作用)
	 * @param @param name
	 * @param @return 设定文件
	 * @return boolean 返回类型
	 * @throws
	 * @param name
	 * @return
	 */
	public boolean gainMembersByName(String username);
	
	/**
	 * 根据手机号码更新地域类型
	* @Title: updateAtypeByMobile
	* @Description: TODO(这里用一句话描述这个方法的作用)
	* @param @param mobile    设定文件
	* @return void    返回类型
	* @author peter
	 */
	public void updateAtypeByMobile(Members member);
	
	/**
	 * 根据ID进行查询
	 */
	public Members gainMembersById(String id);
	/**
	 * 根据用户名进行查询
	 */
	public Members gainMemberByUsername(String userName);
	/**
	 * 添加不可见单品
	 */
	public void addVisibleSku(MembersGoodsShow membersGoodsShow,String ids, List<String> stringConvertList);
	/**
	 * 根据用户id查询不可见单品id集合
	 */
	public List<MembersGoodsShow> gainMembersGoodsByMembersId(
			List<String> stringConvertList);
	/**
	 * 获取未开发移动用户列表
	 */
	public DataGrid gainDisabledMembersList(Members members);
	/**
	 * 未开发移动用户设置为注册用户
	 */
	public void enableMembersById(List<String> stringConvertList);
	
	/**
	 * 根据memberId查询相应记录
	 * @Title:gainBlackMembersById
	 * @Description:TODO(这里用一句话描述这个方法的作用)
	 * @param @param memberId
	 * @param @return 设定文件
	 * @return List<Members> 返回类型
	 * @throws
	 * @param memberId
	 * @return
	 */
	public List<Members> gainBlackMembersById(String memberId);
	
	/**
	 * 批量插入（货到付款黑名单）
	 * @Title: insertBlackMembers
	 * @Description:TODO
	 * @param @param ids
	 * @return void
	 * @author Administrator
	 */
	public void insertBlackMembers(List<String> ids);
	
	/**
	    * 根据条件进行查询获取members数据用于导出
	    * @Title:gainMembersByExport
	    * @Description:TODO(这里用一句话描述这个方法的作用)
	    * @param @param members
	    * @param @return 设定文件
	    * @return List<Members> 返回类型
	    * @throws
	    * @param members
	    * @return
	    */
	public List<Members> gainMembersByExport(Members members);
	   
	/**
	    * 流
	    * @Title:exportDateToExcel
	    * @Description:TODO(这里用一句话描述这个方法的作用)
	    * @param @param list
	    * @param @return 设定文件
	    * @return InputStream 返回类型
	    * @throws
	    * @param list
	    * @return
	    */
	   InputStream exportDateToExcel(List<?> list);
	   /**
	    * 根据区域id查询members
	    * @Title:gainMembersByRegions
	    * @Description:TODO(这里用一句话描述这个方法的作用)
	    * @param @param members
	    * @param @return 设定文件
	    * @return List<Members> 返回类型
	    * @throws
	    * @param members
	    * @return
	    */

	  public  List<Members> gainMembersByRegions(String areaid);
}
