package com.sanji.sjzx.goods.action;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.mail.search.FromStringTerm;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.opensymphony.xwork2.ModelDriven;
import com.sanji.sjzx.accessories.service.AccessoriesService;
import com.sanji.sjzx.appModel.service.AppModelService;
import com.sanji.sjzx.common.util.BaseAction;
import com.sanji.sjzx.common.util.ResourceUtil;
import com.sanji.sjzx.common.util.ToolsUtil;
import com.sanji.sjzx.dict.service.DictService;
import com.sanji.sjzx.fetch.FectResult;
import com.sanji.sjzx.fetch.FecthHandler;
import com.sanji.sjzx.fetch.IDNewTbFacthHander;
import com.sanji.sjzx.gift.service.GiftService;
import com.sanji.sjzx.goods.service.GoodsHotService;
import com.sanji.sjzx.goods.service.GoodsService;
import com.sanji.sjzx.goodssku.service.GoodsskuService;
import com.sanji.sjzx.members.service.MembersPriceService;
import com.sanji.sjzx.model.Accessories;
import com.sanji.sjzx.model.AppModel;
import com.sanji.sjzx.model.Dict;
import com.sanji.sjzx.model.Gift;
import com.sanji.sjzx.model.Goods;
import com.sanji.sjzx.model.GoodsHot;
import com.sanji.sjzx.model.GoodsPic;
import com.sanji.sjzx.model.GoodsSku;
import com.sanji.sjzx.model.MembersPrice;

import com.sanji.sjzx.pic.service.PicService;
import com.sanji.sjzx.pojo.Json;
import com.sanji.sjzx.pojo.SessionInfo;
import java.io.*;  

import jxl.*;  
import jxl.read.biff.BiffException; 


/**
 * @ClassName:GoodsAction
 * @Description:TODO(这里用一句话描述这个类的作用)
 * @author yangningning
 * @date 2014-10-13下午6:12:50
 */
@Namespace("/goods")
@Action(value = "goodsAction", results = {
		@Result(name = "toGoodsList", location = "/admin/goods/list.jsp"),
		@Result(name = "toShowGoods", location = "/admin/goods/showRecycleGoods.jsp"),
		@Result(name = "toAdd", location = "/admin/goods/add.jsp"),
		@Result(name = "toUpdate",location = "/admin/goods/edit.jsp"),
		@Result(name = "toRecycleList",location ="/admin/goods/recycle.jsp"),
		@Result(name = "gainSelectedGift",location = "/admin/goods/edit.jsp"),
		@Result(name = "right",location = "/admin/goods/right.jsp"),
		//@Result(name = "toParam",location = "/admin/goods/new_add.jsp"),
		@Result(name = "toImport_Ex_goodsData", location ="/admin/goods/goods_Ex_Import.jsp"),
		@Result(name = "toEditPriceandStock",location = "/admin/goods/editPriceandStock.jsp"),
		@Result(name = "exportExcel" , type= "stream" ,
			params = {
				"contentType"," application/vnd.ms-excel",
		        "inputName","excelStream",
		        "contentDisposition","attachment;filename=\"goodsSKU.xls\"",
		        "bufferSize","1024"}
		),
		@Result(name = "toParam",location = "/admin/goods/test.jsp"),
		@Result(name = "toAddPrice",location = "/admin/goods/addPrice.jsp"),
		@Result(name = "toEditPrice",location = "/admin/goods/editPrice.jsp")
})
		

public class GoodsAction extends BaseAction implements ModelDriven<Goods> {

	/**
	 * @Fields serialVersionUID:TODO(用一句话描述这个变量表示什么)
	 */
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(GoodsAction.class);
	private Goods goods = new Goods();
	private GoodsSku sku = new GoodsSku();
	private Gift g = new Gift();
	private GoodsPic pic = new GoodsPic();
	private Accessories a = new Accessories();
	private List<GoodsSku> list;
	private List<Gift> giftList = new ArrayList<Gift>();
	private List<Accessories> accList;
	private String array;
	private GoodsPic pp = new GoodsPic();
	private Dict dict = new Dict();
	private GoodsHot goodsHot = new GoodsHot();
	private List<Dict> ramList;// ram的集合
	private List<Dict> cpuList;// cpu核数的集合
	private List<Dict> resolutionList;// 分辨率集合
	private List<Dict> osList;// 操作系统集合
	private List<Dict> standardList;// 制式集合
	private List<Dict> netList;// 适配网络类型集合
	private List<Goods> goodsList;
	private InputStream excelStream;
	private List<MembersPrice> rpList;
	private String paramObj;
	private SessionInfo sInfo=null;
	private MembersPrice membersPrice = new MembersPrice();
	
	private String areaid;//代表区域id 可以是省、市、区/县、镇
	private String areaname;//代表区域id 可以是省、市、区/县、镇的名称
	private String skuId;
	
/*	public SessionInfo getsInfo() {
		return sInfo;
	}

	public void setsInfo(SessionInfo sInfo) {
		this.sInfo = sInfo;
	}*/

	public String getSkuId() {
		return skuId;
	}

	public void setSkuId(String skuId) {
		this.skuId = skuId;
	}

	public String getAreaname() {
		return areaname;
	}

	public void setAreaname(String areaname) {
		this.areaname = areaname;
	}

	public String getAreaid() {
		return areaid;
	}

	public void setAreaid(String areaid) {
		this.areaid = areaid;
	}

	int f=0;
	@Resource
	private GoodsService goodsService;
	@Resource
	private GoodsskuService skuService;
	@Resource
	private GiftService giftService;
	@Resource
	private AccessoriesService accService;
	@Resource
	private PicService picService;
	@Resource
	private DictService dictService;
	@Resource
	private AppModelService appModelService;
	@Resource
	private GoodsHotService goodsHotService;
//	@Resource
//	private RegionsPriceService memberPriceService;
	@Resource
	private MembersPriceService membersPriceService;
	
	boolean flag = false;
	Date date = new Date();// 获取当前系统时间
	
	public Goods getGoods() {
		return goods;
	}

	public void setGoods(Goods goods) {
		this.goods = goods;
	}

	public GoodsSku getSku() {
		return sku;
	}

	public void setSku(GoodsSku sku) {
		this.sku = sku;
	}

	public List<Goods> getGoodsList() {
		return goodsList;
	}

	public void setGoodsList(List<Goods> goodsList) {
		this.goodsList = goodsList;
	}

	public Gift getG() {
		return g;
	}

	public void setG(Gift g) {
		this.g = g;
	}

	public Accessories getA() {
		return a;
	}

	public void setA(Accessories a) {
		this.a = a;
	}

	public List<GoodsSku> getList() {
		return list;
	}

	public void setList(List<GoodsSku> list) {
		this.list = list;
	}

	public List<Gift> getGiftList() {
		return giftList;
	}

	public void setGiftList(List<Gift> giftList) {
		this.giftList = giftList;
	}

	public List<Accessories> getAccList() {
		return accList;
	}

	public void setAccList(List<Accessories> accList) {
		this.accList = accList;
	}

	public GoodsPic getPic() {
		return pic;
	}

	public void setPic(GoodsPic pic) {
		this.pic = pic;
	}

	public String getArray() {
		return array;
	}

	public void setArray(String array) {
		this.array = array;
	}

	public GoodsPic getPp() {
		return pp;
	}

	public void setPp(GoodsPic pp) {
		this.pp = pp;
	}

	public Dict getDict() {
		return dict;
	}

	public void setDict(Dict dict) {
		this.dict = dict;
	}

	public List<Dict> getRamList() {
		return ramList;
	}

	public void setRamList(List<Dict> ramList) {
		this.ramList = ramList;
	}

	public List<Dict> getCpuList() {
		return cpuList;
	}

	public void setCpuList(List<Dict> cpuList) {
		this.cpuList = cpuList;
	}

	public List<Dict> getResolutionList() {
		return resolutionList;
	}

	public void setResolutionList(List<Dict> resolutionList) {
		this.resolutionList = resolutionList;
	}

	public List<Dict> getOsList() {
		return osList;
	}

	public void setOsList(List<Dict> osList) {
		this.osList = osList;
	}

	public List<Dict> getStandardList() {
		return standardList;
	}

	public void setStandardList(List<Dict> standardList) {
		this.standardList = standardList;
	}

	public List<Dict> getNetList() {
		return netList;
	}

	public void setNetList(List<Dict> netList) {
		this.netList = netList;
	}

	public GoodsHot getGoodsHot() {
		return goodsHot;
	}

	public void setGoodsHot(GoodsHot goodsHot) {
		this.goodsHot = goodsHot;
	}
	public InputStream getExcelStream() {
		return excelStream;
	}
	public void setExcelStream(InputStream excelStream) {
		this.excelStream = excelStream;
	}
	
	/**
	 * @Title : toRight
	 * @Description: TODO(单条或批量取消电商热销)
	 * @param @return    设定文件
	 * @return String   返回类型
	 * @author songBbaoZhen
	 */
	public String toRight(){
		rpList = membersPriceService.gainMembersPriceBySkuId(skuId,areaid);
		request.setAttribute("rpList", JSONObject.toJSON(rpList));
		request.setAttribute("skuId", skuId);
		request.setAttribute("areaid", areaid);
		request.setAttribute("areaname", areaname);
		return "right";
	}

	   /**
		 * 单条或批量取消电商热销
		* @Title: danGoodsById
		* @Description: TODO(单条或批量取消电商热销)
		* @param @return    设定文件
		* @return void   返回类型
		* @author songbaozhen
		 */
		public void danGoods(){
			Json j = new Json();
			try {
				goodsService.danGoodsById(ToolsUtil.StringConvertList(goods.getIds()));
				j.setMsg("取消电商热销成功！");
				j.setSuccess(true);
			} catch (Exception e) {
				j.setMsg("取消电商热销失败！");
				j.setSuccess(false);
				logger.error("danGoods() occur error. ", e);
				e.printStackTrace();
			}
			writeJson(j);
		}
		
		/**
		 * 单条或批量设置电商热销
		* @Title: openGoods
		* @Description: TODO(单条或批量设置电商热销)
		* @param @return    设定文件
		* @return void   返回类型
		* @author songbaozhen
		 */
		public void openGoods(){
			Json j = new Json();
			try {
				goodsService.openGoodsById(ToolsUtil.StringConvertList(goods.getIds()));
				j.setMsg("设置电商热销成功！");
				j.setSuccess(true);
			} catch (Exception e) {
				j.setMsg("设置电商热销失败！");
				j.setSuccess(false);
				logger.error("openGoods occur error. ", e);
				e.printStackTrace();
			}
			writeJson(j);
		}
	/**
	 * 跳转到商品列表页面
	 * 
	 * @Title:toGoodsList
	 * @Description:TODO(这里用一句话描述这个方法的作用)
	 * @param @return 设定文件
	 * @return String 返回类型
	 * @throws
	 * @return
	 */
	public String toGoodsList() {
		return "toGoodsList";
	}

	/**
	 * 商品列表
	 * 
	 * @Title:gainGoodsList
	 * @Description:TODO(这里用一句话描述这个方法的作用)
	 * @param 设定文件
	 * @return void 返回类型
	 * @throws
	 */
	public void gainGoodsList() {
		try {
			super.writeJson(goodsService.gainGoodsList(goods));
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("gainGoodsList() occur error. ", e);
		}
	}
	/**
	 * 适用机型列表
	 * @Title:gainApplicationModelList
	 * @Description:TODO(这里用一句话描述这个方法的作用)
	 * @param  设定文件
	 * @return void 返回类型
	 * @throws
	 */
	public void gainApplicationModelList(){
		try {
			super.writeJson(goodsService.gainApplicationModelList(goods));
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("gainApplicationModelList() occur error. ", e);
		}
	}
	/**
	 * 获取商品品牌名称
	 * 
	 * @Title:gainGoodsBrandName
	 * @Description:TODO(这里用一句话描述这个方法的作用)
	 * @param 设定文件
	 * @return void 返回类型
	 * @throws
	 */
	public void gainGoodsBrandName() {
		try {
			super.writeJson(goodsService.gainGoodsBrandName());
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("gainGoodsBrandName() occur error. ", e);
		}
	}

	/**
	 * 获取商品类别名称
	 * 
	 * @Title:gainGoodsCatName
	 * @Description:TODO(这里用一句话描述这个方法的作用)
	 * @param 设定文件
	 * @return void 返回类型
	 * @throws
	 */
	public void gainGoodsCatName() {
		try {
			super.writeJson(goodsService.gainGoodsCatName());
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("gainGoodsCatName() occur error. ", e);
		}
	}

	/**
	 * 跳转到商品详情页面
	 * 
	 * @Title:toShowGoods
	 * @Description:TODO(这里用一句话描述这个方法的作用)
	 * @param @return 设定文件
	 * @return String 返回类型
	 * @throws
	 * @return
	 */
	public String toShowGoods() {
		try {
			// 下拉框选项处理
			List<Dict> dictList = dictService.gainDictList();
			Map<String, List<Dict>> dictMap = new HashMap<String, List<Dict>>();
			for (Dict dict : dictList) {
				List<Dict> subList = dictMap.get(dict.getDictGroup());
				if (subList == null) {
					subList = new ArrayList<Dict>();
				}
				subList.add(dict);
				dictMap.put(dict.getDictGroup(), subList);
			}
			ramList = dictMap.get("RAM");
			cpuList = dictMap.get("CPU_NUMBER");
			resolutionList = dictMap.get("RESOLUTION");
			osList = dictMap.get("OS");
			standardList = dictMap.get("STANDARD");
			netList = dictMap.get("NETSUITTYPE");
			goods = goodsService.gainRecycleGoodsandSku(goods.getId());
			list = skuService.gainSkuByGoodsId(goods.getId());
			for (int i = 0; i < list.size(); i++) {
				List<GoodsPic> picList = picService.gainPic(list.get(i).getId());
				list.get(i).setPicList(picList);
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("toShowGoods() occur error. ", e);
		}
		return "toShowGoods";
	}

	/**
	 * 根据id获取商品信息
	 * 
	 * @Title:gainAll
	 * @Description:TODO(这里用一句话描述这个方法的作用)
	 * @param 设定文件
	 * @return void 返回类型
	 * @throws
	 */
	public void gainAll() {
		super.writeJson(goodsService.gainAll(goods.getId()));
	}

	/**
	 * 获取所有颜色名称
	 * 
	 * @Title:gainGoodsBrandName
	 * @Description:TODO(这里用一句话描述这个方法的作用)
	 * @param 设定文件
	 * @return void 返回类型
	 * @throws
	 */
	public void gainSkuColorName() {
		try {
			super.writeJson(skuService.gainSkuColorName());
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("gainSkuColorName() occur error. ", e);
		}
	}

	/**
	 * 跳转到添加页面
	 * 
	 * @Title:toAdd
	 * @Description:TODO(这里用一句话描述这个方法的作用)
	 * @param @return 设定文件
	 * @return String 返回类型
	 * @throws
	 * @return
	 */
	public String toAdd() {
		return "toAdd";
	}

	/**
	 * 校验商品名称是否存在
	 * 
	 * @Title:AddGoodsValidateAction
	 * @Description:TODO(这里用一句话描述这个方法的作用)
	 * @param 设定文件
	 * @return void 返回类型
	 * @throws
	 */
	public void goodsNameValidate() {
		Json j = new Json();
		try {
			flag = goodsService.gainGoodsByName(goods.getName());
			// 判断查询结果，为空则校验通过，否则不通过
			if (flag) {// 为空
				j.setSuccess(true);
			} else {// 不为空
				j.setSuccess(false);
			}
		} catch (Exception e) {
			j.setSuccess(false);
			logger.error("goodsNameValidate() occur error. ", e);
			e.printStackTrace();
		}
		writeJson(j);
	}
	/**
	 * 校验商品编号是否存在
	 * 
	 * @Title:goodsNumValidate
	 * @Description:TODO(这里用一句话描述这个方法的作用)
	 * @param 设定文件
	 * @return void 返回类型
	 * @throws
	 */
	public void goodsNumValidate() {
		Json j = new Json();
		try {
			flag = goodsService.gainGoodsByGoodsNum(goods.getGoodsNum());
			// 判断查询结果，为空则校验通过，否则不通过
			if (flag) {// 为空
				j.setSuccess(true);
			} else {// 不为空
				j.setSuccess(false);
			}
		} catch (Exception e) {
			j.setSuccess(false);
			logger.error("goodsNumValidate() occur error. ", e);
			e.printStackTrace();
		}
		writeJson(j);
	}
	/**
	 * 校验商品代码是否存在
	 * @Title:skuCodeValidate
	 * @Description:TODO(这里用一句话描述这个方法的作用)
	 * @param  设定文件
	 * @return void 返回类型
	 * @throws
	 */
	public void skuCodeValidate(){
		Json j = new Json();
		try{				  
			flag = skuService.gainSkuBySkuCode(sku.getSkuCode());
			//System.out.println("flag="+flag);
			//判断查询结果，为空则校验通过，否则不通过
			if(flag){//为空
				j.setSuccess(true);				
			}else{//不为空
				j.setSuccess(false);
			}
		}catch (Exception e) {
			j.setSuccess(false);
			logger.error("skuCodeValidate() occur error. ", e);
			e.printStackTrace();
		}
		writeJson(j);
	}
	/**
	 * 校验单品编号是否存在
	 * 
	 * @Title:skuNumValidate
	 * @Description:TODO(这里用一句话描述这个方法的作用)
	 * @param 设定文件
	 * @return void 返回类型
	 * @throws
	 */
	public void skuNumValidate() {
		Json j = new Json();
		try {
			flag = skuService.gainSkuBySkuNum(sku.getSkuNum());
			// 判断查询结果，为空则校验通过，否则不通过
			if (flag) {// 为空
				j.setSuccess(true);
			} else {// 不为空
				j.setSuccess(false);
			}
		} catch (Exception e) {
			j.setSuccess(false);
			logger.error("skuNumValidate() occur error. ", e);
			e.printStackTrace();
		}
		writeJson(j);
	}

	/**
	 * 添加商品信息
	 * 
	 * @Title:addGoods
	 * @Description:TODO(这里用一句话描述这个方法的作用)
	 * @param 设定文件
	 * @return void 返回类型
	 * @throws
	 */
	public void addGoods() {
		Json j = new Json();
		try {
	    //添加商品
	    goods.setId(ToolsUtil.getUUID());
	    goods.setCreateTime(new java.sql.Timestamp(date.getTime()));
	    //借助一个虚拟属性来完成日期类型转换
	    String exposure = request.getParameter("exposure");
	    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
	    if(null != exposure && !"".equals(exposure)){
		    Date exposureDate = sdf.parse(exposure);
		    goods.setExposureDate(exposureDate);
	    }

		//String url = "http://detail.zol.com.cn/274/273715/param.shtml";			
		String road = request.getParameter("road");
		if(road!=null && !"".equals(road)){
			FecthHandler fecth=new IDNewTbFacthHander(null);
			FectResult result = fecth.fecth(road);
			Map<String, String> map = result.getParams().get("基本参数");
			String param = "";//获取到的参数
			//String mark = "";//判断标识，判断值是""还是param
			if(map != null && map.size()>0){
				goods.setCellphoneType(param == null?"":map.get("手机类型"));
			}
			map = result.getParams().get("屏幕");
			if(map != null && map.size()>0){
				goods.setScreenSize(param == null?"":map.get("主屏尺寸").replace("英寸", ""));
				goods.setTouchscreenType(param == null?"":map.get("触摸屏类型"));
				goods.setResolution(param == null?"":map.get("主屏分辨率").replace("px", ""));
				goods.setSreenPixDensity(param == null?"":map.get("屏幕像素密度"));
				goods.setScreenTechnology(param == null?"":map.get("屏幕技术"));
				goods.setNarrowFrame(param == null?"":map.get("窄边框"));
				goods.setScreenRatio(param == null?"":map.get("屏幕占比"));
			}		
			map = result.getParams().get("硬件");
			if(map != null && map.size()>0){
				goods.setRam(param == null?"":map.get("RAM容量"));
				goods.setCpuNumber(param == null?"":map.get("核心数"));
				goods.setCpuRate(param == null?"":map.get("CPU频率"));
				goods.setOperationSystem(param == null?"":map.get("操作系统"));
				goods.setBatteryType(param == null?"":map.get("电池类型"));
				goods.setBatteryCapacity(param == null?"":map.get("电池容量"));
				goods.setUserInterface(param == null?"":map.get("用户界面"));
				goods.setCpuModel(param == null?"":map.get("CPU型号"));
				goods.setGpuModel(param == null?"":map.get("GPU型号"));
			}
			map = result.getParams().get("摄像头");
			if(map != null && map.size()>0){
				goods.setFrontCamera(param == null?"":map.get("前置摄像头"));
				goods.setPostCamera(param == null?"":map.get("后置摄像头"));
				goods.setCamera(param == null?"":map.get("摄像头"));
				goods.setCameraType(param == null?"":map.get("摄像头类型"));
				goods.setSensorType(param == null?"":map.get("传感器类型"));
				goods.setFlashLamp(param == null?"":map.get("闪光灯"));
				goods.setVideoShoot(param == null?"":map.get("视频拍摄"));
				goods.setShootFunction(param == null?"":map.get("拍照功能"));
				goods.setAperture(param == null?"":map.get("光圈"));
				goods.setCameraFeatures(param == null?"":map.get("摄像头特色"));
				goods.setCameraOtherparams(param == null?"":map.get("其他摄像头参数"));
			}
			map = result.getParams().get("网络");
			if(map != null && map.size()>0){
				goods.setWlanFunction(param == null?"":map.get("WLAN功能"));
				goods.setNavigation(param == null?"":map.get("导航"));
				goods.setConnectionShare(param == null?"":map.get("连接与共享"));				
			}
			map = result.getParams().get("外观");
			if(map != null && map.size()>0){
				goods.setModelDesign(param == null?"":map.get("造型设计"));
				goods.setWeight(param == null?"":map.get("手机重量").replace("g", ""));
				goods.setOperationType(param == null?"":map.get("操作类型"));
				goods.setOutSensorType(param == null?"":map.get("感应器类型"));
				goods.setBodyInterface(param == null?"":map.get("机身接口"));
				goods.setCellphoneSize(param == null?"":map.get("手机尺寸"));
			}
			map = result.getParams().get("服务与支持");
			if(map != null && map.size()>0){
				goods.setAudioSupport(param == null?"":map.get("音频支持"));
				goods.setVideoSupport(param == null?"":map.get("视频支持"));
				goods.setImgSupport(param == null?"":map.get("图片支持"));
				goods.setCommonFunctions(param == null?"":map.get("常用功能"));
				goods.setBusinessFunctions(param == null?"":map.get("商务功能"));
			}
		}	
		
			// 添加单品
			//获取手机分类的值
			String machineType = ","+request.getParameter("machineType")+",";
			//System.out.println("machineType>>>>===="+machineType);
			//list.remove(null);
			for(int i=0;i<list.size();i++){
				if("0".equals(list.get(i).getIsDelete())){
					list.remove(i);
				}
			}
			for(int i=0;i<list.size();i++){
				if("false".equals(list.get(i).getShelves())){
					list.get(i).setPrice("0");
					list.get(i).setStock("0");
					list.get(i).setShelvesTime(new java.sql.Timestamp(date.getTime()));
				}
				GoodsSku goodsSku = list.get(i);
				goodsSku.setId(ToolsUtil.getUUID());
				goodsSku.setGoodsId(goods.getId());
				goodsSku.setMachineType(machineType);
			}

			// 处理图片
			if (array != null && !"".equals(array)
					&& !"undefined".equals(array)) {
				JSONArray jsonarray = JSONArray.parseArray(array);
				for (int k = 0; k < jsonarray.size(); k++) {
					// 获取数组里的每个对象
					JSONObject jsonObject = JSONObject.parseObject(jsonarray
							.getString(k));
					// 取得单品编号
					String skuNum = jsonObject.getString("skuNum");
					String imgSrc = jsonObject.getString("imgs");
					if (imgSrc.indexOf('[') > 0 || imgSrc.indexOf(']') > 0
							|| imgSrc.indexOf('\"') > 0) {
						imgSrc = imgSrc.replace("[", "").replace("]", "")
								.replace("\"", "");
					}
					String[] src = imgSrc.split(",");
					for (GoodsSku gs : list) {
						if (skuNum != null && skuNum.equals(gs.getSkuNum())) {
							String skuId = gs.getId();
							for (int s = 0; s < src.length; s++) {
								pic.setId(ToolsUtil.getUUID());
								pic.setSkuId(skuId);
								pic.setGoodsId(goods.getId());
								pic.setPicSrc(src[s]);
								picService.addPic(pic);
							}
						}
					}
				}
			}

			String firstSkuId = list.get(0).getId();
			if (firstSkuId != null && !"".equals(firstSkuId)) {
				List<GoodsPic> picList = picService.gainPic(firstSkuId);
				if (picList != null && picList.size() > 0) {
					String defaultImg = picList.get(0).getPicSrc();
					goods.setDefaultImg(defaultImg);
				}
			}
			goodsService.addGoods(goods, list);
			//获取地域价格参数
			String overParam=request.getParameter("overParam");
			//System.out.println("overParam==="+overParam);
			String overSku="123";//解析得到的规格代码
			String overResult="";
			String overId="";//区域代码
			String overPrice="";//区域价格
			String curSkuId="";
			String userId="";//操作人 
			if (overParam != null && !"".equals(overParam) && !"undefined".equals(overParam)) {
				
				JSONArray jsonarray = JSONArray.parseArray(overParam);
				//System.out.println(jsonarray.size());
				for (int z = 0; z < jsonarray.size(); z++) {
					//System.err.println("I 的长度" + z);
					JSONObject jsonObject = JSONObject.parseObject(jsonarray.getString(z));
					overSku = jsonObject.getString("skuValue");
					overResult = jsonObject.getString("result");
					//System.out.println("^^^^^^^^overSku=="+overSku);
					JSONArray jsonarray1 = JSONArray.parseArray(overResult);
					//System.out.println("jsonarray.size()==="+jsonarray.size());
					
					for (int x = 0; x < jsonarray1.size(); x++) {
						
						JSONObject jsonObject1 = JSONObject.parseObject(jsonarray1.getString(x));
						overId=jsonObject1.getString("memberId");
						overPrice=jsonObject1.getString("memberPrice");
						//double floatPrice=Double.parseDouble(overPrice);
						//System.out.println("overId=="+overId+"  overPrice=="+overPrice);
						if(overSku != null){
							for (GoodsSku gs:list) {
								if(overSku.equals(gs.getSkuNum())){
									curSkuId=gs.getId();
									//System.out.println("curSkuId==="+curSkuId);
								}
							}
							sInfo = (SessionInfo) session.get(ResourceUtil.getSessionInfoName());
							userId=sInfo.getUserId();
							membersPrice.setId(ToolsUtil.getUUID());
							membersPrice.setGoodsSkuId(curSkuId);
							membersPrice.setFloatPrice(overPrice);
							membersPrice.setCreateTime(new java.sql.Timestamp(date.getTime()));
							membersPrice.setUserId(userId);
							membersPrice.setMemberId(overId);
							membersPriceService.addMembersPrice(membersPrice);

						}


					}
				}
			}			
			
			// 添加赠品
			String idList = request.getParameter("idList");
			if (null != idList && !"".equals(idList)) {
				String[] str = idList.split(",");
				for (int i = 0; i < str.length; i++) {
					Gift gift = new Gift();
					String s = str[i].replace(",", "");
					String id = ToolsUtil.getUUID();
					// logger.debug(id);
					gift.setId(id);
					gift.setGiftId(s);
					gift.setGoodsId(goods.getId());
					gift.setGiftPrice(0.0);
					giftService.addGift(gift);
				}
			}
			j.setMsg("添加成功!");
			j.setSuccess(true);		
		} catch (Exception e) {
			j.setMsg("添加失败!");
			j.setSuccess(false);
			logger.error("addGoods() occur error. ", e);
			e.printStackTrace();
		}
		writeJson(j);
	}

	/**
	 * 跳转到修改页面
	 * 
	 * @Title:toUpdate
	 * @Description:TODO(这里用一句话描述这个方法的作用)
	 * @param @return 设定文件
	 * @return String 返回类型
	 * @throws
	 * @return
	 */
	public String toUpdate() {
		try {
			// 下拉框选项处理
			List<Dict> dictList = dictService.gainDictList();
			Map<String, List<Dict>> dictMap = new HashMap<String, List<Dict>>();
			for (Dict dict : dictList) {
				List<Dict> subList = dictMap.get(dict.getDictGroup());
				if (subList == null) {
					subList = new ArrayList<Dict>();
				}
				subList.add(dict);
				dictMap.put(dict.getDictGroup(), subList);
			}
			ramList = dictMap.get("RAM");
			cpuList = dictMap.get("CPU_NUMBER");
			resolutionList = dictMap.get("RESOLUTION");
			osList = dictMap.get("OS");
			standardList = dictMap.get("STANDARD");
			netList = dictMap.get("NETSUITTYPE");

			goods = goodsService.gainAll(goods.getId());
			//展示goods时，也要借助虚拟属性来完成日期类型转换
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM");  
			Date expDate = goods.getExposureDate();	
			if(null != expDate){
				String exposure=sdf.format(expDate);  
				goods.setExposure(exposure);
			}
			
			list = skuService.gainSkuByGoodsId(goods.getId());
			for (int i = 0; i < list.size(); i++) {
				List<GoodsPic> picList = picService
						.gainPic(list.get(i).getId());
				list.get(i).setPicList(picList);
			}

			//System.out.println("请求的返回的值：" + JSON.toJSONString(list));
	//		rpList = membersPriceService.gainAllMembersPrice();
//			System.out.println("rpList=="+rpList);
//			for (int rr = 0; rr < rpList.size(); rr++) {
//				System.out.println(rpList.get(rr).getMemberId()+" "+rpList.get(rr).getGoodsSkuId()+" "+rpList.get(rr).getFloatPrice());
//			}
			//writeJson(rpList);
//			request.setAttribute("rpList", JSONObject.toJSON(rpList));
		} catch (Exception e) {
			logger.error("toUpdate() occur error. ", e);
			e.printStackTrace();
		}
		return "toUpdate";
	}
	
	

	/**
	 * 获取某个商品id下已选的赠品
	 * 
	 * @Title:selectedGift
	 * @Description:TODO(这里用一句话描述这个方法的作用)
	 * @param 设定文件
	 * @return void 返回类型
	 * @throws
	 */
	public void gainSelectedGift() {
		try {
			super.writeJson(accService.gainAccessoriesMaskByGoodsId(goods
					.getId()));
		} catch (Exception e) {
			logger.error("gainSelectedGift occur error. ", e);
			e.printStackTrace();
		}
	}

	/**
	 * 修改时校验商品名称是否存在
	 * 
	 * @Title:goodsNameValidateWhenUpdate
	 * @Description:TODO(这里用一句话描述这个方法的作用)
	 * @param 设定文件
	 * @return void 返回类型
	 * @throws
	 */
	public void goodsNameValidateWhenUpdate() {
		Json j = new Json();
		try {
			flag = goodsService.gainGoodsByNameandId(goods.getId(),
					goods.getName());
			// 判断查询结果，为空则校验通过，否则不通过
			if (flag) {// 为空
				j.setSuccess(true);
			} else {// 不为空
				j.setSuccess(false);
			}
		} catch (Exception e) {
			j.setSuccess(false);
			logger.error("goodsNameValidateWhenUpdate() occur error. ", e);
			e.printStackTrace();
		}
		writeJson(j);
	}

	/**
	 * 修改时校验商品编号是否存在
	 * 
	 * @Title:goodsNumValidateWhenUpdate
	 * @Description:TODO(这里用一句话描述这个方法的作用)
	 * @param 设定文件
	 * @return void 返回类型
	 * @throws
	 */
	public void goodsNumValidateWhenUpdate() {
		Json j = new Json();
		try {
			flag = goodsService.gainGoodsByNumandId(goods.getId(),
					goods.getGoodsNum());
			// 判断查询结果，为空则校验通过，否则不通过
			if (flag) {// 为空
				j.setSuccess(true);
			} else {// 不为空
				j.setSuccess(false);
			}
		} catch (Exception e) {
			j.setSuccess(false);
			logger.error("goodsNumValidateWhenUpdate() occur error. ", e);
			e.printStackTrace();
		}
		writeJson(j);
	}

	/**
	 * 修改时校验商品代码是否存在
	 * @Title:skuCodeValidateWhenUpdate
	 * @Description:TODO(这里用一句话描述这个方法的作用)
	 * @param  设定文件
	 * @return void 返回类型
	 * @throws
	 */
	public void skuCodeValidateWhenUpdate(){
		Json j = new Json();
		try{
			flag = skuService.gainSkuBySkuCodeandId(sku.getId(), sku.getSkuCode());
			//判断查询结果，为空则校验通过，否则不通过
			if(flag){//为空
				j.setSuccess(true);				
			}else{//不为空
				j.setSuccess(false);
			}
		}catch (Exception e) {
			j.setSuccess(false);
			logger.error("skuCodeValidateWhenUpdate() occur error. ", e);
			e.printStackTrace();
		}
		writeJson(j);
	}

	/**
	 * 修改时校验单品编号是否存在
	 * 
	 * @Title:skuNumValidateWhenUpdate
	 * @Description:TODO(这里用一句话描述这个方法的作用)
	 * @param 设定文件
	 * @return void 返回类型
	 * @throws
	 */
	public void skuNumValidateWhenUpdate() {
		Json j = new Json();
		try {
			flag = skuService
					.gainSkuBySkuNumandId(sku.getId(), sku.getSkuNum());
			// 判断查询结果，为空则校验通过，否则不通过
			if (flag) {// 为空
				j.setSuccess(true);
			} else {// 不为空
				j.setSuccess(false);
			}
		} catch (Exception e) {
			j.setSuccess(false);
			logger.error("skuNumValidateWhenUpdate() occur error. ", e);
			e.printStackTrace();
		}
		writeJson(j);
	}

	/**
	 * 修改商品信息
	 * 
	 * @Title:updateGoods
	 * @Description:TODO(这里用一句话描述这个方法的作用)
	 * @param 设定文件
	 * @return void 返回类型
	 * @throws
	 */
	String overParam="";
	String overSku="";//解析得到的规格代码
	String overResult="";
	String overId="";//区域代码
	String overPrice="";//区域价格
	String curSkuId="";
	String userId="";//操作人 

	public void updateGoods() {
		Json j = new Json();
		try {
			String idList = request.getParameter("idList");// 获取前台用户选择的赠品id字符串
			String goodsId = request.getParameter("id");// 获取前台商品的主键id
			String machineType = request.getParameter("machineType");
			if(machineType != null){
				
			}
			//System.out.println("machineType==="+machineType);
			String[] mac = machineType.split(",");
			//String mach="";
			List<String> macList=new ArrayList<String>();
			for (int index = 0; index < mac.length; index++) {
				if("裸机".equals(mac[index])){
					mac[index]="lj";
				}else if ("包销机".equals(mac[index])) {
					mac[index]="bxjx";
				}else if ("移动合约机".equals(mac[index])) {
					mac[index]="ydhy";
				}else if ("联通合约机".equals(mac[index])) {
					mac[index]="lthy";
				}else if ("电信合约机".equals(mac[index])) {
					mac[index]="dxhy";
				}else if ("功能机".equals(mac[index])) {
					mac[index]="gnj";
				}else if("lj".equals(mac[index])){
					mac[index]="lj";
				}else if ("bxjx".equals(mac[index])) {
					mac[index]="bxjx";
				}else if("ydhy".equals(mac[index])){
					mac[index]="ydhy";
				}else if("lthy".equals(mac[index])){
					mac[index]="lthy";
				}else if("dxhy".equals(mac[index])){
					mac[index]="dxhy";
				}else if("gnj".equals(mac[index])){
					mac[index]="gnj";
				}
				
				if (!macList.contains(mac[index]))
				{
					macList.add(mac[index]);
				}
				
				//System.out.println("macList>>> "+ macList);
				//System.out.println(">>>>>  "+mac[index]);
			}
			
			if(macList.size()>0 && macList !=null){
				StringBuffer sbr = new StringBuffer();
				sbr.append(",");
				for (String str : macList)
				{
					sbr.append(str).append(",");
				}
				machineType = sbr.toString();
				//System.out.println("machineType>>> "+ machineType);
			}
			
			accList = accService.gainAccessoriesByGoodsId(goodsId);
			// 如果数据表里存在添加商品时选择的赠品数据
			if (accList != null && accList.size() > 0) {
				List<Gift> gifts = giftService.gainGiftList(goodsId);
				// 删除添加商品时已选的赠品数据
				for (int i = 0; i < gifts.size(); i++) {
					//String gid = gifts.get(i).getId();
					//g.setId(gid);
					Gift gift = gifts.get(i);
					gift.setDisabled("true");
					giftService.updateGift(gift);
					//giftService.dropGift(gid);
				}
			}
			// 如果前台已选择赠品页面存在用户已选择的赠品数据的情况
			if (idList != null && idList != "") {
				String[] str = idList.split(",");
				// 批量添加赠品
				for (int i = 0; i < str.length; i++) {
					Gift gift = new Gift();
					String s = str[i].replace(",", "");
					String uuid = ToolsUtil.getUUID();
//					List<Gift> giftList = giftService.gainGiftByGiftId(goods.getId(),s);
//					if(giftList !=null && giftList.size()>0){
//						for (int k = 0; k < giftList.size(); k++) {
//							if("true".equals(giftList.get(k).getDisabled())){
//								Gift g = giftList.get(k);
//								g.setDisabled("false");
//								giftService.updateGift(g);
//							}
//						}
//					}else{
						gift.setId(uuid);
						gift.setGiftId(s);
						gift.setGoodsId(goodsId);
						gift.setGiftPrice(0.0);
						gift.setDisabled("false");
						giftService.addGift(gift);
//					}
				}
			}
			goods.setModifyTime(new java.sql.Timestamp(date.getTime()));
			//修改goods时也要借助一个虚拟属性来完成日期类型转换
		    String exposure = request.getParameter("exposure");
		    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
		    if(null != exposure && !"".equals(exposure)){
		    	Date exposureDate = sdf.parse(exposure);
		    	goods.setExposureDate(exposureDate);
		    }
		    
			List<GoodsSku> oldList = skuService.gainSkuByGoodsId(goodsId);
			//删掉isDelete值为0的对象
			for(int n=0;n<list.size();n++){
				if("0".equals(list.get(n).getIsDelete())){
					list.remove(n);
				}
			}

			int oldNum = oldList.size();
			int newNum = list.size();
			int num = newNum - oldNum;
			//System.out.println("num=="+num);
			if (oldNum == newNum) {
				// 处理图片
				List<GoodsPic> srcList = picService.gainPicByGoodsId(goodsId);// 根据商品id获取原有图片路径
				if (srcList != null && srcList.size() > 0) {// 遍历删除
					for (int i = 0; i < srcList.size(); i++) {
						picService.DropPic(goodsId);
					}
				}
				if (array != null && !"".equals(array)
						&& !"undefined".equals(array)) {
					JSONArray jsonarray = JSONArray.parseArray(array);
					for (int k = 0; k < jsonarray.size(); k++) {
						// 获取数组里的每个对象
						JSONObject jsonObject = JSONObject
								.parseObject(jsonarray.getString(k));
						// 取得单品编号
						String skuNum = jsonObject.getString("skuNum");
						String imgSrc = jsonObject.getString("imgs");
						if (imgSrc.indexOf('[') > 0 || imgSrc.indexOf(']') > 0
								|| imgSrc.indexOf('\"') > 0) {
							imgSrc = imgSrc.replace("[", "").replace("]", "")
									.replace("\"", "");
						}
						String[] src = imgSrc.split(",");
						for (GoodsSku gs : list) {
							if (skuNum != null && skuNum.equals(gs.getSkuNum())) {
								String skuId = gs.getId();
								for (int s = 0; s < src.length; s++) {
									pic.setId(ToolsUtil.getUUID());
									pic.setSkuId(skuId);
									pic.setGoodsId(goodsId);
									pic.setPicSrc(src[s]);
									picService.addPic(pic);
								}
							}
						}
					}
				}
				//处理下架单品
				for(int n=0;n<list.size();n++){
					if("false".equals(list.get(n).getShelves())){
						list.get(n).setShelvesTime(new java.sql.Timestamp(date.getTime()));
						list.get(n).setPrice("0");
						list.get(n).setStock("0");
					}
				}
				for(GoodsSku sku:list){
					sku.setMachineType(machineType);
				}
				goodsService.updateGoods(goods, list);
				//修改区域参数
				//获取地域价格参数
				overParam=request.getParameter("overParam");
				if (overParam != null && !"".equals(overParam) && !"undefined".equals(overParam)) {
					
					JSONArray jsonarray = JSONArray.parseArray(overParam);
					//System.out.println(jsonarray.size());
					for (int z = 0; z < jsonarray.size(); z++) {
						JSONObject jsonObject = JSONObject.parseObject(jsonarray.getString(z));
						overSku = jsonObject.getString("skuId");
						overResult = jsonObject.getString("result");
						//System.out.println("^^^^^^^^overSku=="+overSku);
						JSONArray jsonarray1 = JSONArray.parseArray(overResult);
						//System.out.println("jsonarray.size()==="+jsonarray.size());
						
						for (int x = 0; x < jsonarray1.size(); x++) {
							
							JSONObject jsonObject1 = JSONObject.parseObject(jsonarray1.getString(x));
							overId=jsonObject1.getString("memberId");
							//System.out.println("overId=="+overId);
							overPrice=jsonObject1.getString("memberPrice");
							if(overSku != null){
								for (GoodsSku gs:list) {
									if(overSku.equals(gs.getId())){
										curSkuId=gs.getId();
										//System.out.println("curSkuId==="+curSkuId);
									
/*								
										List<RegionsPrice> regionsPrices=memberPriceService.gainRegionsPriceBySkuId(curSkuId);
										if(regionsPrices !=null && regionsPrices.size()>0){//存在此单品的地域价格参数
											sInfo = (SessionInfo) session.get(ResourceUtil.getSessionInfoName());
											userId=sInfo.getUserId();
											//regionsPrice.setId(regionsPrice.getId());
											regionsPrice.setGoodsSkuId(curSkuId);
											regionsPrice.setFloatPrice(overPrice);
											regionsPrice.setCreateTime(new java.sql.Timestamp(date.getTime()));
											regionsPrice.setUserId(userId);
											regionsPrice.setRegionsId(overId);
											memberPriceService.updateRegionsPriceBySkuId(regionsPrice);
										}else {
											sInfo = (SessionInfo) session.get(ResourceUtil.getSessionInfoName());
											userId=sInfo.getUserId();
											regionsPrice.setId(ToolsUtil.getUUID());
											regionsPrice.setGoodsSkuId(curSkuId);
											regionsPrice.setFloatPrice(overPrice);
											regionsPrice.setCreateTime(new java.sql.Timestamp(date.getTime()));
											regionsPrice.setUserId(userId);
											regionsPrice.setRegionsId(overId);
											memberPriceService.addRegionsPrice(regionsPrice);
									    }*/
										//根据单品id获取 区域单品价格列表
										List<MembersPrice> membersPrices=membersPriceService.gainMembersPriceBySkuId(curSkuId);
										boolean isuppdate = false;
										if(membersPrices !=null && membersPrices.size()>0)
										{//存在此单品的地域价格参数
											
											for (MembersPrice rp : membersPrices)
											{	
												if (overId .equals(rp.getMemberId()))
												{
													sInfo = (SessionInfo) session.get(ResourceUtil.getSessionInfoName());
													/*userId=sInfo.getUserId();
													regionsPrice.setId(rp.getId());
													regionsPrice.setGoodsSkuId(curSkuId);
													regionsPrice.setFloatPrice(overPrice);
													regionsPrice.setCreateTime(new java.sql.Timestamp(date.getTime()));
													regionsPrice.setUserId(userId);
													regionsPrice.setRegionsId(overId);
													memberPriceService.updateRegionsPriceBySkuId(regionsPrice);*/
													rp.setUserId(sInfo.getUserId());
													rp.setGoodsSkuId(curSkuId);
													rp.setFloatPrice(overPrice);
													rp.setCreateTime(new java.sql.Timestamp(date.getTime()));
													//rp.setRegionsId(overId);
													membersPriceService.updateMembersPriceById(rp);
													isuppdate = true;
													break;
												}
											}
										}

										if (isuppdate == false)
										{
											sInfo = (SessionInfo) session.get(ResourceUtil.getSessionInfoName());
											userId=sInfo.getUserId();
											membersPrice.setId(ToolsUtil.getUUID());
											membersPrice.setGoodsSkuId(curSkuId);
											membersPrice.setFloatPrice(overPrice);
											membersPrice.setCreateTime(new java.sql.Timestamp(date.getTime()));
											membersPrice.setUserId(userId);
											membersPrice.setMemberId(overId);
											membersPriceService.addMembersPrice(membersPrice);
											
										}
										
									}	
								}

							}
						}
					}
				}			
				//System.out.println("地域价格更新完毕");
				
				// 设置商品的第一个单品的第一张图片为商品的默认图片
				String firstSkuId = list.get(0).getId();
				if (firstSkuId != null && !"".equals(firstSkuId)) {
					List<GoodsPic> picList = picService.gainPic(firstSkuId);
					if (picList != null && picList.size() > 0) {
						String defaultImg = picList.get(0).getPicSrc();
						goods.setDefaultImg(defaultImg);
					} else {
						goods.setDefaultImg("");
					}
					goodsService.updateGoodsById(goods);
				}
			} else { 
				//System.out.println("oldList:"+oldList.toString());
				if(oldList !=null && oldList.size()>0){
					//处理下架单品
					for(int d=0;d<oldList.size();d++){
						if("false".equals(oldList.get(d).getShelves())){
							oldList.get(d).setPrice("0");
							oldList.get(d).setStock("0");
							oldList.get(d).setShelvesTime(new java.sql.Timestamp(date.getTime()));
						}
					}	
					for(GoodsSku sku:oldList){
						sku.setMachineType(machineType);
					}
					goodsService.updateGoods(goods, oldList);
					
					//修改区域参数
					//获取地域价格参数
					overParam=request.getParameter("overParam");
					if (overParam != null && !"".equals(overParam) && !"undefined".equals(overParam)) {
						
						JSONArray jsonarray = JSONArray.parseArray(overParam);
						//System.out.println(jsonarray.size());
						for (int z = 0; z < jsonarray.size(); z++) {
							//System.err.println("I 的长度" + z);
							JSONObject jsonObject = JSONObject.parseObject(jsonarray.getString(z));
							overSku = jsonObject.getString("skuId");
							overResult = jsonObject.getString("result");
							//System.out.println("^^^^^^^^overSku=="+overSku);
							JSONArray jsonarray1 = JSONArray.parseArray(overResult);
							//System.out.println("jsonarray.size()==="+jsonarray.size());
							
							for (int x = 0; x < jsonarray1.size(); x++) {
								
								JSONObject jsonObject1 = JSONObject.parseObject(jsonarray1.getString(x));
								overId=jsonObject1.getString("memberId");
								overPrice=jsonObject1.getString("memberPrice");
								if(overSku != null){
									for (GoodsSku gs:oldList) {
										if(overSku.equals(gs.getId())){
											curSkuId=gs.getId();
											//System.out.println("curSkuId==="+curSkuId);
										
									
/*											List<RegionsPrice> regionsPrices=memberPriceService.gainRegionsPriceBySkuId(curSkuId);
											if(regionsPrices !=null && regionsPrices.size()>0){//存在此单品的地域价格参数
												sInfo = (SessionInfo) session.get(ResourceUtil.getSessionInfoName());
												userId=sInfo.getUserId();
												//regionsPrice.setId(regionsPrice.getId());
												regionsPrice.setGoodsSkuId(curSkuId);
												regionsPrice.setFloatPrice(overPrice);
												regionsPrice.setCreateTime(new java.sql.Timestamp(date.getTime()));
												regionsPrice.setUserId(userId);
												regionsPrice.setRegionsId(overId);
												memberPriceService.updateRegionsPriceBySkuId(regionsPrice);
											}else {
												sInfo = (SessionInfo) session.get(ResourceUtil.getSessionInfoName());
												userId=sInfo.getUserId();
												regionsPrice.setId(ToolsUtil.getUUID());
												regionsPrice.setGoodsSkuId(curSkuId);
												regionsPrice.setFloatPrice(overPrice);
												regionsPrice.setCreateTime(new java.sql.Timestamp(date.getTime()));
												regionsPrice.setUserId(userId);
												regionsPrice.setRegionsId(overId);
												memberPriceService.addRegionsPrice(regionsPrice);
										    }*/
											List<MembersPrice> membersPrices=membersPriceService.gainMembersPriceBySkuId(curSkuId);
											boolean isuppdate = false;
											if(membersPrices !=null && membersPrices.size()>0)
											{//存在此单品的地域价格参数
												
												for (MembersPrice rp : membersPrices)
												{	
													if (overId.equals(rp.getMemberId()))
													{
														sInfo = (SessionInfo) session.get(ResourceUtil.getSessionInfoName());
														userId=sInfo.getUserId();
														//regionsPrice.setId(regionsPrice.getId());
														membersPrice.setGoodsSkuId(curSkuId);
														membersPrice.setFloatPrice(overPrice);
														membersPrice.setCreateTime(new java.sql.Timestamp(date.getTime()));
														membersPrice.setUserId(userId);
														membersPrice.setMemberId(overId);
														membersPriceService.updateMembersPriceBySkuId(membersPrice);
														isuppdate = true;
														break;
													}
												}
											}

											if (isuppdate == false)
											{
												sInfo = (SessionInfo) session.get(ResourceUtil.getSessionInfoName());
												userId=sInfo.getUserId();
												membersPrice.setId(ToolsUtil.getUUID());
												membersPrice.setGoodsSkuId(curSkuId);
												membersPrice.setFloatPrice(overPrice);
												membersPrice.setCreateTime(new java.sql.Timestamp(date.getTime()));
												membersPrice.setUserId(userId);
												membersPrice.setMemberId(overId);
												membersPriceService.addMembersPrice(membersPrice);
												
											}

											
											
										}
									}
								}
							}
						}
					}			
					
					
					
					
				}else {
					//如果原有的数据为空，则oldNum赋值为0
					oldNum=0;
				}
				for (int i = oldNum; i < newNum; i++) {
						list.get(i).setId(ToolsUtil.getUUID());
						list.get(i).setGoodsId(goodsId);
						if("false".equals(list.get(i).getShelves())){
							list.get(i).setPrice("0");
							list.get(i).setStock("0");
							list.get(i).setShelvesTime(new java.sql.Timestamp(date.getTime()));
						}
						list.get(i).setMachineType(machineType);
						skuService.addGoodsSku(list.get(i));
						//String skuNumValue = list.get(i).getSkuNum();//规格代码
								
						
						//修改区域参数
						//获取地域价格参数
						//此处为处理修改页面添加新的单品的时候进行特殊处理
/*						overParam=request.getParameter("overParam");
						if (overParam != null && !"".equals(overParam) && !"undefined".equals(overParam)) {
							
							JSONArray jsonarray = JSONArray.parseArray(overParam);
							System.out.println(jsonarray.size());
							for (int z = 0; z < jsonarray.size(); z++) {
								System.err.println("I 的长度" + z);
								JSONObject jsonObject = JSONObject.parseObject(jsonarray.getString(z));
								overSku = jsonObject.getString("skuId");
								overResult = jsonObject.getString("result");
								System.out.println("^^^^^^^^overSku=="+overSku);
								JSONArray jsonarray1 = JSONArray.parseArray(overResult);
								System.out.println("jsonarray.size()==="+jsonarray.size());
								
								for (int x = 0; x < jsonarray1.size(); x++) {
									
									JSONObject jsonObject1 = JSONObject.parseObject(jsonarray1.getString(x));
									overId=jsonObject1.getString("memberId");
									overPrice=jsonObject1.getString("memberPrice");
									if(overSku != null){
										for (GoodsSku gs:list) {
											if(overSku.equals(gs.getSkuNum())){
												curSkuId=gs.getId();
												System.out.println("curSkuId==="+curSkuId);
											}
										}
										
										
										List<RegionsPrice> regionsPrices=memberPriceService.gainRegionsPriceBySkuId(curSkuId);
										if(regionsPrices !=null && regionsPrices.size()>0){//存在此单品的地域价格参数
											sInfo = (SessionInfo) session.get(ResourceUtil.getSessionInfoName());
											userId=sInfo.getUserId();
											//regionsPrice.setId(ToolsUtil.getUUID());
											regionsPrice.setGoodsSkuId(curSkuId);
											regionsPrice.setFloatPrice(overPrice);
											regionsPrice.setCreateTime(new java.sql.Timestamp(date.getTime()));
											regionsPrice.setUserId(userId);
											regionsPrice.setRegionsId(overId);
											memberPriceService.updateRegionsPriceBySkuId(regionsPrice.getGoodsSkuId());
										}else {
											sInfo = (SessionInfo) session.get(ResourceUtil.getSessionInfoName());
											userId=sInfo.getUserId();
											regionsPrice.setId(ToolsUtil.getUUID());
											regionsPrice.setGoodsSkuId(curSkuId);
											regionsPrice.setFloatPrice(overPrice);
											regionsPrice.setCreateTime(new java.sql.Timestamp(date.getTime()));
											regionsPrice.setUserId(userId);
											regionsPrice.setRegionsId(overId);
											memberPriceService.addRegionsPrice(regionsPrice);
										}
										

									}
								}
							}
						}					*/
						
						
						
						
						
				}
				// 处理图片
				List<GoodsPic> srcList = picService.gainPicByGoodsId(goodsId);// 根据商品id获取原有图片路径
				if (srcList != null && srcList.size() > 0) {// 遍历删除
					for (int i = 0; i < srcList.size(); i++) {
						picService.DropPic(goodsId);
					}
				}
				if (array != null && !"".equals(array)&& !"undefined".equals(array)) {
					JSONArray jsonarray = JSONArray.parseArray(array);
					for (int k = 0; k < jsonarray.size(); k++) {
						// 获取数组里的每个对象
						JSONObject jsonObject = JSONObject
								.parseObject(jsonarray.getString(k));
						// 取得单品编号
						String skuNum = jsonObject.getString("skuNum");
						String imgSrc = jsonObject.getString("imgs");
						if (imgSrc.indexOf('[') > 0 || imgSrc.indexOf(']') > 0
								|| imgSrc.indexOf('\"') > 0) {
							imgSrc = imgSrc.replace("[", "").replace("]", "")
									.replace("\"", "");
						}
						String[] src = imgSrc.split(",");
						for (GoodsSku gs : oldList) {
							if (skuNum != null && skuNum.equals(gs.getSkuNum())) {
								String skuId = gs.getId();
								//System.out.println("skuId===" + skuId);
								//System.out.println("goodsId====" + goodsId);
								for (int s = 0; s < src.length; s++) {
									pic.setId(ToolsUtil.getUUID());
									pic.setSkuId(skuId);
									pic.setGoodsId(goodsId);
									pic.setPicSrc(src[s]);
									picService.addPic(pic);
								}
							}
						}
						int n = oldList.size();
						for (int i = n; i < list.size(); i++) {
							if (skuNum != null
									&& skuNum.equals(list.get(n).getSkuNum())) {
								String skuId = list.get(i).getId();
								for (int s = 0; s < src.length; s++) {
									pic.setId(ToolsUtil.getUUID());
									pic.setSkuId(skuId);
									pic.setGoodsId(goodsId);
									pic.setPicSrc(src[s]);
									picService.addPic(pic);
								}
							}
						}
					}
				}

				// 设置商品的第一个单品的第一张图片为商品的默认图片
				if(oldList!=null && oldList.size()>0){
					String firstSkuId = oldList.get(0).getId();
					if (firstSkuId != null && !"".equals(firstSkuId)) {
						List<GoodsPic> picList = picService.gainPic(firstSkuId);
						if (picList != null && picList.size() > 0) {
							String defaultImg = picList.get(0).getPicSrc();
							goods.setDefaultImg(defaultImg);
						} else {
							goods.setDefaultImg("");
						}
						goodsService.updateGoodsById(goods);
					}
				}

			}
			j.setMsg("修改成功!");
			j.setSuccess(true);
		} catch (Exception e) {
			j.setMsg("修改失败!");
			j.setSuccess(false);
			logger.error("updateGoods() occur error.", e);
			e.printStackTrace();
		}
		writeJson(j);
	}

	/**
	 * 逻辑删除商品信息
	 * 
	 * @Title:deleteGoods
	 * @Description:TODO(这里用一句话描述这个方法的作用)
	 * @param 设定文件
	 * @return void 返回类型
	 * @throws
	 */
	public void deleteGoods() {
		Json j = new Json();
		try {
			String ids = request.getParameter("ids");
			if (ids != null && ids != "") {
				String[] str = ids.split(",");
				for (int i = 0; i < str.length; i++) {
					String id = str[i].replace(",", "");
					List<GoodsSku> skuList = skuService.gainSkuByGoodsId(id);// 先根据商品id查询出单品信息
					for(GoodsSku sku:skuList){
						// 处理热销商品
						String skuId = sku.getId();// 根据单品id查询热销商品信息，并判断是否存在热销商品
						GoodsHot goodsHot = goodsHotService.gainGoodsHotsBySkuId(skuId);
						if (goodsHot != null) {// 如果存在热销商品，那么提示先删掉相应的热销记录
							goodsHotService.deleteHotBySkuId(skuId);
							j.setMsg("该商品存在热销商品，已取消热销；如不再回收该宝贝，请重新设置该商品热销！");
							j.setSuccess(true);
							writeJson(j); 
						}
					}
					for (GoodsSku sku:skuList) {
						// 处理单价、库存
						Double price = Double.parseDouble(sku.getPrice());
						Integer stock = Integer.parseInt(sku.getStock());
						if(price !=0 || stock !=0){
							j.setMsg("请修改商品价格、库存为0之后，才能进行宝贝回收！");
							j.setSuccess(false);
							writeJson(j); 
							return;
						}
					}
					for (GoodsSku sku:skuList) {
						// 记录下架时间，修改下架标识
						sku.setShelvesTime(new java.sql.Timestamp(date.getTime()));
						sku.setShelves("false");
						goodsService.deleteGoodsandSku(ToolsUtil.StringConvertList(goods.getIds()), skuList);
						j.setMsg("商品存入宝贝仓库成功！");
						j.setSuccess(true);
					}
				}
			}
		} catch (Exception e) {
			j.setMsg("删除失败！");
			j.setSuccess(false);
			logger.error("deleteGoods() occur error. ", e);
			e.printStackTrace();
		}
		writeJson(j);
	}

	public Goods getModel() {
		return goods;
	}

	/**
	 * 跳转到回收站页面
	 * 
	 * @Title:toRecycleList
	 * @Description:TODO(这里用一句话描述这个方法的作用)
	 * @param @return 设定文件
	 * @return String 返回类型
	 * @throws
	 * @return
	 */
	public String toRecycleList() {
		return "toRecycleList";
	}

	/**
	 * 回收站列表
	 * 
	 * @Title:gainRecycleList
	 * @Description:TODO(这里用一句话描述这个方法的作用)
	 * @param 设定文件
	 * @return void 返回类型
	 * @throws
	 */
	public void gainRecycleList() {
		try {
			super.writeJson(goodsService.gainRecycleList(goods));
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("gainRecycleList() occur error. ", e);
		}
	}

	/**
	 * 恢复删除到回收站的商品信息
	 * @Title:recoverGoods
	 * @Description:TODO(这里用一句话描述这个方法的作用)
	 * @param 设定文件
	 * @return void 返回类型
	 * @throws
	 */
	public void recoverGoods() {
		Json j = new Json();
		try {
			//先根据goodsId获取宝贝仓库中相应的单品信息
			String ids = request.getParameter("ids");
			if (ids != null && ids != "") {
				String[] str = ids.split(",");
				for (int i = 0; i < str.length; i++) {
					String id = str[i].replace(",", "");
					List<GoodsSku> recycleList = skuService.gainRecycelSkuByGoodsId(id);
					for(GoodsSku sku:recycleList){
					   	Double price = Double.parseDouble(sku.getPrice());
						if(price==0){
							j.setMsg("请修改商品价格大于0之后，才能进行商品恢复！");
							j.setSuccess(false);
							writeJson(j);
							return;
						}
					}
					for(GoodsSku sku:recycleList){
						Integer stock = Integer.parseInt(sku.getStock());
						if(stock==0){
							f++;
							//System.out.println("f:"+f);
							if(f==recycleList.size()){
								j.setMsg("请修改商品库存并且至少有一个单品的库存大于0，才能进行商品恢复！");
								j.setSuccess(false);
								writeJson(j);
								return;
							}
						}
					}
					for(GoodsSku sku:recycleList){
						sku.setShelves("true");
						goodsService.recoverGoodsandSku(ToolsUtil.StringConvertList(goods.getIds()), recycleList);
						j.setMsg("恢复成功！");
						j.setSuccess(true);
					}
				}
			}
		} catch (Exception e) {
			j.setMsg("恢复失败！");
			j.setSuccess(false);
			logger.error("recoverGoods() occur error. ", e);
			e.printStackTrace();
		}
		writeJson(j);
	}

	/**
	 * 删除相应id的商品记录(物理信息)
	 * 
	 * @Title:dropGoods
	 * @Description:TODO(这里用一句话描述这个方法的作用)
	 * @param 设定文件
	 * @return void 返回类型
	 * @throws
	 */
	public void dropGoods() {
		Json j = new Json();
		try {
			goodsService.dropGoods(ToolsUtil.StringConvertList(goods.getIds()),
					ToolsUtil.StringConvertList(goods.getIds()),
					ToolsUtil.StringConvertList(goods.getIds()));

			String ids = request.getParameter("ids");
			if (ids != null && ids != "") {
				String[] str = ids.split(",");
				for (int i = 0; i < str.length; i++) {
					String id = str[i].replace(",", "");
					// 处理图片
					List<GoodsPic> picList = picService.gainPicByGoodsId(id);
					if (picList != null && picList.size() > 0) {// 如果存在图片,那么删除该商品下的所有图片
						for (int ii = 0; ii < picList.size(); ii++) {
							picService.DropPic(id);
						}
					}
					// 处理适配机型
					List<AppModel> list = appModelService
							.gainAppModelByGoodsId(id);
					if (list != null && list.size() > 0) {// 如果该商品时适用机型
						for (int ii = 0; ii < list.size(); ii++) {
							appModelService.dropAppModelByGoodsId(id);
						}
					}
				}
			}
			j.setMsg("删除成功！");
			j.setSuccess(true);
		} catch (Exception e) {
			j.setMsg("删除失败！");
			j.setSuccess(false);
			logger.error("dropGoods() occur error. ", e);
			e.printStackTrace();
		}
		writeJson(j);
	}

	/**
	 * 跳转到添加商品参数页面
	 * 
	 * @Title:toParam
	 * @Description:TODO(这里用一句话描述这个方法的作用)
	 * @param @return 设定文件
	 * @return String 返回类型
	 * @throws
	 * @return
	 */
	public String toParam() {
		return "toParam";
	}

	/**
	 * @Title: import_Ex_goodsData
	 * @Description: TODO商品批量导入
	 * @param ????设定文件
	 * @return void????返回类型
	 */
	public String toImport_Ex_goodsData() {
		return "toImport_Ex_goodsData";
	}

	/**
	 * @Title: import_Ex_goodsData
	 * @Description: TODO商品批量导入
	 * @param ????设定文件
	 * @return void????返回类型
	 */
	public void import_Ex_goodsData() {
		Json json = new Json();
		try {
			String msg1 = "不存在的手机规格代码:";
			String msg2 = "不存在的配件规格代码:";
			String msg3 = "以下是未知的分类，规格代码：";
			String target = ServletActionContext.getServletContext().getRealPath("");
			if (goods.getMyFile() != null) {
				target = target + ToolsUtil.uploadFile(request, goods.getMyFile(),
						"/attached/excel","xls,xlsx",goods.getMyFileFileName());
				if(target.equals("")){
					this.uploadError("上传文件失败！","上传文件扩展名是不允许的扩展名。\n只允许xls,xlsx格式！");
					return ;
				}
				target=target.replace("../","/");
				target=target.replace("/","\\");
				//target=target.replace("/","\\");适用Linux
				InputStream is = new FileInputStream(target);  
			    Workbook rwb = Workbook.getWorkbook(is);  
			    //Sheet st = rwb.getSheet("0")这里有两种方法获取sheet表,1为名字，而为下标，从0开始  
			    Sheet st = rwb.getSheet("Sheet1");  
			    int rs=st.getColumns();  
			    int rows=st.getRows(); 
			    GoodsSku sku ;
			    Accessories accessories;
			   // System.out.println("列数===>"+rs+"行数："+rows);  
			    for (int i = 1; i < rows; i++) {
			    	Cell c2 = st.getCell(2,i);
			    	String s2 = c2.getContents().trim();
			    	Cell c4 = st.getCell(4,i);
			    	String s4 = c4.getContents().trim();
			    	Cell c5 = st.getCell(5,i);
			    	String s5 = c5.getContents().trim();
			    	Cell c6 = st.getCell(6,i);
			    	String s6 = c6.getContents().trim();
			    	if ("手机".equals(s6)) {
			    		if (skuService.gainSkuBySkuNum(s2)) {
							//不存在
							msg1 = msg1 + s2;
						}else {
							sku = new GoodsSku();
							sku.setSkuNum(s2);
							sku.setStock(s4);
							sku.setPrice(s5);
							skuService.updatePriceBySkuNum(sku);
						}
					}else if ("配件".equals(s6)) {
						accessories = new Accessories();
						accessories.setSpecCode(s2);
						accessories.setStock(s4);
						accessories.setPrice(s5);
						accService.updatePriceByNum(accessories);
					}else {
						msg3 = msg3 +","+s2;
					}
				}
				json.setSuccess(true);
				json.setMsg(msg1+"<br/>"+msg2+"<br/>"+msg3+"");
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
	
	/**
	 * 跳转到修改价格库存页面
	 */
	public String toEditPriceandStock(){
		list = skuService.gainSkuByGoodsId(goods.getId());
		return "toEditPriceandStock";
	}

	/**
	 * 修改价格库存数据
	 */
	public void updatePriceandStock(){
		Json j = new Json();
		try {
			sInfo = (SessionInfo) session.get(ResourceUtil.getSessionInfoName());
			if(list != null && list.size() > 0){
				//for(int i=0;i<list.size();i++){
					goods.setUserId(sInfo.getUserId());
					goods.setId(list.get(0).getGoodsId());
					goodsService.updateGoodsById(goods);
			//	}
			}
			goodsService.updatePriceandStockList(list);
			j.setMsg("修改成功！");
			j.setSuccess(true);
		} catch (Exception e) {
			j.setMsg("修改失败！");
			j.setSuccess(false);
			logger.error("updatePriceandStock.",e);
			e.printStackTrace();
		}
		writeJson(j);
	}
	/**
	 * 根据goodsId获取宝贝仓库中某个商品具体的信息
	 */
	public String toShowRecycleGoods(){
		return "toShowRecycleGoods";
	}
	
	/**
	 * 导出商品列表
	 * @return
	 */
	public String exportGoodsExcel() {
		List<GoodsSku> list = skuService.gainGoosdSKUByExport(goods);
		excelStream = skuService.exportDateToExcel(list);// 导出excel表格
		return "exportExcel";
	}
	/**
	 * 跳转到添加地域价格页面
	 * @Title:toAddPrice
	 * @Description:TODO(这里用一句话描述这个方法的作用)
	 * @param @return 设定文件
	 * @return String 返回类型
	 * @throws
	 * @return
	 */
	public String toAddPrice(){
		//System.out.println("paramObj==="+paramObj);
		//paramObj= request.getParameter("paramObj");
		//System.out.println("paramObj==="+paramObj);
		return "toAddPrice";
	}
	/**
	 * 跳转到修改地域价格页面
	 * @Title:toEditPrice
	 * @Description:TODO(这里用一句话描述这个方法的作用)
	 * @param @return 设定文件
	 * @return String 返回类型
	 * @throws
	 * @return
	 */
	public String toEditPrice(){
		//paramObj= request.getParameter("paramObj");
		//System.out.println("paramObj==="+paramObj);
		request.setAttribute("skuId", skuId);
		return "toEditPrice";
	}
	
	public String getParamObj() {
		return paramObj;
	}

	public void setParamObj(String paramObj) {
		this.paramObj = paramObj;
	}

	public MembersPrice getMembersPrice() {
		return membersPrice;
	}

	public void setMembersPrice(MembersPrice membersPrice) {
		this.membersPrice = membersPrice;
	}

	public List<MembersPrice> getRpList() {
		return rpList;
	}

	public void setRpList(List<MembersPrice> rpList) {
		this.rpList = rpList;
	}

}
