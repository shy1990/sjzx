package com.sanji.sjzx.system.friendlylink.action;

import java.io.File;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.dispatcher.multipart.MultiPartRequestWrapper;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;
import com.sanji.sjzx.common.util.BaseAction;
import com.sanji.sjzx.common.util.FtpUtil;
import com.sanji.sjzx.common.util.ResourceUtil;
import com.sanji.sjzx.common.util.ToolsUtil;
import com.sanji.sjzx.model.FriendlyLink;
import com.sanji.sjzx.pojo.Json;
import com.sanji.sjzx.pojo.SessionInfo;
import com.sanji.sjzx.system.friendlylink.service.FriendlyLinkService;
@Namespace("/friendlyLink")
@Action(value ="friendlyLinkAction",results = {
		@Result(name = "toFriendlyLinkList", location = "/admin/friendlyLink/list.jsp"),
		@Result(name = "toAdd", location = "/admin/friendlyLink/add.jsp"),
		@Result(name = "toUpdate", location = "/admin/friendlyLink/edit.jsp")
})
public class FriendlyLinkAction extends BaseAction implements ModelDriven<FriendlyLink>{
	
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(FriendlyLinkAction.class);
	private SessionInfo sInfo = null;
	private boolean flag;
	private FriendlyLink friendlyLink ;
	private File file;
	@Resource
	private FriendlyLinkService friendlyLinkService;
	
	public FriendlyLink getModel() {
		if(friendlyLink == null){
			friendlyLink = new FriendlyLink();
		}
		return friendlyLink;
	}
	/**
	 * 跳转到友情链接公司列表页面
	* @Title: tofriendlyLinkLost
	* @Description: TODO(跳转到友情链接公司列表页面)
	* @param @return    设定文件
	* @return String    返回类型
	* @author songbaozhen
	 */
	public String toFriendlyLinkList(){
		
		return "toFriendlyLinkList";
	}
	/**
	 * 获取友情链接公司列表
	* @Title: gainfriendlyLinkList
	* @Description: TODO(获取友情链接公司列表)
	* @param @return    设定文件
	* @return void   返回类型
	* @author songbaozhen
	 */
	public void gainFriendlyLinkList(){
		try {
			super.writeJson(friendlyLinkService.gainFriendlyLinkList(friendlyLink));
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("gainFriendlyLinkList() occur error. ", e);
		}
		
	}
	
	/**
	 * 跳转到友情链接公司添加页面
	 * @return
	 */
	public String toAdd(){
	BigDecimal	orderNum = new BigDecimal(friendlyLinkService.getMaxOrderNum());
	friendlyLink.setOrderlist(orderNum);
	ActionContext.getContext().getSession().put("friendlyLink", friendlyLink);
		return "toAdd";
	}
	
	/**
	 * 添加友情链接公司列表
	* @Title: addfriendlyLink
	* @Description: TODO(添加友情链接公司)
	* @param @return    设定文件
	* @return void   返回类型
	* @author songbaozhen
	 */
	public void addFriendlyLink(){
		Json j = new Json();
		try {
			//查询验证物理公司名称是否存在
			flag = friendlyLinkService.gainIsExistName(friendlyLink.getName(),friendlyLink.getId());
			
			if(flag){//不存在
				friendlyLink.setId(ToolsUtil.getUUID());
				friendlyLink.setName(friendlyLink.getName());
				friendlyLink.setHref(friendlyLink.getHref());
				friendlyLink.setImageUrl(friendlyLink.getImageUrl());
				friendlyLink.setOrderlist(friendlyLink.getOrderlist());
			    friendlyLinkService.addFriendlyLink(friendlyLink);
				j.setMsg("添加成功！");
				j.setSuccess(true);				
			}else{
				j.setMsg("此友情链接公司已添加！");
				j.setSuccess(false);					
			}
		} catch (Exception e) {
			j.setMsg("添加失败！");
			j.setSuccess(false);
			logger.error("addFriendlyLink() occur error. ", e);
			e.printStackTrace();
		}
		writeJson(j);
	}
	
	/**
	 * 跳转到友情链接公司修改页面
	 * @return
	 */
	public String toUpdate(){
		String imgUrl = friendlyLinkService.gainFriendlyLinkByIdForImageUrl(friendlyLink.getId());
		request.setAttribute("imgUrl", imgUrl);
		return "toUpdate";
	}
	/**
	 * 更新友情链接公司
	* @Title: updatefriendlyLink
	* @Description: TODO(更新友情链接公司)
	* @param @return    设定文件
	* @return viud   返回类型
	* @author songbaozhen
	 */
	public void updateFriendlyLink(){
		Json j = new Json();
		try {
			//根据公司名称和主键验证友情链接公司是否存在
			flag = friendlyLinkService.gainIsExistName(friendlyLink.getName(),friendlyLink.getId());
			if(flag){
				friendlyLink.setName(friendlyLink.getName());
				friendlyLink.setHref(friendlyLink.getHref());
				friendlyLink.setImageUrl(friendlyLink.getImageUrl());
				friendlyLinkService.modifyFriendlyLink(friendlyLink);
				j.setObj(friendlyLink);
				j.setMsg("修改成功！");
				j.setSuccess(true);
			}else{
				j.setMsg("此友情链接公司已添加！");
				j.setSuccess(false);		
			}
			
		} catch (Exception e) {
			j.setMsg("修改失败！");
			j.setSuccess(false);
			logger.error("updatefriendlyLink() occur error. ", e);
			e.printStackTrace();
		}
		writeJson(j);
	}
	
	/**
	 * 删除单条或批量删除友情链接公司(物理删除)
	* @Title: dropfriendlyLink
	* @Description: TODO(删除单条或批量删除友情链接公司)
	* @param @return    设定文件
	* @return void   返回类型
	* @author songbaozhen
	 */
	public void dropFriendlyLink(){
		Json j = new Json();
		try {
			friendlyLinkService.dropFriendlyLinkById(ToolsUtil.StringConvertList(friendlyLink.getIds()));
			j.setMsg("删除成功！");
			j.setSuccess(true);	
		} catch (Exception e) {
			j.setMsg("删除失败！");
			j.setSuccess(false);
			logger.error("dropfriendlyLink() occur error. ", e);
			e.printStackTrace();
		}
		writeJson(j);
	}
	/**
	* @Title: toupLoader
	* @Description: TODO跳转上传页面弹窗
	* @param @return    设定文件
	* @return String    返回类型
	*/
	public String toUpLoaderForAdd(){
		try {
			request.setAttribute("id",ToolsUtil.getUUID());
			return "toUpLoaderForAdd";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public void ftpUpload(){
		try {
			Map<String,Object> map=new HashMap<String,Object>();
			FtpUtil ftp= new FtpUtil(ResourceUtil.getFtpIp(), ResourceUtil.getFtpUserName(), ResourceUtil.getFtpPassword());
			ftp.connectServer();
			String savePath=ResourceUtil.getGoods_Img_Directory();
			if(!ftp.isDirExist(savePath)){
				ftp.createDir(savePath);
			}
			ftp.cd(savePath);
			try {
				ftp.upload(this.file.getPath(), request.getParameter("name"));
				map.put("status", true);
				map.put("newName", request.getParameter("name"));
				map.put("thumbPath", ResourceUtil.getWebPath()+savePath+"/"+request.getParameter("name"));
			} catch (Exception e) {
				this.uploadError("上传文件失败！", request.getParameter("name"));
				return;
			}
			ftp.closeServer();
			super.writeJson(map);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	* @Title: uploadError
	* @Description: TODO上传失败
	* @param @param err
	* @param @param msg    设定文件
	* @return void    返回类型
	 */
	private void uploadError(String err, String msg) {
		Map<String, Object> m = new HashMap<String, Object>();
		m.put("err", err);
		m.put("msg", msg);
		super.writeJson(m);
	}
	/**
	* @Title: uploadError
	* @Description: TODO上传失败
	* @param @param err
	* @param @param msg    设定文件
	* @return void    返回类型
	 */
	private void uploadError(String err) {
		this.uploadError(err, "");
	}
	/**
	* @Title: uploadError
	* @Description: TODO上传成功
	* @param @param err
	* @param @param msg    设定文件
	* @return void    返回类型
	 */
	private void uploadSuccess(String newFileName, String fileName, int id) {
		Map<String, Object> m = new HashMap<String, Object>();
		m.put("err", "");
		Map<String, Object> nm = new HashMap<String, Object>();
		nm.put("url", newFileName);
		nm.put("localfile", fileName);
		nm.put("id", id);
		m.put("msg", nm);
		super.writeJson(m);
	}
	/**
	 * @return the file
	 */
	public File getFile() {
		return file;
	}
	/**
	 * @param file the file to set
	 */
	public void setFile(File file) {
		this.file = file;
	}
	

}
