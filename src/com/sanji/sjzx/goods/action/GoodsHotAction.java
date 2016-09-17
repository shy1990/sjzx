/**  
* @Title: GoodsHotAction.java
* @Package com.sanji.sjzx.goods.action
* @Description: TODO(用一句话描述该文件做什么)
* @author ZhouZhangbao  
* @date 2014-10-23 上午10:50:46
* @version V1.0  
*/
package com.sanji.sjzx.goods.action;

import java.util.Date;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ModelDriven;
import com.sanji.sjzx.common.util.BaseAction;
import com.sanji.sjzx.common.util.ResourceUtil;
import com.sanji.sjzx.common.util.ToolsUtil;
import com.sanji.sjzx.goods.service.GoodsHotService;
import com.sanji.sjzx.model.GoodsHot;
import com.sanji.sjzx.model.GoodsSku;
import com.sanji.sjzx.pojo.Json;
import com.sanji.sjzx.pojo.SessionInfo;

/**
 * @ClassName: GoodsHotAction
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author ZhouZhangbao
 * @date 2014-10-23 上午10:50:46
 */
@Namespace("/goods")
@Action(value = "goodsHotAction", results = {
		@Result(name = "toHotList",location = "/admin/goodsHot/list.jsp"),
		@Result(name = "toAdd",location = "/admin/goodsHot/add.jsp")
		})
public class GoodsHotAction extends BaseAction implements ModelDriven<GoodsHot>{

	/**
	* @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)
	*/
	
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(GoodsHotAction.class);
	
	private GoodsHot goodsHot = new GoodsHot();
	private GoodsSku goodsSku = new GoodsSku();
	private String goodsType;
	
	@Resource
	private GoodsHotService goodsHotService;
	private boolean flag;
	private SessionInfo sInfo = null;
	/**
	 * 跳转到热销商品列表页面
	 * @Title:toGoodsHotList
	 * @Description:TODO(这里用一句话描述这个方法的作用)
	 * @param @return 设定文件
	 * @return String 返回类型
	 * @throws
	 * @return
	 */
	public String toGoodsHotList(){
		return "toHotList";
	}
	
	/**
	 * 获取热销商品列表
	 * @Title:toGoodsHotList
	 * @Description:TODO(这里用一句话描述这个方法的作用)
	 * @param @return 设定文件
	 * @return void 返回类型
	 * @throws
	 * @return
	 */
	public void gainGoodsHotList(){
		try {
			
			writeJson( goodsHotService.gainGoodsList(goodsHot));	
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	/**
	 * 跳转到设为热销商品列表
	 * @Title:toGoodsHotList
	 * @Description:TODO(这里用一句话描述这个方法的作用)
	 * @param @return 设定文件
	 * @return String 返回类型
	 * @throws
	 * @return
	 */
	public String toAdd(){
		 goodsHot = goodsHotService.gainGoodsById(goodsHot.getId());
		int  maxNum = goodsHotService.gainMaxNum();
		 request.setAttribute("goodsHot", goodsHot);
		 request.setAttribute("num", maxNum);
		return "toAdd";
	}
	/**
	 * 将商品设为热销
	 * @Title:toGoodsHotList
	 * @Description:TODO(这里用一句话描述这个方法的作用)
	 * @param @return 设定文件
	 * @return void 返回类型
	 * @throws
	 * @return
	 */
	
	public void addGoodsHot(){
		sInfo = (SessionInfo) session.get(ResourceUtil.getSessionInfoName());
		Json j = new Json();
		flag = goodsHotService.existGoodsHotByIdAndNum(goodsHot.getTargetId(),goodsHot.getNum());
		try {
			if(flag){
				goodsHot.setId(ToolsUtil.getUUID());
				goodsHot.setUserId(sInfo.getUserId());
				goodsHot.setCreateTime(new Date());
				goodsHotService.addGoodsHot(goodsHot);
				j.setMsg("设置成功！");
				j.setSuccess(true);	
			}else{
				j.setMsg("排名为"+goodsHot.getNum()+"的热销商品已存在！");
				j.setSuccess(false);	
			}
		} catch (Exception e) {
			   j.setMsg("设置失败！");
			   j.setSuccess(false);
			   logger.error("addGoodsHot() occur error. ", e);
			   e.printStackTrace();
		}
		writeJson(j);
	}
	
	/**
	 * 设置商品为未热销
	 * @Title:toGoodsHotList
	 * @Description:TODO(这里用一句话描述这个方法的作用)
	 * @param @return 设定文件
	 * @return void 返回类型
	 * @throws
	 * @return
	 */
	public void danGoodsHot(){
		Json j = new Json();
		try {
			goodsHotService.deleteGoodsHotByIds(ToolsUtil.StringConvertList(goodsHot.getIds()));
			j.setMsg("设置成功！");
			j.setSuccess(true);	
		} catch (Exception e) {
			j.setMsg("设置失败！");
			j.setSuccess(false);
			logger.error("danGoodsHot() occur error. ", e);
			e.printStackTrace();
		}
		writeJson(j);
	}
	
	public GoodsSku getGoodsSku() {
		return goodsSku;
	}

	public void setGoodsSku(GoodsSku goodsSku) {
		this.goodsSku = goodsSku;
	}


	public GoodsHot getModel() {
		// TODO Auto-generated method stub
		return goodsHot;
	}

	public String getGoodsType() {
		return goodsType;
	}

	public void setGoodsType(String goodsType) {
		this.goodsType = goodsType;
	}
	
	
}
