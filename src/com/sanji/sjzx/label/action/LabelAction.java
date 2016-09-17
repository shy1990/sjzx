package com.sanji.sjzx.label.action;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ModelDriven;
import com.sanji.sjzx.authorityManage.admin.action.AdminAction;
import com.sanji.sjzx.common.util.BaseAction;
import com.sanji.sjzx.common.util.ToolsUtil;
import com.sanji.sjzx.goodsLabel.service.GoodsLabelService;
import com.sanji.sjzx.label.service.LabelService;
import com.sanji.sjzx.model.Label;
import com.sanji.sjzx.pojo.Json;
@Namespace("/label")
@Action(value="labelAction", results = {
	@Result(name = "toLabelList",location="/admin/label/list.jsp"),
	@Result(name = "toAdd",location="/admin/label/add.jsp"),
	@Result(name = "toUpdate",location="/admin/label/edit.jsp")
})
public class LabelAction extends BaseAction implements ModelDriven<Label> {
	
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(LabelAction.class);
	
	private Label label = new Label();
	@Resource
	private LabelService labelService;
	@Resource
	private GoodsLabelService goodsLabelService;
	
	private boolean flag;
	
	/**
	 * 跳转到标签列表页面
	* @Title: toLabelList
	* @Description: TODO(跳转到标签列表页面)
	* @param @return    设定文件
	* @return String    返回类型
	* @author songbaozhen
	 */
	public String toLabelList(){
		return "toLabelList";
	}
	
	/**
	 * 获取标签列表
	* @Title: gainLabelList
	* @Description: TODO(获取标签列表)
	* @param @return    设定文件
	* @return void   返回类型
	* @author songbaozhen
	 */
	public void gainLabelList(){
		try {
			super.writeJson(labelService.gainLabelList(label));
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("gainLabelList() occur error. ", e);
		}
	}
	
	/**
	 * 跳转到标签添加页面
	* @Title: toAddLabel
	* @Description: TODO(跳转到标签添加页面)
	* @param @return    设定文件
	* @return String   返回类型
	* @author songbaozhen
	 */
	public String toAdd(){
		return "toAdd";
	}
	/**
	 * 添加标签
	* @Title: addLabel
	* @Description: TODO(添加标签)
	* @param @return    设定文件
	* @return void   返回类型
	* @author songbaozhen
	 */
	public void addLabel(){
		Json j = new Json();
		try {
			//根据名称和主键验证标签名称是否存在
			flag = labelService.gainIsExistName(label.getName(),label.getId());
			if(flag){//不存在
				label.setId(ToolsUtil.getUUID());
				labelService.addLabel(label);
				j.setMsg("添加成功！");
				j.setSuccess(true);				
			}else{
				j.setMsg("此标签已添加！");
				j.setSuccess(false);					
			}
		} catch (Exception e) {
			j.setMsg("添加失败！");
			j.setSuccess(false);
			logger.error("addLabel() occur error. ", e);
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
	* @Title: updatelabel
	* @Description: TODO(更新编辑标签)
	* @param @return    设定文件
	* @return void   返回类型
	* @author songbaozhen
	 */
	public void updateLabel(){
		Json j = new Json();
		try {
			//根据名称和主键验证标签是否存在
			flag = labelService.gainIsExistName(label.getName(),label.getId());
			if(flag){
				
				labelService.modifylabel(label);
				j.setObj(label);
				j.setMsg("修改成功！");
				j.setSuccess(true);
			}else{
				j.setMsg("此标签已存在！");
				j.setSuccess(false);		
			}
			
		} catch (Exception e) {
			j.setMsg("修改失败！");
			j.setSuccess(false);
			logger.error("updatelabel() occur error. ", e);
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
	public void dropLabel(){
		Json j = new Json();
		try {
			//判断标签是否正在使用
			flag = goodsLabelService.existLabelIsused(ToolsUtil.StringConvertList(label.getIds()));
			if(flag){
				labelService.droplabelById(ToolsUtil.StringConvertList(label.getIds()));
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
	
	
	public Label getModel() {
		// TODO Auto-generated method stub
		return label;
	}
	
}
