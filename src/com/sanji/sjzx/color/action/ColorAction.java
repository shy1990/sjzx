package com.sanji.sjzx.color.action;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ModelDriven;
import com.sanji.sjzx.color.service.ColorService;
import com.sanji.sjzx.common.util.BaseAction;
import com.sanji.sjzx.common.util.ToolsUtil;
import com.sanji.sjzx.model.Color;
import com.sanji.sjzx.pojo.Json;
@Namespace("/color")
@Action(value = "colorAction", results = {
		@Result (name = "toColorList", location = "/admin/color/list.jsp"),
		@Result (name = "toAdd", location = "/admin/color/add.jsp"),
		@Result (name = "toUpdate", location = "/admin/color/edit.jsp"),
		@Result (name = "selectColor", location = "/admin/color/color.jsp")
})
public class ColorAction extends BaseAction implements ModelDriven<Color> {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(ColorAction.class);
	private boolean flag;
	private Color color = new Color();
	@Resource
	private ColorService colorService;
	
	public void gainColorsList(){
		try {
			super.writeJson(colorService.gainAllColors(color));
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	/**
	 * 跳转到颜色列表页面
	* @Title: toColorList
	* @Description: TODO(跳转到颜色列表页面)
	* @param @return    设定文件
	* @return String    返回类型
	* @author songbaozhen
	 */
	public String toColorList(){
		return "toColorList";
	}

	/**
	 * 获取标签列表
	* @Title: gainColorList
	* @Description: TODO(获取标签列表)
	* @param @return    设定文件
	* @return void   返回类型
	* @author songbaozhen
	 */
	public void gainColorList(){
		try {
			super.writeJson(colorService.gainColorList(color));
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("gainColorList() occur error. ", e);
		}
	}

	/**
	 * 跳转到颜色添加页面
	* @Title: toAddcolor
	* @Description: TODO(跳转到颜色添加页面)
	* @param @return    设定文件
	* @return String   返回类型
	* @author songbaozhen
	 */
	public String toAdd(){
		return "toAdd";
	}
	/**
	 * 添加颜色
	* @Title: addcolor
	* @Description: TODO(添加颜色)
	* @param @return    设定文件
	* @return void   返回类型
	* @author songbaozhen
	 */
	public void addColor(){
		Json j = new Json();
		try {
			//根据名称和主键验证标签名称是否存在
			flag = colorService.gainIsExistName(color.getColorName(),color.getId());
			System.out.println("============="+flag);
			if(flag){//不存在
				colorService.addColor(color);
				j.setMsg("添加成功！");
				j.setSuccess(true);				
			}else{
				j.setMsg("此标签已添加！");
				j.setSuccess(false);					
			}
		} catch (Exception e) {
			j.setMsg("添加失败！");
			j.setSuccess(false);
			logger.error("addColor() occur error. ", e);
			e.printStackTrace();
		}
		writeJson(j);
	}
	
	
	/**
	 * 跳转到标签修改页面
	 * @return
	 */
	public String toUpdate(){
		return "toUpdate";
	}
	
	/**
	 * 更新编辑标签
	* @Title: updatecolor
	* @Description: TODO(更新编辑标签)
	* @param @return    设定文件
	* @return void   返回类型
	* @author songbaozhen
	 */
	public void updateColor(){
		Json j = new Json();
		try {
			//根据名称和主键验证标签是否存在
			flag =colorService.gainIsExistName(color.getColorName(),color.getId());
			if(flag){
				
				colorService.modifyColor(color);
				j.setObj(color);
				j.setMsg("修改成功！");
				j.setSuccess(true);
			}else{
				j.setMsg("此标签已存在！");
				j.setSuccess(false);		
			}
			
		} catch (Exception e) {
			j.setMsg("修改失败！");
			j.setSuccess(false);
			logger.error("updateColor() occur error. ", e);
			e.printStackTrace();
		}
		writeJson(j);
	}
	
	/**
	 *删除单条或批量删除标签(物理删除)
	* @Title: updatelabel
	* @Description: TODO(删除单条或批量删除标签(物理删除))
	* @param @return    设定文件
	* @return viud   返回类型
	* @author songbaozhen
	 */
	public void dropColor(){
		Json j = new Json();
		try {
			//判断颜色是否正在使用
			flag = colorService.existColorIsused(ToolsUtil.StringConvertList(color.getIds()));
			if(flag){
				colorService.deleteColorById(ToolsUtil.StringConvertList(color.getIds()));
				j.setMsg("删除成功！");
				j.setSuccess(true);	
			}else{
				j.setMsg("此标签正在使用中！");
				j.setSuccess(false);
			}
			
		} catch (Exception e) {
			j.setMsg("删除失败！");
			j.setSuccess(false);
			logger.error("droplabel() occur error. ", e);
			e.printStackTrace();
		}
		writeJson(j);
	}
	
	public String selectColor(){
		
		return "selectColor";
	}
	public Color getModel() {
		// TODO Auto-generated method stub
		return color;
	}
}
