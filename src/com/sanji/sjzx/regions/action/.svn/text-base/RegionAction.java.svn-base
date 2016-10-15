/**  
* @Title: RegionAction.java
* @Package com.sanji.sjzx.regions.action
* @Description: TODO(用一句话描述该文件做什么)
* @author ZhouZhangbao  
* @date 2015-2-5 上午10:52:06
* @version V1.0  
*/
package com.sanji.sjzx.regions.action;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ModelDriven;
import com.sanji.sjzx.common.util.BaseAction;
import com.sanji.sjzx.model.Regions;
import com.sanji.sjzx.pojo.ComboTreeNode;
import com.sanji.sjzx.pojo.Json;
import com.sanji.sjzx.regions.service.RegionService;

/**
 * @ClassName: RegionAction
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author ZhouZhangbao
 * @date 2015-2-5 上午10:52:06
 */
@Namespace("/region")
@Action(value="regionAction", results = {
	@Result(name = "ts", location = "/admin/role/list.jsp")
	})
public class RegionAction extends BaseAction implements ModelDriven<Regions>{

	/**
	* @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)
	*/
	
	private static final long serialVersionUID = 1L;
	
	@Resource
	private RegionService regionService;
	List<ComboTreeNode> list;
	List<ComboTreeNode> children;
	private Regions regions;
	/**
	 * 获取省市区TreeList
	 */
	public void gainRegionTreeList(){
    List<Regions>	parentList = regionService.gainRegionByPid2(regions);
    if(parentList != null && parentList.size() > 0){
    	 list  = new ArrayList<ComboTreeNode>();
    	for(Regions r : parentList){
    		ComboTreeNode parentTreeNode = new ComboTreeNode();
    		parentTreeNode.setId(r.getId());
    		parentTreeNode.setText(r.getName());
        		 List<Regions> childList   = regionService.gainRegionByPid2(r);
        		if(childList != null && childList.size()>0 ){
        			 children  = new ArrayList<ComboTreeNode>();
        			 parentTreeNode.setState("closed");
        	}else{
        		 parentTreeNode.setState("open");
        	}
        	list.add(parentTreeNode);
    	}
    	
    }

		super.writeJson(list);
	}
	
	
	/*private List<ComboTreeNode> buildComboTree(Regions  regions){
		List<Regions> childList   = regionService.gainRegionByPid2(regions.getId());
		if(childList !=null && childList.size() >0){
			grandson = new ArrayList<ComboTreeNode>();
			for(Regions r: childList){
				ComboTreeNode  sonTreeNode = new ComboTreeNode();
				sonTreeNode.setId(r.getId());
				sonTreeNode.setText(r.getName());
				grandson.add(sonTreeNode);
				//buildComboTree(r);
			}
		}
		return grandson;
	}*/

	public void gainRegionByPid(){
		//List<Regions> regionsList = regionService.gainRegionByPid(pid);//省
		List<Regions> regions = regionService.gainReionById("2182");//山东省
		super.writeJson(regions);
	}
	
	public String gainTs(){
		return "ts";
	}
	/**
	 * 获取省市区树信息
	 * @Title:gainRegionsList
	 * @Description:TODO(这里用一句话描述这个方法的作用)
	 * @param  设定文件
	 * @return void 返回类型
	 * @throws
	 */
	public void gainRegionsList(){
		Json j = new Json();
		try {
			List<Regions> list = regionService.gainRegionsListByPid(regions);
			for (int i = 0; i < list.size(); i++) {
				
				if(list.get(i).getPid()==null){
					list.get(i).setPid("-1");
					list.get(i).setIcon("");
					list.get(i).setIsParent("true");
					list.get(i).setOpen(true);
				}
				//System.out.println(">>>>>  :"+list.get(i).getId()+"  "+list.get(i).getName()+"  "+list.get(i).getPid());
			}
			j.setObj(list);
			j.setMsg("加载成功!");
			j.setSuccess(true);
		} catch (Exception e) {
			e.printStackTrace();
			j.setMsg("加载失败!");
			j.setSuccess(false);
		}
		writeJson(j);
	}
	
	public void gainRegionsListByPid(){
		Json j = new Json();
		try {
			List<Regions> list = regionService.gainRegionsListByPid(regions);
			
			for(int i = 0; i < list.size(); i++){
				Long clist = regionService.gainRegionsForExsitChild(list.get(i).getId());
				if(clist > 0){
					list.get(i).setIsParent("true");
					//list.get(i).setOpen(true);
				}else{
					list.get(i).setIsParent("false");
					//list.get(i).setOpen(false);
				}
				
				
			}
			/*for (int i = 0; i < list.size(); i++) {
				
				if(list.get(i).getPid()==null){
					list.get(i).setPid("-1");
					list.get(i).setIcon("");
					list.get(i).setIsParent("true");
					list.get(i).setOpen(true);
				}
				//System.out.println(">>>>>  :"+list.get(i).getId()+"  "+list.get(i).getName()+"  "+list.get(i).getPid());
			}*/
			j.setObj(list);
			j.setMsg("加载成功!");
			j.setSuccess(true);
		} catch (Exception e) {
			e.printStackTrace();
			j.setMsg("加载失败!");
			j.setSuccess(false);
		}
		writeJson(j);
	}

	public Regions getRegions() {
		return regions;
	}

	public void setRegions(Regions regions) {
		this.regions = regions;
	}


	public Regions getModel() {
		regions = new Regions();
		return regions;
	}
	
}
