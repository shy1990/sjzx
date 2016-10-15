package com.sanji.sjzx.members.dao;

import java.util.List;

import com.sanji.sjzx.model.Accessories;
import com.sanji.sjzx.model.Apps;
import com.sanji.sjzx.model.Members;

/**
 * @author Administrator
 *
 */
public interface MembersMapper {
  		
	/**
	 * 查询会员列表
	 * @Title: gainMembersList
	 * @Description:TODO
	 * @param @param members
	 * @param @return
	 * @return List<Members>
	 * @author Administrator
	 */
	public List<Members> gainMembersList(Members members);
	
	/**
	 * 获取总条数
	 * @Title: gainMembersCount
	 * @Description:TODO
	 * @param @param members
	 * @param @return
	 * @return Long
	 * @author Administrator
	 */
	public Long gainMembersCount(Members members);
	
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
	 * 根据条件查询会员信息
	 * @param id
	 * @return
	 */
	public Members gainMembersById(String id);
	
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
	 * 批量插入
	 * @Title: insertBlackMembers
	 * @Description:TODO
	 * @param @param ids
	 * @return void
	 * @author Administrator
	 */
	public void insertBlackMembers(String id);
	
	/**
	 * 根据条件查询会员信息
	 * @param userName
	 * @return
	 */
	public Members gainMembersByUsername(String userName);
	/**
	 * 根据用户Id查询会员信息
	 * @param userId
	 * @return
	 */
	public Members selectByPrimaryKey(String userId);
	/**
	 * 更新会员信息
	 * @param userId
	 * @return
	 */
	public void updateByPrimaryKey(Members member);
	/**
	 * 获取未开发移动客户列表
	 * @param userId
	 * @return
	 */
	public List gainDisabledMembersList(Members members);
	/**
	 * 获取未开发移动客户总行数
	 * @param userId
	 * @return
	 */
	public Long gainDisabledMembersCount(Members members);
	/**
	 * 未开发移动客户设置为注册用户
	 * @param userId
	 * @return
	 */
	public void enableMembersById(List<String> ids);
	
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
	public List<Members> gainMembersByName(String username);
	
	/**
	 * 根据手机号更新地域类型
	 * @Title: updateAtypeByMobile
	 * @Description:TODO(这里用一句话描述这个方法的作用)
	 * @param @param mobile
	 * @param @return 设定文件
	 * @return void 返回类型
	 * @throws
	 * @param mobile
	 * @return
	 */
	public void updateAtypeByMobile(Members member);
	

	public List<Members> gainMembersByRegions(String areaid);

}