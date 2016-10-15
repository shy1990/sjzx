package com.sanji.sjzx.members.service.impl;

import java.util.List;

import javax.annotation.Resource;

import com.sanji.sjzx.members.dao.MembersBlackListMapper;
import com.sanji.sjzx.members.service.MembersBlackListService;
import com.sanji.sjzx.model.MembersBlackList;

public class MembersBlackListServiceImpl implements MembersBlackListService{

	@Resource
	private MembersBlackListMapper mBlackListMapper;
	public List<MembersBlackList> gainAllMembersBlackList() {
		
		return mBlackListMapper.gainMembersBlackList();
	}

}
