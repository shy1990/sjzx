package com.sanji.sjzx.members.service.impl;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import jxl.Workbook;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sanji.sjzx.members.dao.MembersPriceMapper;
import com.sanji.sjzx.members.service.MembersPriceService;
import com.sanji.sjzx.model.MembersPrice;
import com.sanji.sjzx.pojo.DataGrid;


@Service("membersPriceService")
@Transactional(rollbackFor=Exception.class)
public class MembersPriceServiceImpl implements MembersPriceService {

	@Resource
	private MembersPriceMapper membersPriceMapper;
	/**
	 * 添加地域价格信息
	 */
	public void addMembersPrice(MembersPrice membersPrice) {
		membersPriceMapper.addMembersPrice(membersPrice);
	}
    /**
     * 获取所有节点数据
     */
	public List<MembersPrice> gainAllMembersPrice() {
		return membersPriceMapper.gainAllMembersPrice();
	}
	/**
	 * 根据单品id即goodsSkuId修改地域价格信息
	 */
	public void updateMembersPriceBySkuId(MembersPrice membersPrice) {
		membersPriceMapper.updateMembersPriceBySkuId(membersPrice);
	}
	/**
	 * 根据单品id即goodsSkuId获取相应单品的地域价格
	 */
	public List<MembersPrice> gainMembersPriceBySkuId(String skuId) {
		return membersPriceMapper.gainMembersPriceBySkuId(skuId);
	}
	
	public void updateMembersPriceById(MembersPrice membersPrice) {
		 membersPriceMapper.updateMembersPriceById(membersPrice);
	}
	/**
	 * 获取客户价格列表
	 */
	public DataGrid gainMembersPriceList(MembersPrice membersPrice) {
		DataGrid j=new DataGrid();
		j.setRows(membersPriceMapper.gainMembersPriceList(membersPrice));
		j.setTotal(membersPriceMapper.gainMembersPriceCount(membersPrice));
		return j;
	}
	
	public List<MembersPrice> gainMemberPriceByExport(MembersPrice membersPrice) {
	
		return  membersPriceMapper.gainMemberPriceByExport(membersPrice);
	}
	/**
	 * 流
	 */
	public InputStream exportMemberPriceToExcel(List<?> list) {
		if(list==null){
			try {
				throw new Exception("list is null in exportDateToExcel method,it mustn't be null.");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		ByteArrayOutputStream out = new ByteArrayOutputStream();   
		putMemberPriceDataOnOutputStream(out,list);   
		return new ByteArrayInputStream(out.toByteArray());
	}
	
	/**
	 * 流
	 * @Title:putMemberPriceDataOnOutputStream
	 * @Description:TODO(这里用一句话描述这个方法的作用)
	 * @param @param os
	 * @param @param list 设定文件
	 * @return void 返回类型
	 * @throws
	 * @param os
	 * @param list
	 */
  
	private void putMemberPriceDataOnOutputStream(ByteArrayOutputStream os,List<?> list) {
		if(list==null)
			try {
				throw new Exception("list is null in exportDateToExcel method,it mustn't be null.");
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		String createTime;
		WritableWorkbook workbook;
		try {
			workbook = Workbook.createWorkbook(os);
			WritableSheet sheet = workbook.createSheet("Sheet1", 0);
			sheet.getSettings().setDefaultColumnWidth(25);
			sheet.addCell(new jxl.write.Label(0, 0, "当前时间"));
			sheet.addCell(new jxl.write.Label(1, 0, "所在区域"));
			sheet.addCell(new jxl.write.Label(2, 0, "门店名称"));
			sheet.addCell(new jxl.write.Label(3, 0, "商品名称"));
			sheet.addCell(new jxl.write.Label(4, 0, "颜色"));
			sheet.addCell(new jxl.write.Label(5, 0, "成本价"));
			sheet.addCell(new jxl.write.Label(6, 0, "原供价"));
			sheet.addCell(new jxl.write.Label(7, 0, "调整年时间"));
			sheet.addCell(new jxl.write.Label(8, 0, "操作人"));
			sheet.addCell(new jxl.write.Label(9, 0, "调后价格"));
			sheet.addCell(new jxl.write.Label(10, 0, "品日提货量"));
			sheet.addCell(new jxl.write.Label(11, 0, "总提货量"));
	        //循环遍历到数据集
	        for(int i= 0;i<list.size();i++){
	        	MembersPrice membersPrice = (MembersPrice) list.get(i);
	        	SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	        	if(null != membersPrice.getCreateTime()){
	        		 createTime=sdf.format(membersPrice.getCreateTime());
	        	}else{
	        		 createTime = "";
	        	}
	        	
	        	sheet.addCell(new jxl.write.Label(0,i+1 ,membersPrice.getCurrentTime()+""));
	        	sheet.addCell(new jxl.write.Label(1,i+1 ,membersPrice.getPcat()));
	        	sheet.addCell(new jxl.write.Label(2,i+1 ,membersPrice.getUserName()));
	        	sheet.addCell(new jxl.write.Label(3,i+1 ,membersPrice.getGoodsName()));
	        	sheet.addCell(new jxl.write.Label(4,i+1 ,membersPrice.getColorName()));
	        	sheet.addCell(new jxl.write.Label(5,i+1 ,membersPrice.getPrice()));
	        	sheet.addCell(new jxl.write.Label(6,i+1 ,membersPrice.getOriginalPrice()));
	        	sheet.addCell(new jxl.write.Label(7,i+1 ,createTime));
	        	sheet.addCell(new jxl.write.Label(8,i+1 ,membersPrice.getOverMan()));
	        	sheet.addCell(new jxl.write.Label(9,i+1 ,membersPrice.getAfterFloatPrice()));
	        	sheet.addCell(new jxl.write.Label(10,i+1 ,String.valueOf(membersPrice.getItemNum())));
	        	sheet.addCell(new jxl.write.Label(11,i+1 ,String.valueOf(membersPrice.getTotalNum())));
	        }
			workbook.write();
			workbook.close();
		} catch (Exception e) {
			try {
				throw new Exception("putMemberPriceDataOnOutputStream has some error:",e);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
	}
	/**
	 * 根据goodsSku 和 areaid 查询 客户价格
	 */
	public List<MembersPrice> gainMembersPriceBySkuId(String skuId,
			String areaid) {
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("goodsSkuId", skuId);
		map.put("region", areaid);
	    return membersPriceMapper.gainMembersPriceBySkuIdAndRegion(map);
	}
}
