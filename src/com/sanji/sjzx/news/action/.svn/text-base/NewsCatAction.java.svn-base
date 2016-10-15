package com.sanji.sjzx.news.action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;


import com.opensymphony.xwork2.ModelDriven;
import com.sanji.sjzx.common.util.BaseAction;
import com.sanji.sjzx.common.util.ToolsUtil;
import com.sanji.sjzx.model.NewsCat;
import com.sanji.sjzx.news.service.NewsCatService;
import com.sanji.sjzx.news.service.NewsService;
import com.sanji.sjzx.pojo.Json;

/**
 * @ClassName: NewsCatAction
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author ZhouZhangbao
 * @date 2013-5-17 下午3:34:08
 *
 */
@Action(value = "newsCat", results = {
		@Result(name = "toList", location = "/admin/newsCat/list.jsp"),
		@Result(name = "toAdd", location = "/admin/newsCat/add.jsp"),
		@Result(name = "toEdit", location = "/admin/newsCat/edit.jsp")})
public class NewsCatAction extends BaseAction implements ModelDriven<NewsCat>{
	private static final long serialVersionUID = 5681734021324829579L;
	@Autowired
	private NewsCatService newsCatService;
	@Autowired
	private NewsService newsService;
	private NewsCat newsCat=new NewsCat();
	
	/**
	 * @return the newsCat
	 */
	public NewsCat getNewsCat() {
		return newsCat;
	}
	/**
	 * @param newsCat the newsCat to set
	 */
	public void setNewsCat(NewsCat newsCat) {
		this.newsCat = newsCat;
	}

	public NewsCat getModel() {
		return newsCat;
	}
	public String toList(){
		return "toList";
	}
	public String toAdd(){
		request.setAttribute("pid", request.getParameter("id"));
		return "toAdd";
	}
	public String toEdit(){
		newsCat=newsCatService.gainNewsCatById(request.getParameter("id"));
		return "toEdit";
	}
	public void gainAll(){
		super.writeJson(newsCatService.gainAll(newsCat));
	}
	/**
	* @Title: add
	* @Description: TODO(这里用一句话描述这个方法的作用)
	* @param     设定文件
	* @return void    返回类型
	*/
	public void add(){
		Json j=new Json();
		newsCat.setId(ToolsUtil.getUUID());
		if(newsCat.getPid()!=null&&!"".equals(newsCat.getPid())){
			NewsCat pnewsCat=newsCatService.gainNewsCatById(newsCat.getPid());
			if(pnewsCat.getGrade()>=2){
				j.setSuccess(false);
				j.setMsg("添加失败,深度级别不能超过2!");
				super.writeJson(j);
				return ;
			}
			newsCat.setGrade(pnewsCat.getGrade()+1);//设置深度
			if(pnewsCat.getPtree()!=null){
				newsCat.setPtree(pnewsCat.getPtree()+newsCat.getPid()+",");
			}else{
				newsCat.setPtree(newsCat.getPid()+",");
			}
		}else{
			newsCat.setGrade(0L);
		}
		try {
			newsCatService.addNewsCat(newsCat);
			j.setSuccess(true);
			j.setMsg("添加成功");
		} catch (Exception e) {
			j.setSuccess(false);
			j.setMsg("添加失败");
			e.printStackTrace();
		}
		super.writeJson(j);
	}
	
	public void edit(){
		Json j=new Json();
		if(newsCat.getPid()!=null&&!"".equals(newsCat.getPid())){
			if(newsCat.getPid().equals(newsCat.getId())){
				j.setSuccess(false);
				j.setMsg("添加失败,上级分类不能选中自己!");
				super.writeJson(j);
				return ;
			}
			NewsCat pnewsCat=newsCatService.gainNewsCatById(newsCat.getPid());
			if(pnewsCat.getGrade()>=2){
				j.setSuccess(false);
				j.setMsg("添加失败,深度级别不能超过2!");
				super.writeJson(j);
				return ;
			}
			if(isChildren(newsCat.getId(),pnewsCat.getPtree())){//判断是否是将当前节点修改到当前节点的子节点
				j.setSuccess(false);
				j.setMsg("父类节点不允许移动到子类节点当中");
				super.writeJson(j);
				return ;
			}
			newsCat.setGrade(pnewsCat.getGrade()+1);//设置深度
			if(pnewsCat.getPtree()!=null){
				newsCat.setPtree(pnewsCat.getPtree()+newsCat.getPid()+",");
			}else{
				newsCat.setPtree(newsCat.getPid()+",");
			}
		}else{//没有选中上级菜单
			newsCat.setGrade(0L);
		}
		try {
			newsCatService.updateNewsCat(newsCat);
			j.setSuccess(true);
			j.setMsg("编辑成功");
		} catch (Exception e) {
			j.setSuccess(false);
			j.setMsg("添加失败");
			e.printStackTrace();
		}
		super.writeJson(j);
	}

	/**
	 * 判断是否是将当前节点修改到当前节点的子节点
	 * 
	 * @param id
	 *            当前节点
	 * @param ptree
	 *            要修改到的节点的ptree
	 * @return
	 */
	private boolean isChildren(String id, String ptree) {
		if(ptree!=null&&ptree.contains(id)){
			return true;
		}else{
			return false;
		}
	}
	
	
	/**
	* @Title: gainFirstNewsCat
	* @Description: TODO获取一级商品分类
	* @param     设定文件
	* @return void    返回类型
	*/
	public void gainFirstNewsCat(){
		super.writeJson(newsCatService.gainFirstNewsCat(newsCat));
	}
	
	/**
	* @Title: gainSecondNewsCat
	* @Description: TODO根据一级商品分类获取二级商品分类
	* @param     设定文件
	* @return void    返回类型
	*/
	public void gainSecondNewsCat(){
		super.writeJson(newsCatService.gainSecondNewsCatByFirstId(request.getParameter("id")));
	}
	
	/**
	* @Title: drop
	* @Description: TODO删除分类
	* @param     设定文件
	* @return void    返回类型
	*/
	public void drop(){
		Json j=new Json();
		String id=request.getParameter("id");
		Long count =newsService.gainNewsCountByNewsCatId(id);
		Long count1=newsCatService.gainNewsCatChildByPid(id);
		if(count1>0){
			j.setSuccess(false);
			j.setMsg("要删除的该分类下有子类,请清空之后之后再操作");
			super.writeJson(j);
			return ;
		}
		if(count>0){
			j.setSuccess(false);
			j.setMsg("要删除的该分类下有文章,无法删除,请清空该分类下的文章之后再操作");
			super.writeJson(j);
			return ;
		}
		try {
			newsCatService.drop(newsCat);
			j.setMsg("删除成功");
			j.setSuccess(true);
		} catch (Exception e) {
			j.setSuccess(false);
			j.setMsg("删除失败");
			e.printStackTrace();
		}
		super.writeJson(j);
	}
}
