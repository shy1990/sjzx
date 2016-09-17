package com.sanji.sjzx.members.service;

import java.io.InputStream;
import java.util.List;

import com.sanji.sjzx.model.MembersPrice;
import com.sanji.sjzx.pojo.DataGrid;

public interface MembersPriceService {
	
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
	public List<MembersPrice> gainMembersPriceBySkuId(String skuId);
	/**
	 * 根据订单区域价格id修改地域价格信息
	 * @param MembersPrice
	 */
	public void updateMembersPriceById(MembersPrice membersPrice);

	public DataGrid gainMembersPriceList(MembersPrice memberPrice);

	public List<MembersPrice> gainMemberPriceByExport(MembersPrice membersPrice);

	public InputStream exportMemberPriceToExcel(List<?> list);

	public List<MembersPrice> gainMembersPriceBySkuId(String skuId,
			String areaid);
}
