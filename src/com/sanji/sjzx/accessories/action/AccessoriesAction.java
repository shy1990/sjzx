package com.sanji.sjzx.accessories.action;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
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
import com.sanji.sjzx.accessories.service.AccessoriesService;
import com.sanji.sjzx.appModel.service.AppModelService;
import com.sanji.sjzx.common.util.BaseAction;
import com.sanji.sjzx.common.util.ToolsUtil;
import com.sanji.sjzx.gift.service.GiftService;
import com.sanji.sjzx.goods.service.GoodsService;
import com.sanji.sjzx.model.Accessories;
import com.sanji.sjzx.model.AppModel;
import com.sanji.sjzx.model.Gift;
import com.sanji.sjzx.model.Goods;
import com.sanji.sjzx.pojo.Json;

@Namespace("/acc")
@Action(value = "accAction", results = {
		@Result(name = "toAccList", location = "/admin/accessories/list.jsp"),
		@Result(name = "toAdd",location="/admin/accessories/add.jsp"),
		@Result(name = "toUpdate",location="/admin/accessories/edit.jsp"),
		@Result(name = "toShelves",location="/admin/accessories/shelves.jsp"),
		@Result(name = "toEditPrice",location="/admin/accessories/editPrice.jsp"),
		@Result(name = "toImport_Ex_accData",location="/admin/accessories/acc_Ex_Import.jsp"),
		@Result(name = "exportExcel",type= "stream" ,
				params = {
					"contentType"," application/vnd.ms-excel",
			        "inputName","excelStream",
			        "contentDisposition","attachment;filename=\"acc.xls\"",
			        "bufferSize","1024"})})

public class AccessoriesAction extends BaseAction implements ModelDriven<Accessories>{
	/**
	 * @Fields serialVersionUID:TODO(用一句话描述这个变量表示什么)
	 */
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(AccessoriesAction.class);
	private Accessories a = new Accessories();
	private AppModel appModel = new AppModel();
	private Goods goods = new Goods();
	@Resource
	private AccessoriesService accessoriesService;
	@Resource
	private AppModelService appModelService;
	@Resource
	private GoodsService goodsService;
	@Resource
	private GiftService giftService;
	
	private boolean flag=false;
	Date date = new Date();//获取当前系统时间
	private InputStream excelStream;
	
	public InputStream getExcelStream() {
		return excelStream;
	}

	public void setExcelStream(InputStream excelStream) {
		this.excelStream = excelStream;
	}

	public Accessories getA() {
		return a;
	}

	public void setA(Accessories a) {
		this.a = a;
	}

	public Accessories getModel() {
		return a;
	}

	public AppModel getAppModel() {
		return appModel;
	}

	public void setAppModel(AppModel appModel) {
		this.appModel = appModel;
	}

	public Goods getGoods() {
		return goods;
	}

	public void setGoods(Goods goods) {
		this.goods = goods;
	}

	/**
	 * 跳转到配件列表页面
	 * @Title:toAccList
	 * @Description:TODO(这里用一句话描述这个方法的作用)
	 * @param @return 设定文件
	 * @return String 返回类型
	 * @throws
	 * @return
	 */
	public String toAccList(){
		return "toAccList";
	}
	/**
	 * 获取配件列表
	 */
	public void gainAccessoriesList(){
		try{
			super.writeJson(accessoriesService.gainAccessoriesList(a));
		}catch (Exception e) {
			logger.error("gainAccessoriesList occur error. ",e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 跳转到添加页面
	 * @Title:toAdd
	 * @Description:TODO(这里用一句话描述这个方法的作用)
	 * @param @return 设定文件
	 * @return String 返回类型
	 * @throws
	 * @return
	 */
	public String toAdd(){
		return "toAdd";
	}
	
	/**
	 * @throws ParseException 
	 * 添加配件信息
	 * @Title:addAccessories
	 * @Description:TODO(这里用一句话描述这个方法的作用)
	 * @param  设定文件
	 * @return void 返回类型
	 * @throws
	 */
	public void addAccessories(){
		Json j = new Json();
		try {
			a.setId(ToolsUtil.getUUID());
			a.setCreateTime(new java.sql.Timestamp(date.getTime()));
			String picSrc =request.getParameter("picSrc");
			a.setDefaultImg(picSrc);
			if("false".equals(a.getIsshelves())){//如果为false即下架，则添加下架时间
				a.setShelvesTime(new java.sql.Timestamp(date.getTime()));
				a.setPrice("0");
				a.setStock("0");
				a.setDisabled("true");
			}
			accessoriesService.addAccessories(a);
			String suitType = request.getParameter("suitType");
			System.out.println(suitType);
			//添加配件时只有配件为上架的时候才存储其适用机型
			if("true".equals(a.getIsshelves())){
				if(null != suitType && !"".equals(suitType)){
					String[] suits = suitType.split(",");
					for(int i=0;i<suits.length;i++){
						String suit =suits[i].replace(",", "");
						appModel.setId(ToolsUtil.getUUID());
						appModel.setAccessoriesId(a.getId());
						appModel.setGoodsId(suit);
						appModelService.addAppModel(appModel);
					}
				}
			}
			j.setMsg("添加成功!");
			j.setSuccess(true);				
		} catch (Exception e) {
			j.setMsg("添加失败!");
			j.setSuccess(false);				
			logger.error("addAccessories occur error. ",e);
			e.printStackTrace();
		}
		writeJson(j);
	}
	
	/**
	 * 校验配件名称
	 * @Title:gainAccessoriesByName
	 * @Description:TODO(这里用一句话描述这个方法的作用)
	 * @param  设定文件
	 * @return void 返回类型
	 * @throws
	 */
	public void gainAccessoriesByName(){
		Json j = new Json();
		try{
			flag = accessoriesService.gainAccessoriesByName(a.getName());
			//判断查询结果，为空则校验通过，否则不通过
			if(flag){//为空
				j.setSuccess(true);				
			}else{//不为空
				j.setSuccess(false);
			}
		}catch (Exception e) {
			j.setSuccess(false);
			logger.error("gainAccessoriesByName() occur error. ", e);
			e.printStackTrace();
		}
		writeJson(j);
	}
	
	/**
	 * 校验配件编号
	 * @Title:gainAccessoriesByNum
	 * @Description:TODO(这里用一句话描述这个方法的作用)
	 * @param  设定文件
	 * @return void 返回类型
	 * @throws
	 */
	public void gainAccessoriesByNum(){
		Json j = new Json();
		try{
			flag = accessoriesService.gainAccessoriesByNum(a.getAccessoriesNum());
			//判断查询结果，为空则校验通过，否则不通过
			if(flag){//为空
				j.setSuccess(true);				
			}else{//不为空
				j.setSuccess(false);
			}
		}catch (Exception e) {
			j.setSuccess(false);
			logger.error("gainAccessoriesByNum() occur error. ", e);
			e.printStackTrace();
		}
		writeJson(j);
	}
	
	/**
	 * 校验规格编号
	 * @Title:gainAccessoriesBySpecCode
	 * @Description:TODO(这里用一句话描述这个方法的作用)
	 * @param  设定文件
	 * @return void 返回类型
	 * @throws
	 */
	public void gainAccessoriesBySpecCode(){
		Json j = new Json();
		try{
			flag = accessoriesService.gainAccessoriesBySpecCode(a.getSpecCode());
			//判断查询结果，为空则校验通过，否则不通过
			if(flag){//为空
				j.setSuccess(true);				
			}else{//不为空
				j.setSuccess(false);
			}
		}catch (Exception e) {
			j.setSuccess(false);
			logger.error("gainAccessoriesBySpecCode() occur error. ", e);
			e.printStackTrace();
		}
		writeJson(j);
	}
	/**
	 * 跳转到修改页面
	 * @Title:toUpdate
	 * @Description:TODO(这里用一句话描述这个方法的作用)
	 * @param @return 设定文件
	 * @return String 返回类型
	 * @throws
	 * @return
	 */
	public String toUpdate(){
		try {
			a = accessoriesService.gainAccessoriesById(a.getId());
		} catch (Exception e) {
			logger.error("toUpdate() occur error. ", e);	
			e.printStackTrace();
		}
		return "toUpdate";
	}
	/**
	 * 修改配件信息
	 * @Title:updateAccessories
	 * @Description:TODO(这里用一句话描述这个方法的作用)
	 * @param  设定文件
	 * @return void 返回类型
	 * @throws
	 */
	public void updateAccessories(){
		Json j = new Json();
		try {
			//处理适配机型
			//List<Goods> list = goodsService.gainGoodsByAccId(a.getId());
			//if(list!=null && list.size()>0){
				System.out.println("a.getId============"+a.getId());
				List<AppModel> appModelList = appModelService.gainAppModelByAccId(a.getId());
				if(appModelList != null && appModelList.size()>0){
					//删除该appList数据表中数据
					for(int i=0;i<appModelList.size();i++){
						String id = appModelList.get(i).getId();
						appModelService.dropAppModel(id);
					}
				}
			//}
			//修改配件时只有配件为上架的时候才存储其适用机型
			if("true".equals(a.getIsshelves())){
				//如果前台存在新选择的事件
				String suitType = request.getParameter("suitType");//前台传过来的参数
				String id = request.getParameter("id");
				if(null != suitType && !"".equals(suitType)){
					String[] suits = suitType.split(",");
					for(int i=0;i<suits.length;i++){
						String suit =suits[i].replace(",", "");
						appModel.setId(ToolsUtil.getUUID());
						appModel.setAccessoriesId(id);
						appModel.setGoodsId(suit);
						appModelService.addAppModel(appModel);
					}
				}
			}
			if("false".equals(a.getIsshelves())){//如果为false即下架，则添加下架时间；如果该配件为赠品，删除配件的赠品记录
				List<Gift> list = accessoriesService.gainGiftByAccId(a.getId());
				if(null !=list && list.size()>0){
					for(Gift gift:list){
						giftService.dropGift(gift.getId());
					}
				}
				a.setShelvesTime(new java.sql.Timestamp(date.getTime()));
				a.setPrice("0");
				a.setStock("0");
				a.setDisabled("true");
			}

			//图片
			String picSrc =request.getParameter("picSrc");
			a.setModifyTime(new java.sql.Timestamp(date.getTime()));
			a.setDefaultImg(picSrc);
			accessoriesService.updateAccessories(a);

			j.setMsg("修改成功!");
			j.setSuccess(true);				
		} catch (Exception e) {
			j.setMsg("修改失败!");
			j.setSuccess(false);				
			logger.error("updateAccessories occur error. ",e);
			e.printStackTrace();
		}
		writeJson(j);
	}
	
	/**
	 * 修改时校验配件名称
	 * @Title:gainAccessoriesByIdandName
	 * @Description:TODO(这里用一句话描述这个方法的作用)
	 * @param  设定文件
	 * @return void 返回类型
	 * @throws
	 */
	public void gainAccessoriesByIdandName(){
		Json j = new Json();
		try{
			flag = accessoriesService.gainAccessoriesByIdandName(a.getId(), a.getName());
			//判断查询结果，为空则校验通过，否则不通过
			if(flag){//为空
				j.setSuccess(true);				
			}else{//不为空
				j.setSuccess(false);
			}
		}catch (Exception e) {
			j.setSuccess(false);
			logger.error("gainAccessoriesByIdandName() occur error. ", e);
			e.printStackTrace();
		}
		writeJson(j);
	}
	/**
	 * 修改时校验配件编号
	 * @Title:gainAccessoriesByIdandNum
	 * @Description:TODO(这里用一句话描述这个方法的作用)
	 * @param  设定文件
	 * @return void 返回类型
	 * @throws
	 */
	public void gainAccessoriesByIdandNum(){
		Json j = new Json();
		try{
			flag = accessoriesService.gainAccessoriesByIdandNum(a.getId(), a.getAccessoriesNum());
			System.out.println("flag="+flag);
			//判断查询结果，为空则校验通过，否则不通过
			if(flag){//为空
				j.setSuccess(true);				
			}else{//不为空
				j.setSuccess(false);
			}
		}catch (Exception e) {
			j.setSuccess(false);
			logger.error("gainAccessoriesByIdandNum() occur error. ", e);
			e.printStackTrace();
		}
		writeJson(j);
	}
	
	/**
	 * 校验规格代码
	 * @Title:gainAccessoriesByIdandSpecCode
	 * @Description:TODO(这里用一句话描述这个方法的作用)
	 * @param  设定文件
	 * @return void 返回类型
	 * @throws
	 */
	public void gainAccessoriesByIdandSpecCode(){
		Json j = new Json();
		try{
			flag = accessoriesService.gainAccessoriesByIdandSpecCode(a.getId(), a.getSpecCode());
			System.out.println("flag="+flag);
			//判断查询结果，为空则校验通过，否则不通过
			if(flag){//为空
				j.setSuccess(true);				
			}else{//不为空
				j.setSuccess(false);
			}
		}catch (Exception e) {
			j.setSuccess(false);
			logger.error("gainAccessoriesByIdandSpecCode() occur error. ", e);
			e.printStackTrace();
		}
		writeJson(j);
	}
	
	/**
	 * 批量或单条删除配件信息(物理删除)
	 * @Title:deleteAccessories
	 * @Description:TODO(这里用一句话描述这个方法的作用)
	 * @param @param ids 设定文件
	 * @return void 返回类型
	 * @throws
	 * @param ids
	 */	
	public void dropAccessories() {
		Json j = new Json();
		try {
			String ids =request.getParameter("ids");
			if(ids !=null && ids!=""){
				String[] str = ids.split(",");
				String id=null;
				List<Gift> list=null;
				List<AppModel> list1=null;
				for(int i=0;i<str.length;i++){
					id = str[i].replace(",", "");
					System.out.println("id="+id);
					//根据配件id查询是否存在赠品，如果存在，则不能删除该记录的配件信息
					list = accessoriesService.gainGiftByAccId(id);
					//根据配件id查询是否存在适用机型，如果存在，则删除相应记录的配件信息和适用机型信息
					list1 = appModelService.gainAppModelByAccId(id);
					if(list!=null && list.size()>0){
						j.setMsg("该配件存在相关联赠品,不能删除！");
						j.setSuccess(false);
					}else{
						accessoriesService.dropAccessories(ToolsUtil.StringConvertList(a.getIds()));
						if(list1!=null && list1.size()>0){//存在
							for(int ii=0;ii<list1.size();ii++){
								appModelService.dropAppModelByAccId(id);//dropAppModelByAccId
							}
						}
						j.setMsg("删除成功！");
						j.setSuccess(true);	
					}
				}
			}
		} catch (Exception e) {
			j.setMsg("删除失败！");
			j.setSuccess(false);
			logger.error("dropAccessories() occur error. ", e);
			e.printStackTrace();
		}
		writeJson(j);
	}

	/**
	 * 获取所有品牌
	 * @Title:gainAllBrand
	 * @Description:TODO(这里用一句话描述这个方法的作用)
	 * @param  设定文件
	 * @return void 返回类型
	 * @throws
	 */
	public void gainAllBrand(){
		try {
			super.writeJson(accessoriesService.gainAllBrand());
		} catch (Exception e) {
			logger.error("gainAllBrand() occur error. ", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 获取所有类别
	 * @Title:gainAllCat
	 * @Description:TODO(这里用一句话描述这个方法的作用)
	 * @param  设定文件
	 * @return void 返回类型
	 * @throws
	 */
	public void gainAllCat(){
		try {
			super.writeJson(accessoriesService.gainAllCat());
		} catch (Exception e) {
			logger.error("gainAllCat() occur error. ", e);
			e.printStackTrace();
		}
	}
	/**
	 * 获取所有颜色
	 * @Title:gainAllColor
	 * @Description:TODO(这里用一句话描述这个方法的作用)
	 * @param  设定文件
	 * @return void 返回类型
	 * @throws
	 */
	public void gainAllColor(){
		try {
			super.writeJson(accessoriesService.gainAllColor());
		} catch (Exception e) {
			logger.error("gainAllColor() occur error. ", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 根据配件id获取被选中的适配机型
	 * @Title:gainSelectedGoods
	 * @Description:TODO(这里用一句话描述这个方法的作用)
	 * @param  设定文件
	 * @return void 返回类型
	 * @throws
	 */
	public void gainSelectedGoods(){
		try {
			super.writeJson(goodsService.gainGoodsByAccId(a.getId()));
		} catch (Exception e) {
			logger.error("gainSelectedGoods. ",e);
			e.printStackTrace();
		}	
	}
	
	/**
	 * 获取配件保护膜列表
	 * @Title:gainAccessoriesMaskList
	 * @Description:TODO(这里用一句话描述这个方法的作用)
	 * @param  设定文件
	 * @return void 返回类型
	 * @throws
	 */
	public void gainAccessoriesMaskList(){
		try {
			super.writeJson(accessoriesService.gainAccessoriesMaskList(a));
		} catch (Exception e) {
			logger.error("gainAccessoriesMaskList. ",e);
			e.printStackTrace();
		}	
	}
	/**
	 * 根据配件id下架配件，修改可用状态，修改库存为0，修改价格为0，修改上下架状态，添加下架时
	 * @Title:updateShelves
	 * @Description:TODO(这里用一句话描述这个方法的作用)
	 * @param  设定文件
	 * @return void 返回类型
	 * @throws
	 */
	public void updateShelves(){
		Json j = new Json();
		try {
			System.out.println("a.getId=="+a.getId());
			/**
			 * 下架之前，需要判断该配件是否为专用配件，是否为赠品
			 * 1.判断该配件是否为专用配件；如果是，则删除该专用配件记录；
			 * 2.判断该配件是否为赠品；如果是，则删除该赠品记录；
			 */
			List<AppModel> accList = appModelService.gainAppModelByAccId(a.getId());
			if(null != accList && accList.size()>0){
				for(AppModel appModel:accList){
					appModelService.dropAppModelByAccId(appModel.getAccessoriesId());
				}
			}
			List<Gift> giftList = accessoriesService.gainGiftByAccId(a.getId());
			if(null !=giftList && giftList.size()>0){
				for(Gift gift:giftList){
					giftService.dropGift(gift.getId());
				}
			}
			
			a.setDisabled("true");
			a.setStock("0");
			a.setPrice("0");
			a.setIsshelves("false");
			a.setShelvesTime(new java.sql.Timestamp(date.getTime()));
			accessoriesService.updateShelves(a);
			j.setMsg("下架成功");
			j.setSuccess(true);
		} catch (Exception e) {
			j.setMsg("下架失败");
			j.setSuccess(false);
			logger.error("updateShelves. ",e);
			e.printStackTrace();
		}
		writeJson(j);
	}
	/**
	 * 跳转到配件仓库列表
	 * @Title:toShelves
	 * @Description:TODO(这里用一句话描述这个方法的作用)
	 * @param @return 设定文件
	 * @return String 返回类型
	 * @throws
	 * @return
	 */
	public String toShelves(){
		return "toShelves";
	}
	/**
	 * 获取配件仓库列表
	 * @Title:gainShelvesList
	 * @Description:TODO(这里用一句话描述这个方法的作用)
	 * @param  设定文件
	 * @return void 返回类型
	 * @throws
	 */
	public void gainShelvesList(){
		try{
			super.writeJson(accessoriesService.gainShelvesList(a));
		}catch (Exception e) {
			logger.error("gainShelvesList occur error. ",e);
			e.printStackTrace();
		}
	}
	/**
	 * 恢复配件仓库中的下架配件
	 * @Title:recoverShelves
	 * @Description:TODO(这里用一句话描述这个方法的作用)
	 * @param  设定文件
	 * @return void 返回类型
	 * @throws
	 */
	public void recoverShelves(){
		Json j = new Json();
		try {
			Accessories acc = accessoriesService.gainShelvesById(a.getId());
			if(null !=acc){
				if("0".equals(acc.getPrice())){
					j.setMsg("请修改配件价格大于0之后，才能进行配件恢复上架！");
					j.setSuccess(false);
				}else{
					a.setDisabled("false");
					a.setIsshelves("true");
					accessoriesService.updateRecover(a);
					j.setMsg("恢复成功！");
					j.setSuccess(true);
				}
			}
		} catch (Exception e) {
			j.setMsg("恢复失败！");
			j.setSuccess(false);
			logger.error("recoverShelves() occur error. ", e);
			e.printStackTrace();
		}
		writeJson(j);
	}
	/**
	 * 修改下架配件价格的页面
	 * @Title:toEditPrice
	 * @Description:TODO(这里用一句话描述这个方法的作用)
	 * @param @return 设定文件
	 * @return String 返回类型
	 * @throws
	 * @return
	 */
	public String toEditPrice(){
		a = accessoriesService.gainShelvesById(a.getId());
		return "toEditPrice";
	}
	/**
	 * 恢复时修改价格
	 * @Title:updatePrice
	 * @Description:TODO(这里用一句话描述这个方法的作用)
	 * @param  设定文件
	 * @return void 返回类型
	 * @throws
	 */
	public void updatePrice(){
		Json j = new Json();
		try {
			accessoriesService.updatePrice(a);
			j.setMsg("修改成功！");
			j.setSuccess(true);
		} catch (Exception e) {
			j.setMsg("修改失败！");
			j.setSuccess(false);
			logger.error("updatePrice() occur error. ", e);
			e.printStackTrace();
		}
		writeJson(j);
	}
	/**
	 * 导出配件列表
	 */
	public String exportAccExcel() {
		List<Accessories> list = accessoriesService.gainAccByExport(a);
		excelStream = accessoriesService.exportDateToExcel(list);// 导出excel表格
		return "exportExcel";
	}
	
	/**
	 * @Title: import_Ex_goodsData
	 * @Description: TODO商品批量导入
	 * @param ????设定文件
	 * @return void????返回类型
	 */
	public String toImport_Ex_accData() {
		return "toImport_Ex_accData";
	}
	
	
	public void import_Ex_accData(){
		Json json = new Json();
		try {
			String msg1 = "不存在的配件规格代码:";
			String msg2 = "以下是未知的配件规格代码：";
			String target = ServletActionContext.getServletContext().getRealPath("");
			if (a .getMyFile() != null) {
				target = target + ToolsUtil.uploadFile(request, a.getMyFile(),
						"/attached/excel","xls,xlsx",a.getMyFileFileName());
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
			    List<Accessories> accList = new ArrayList<Accessories>();
			    for (int i = 1; i < rows; i++) {
			    	
			    	Cell c2 = st.getCell(2,i);
			    	String specCode = c2.getContents().trim();
			    	Cell c3 = st.getCell(3,i);
			    	String stock = c3.getContents().trim();
			    	Cell c4 = st.getCell(4,i);
			    	String price = c4.getContents().trim();
			    	if(accessoriesService.exsitAccBySpecCode(specCode)){
			    	Accessories accessories = new Accessories();
			    	accessories.setSpecCode(specCode);
			    	accessories.setStock(stock);
			    	accessories.setPrice(price);
			    	accessoriesService.updatePriceByAcc(accessories);
			    		//accList.add(accessories);
			    	}else{
			    		msg2 = msg2 +","+specCode;
			    	}
			    	
			    }
			  //  accessoriesService.updatePriceByList(accList);
			    json.setSuccess(true);
				json.setMsg(msg1+"<br/>"+msg2+"<br/>");
			 }			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (BiffException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
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
}
