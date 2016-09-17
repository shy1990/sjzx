package com.sanji.sjzx.integral.action;

import java.util.Date;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ModelDriven;
import com.sanji.sjzx.common.util.BaseAction;
import com.sanji.sjzx.common.util.ToolsUtil;
import com.sanji.sjzx.integral.service.IntegralGoodsService;
import com.sanji.sjzx.model.IntegralGoods;
import com.sanji.sjzx.pojo.Json;

@Namespace("/integral")
@Action(value = "integralAction", results = {
		@Result(name = "toIntegralList", location = "/admin/integral/list.jsp"),
		@Result(name = "toAdd",location="/admin/integral/add.jsp"),
		@Result(name = "toUpdate",location="/admin/integral/edit.jsp"),
		@Result(name = "toShelvesList",location="/admin/integral/shelves.jsp"),
		@Result(name = "toEditPrice",location="/admin/integral/editPrice.jsp")})

public class IntegralGoodsAction extends BaseAction implements ModelDriven<IntegralGoods>{
	/**
	 * @Fields serialVersionUID:TODO(用一句话描述这个变量表示什么)
	 */
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(IntegralGoodsAction.class);
	private IntegralGoods integralGoods = new IntegralGoods();
	@Resource
	private IntegralGoodsService integralService;
	private boolean flag=false;
	Date date = new Date();
	/**
	 * 跳转到积分商品列表
	 * @Title:toIntegralList
	 * @Description:TODO(这里用一句话描述这个方法的作用)
	 * @param @return 设定文件
	 * @return String 返回类型
	 * @throws
	 * @return
	 */
	public String toIntegralList(){
		return "toIntegralList";
	}
	/**
	 * 获取积分商品列表
	 */
	public void gainIntegralGoodsList(){
		try{
			super.writeJson(integralService.gainIntegralGoodsList(integralGoods));
		}catch (Exception e) {
			logger.error("gainIntegralGoodsList occur error. ",e);
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
	 * 添加积分商品信息
	 * @Title:addIntegralGoods
	 * @Description:TODO(这里用一句话描述这个方法的作用)
	 * @param  设定文件
	 * @return void 返回类型
	 * @throws
	 */
	public void addIntegralGoods(){
		Json j = new Json();
		try {
			flag = integralService.gainIntegralGoodsByName(integralGoods.getName());
			if(flag){
				integralGoods.setId(ToolsUtil.getUUID());
				if("false".equals(integralGoods.getIsshelves())){
					integralGoods.setPrice("0");
					integralGoods.setStock("0");
					integralGoods.setShelvesTime(new java.sql.Timestamp(date.getTime()));
				}
				integralService.addIntegralGoods(integralGoods);
				j.setMsg("添加成功!");
				j.setSuccess(true);				
			}else{
				j.setMsg("此积分商品名称已存在!");
				j.setSuccess(false);				
			}
		} catch (Exception e) {
			j.setMsg("添加失败!");
			j.setSuccess(false);				
			logger.error("addIntegralGoods occur error. ",e);
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
		return "toUpdate";
	}
	/**
	 * 修改积分商品信息
	 * @Title:updateIntegralGoods
	 * @Description:TODO(这里用一句话描述这个方法的作用)
	 * @param  设定文件
	 * @return void 返回类型
	 * @throws
	 */
	public void updateIntegralGoods(){
		Json j = new Json();
		try {
			flag = integralService.gainIntegralGoodsByIdandName(integralGoods.getId(), integralGoods.getName());
			if(flag){
				if("false".equals(integralGoods.getIsshelves())){
					integralGoods.setPrice("0");
					integralGoods.setStock("0");
					integralGoods.setShelvesTime(new java.sql.Timestamp(date.getTime()));
				}
				integralService.updateIntegralGoods(integralGoods);
				j.setMsg("修改成功!");
				j.setSuccess(true);				
			}else{
				j.setMsg("此积分商品名称已存在!");
				j.setSuccess(false);				
			}
		} catch (Exception e) {
			j.setMsg("修改失败!");
			j.setSuccess(false);				
			logger.error("updateIntegralGoods occur error. ",e);
			e.printStackTrace();
		}
		writeJson(j);
	}

	/**
	 * 批量或单条删除配件信息(物理删除)
	 * @Title:dropAccessories
	 * @Description:TODO(这里用一句话描述这个方法的作用)
	 * @param  设定文件
	 * @return void 返回类型
	 * @throws
	 */
	public void dropIntegralGoods(){
		Json j = new Json();
		try {
			integralService.dropIntegralGoods(ToolsUtil.StringConvertList(integralGoods.getIds()));
			j.setMsg("删除成功！");
			j.setSuccess(true);			
		} catch (Exception e) {
			j.setMsg("删除失败！");
			j.setSuccess(false);
			logger.error("dropIntegralGoods() occur error. ", e);
			e.printStackTrace();
		}
		writeJson(j);
	}

	/**
	 * 添加时校验商品代码是否存在
	 * @Title:gainIntegralGoodsByIntegralCode
	 * @Description:TODO(这里用一句话描述这个方法的作用)
	 * @param  设定文件
	 * @return void 返回类型
	 * @throws
	 */
	public void gainIntegralGoodsByIntegralCode(){
		Json j = new Json();
		try{
			flag = integralService.gainIntegralGoodsByIntegralCode(integralGoods.getIntegralCode());
			//判断查询结果，为空则校验通过，否则不通过
			/*if(flag){//为空
				j.setSuccess(true);				
			}else{//不为空
				j.setSuccess(false);
			}*/
			j.setSuccess(true);
		}catch (Exception e) {
			j.setSuccess(false);
			logger.error("gainIntegralGoodsByIntegralCode() occur error. ", e);
			e.printStackTrace();
		}
		writeJson(j);
	}
	
	/**
	 * 添加时校验规格代码是否存在
	 * @Title:gainIntegralGoodsBySpecCode
	 * @Description:TODO(这里用一句话描述这个方法的作用)
	 * @param  设定文件
	 * @return void 返回类型
	 * @throws
	 */
	public void gainIntegralGoodsBySpecCode(){
		Json j = new Json();
		try{
			flag = integralService.gainIntegralGoodsBySpecCode(integralGoods.getSpecCode());
			//判断查询结果，为空则校验通过，否则不通过
			if(flag){//为空
				j.setSuccess(true);				
			}else{//不为空
				j.setSuccess(false);
			}
		}catch (Exception e) {
			j.setSuccess(false);
			logger.error("gainIntegralGoodsBySpecCode() occur error. ", e);
			e.printStackTrace();
		}
		writeJson(j);
	}
	
	/**
	 * 修改时校验商品代码
	 * @Title:gainIntegralGoodsByIdandIntegralCode
	 * @Description:TODO(这里用一句话描述这个方法的作用)
	 * @param  设定文件
	 * @return void 返回类型
	 * @throws
	 */
	public void gainIntegralGoodsByIdandIntegralCode(){
		Json j = new Json();
		try{
			flag = integralService.gainIntegralGoodsByIdandIntegralCode(integralGoods.getId(), integralGoods.getIntegralCode());
			//判断查询结果，为空则校验通过，否则不通过
			/*if(flag){//为空
				j.setSuccess(true);				
			}else{//不为空
				j.setSuccess(false);
			}*/
			j.setSuccess(true);
		}catch (Exception e) {
			j.setSuccess(false);
			logger.error("gainIntegralGoodsByIdandIntegralCode() occur error. ", e);
			e.printStackTrace();
		}
		writeJson(j);
	}
	
	/**
	 * 修改时校验规格代码
	 * @Title:gainIntegralGoodsByIdandSpecCode
	 * @Description:TODO(这里用一句话描述这个方法的作用)
	 * @param  设定文件
	 * @return void 返回类型
	 * @throws
	 */
	public void gainIntegralGoodsByIdandSpecCode(){
		Json j = new Json();
		try{
			flag = integralService.gainIntegralGoodsByIdandSpecCode(integralGoods.getId(), integralGoods.getSpecCode());
			//判断查询结果，为空则校验通过，否则不通过
			if(flag){//为空
				j.setSuccess(true);				
			}else{//不为空
				j.setSuccess(false);
			}
		}catch (Exception e) {
			j.setSuccess(false);
			logger.error("gainIntegralGoodsByIdandSpecCode() occur error. ", e);
			e.printStackTrace();
		}
		writeJson(j);
	}
	/**
	 * 跳转到下架积分商品列表
	 */
	public String toShelvesList(){
		return "toShelvesList";
	}
	
	/**
	 * 获取下架积分商品列表
	 */
	public void gainShelvesIntegralGoodsList(){
		try{
			super.writeJson(integralService.gainShelvesIntegralGoodsList(integralGoods));
		}catch (Exception e) {
			logger.error("gainShelvesIntegralGoodsList occur error. ",e);
			e.printStackTrace();
		}
	}
	/**
	 * 进行下架操作
	 * @Title:updateShelves
	 * @Description:TODO(这里用一句话描述这个方法的作用)
	 * @param  设定文件
	 * @return void 返回类型
	 * @throws
	 */
	public void updateShelves(){
		Json j = new Json();
		try {
			integralGoods.setPrice("0");
			integralGoods.setStock("0");
			integralGoods.setIsshelves("false");
			integralGoods.setShelvesTime(new java.sql.Timestamp(date.getTime()));
			integralService.updateIntegralGoods(integralGoods);
			j.setMsg("下架成功！");
			j.setSuccess(true);
		} catch (Exception e) {
			j.setMsg("下架失败！");
			j.setSuccess(false);
			logger.error("updateShelves occur error. ",e);
			e.printStackTrace();
		}
		writeJson(j);
	}
	/**
	 * 恢复上架
	 * @Title:recoverShelves
	 * @Description:TODO(这里用一句话描述这个方法的作用)
	 * @param  设定文件
	 * @return void 返回类型
	 * @throws
	 */
	public void recoverShelves(){
		Json j = new Json();
		try {
			IntegralGoods goods = integralService.gainIntegralGoodsById(integralGoods.getId());
			if("0".equals(goods.getPrice())){
				j.setMsg("请修改积分商品价格大于0，才能进行上架恢复！");
				j.setSuccess(false);
			}else{
				integralGoods.setIsshelves("true");
				integralService.updateRecover(integralGoods);
				j.setMsg("恢复成功！");
				j.setSuccess(true);
			}
		}catch (Exception e) {
			j.setMsg("恢复失败！");
			j.setSuccess(false);
			logger.error("recoverShelves occur error. ",e);
			e.printStackTrace();
		}
		writeJson(j);
	}
	/**
	 * 恢复时需要修改价格时跳转到修改价格的页面
	 * @Title:toEditPrice
	 * @Description:TODO(这里用一句话描述这个方法的作用)
	 * @param @return 设定文件
	 * @return String 返回类型
	 * @throws
	 * @return
	 */
	public String toEditPrice(){
		return "toEditPrice";
	}
	/**
	 * 恢复时进行价格修改
	 * @Title:updatePrice
	 * @Description:TODO(这里用一句话描述这个方法的作用)
	 * @param  设定文件
	 * @return void 返回类型
	 * @throws
	 */
	public void updatePrice(){
		Json j = new Json();
		try {
			integralService.updatePrice(integralGoods);
			j.setMsg("修改成功！");
			j.setSuccess(true);
		} catch (Exception e) {
			j.setMsg("修改失败！");
			j.setSuccess(false);
			logger.error("updatePrice occur error. ",e);
			e.printStackTrace();
		}
		writeJson(j);
	}
	
	public IntegralGoods getModel() {
		return integralGoods;
	}
}
