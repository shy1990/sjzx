package com.sanji.sjzx.members.dao;

import java.util.List;

import com.sanji.sjzx.model.MembersGoodsShow;


public interface MembersGoodsShowMapper {
    int insert(MembersGoodsShow record);

    int insertSelective(MembersGoodsShow record);

	void addVisibleSku(List<MembersGoodsShow> memberGoodsList);

	void dropMembersGoodsByMembersId(String mid);

	List<MembersGoodsShow> gainMembersGoodsByMembersId(List<String> ids);

	Long gainMembersGoodsBySkuId(List<String> skuIds);
}