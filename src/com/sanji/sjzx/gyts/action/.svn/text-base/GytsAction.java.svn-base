package com.sanji.sjzx.gyts.action;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
//import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ModelDriven;
import com.sanji.sjzx.common.util.BaseAction;
import com.sanji.sjzx.common.util.EcErpUtil;
import com.sanji.sjzx.common.util.ToolsUtil;
import com.sanji.sjzx.gyts.service.GytsService;
import com.sanji.sjzx.model.Gyts;
import com.sanji.sjzx.pojo.Json;

//1300034919076
@Namespace("/gyts")
@Action(value = "gytsAction", results = {
	@Result(name = "toGytsList",location = "/admin/gyts/list.jsp"),
	@Result(name = "toImport_Ex_orderData",location = "/admin/gyts/gyts_Ex_Import.jsp")
})
public class GytsAction extends BaseAction implements ModelDriven<Gyts>{
	/**
	 * @Fields serialVersionUID:TODO(用一句话描述这个变量表示什么)
	 */
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(GytsAction.class);
	private Gyts gyts = new Gyts();
	@Resource
	private GytsService gytsService;
	Date date = new Date();
	//SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//小写的mm表示的是分钟  
	//private boolean flag = false;
	/**
	 * 跳转到列表页面
	 */
	public String toGytsList(){
		return "toGytsList";
	}
	/**
	 * 获取推送订单分页列表
	 */
	public void gainGytsList(){
		try {
			super.writeJson(gytsService.gainGytsList(gyts));
		} catch (Exception e) {
			logger.error("gainGytsList() occur error. ", e);
			e.printStackTrace();
		}
	}
	/**
	 * 添加推送订单
	 */
	public void addGyts(){
		Json j = new Json();
		try {
			gyts.setId(ToolsUtil.getUUID());
			gytsService.addGyts(gyts);
			j.setObj(gyts);
			j.setMsg("添加成功!");
			j.setSuccess(true);				
		} catch (Exception e) {
			j.setMsg("添加失败!");
			j.setSuccess(false);
			logger.error("addGyts() occur error. ", e);
			e.printStackTrace();
		}	
		writeJson(j);
	}
	/**
	 * 跳转到导入页面
	 */
	public String toImport_Ex_orderData() {
		return "toImport_Ex_orderData";
	}
	/**
	 * 导入订单
	 * @throws ParseException 
	 */
	public void import_Ex_orderData() throws ParseException {
		Json json = new Json();
		try {
			String msg = "";
			boolean flag = false;
			int g=0;
			String target = ServletActionContext.getServletContext().getRealPath("");
			if (gyts.getMyFile() != null) {
				target = target + ToolsUtil.uploadFile(request, gyts.getMyFile(),
						"/attached/excel","xls,xlsx",gyts.getMyFileFileName());
				if(target.equals("")){
					this.uploadError("上传文件失败！","上传文件扩展名是不允许的扩展名。\n只允许xls,xlsx格式！");
					return ;
				}
				target=target.replace("../","/");
				target=target.replace("/","\\");
				InputStream is = new FileInputStream(target);  
			    Workbook rwb = Workbook.getWorkbook(is);  
			    //Sheet st = rwb.getSheet("0")这里有两种方法获取sheet表,1为名字，而为下标，从0开始  
			    Sheet st = rwb.getSheet("Sheet1");  
			    int rs=st.getColumns();  
			    int rows=st.getRows(); 
			    Gyts gyts;
			    System.out.println("列数===>"+rs+"   行数===>"+rows);  
			    for (int i = 1; i < rows; i++) {
			    	Cell c1 = st.getCell(0,i);
			    	String s1 = c1.getContents().trim();
			    	Cell c2 = st.getCell(1,i);
			    	String s2 = c2.getContents().trim();
			    	Cell c3 = st.getCell(2,i);
			    	String s3 = c3.getContents().trim();
			    	Cell c4 = st.getCell(3,i);
			    	String s4 = c4.getContents().trim();
			    	Cell c5 = st.getCell(4,i);
			    	String s5 = c5.getContents().trim();
			    	Cell c6 = st.getCell(5,i);
			    	String s6 = c6.getContents().trim();
			    	Cell c7 = st.getCell(6,i);
			    	String s7 = c7.getContents().trim();
			    	Cell c8 = st.getCell(7,i);
			    	String s8 = c8.getContents().trim();
			    	Cell c9 = st.getCell(8,i);
			    	String s9 = c9.getContents().trim();
			    	Cell c10 = st.getCell(9,i);
			    	String s10 = c10.getContents().trim();
			    	Cell c11 = st.getCell(10,i);
			    	String s11 = c11.getContents().trim();
			    	Cell c12 = st.getCell(11,i);
			    	String s12 = c12.getContents().trim();
			    	Cell c13 = st.getCell(12,i);
			    	String s13 = c13.getContents().trim();
			    	
			    	Cell c14 = st.getCell(13,i);
			    	String s14 = c14.getContents().trim();
			    	Cell c15 = st.getCell(14,i);
			    	String s15 = c15.getContents().trim();
			    	Cell c16 = st.getCell(15,i);
			    	String s16 = c16.getContents().trim();
			    	Cell c17 = st.getCell(16,i);
			    	String s17 = c17.getContents().trim();
			    	Cell c18 = st.getCell(17,i);
			    	String s18 = c18.getContents().trim();
			    	Cell c19 = st.getCell(18,i);
			    	String s19 = c19.getContents().trim();
			    	Cell c20 = st.getCell(19,i);
			    	String s20 = c20.getContents().trim();
			    	
			    	Cell c21 = st.getCell(20,i);
			    	String s21 = c21.getContents().trim();
			    	Cell c22 = st.getCell(21,i);
			    	String s22 = c22.getContents().trim();
			    	Cell c23 = st.getCell(22,i);
			    	String s23 = c23.getContents().trim();
			    	Cell c24 = st.getCell(23,i);
			    	String s24 = c24.getContents().trim();
			    	Cell c25 = st.getCell(24,i);
			    	String s25 = c25.getContents().trim();
			    	Cell c26 = st.getCell(25,i);
			    	String s26 = c26.getContents().trim();
			    	Cell c27 = st.getCell(26,i);
			    	String s27 = c27.getContents().trim();
			    	Cell c28 = st.getCell(27,i);
			    	String s28 = c28.getContents().trim();
			    	Cell c29 = st.getCell(28,i);
			    	String s29 = c29.getContents().trim();
			    	Cell c30 = st.getCell(29,i);
			    	String s30 = c30.getContents().trim();

			    	Cell c31 = st.getCell(30,i);
			    	String s31 = c31.getContents().trim();
			    	Cell c32 = st.getCell(31,i);
			    	String s32 = c32.getContents().trim();
			    	Cell c33 = st.getCell(32,i);
			    	String s33 = c33.getContents().trim();
			    	Cell c34 = st.getCell(33,i);
			    	String s34 = c34.getContents().trim();
			    	Cell c35 = st.getCell(34,i);
			    	String s35 = c35.getContents().trim();
			    	Cell c36 = st.getCell(35,i);
			    	String s36 = c36.getContents().trim();
			    	Cell c37 = st.getCell(36,i);
			    	String s37 = c37.getContents().trim();
			    	Cell c38 = st.getCell(37,i);
			    	String s38 = c38.getContents().trim();
			    	Cell c39 = st.getCell(38,i);
			    	String s39 = c39.getContents().trim();
			    	Cell c40 = st.getCell(39,i);
			    	String s40 = c40.getContents().trim();
			    	
			    	Cell c41 = st.getCell(40,i);
			    	String s41 = c41.getContents().trim();
			    	Cell c42 = st.getCell(41,i);
			    	String s42 = c42.getContents().trim();
			    	Cell c43 = st.getCell(42,i);
			    	String s43 = c43.getContents().trim();
			    	
		    		gyts = new Gyts();
		    		gyts.setId(ToolsUtil.getUUID());
		    		gyts.setMail(s1);
		    		gyts.setItem(s2);
		    		gyts.setPrice(s3);
		    		gyts.setSku(s4);
		    		gyts.setNums(s5);
		    		gyts.setReceiverName(s6);
		    		gyts.setReceiverAddress(s7);
		    		gyts.setReceiverState(s8);
		    		gyts.setReceiverCity(s9);
		    		gyts.setReceiverDistrict(s10);
		    		gyts.setLogisticsType(s11);
		    		gyts.setOuterTid(s12);
		    		gyts.setOuterShopCode(s13);
		    		gyts.setAddTime(new java.sql.Timestamp(date.getTime()));
		    		
		    		gyts.setReceiverPhone(s14);
		    		gyts.setReceiverMobile(s15);
		    		gyts.setOuterDdly(s16);
		    		gyts.setBuyerMessage(s17);
		    		gyts.setStoreCode(s18);
		    		gyts.setReceiverZip(s19);
		    		gyts.setLogisticsFee(s20);
		    		
		    		gyts.setFptt(s21);
		    		gyts.setSyfp(s22);
		    		gyts.setLxdm(s23);
		    		gyts.setTicketNo(s24);
		    		gyts.setPayCodes(s25);
		    		gyts.setPayMoneys(s26);
		    		gyts.setPayDatatimes(s27);
		    		gyts.setAutosplit(s28);
		    		gyts.setTradeMemo(s29);
		    		gyts.setToverify(s30);
		    		
		    		gyts.setIsCod(s31);
		    		gyts.setYgdm(s32);
		    		gyts.setInvoiceContent(s33);
		    		gyts.setInvoiceAmount(s34);
		    		gyts.setInvoiceNumber(s35);
		    		gyts.setInvoiceDate(s36);
		    		gyts.setYfrq(s37);
		    		gyts.setTbBz(s38);
		    		gyts.setCodFee(s39);
		    		gyts.setTotalDiscountFee(s40);
		    		
		    		gyts.setPayTradeIds(s41);
		    		gyts.setPayAccounts(s42);
		    		gyts.setPayMemos(s43);
		    		
		    		/**
		    		 * 推送订单等待管易返回信息
		    		 * 返回map的key为：1 created-管易返回的创建订单时间 ；2 tid-管易所生产的订单号码 ；3 ERROR - 管易创建失败的原因
		    		 * 创建成功map中只有1和2，创建失败map中只有3
		             */
		    		Map<String, Object> map = EcErpUtil.OrderAddNew(gyts);
		    		if(map != null && map.size()>0){
			    		String created = (String) map.get("created");
			    		gyts.setCreated(created);
			    		String tid = (String) map.get("tid");
			    		gyts.setTid(tid);
			    		String error = (String) map.get("ERROR");
			    		gyts.setError(error);
			    		System.out.println("error=="+error);
			    		if(error == null || "".equals(error)){
			    			//如果为空
			    			//g=0;
			    			System.out.println(">>>>> if中 g=="+g);
			    		}else {
							//如果不为空，记录失败的记录数
			    			g++;
						}
			    	}
		    		gytsService.addGyts(gyts);		    		
		    		flag = true;
			    }
	    		if(g>0){
	    			msg = "导入完成,有"+g+"条失败记录，请看列表！";
	    		}else {
					msg = "导入完成！";
				}
			    json.setSuccess(flag);
			    json.setMsg(msg+"<br/>");
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (BiffException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}catch (Exception e) {
			json.setSuccess(false);
			json.setMsg("推送失败,请检查excel数据!");
			logger.error("import_Ex_orderData() occur error. ");
			//e.printStackTrace();
		}
		super.writeJson(json);
	}

	/**
	 * @Title: uploadError
	 * @Description: TODO上传失败
	 * @param @param err
	 * @param @param msg????设定文件
	 * @return void????返回类型
	 */
	private void uploadError(String err, String msg) {
		Map<String, Object> m = new HashMap<String, Object>();
		m.put("err", err);
		m.put("msg", msg);
		super.writeJson(m);
	}
	public static Logger getLogger() {
		return logger;
	}

	public Gyts getGyts() {
		return gyts;
	}

	public void setGyts(Gyts gyts) {
		this.gyts = gyts;
	}

	public Gyts getModel() {
		return gyts;
	}
}
