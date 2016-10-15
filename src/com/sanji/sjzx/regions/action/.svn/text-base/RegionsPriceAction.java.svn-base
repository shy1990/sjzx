package com.sanji.sjzx.regions.action;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ModelDriven;
import com.sanji.sjzx.common.util.BaseAction;
import com.sanji.sjzx.model.RegionsPrice;
import com.sanji.sjzx.pojo.Json;
import com.sanji.sjzx.regions.service.RegionsPriceService;

@Namespace("/regionsPrice")
@Action(value="regionsPriceAction", results = {
	@Result(name = "ts", location = "/admin/role/list.jsp")
})
public class RegionsPriceAction extends BaseAction implements ModelDriven<RegionsPrice>{
	
	private static final long serialVersionUID = 1L;
	
	@Resource
	private RegionsPriceService regionsPriceService;
	private RegionsPrice regionsPrice = new RegionsPrice();

	/**
	 * 添加地域价格信息
	 * @Title:addRegionsPrice
	 * @Description:TODO(这里用一句话描述这个方法的作用)
	 * @param  设定文件
	 * @return void 返回类型
	 * @throws
	 */
	public void addRegionsPrice(){
		Json j = new Json();
		try {
			regionsPriceService.addRegionsPrice(regionsPrice);
			j.setMsg("添加成功！");
			j.setSuccess(true);
		} catch (Exception e) {
			j.setMsg("添加失败！");
			j.setSuccess(false);
		}
		writeJson(j);
	}
	/**
	 * 修改地域价格信息
	 * @Title:updateRegionsPrice
	 * @Description:TODO(这里用一句话描述这个方法的作用)
	 * @param  设定文件
	 * @return void 返回类型
	 * @throws
	 */
/*	public void updateRegionsPrice(){
		Json j = new Json();
		try {
			regionsPriceService.updateRegionsPrice(regionsPrice.getId());
			j.setMsg("修改成功！");
			j.setSuccess(true);
		} catch (Exception e) {
			j.setMsg("修改失败！");
			j.setSuccess(false);
		}
		writeJson(j);
	}*/
	
	public RegionsPrice getRegionsPrice() {
		return regionsPrice;
	}

	public void setRegionsPrice(RegionsPrice regionsPrice) {
		this.regionsPrice = regionsPrice;
	}

	public RegionsPrice getModel() {
		return regionsPrice;
	}
	
}
