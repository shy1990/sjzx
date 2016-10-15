package com.sanji.sjzx.members.dao;

import java.util.List;
import java.util.Map;

import com.sanji.sjzx.model.MembersPrice;

public interface MembersPriceMapper {
	/**
	 * 获取所有节点数据
	 * @Title:gainAllMembersPrice
	 * @Description:TODO(这里用一句话描述这个方法的作用)
	 * @param @return 设定文件
	 * @return List<MembersPrice> 返回类型
	 * @throws
	 * @return
	 */
	public List<MembersPrice> gainAllMembersPrice();
	/**
	 * 添加地域价格信息
	 * @Title:addMembersPrice
	 * @Description:TODO(这里用一句话描述这个方法的作用)
	 * @param @param MembersPrice 设定文件
	 * @return void 返回类型
	 * @throws
	 * @param MembersPrice
	 */
	public void addMembersPrice(MembersPrice membersPrice);
	/**
	 * 根据单品id即goodsSkuId修改地域价格信息
	 * @Description:TODO(这里用一句话描述这个方法的作用)
	 * @param @param id 设定文件
	 * @return void 返回类型
	 * @throws
	 * @param id
	 */
	public void updateMembersPriceBySkuId(MembersPrice membersPrice);
	/**
	 * 根据单品id即goodsSkuId获取该单品相应的地域价格信息
	 * @Title:gainMembersPriceBySkuId
	 * @Description:TODO(这里用一句话描述这个方法的作用)
	 * @param @param skuId
	 * @param @return 设定文件
	 * @return List<MembersPrice> 返回类型
	 * @throws
	 * @param skuId
	 * @return
	 */
	public List<MembersPrice> gainMembersPriceBySkuId(String goodsSkuId);
	
	/**
	 * 根据订单区域价格id修改地域价格信息
	 * @param MembersPrice
	 */
	void updateMembersPriceById(MembersPrice membersPrice);
	/**
	 * 获取客户价格列表
	 * @param MembersPrice
	 */
	public List gainMembersPriceList(MembersPrice membersPrice);
	/**
	 * 获取客户价格总记录数
	 * @param MembersPrice
	 */
	public Long gainMembersPriceCount(MembersPrice membersPrice);
	
	public List<MembersPrice> gainMemberPriceByExport(MembersPrice membersPrice);
	
	public List<MembersPrice> gainMembersPriceBySkuIdAndRegion(String goodsSkuId,
			String region);
	public List<MembersPrice> gainMembersPriceBySkuIdAndRegion(
			Map<String, String> map);
	
	
	
}