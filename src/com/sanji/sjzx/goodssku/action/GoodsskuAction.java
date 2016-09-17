package com.sanji.sjzx.goodssku.action;

import java.util.List;
import javax.annotation.Resource;
import org.apache.log4j.Logger;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import com.opensymphony.xwork2.ModelDriven;
import com.sanji.sjzx.common.util.BaseAction;
import com.sanji.sjzx.goods.service.GoodsHotService;
import com.sanji.sjzx.goodssku.service.GoodsskuService;
import com.sanji.sjzx.model.GoodsHot;
import com.sanji.sjzx.model.GoodsSku;
import com.sanji.sjzx.pojo.Json;

/**
 * @ClassName:GoodsAction
 * @Description:TODO(这里用一句话描述这个类的作用)
 * @author yangningning
 * @date 2014-10-13下午6:12:50
 */
@Namespace("/sku")
@Action(value = "skuAction", results = {
		@Result(name = "toAdd", location = "/admin/goods/add.jsp"),
		@Result(name = "dropGoodsSkuById",location = "/admin/goods/edit.jsp"),
		@Result(name = "toOutOfStock",location = "/admin/goods/outOfStockList.jsp"),
		@Result(name = "toInvisibleGoodsList",location = "/admin/goods/invisibleGoods.jsp")})

public class GoodsskuAction extends BaseAction implements ModelDriven<GoodsSku>{
	
	/**
	 * @Fields serialVersionUID:TODO(用一句话描述这个变量表示什么)
	 */
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(GoodsskuAction.class);
	private GoodsSku sku = new GoodsSku();
	private List<GoodsSku> skuList;
	private List<GoodsHot> hot;
	private GoodsHot goodsHot = new GoodsHot();
	@Resource
	private GoodsskuService skuService;
	@Resource
	private GoodsHotService hotService;

	boolean flag = false;
	public GoodsSku getSku() {
		return sku;
	}
	public void setSku(GoodsSku sku) {
		this.sku = sku;
	}
	
	public List<GoodsSku> getSkuList() {
		return skuList;
	}
	public void setSkuList(List<GoodsSku> skuList) {
		this.skuList = skuList;
	}

	public List<GoodsHot> getHot() {
		return hot;
	}
	public void setHot(List<GoodsHot> hot) {
		this.hot = hot;
	}
	
	public GoodsskuService getSkuService() {
		return skuService;
	}
	public void setSkuService(GoodsskuService skuService) {
		this.skuService = skuService;
	}
	public GoodsHotService getHotService() {
		return hotService;
	}
	public void setHotService(GoodsHotService hotService) {
		this.hotService = hotService;
	}
	
	public GoodsHot getGoodsHot() {
		return goodsHot;
	}
	public void setGoodsHot(GoodsHot goodsHot) {
		this.goodsHot = goodsHot;
	}
	
	/**
	 * 跳转到不可见sku列表
	 * 
	 * @Title:toinvisibleGoodsList
	 * @Description:TODO(toinvisibleGoodsList)
	 * @param @return 设定文件
	 * @return String 返回类型
	 * @throws
	 * @return
	 * @author songbaozhen
	 */
	public String toInvisibleSkuList(){
		return "toInvisibleGoodsList";
	}
	/**
	 * 获取设置不可见sku列表
	 * 
	 * @Title:gainInvisibleGoodsList
	 * @Description:TODO(gainInvisibleGoodsList)
	 * @param @return 设定文件
	 * @return String 返回类型
	 * @throws
	 * @return
	 * @author songbaozhen
	 */
	public void gainInvisibleSkuList(){
		try {
			super.writeJson(skuService.gainSkuList(sku));
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("gainInvisibleSkuList() occur error. ", e);
		}
	}
	
	/**
	 * 跳转到缺货提醒列表页面
	 * 
	 * @Title:toOutOfStockList
	 * @Description:TODO(toOutOfStockList)
	 * @param @return 设定文件
	 * @return String 返回类型
	 * @throws
	 * @return
	 * @author songbaozhen 
	 */
	public String toOutOfStockList(){
		
		return "toOutOfStock";
	}
	
	public void gainSkuOutOfSockList(){
		try {
			//sku.setTimeInterval(new BigDecimal(String.valueOf(sku.getTimeInterval())));
			super.writeJson(skuService.gainSkuOutOfStockList(sku));
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("gainSkuOutOfSockList() occur error. ", e);
		}
		
	}
	
   
	/**
	 * 获取所有颜色名称
	 * @Title:gainGoodsBrandName
	 * @Description:TODO(这里用一句话描述这个方法的作用)
	 * @param  设定文件
	 * @return void 返回类型
	 * @throws
	 * @author songbaozhen
	 */
	public void gainSkuColorName() {
		try{
			super.writeJson(skuService.gainSkuColorName());
		}catch (Exception e) {
			e.printStackTrace();
			logger.error("gainSkuColorName() occur error. ",e);
		}
	}
	
	/**
	 * 单条删除单品信息
	 * @Title:dropGoodsSkuById
	 * @Description:TODO(这里用一句话描述这个方法的作用)
	 * @param  设定文件
	 * @return void 返回类型
	 * @throws
	 * @author songbaozhen
	 */
	public void dropGoodsSkuById(){
		Json j = new Json();
		try {
			GoodsHot hot = hotService.gainGoodsHotsBySkuId(sku.getId());
			if(hot !=null){// 存在热销商品
				j.setMsg("该单品已经被设置成热销商品,如要删除该单品,请先取消热销设置！");
				j.setSuccess(false);
			}else{
				skuService.dropGoodsSkuBySkuId(sku.getId());
				j.setMsg("删除成功！");
				j.setSuccess(true);
			}
		} catch (Exception e) {
			j.setMsg("删除失败！");
			j.setSuccess(false);
			logger.error("dropGoodsSkuById() occur error. ", e);
			e.printStackTrace();
		}
		writeJson(j);
	}

	public GoodsSku getModel() {
		return sku;
	}
}