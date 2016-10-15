package com.sanji.sjzx.members.dao;

import java.util.List;

import com.sanji.sjzx.model.MembersBlackList;;

public interface MembersBlackListMapper {

	
	/**
	 * 查询黑名单列表
	 * @Title: gainMembersList
	 * @Description:TODO
	 * @param @param members
	 * @param @return
	 * @return List<Members>
	 * @author Administrator
	 */
	public List<MembersBlackList> gainMembersBlackList();
}
