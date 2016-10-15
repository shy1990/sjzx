package com.sanji.sjzx.news.action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;


import com.opensymphony.xwork2.ModelDriven;
import com.sanji.sjzx.common.util.BaseAction;
import com.sanji.sjzx.common.util.ToolsUtil;
import com.sanji.sjzx.model.NewsCatType;
import com.sanji.sjzx.news.service.NewsCatTypeService;
import com.sanji.sjzx.pojo.DataGrid;
import com.sanji.sjzx.pojo.Json;

/**
 * @ClassName: NewsCatTypeAction
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author ZhouZhangbao
 * @date 2013-5-11 上午10:11:18
 *
 */
@Action(value = "newsCatType", results = {
		@Result(name = "toList", location = "/admin/newsCatType/list.jsp"),
		@Result(name = "toAdd", location = "/admin/newsCatType/add.jsp"),
		@Result(name = "toEdit", location = "/admin/newsCatType/edit.jsp")})
public class NewsCatTypeAction extends BaseAction implements ModelDriven<NewsCatType>{
	
	private static final long serialVersionUID = 1L;
	@Autowired
	private NewsCatTypeService newsCatTypeService;
	private NewsCatType newsCatType=new NewsCatType();
	
	public NewsCatType getModel() {
		// TODO Auto-generated method stub
		return newsCatType;
	}
	/**
	 * @return the newsCatType
	 */
	public NewsCatType getNewsCatType() {
		return newsCatType;
	}
	/**
	 * @param newsCatType the newsCatType to set
	 */
	public void setNewsCatType(NewsCatType newsCatType) {
		this.newsCatType = newsCatType;
	}
	public String toList(){
		return "toList";
	}
	public String toAdd(){
		return "toAdd";
	}
	public String toEdit(){
		newsCatType=newsCatTypeService.gainNewsCatTypeById(request.getParameter("id"));
		return "toEdit";
	}

	/**
	* @Title: gainAllList
	* @Description: TODO list
	* @param     设定文件
	* @return void    返回类型
	*/
	public void gainAllList(){
		DataGrid j=new DataGrid();
		j.setRows(newsCatTypeService.gainAllList(newsCatType));
		j.setTotal(newsCatTypeService.gainAllCount(newsCatType));
		super.writeJson(j);
	}
	/**
	* @Title: gainAll
	* @Description: TODO分类类型下拉框
	* @param     设定文件
	* @return void    返回类型
	*/
	public void gainAll(){
		super.writeJson(newsCatTypeService.gainAll(newsCatType));
	}
	
	
	public void add(){
		Json j=new Json();
		newsCatType.setId(ToolsUtil.getUUID());
		try {
			newsCatTypeService.add(newsCatType);
			j.setSuccess(true);
			j.setMsg("添加成功");
		} catch (Exception e) {
			j.setSuccess(false);
			j.setMsg("添加失败");
			e.printStackTrace();
		}
		super.writeJson(j);
	}
	
	public void update(){
		Json j=new Json();
		try{
			newsCatTypeService.update(newsCatType);
			j.setSuccess(true);
			j.setMsg("更新成功");
		} catch (Exception e) {
			j.setSuccess(false);
			j.setMsg("更新失败");
			e.printStackTrace();
		}
		super.writeJson(j);
	}
	
	public void drop(){
		Json j=new Json();
		try{
			newsCatTypeService.drop(request.getParameter("id"));
			j.setSuccess(true);
			j.setMsg("删除成功");
		} catch (Exception e) {
			j.setSuccess(false);
			j.setMsg("删除失败");
			e.printStackTrace();
		}
		super.writeJson(j);
	}
}
