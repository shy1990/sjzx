package com.sanji.sjzx.cat.action;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ModelDriven;
import com.sanji.sjzx.cat.service.CatService;
import com.sanji.sjzx.common.util.BaseAction;
import com.sanji.sjzx.common.util.ToolsUtil;
import com.sanji.sjzx.model.Cat;
import com.sanji.sjzx.pojo.Json;
@Namespace("/cat")
@Action(value = "catAction", results = {
		@Result(name = "toCatList", location = "/admin/cat/list.jsp"),
		@Result(name = "toAdd", location = "/admin/cat/add.jsp"),
		@Result(name = "toUpdate", location = "/admin/cat/edit.jsp")})

public class CatAction extends BaseAction implements ModelDriven<Cat>{
	
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(CatAction.class);
	private Cat cat = new Cat();
	private List<Cat> catList;
	@Resource
	private CatService catService;
	public Cat getCat() {
		return cat;
	}
	public void setCat(Cat cat) {
		this.cat = cat;
	}
	public List<Cat> getCatList() {
		return catList;
	}
	public void setCatList(List<Cat> catList) {
		this.catList = catList;
	}
	public Cat getModel() {
		return cat;
	}
	private boolean flag = false;
	/**
	 * 跳转到cat列表页面
	 * @return
	 */
	public String toCatList(){
		return "toCatList";
	}
	/**
	 * cat列表
	 */
	public void gainCatList(){
		try{
			super.writeJson(catService.gainCatList(cat));
		}catch (Exception e) {
			logger.error("gainCatList() occur error. ",e);
			e.printStackTrace();
		}
	}
	/**
	 * 跳转到添加页面
	 */
	public String toAdd(){
		return "toAdd";
	}
	/**
	 * 添加cat
	 */
	public void addCat(){
		Json j = new Json();
		try {
			flag=catService.gainCatByName(cat.getName());
			if(flag){//该name不存在
				cat.setId(ToolsUtil.getUUID());
				catService.addCat(cat);
				j.setObj(cat);
				j.setMsg("添加成功!");
				j.setSuccess(true);				
			}else{
				j.setMsg("此分类名称已经存在!");
				j.setSuccess(false);
			}
		} catch (Exception e) {
			j.setMsg("添加失败!");
			j.setSuccess(false);
			logger.error("addCat() occur error. ", e);
			e.printStackTrace();
		}
		writeJson(j);
	}
	/**
	 * 跳转到修改页面
	 */
	public String toUpdate(){
		return "toUpdate";
	}
	/**
	 * 修改cat
	 */
	public void updateCat(){
		Json j = new Json();
		try {
			flag=catService.gainCatByNameandId(cat.getId(), cat.getName());
			if(flag){//该name不存在
				catService.updateCat(cat);
				j.setObj(cat);
				j.setMsg("修改成功!");
				j.setSuccess(true);				
			}else{
				j.setMsg("此分类名称已经存在!");
				j.setSuccess(false);
			}
		} catch (Exception e) {
			j.setMsg("修改失败!");
			j.setSuccess(false);
			logger.error("updateUpdate() occur error. ", e);
			e.printStackTrace();
		}
		writeJson(j);
	}
	/**
	 * 删除相应id的记录 
	 */
	public void dropCat(){
		Json j = new Json();
		try { 
			String ids = request.getParameter("ids");			
			if(ids!=null && ids !=""){
				String []str = ids.split(",");
				for(int i=0;i<str.length;i++){
					String id = str[i].replace(",", "");
					flag = catService.gainGoodsByCatId(id);
					if(!flag){//存在
						j.setMsg("该类别下有关联商品,无法删除!");
						j.setSuccess(false);			
					}else{
						catService.dropCat(ToolsUtil.StringConvertList(cat.getIds()));
						j.setMsg("删除成功！");
						j.setSuccess(true);			
					}
				}
			}
		} catch (Exception e) {
			j.setMsg("删除失败！");
			j.setSuccess(false);
			logger.error("dropCat() occur error. ", e);
			e.printStackTrace();
		}
		writeJson(j);
	}
}
