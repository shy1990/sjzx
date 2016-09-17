package com.sanji.sjzx.members.action;

import java.io.InputStream;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ModelDriven;
import com.sanji.sjzx.common.util.BaseAction;
import com.sanji.sjzx.members.service.MembersPriceService;
import com.sanji.sjzx.model.MembersPrice;
import com.sanji.sjzx.pojo.SessionInfo;
@Namespace("/members")
@Action(value = "membersPriceAction",results = {
		@Result(name = "toMembersPriceList", location ="/admin/members/memberPricelist.jsp"),
		@Result(name = "exportExcel",type= "stream" ,
		params = {
			"contentType"," application/vnd.ms-excel",
	        "inputName","excelStream",
	        "contentDisposition","attachment;filename=\"membersPrice.xls\"",
	        "bufferSize","1024"})
		})
public class MembersPriceAction extends BaseAction implements ModelDriven<MembersPrice> {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final Logger log = Logger.getLogger(MembersPriceAction.class);
	private MembersPrice membersPrice = new MembersPrice() ;
	private SessionInfo sInfo = null;
	private InputStream excelStream;
	public InputStream getExcelStream() {
		return excelStream;
	}


	public void setExcelStream(InputStream excelStream) {
		this.excelStream = excelStream;
	}


	@Resource
	private MembersPriceService membersPriceService;
	
	
	/**
	 * 功能说明：导出客户价格
	 */
	public String exportMemberPriceExcel(){
		List<MembersPrice> list = membersPriceService.gainMemberPriceByExport(membersPrice);
			excelStream = membersPriceService.exportMemberPriceToExcel(list);// 导出excel表格
		
		return "exportExcel";
	}
	
	
	/**
	 * 跳转到会员列表页面
	 * @Title: toMembersPriceList
	 * @Description:TODO
	 * @param @return
	 * @return String
	 * @author Administrator
	 */
	public String toMembersPriceList(){
		
		return "toMembersPriceList";
	}
	/**
	 * 获取会员列表
	 * @return
	 */
	public void gainMembersPriceList(){
		try{
			super.writeJson(membersPriceService.gainMembersPriceList(membersPrice));
		}catch(Exception e){
			e.printStackTrace();
			log.error("gainMembersPriceList() occur error. ",e);
		}
	}



	public MembersPrice getModel() {
		/*if( null == membersPrice ){
			membersPrice = new MembersPrice();
		}*/
		return membersPrice;
	}

}
