package com.sanji.sjzx.news.action;


import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.dispatcher.multipart.MultiPartRequestWrapper;
import org.springframework.beans.factory.annotation.Autowired;


import com.opensymphony.xwork2.ModelDriven;
import com.sanji.sjzx.common.exception.SystemException;
import com.sanji.sjzx.common.util.BaseAction;
import com.sanji.sjzx.common.util.FtpUtil;
import com.sanji.sjzx.common.util.ResourceUtil;
import com.sanji.sjzx.common.util.ToolsUtil;
import com.sanji.sjzx.model.News;
import com.sanji.sjzx.news.service.NewsService;
import com.sanji.sjzx.pojo.DataGrid;
import com.sanji.sjzx.pojo.Json;
import com.sanji.sjzx.pojo.SessionInfo;

/**
 * @ClassName: newsAction
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author ZhouZhangbao 
 * @date 2013-5-3 上午9:13:40
 *
 */
@Action(value = "news", results = {
		@Result(name = "toList", location = "/admin/news/list.jsp"),
		@Result(name = "toRecycleList", location = "/admin/news/newsRecycle.jsp"),
		@Result(name = "toAdd", location = "/admin/news/add.jsp"),
		@Result(name = "toEdit", location = "/admin/news/edit.jsp"),
		@Result(name = "toUpload", location = "/admin/news/uploader.jsp")})
public class NewsAction extends BaseAction implements ModelDriven<News>{
	private static final long serialVersionUID = 1L;
	@Autowired
	private NewsService newsService;
	private News news=new News();
	
	/* (非 Javadoc)
	 * <p>Title: getModel</p>
	 * <p>Description: </p>
	 * @return
	 * @see com.opensymphony.xwork2.ModelDriven#getModel()
	 */
	public News getModel() {
		return news;
	}
	public String toList(){
		return "toList";
	}
	public String toRecycleList(){
		return "toRecycleList";
	}
	
	public String toAdd(){
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
		request.setAttribute("currentTime", df.format(new Date()));
		return "toAdd";
	}
	
	public String toUpload(){
		return "toUpload";
	}
	
	public String toEdit(){
		news=newsService.gainNewsById(news.getId());
		return "toEdit";
	}
	
	/**
	 * @return the news
	 */
	public News getNews() {
		return news;
	}
	/**
	 * @param news the news to set
	 */
	public void setNews(News news) {
		this.news = news;
	}
	public String toRecycle(){
		return "toRecycle";
	}
	
	public void gainNewsById(){
		news=newsService.gainNewsById(news.getId());
	}
	
	
	/**
	* @Title: delete
	* @Description: TODO逻辑删除
	* @param     设定文件
	* @return void    返回类型
	*/
	public void delete(){
		Json j=new Json();
		try {
			newsService.delete(ToolsUtil.StringConvertList(news.getIds()));
			j.setSuccess(true);
			j.setMsg("删除成功");
		} catch (SystemException e) {
			j.setSuccess(false);
			j.setMsg("删除失败");
			e.printStackTrace();
		}
		super.writeJson(j);
	}
	
	/**
	* @Title: recover
	* @Description: TODO恢复
	* @param     设定文件
	* @return void    返回类型
	*/
	public void recover(){
		Json j=new Json();
		try {
			newsService.recover(ToolsUtil.StringConvertList(news.getIds()));
			j.setSuccess(true);
			j.setMsg("恢复成功");
		} catch (SystemException e) {
			j.setSuccess(false);
			j.setMsg("恢复失败");
			e.printStackTrace();
		}
		super.writeJson(j);
	}

	public void drop(){
		Json j=new Json();
		try {
			newsService.drop(ToolsUtil.StringConvertList(news.getIds()));
			j.setSuccess(true);
			j.setMsg("删除成功");
		} catch (SystemException e) {
			j.setSuccess(false);
			j.setMsg("删除失败");
			e.printStackTrace();
		}
		super.writeJson(j);
	}
	/**
	* @Title: gainAll
	* @Description: TODO获取所有有效的文章列表
	* @param     设定文件
	* @return void    返回类型
	*/
	public void gainAll(){
		DataGrid d=new DataGrid();
		news.setDisabled("false");
		d.setRows(newsService.gainAll(news));
		d.setTotal(newsService.gainAllCount(news));
		super.writeJson(d);
	}
	
	public void gainAllRecycle(){
		DataGrid d=new DataGrid();
		news.setDisabled("true");
		d.setRows(newsService.gainAll(news));
		d.setTotal(newsService.gainAllCount(news));
		super.writeJson(d);
	}

	/**
	* @Title: addNews
	* @Description: TODO添加商品
	* @param     设定文件
	* @return void    返回类型
	*/
	public void addNews(){
		Json j=new Json();
		SessionInfo si=(SessionInfo) session.get(ResourceUtil.getSessionInfoName());
		news.setStatus("true");
		news.setIsCallCenter(1);
		if(news.getMyFile()!=null){
			String extName = news.getMyFileFileName().substring(news.getMyFileFileName().lastIndexOf(".")+ 1).toLowerCase();
			FtpUtil ftp= new FtpUtil(ResourceUtil.getFtpIp(), ResourceUtil.getFtpUserName(), ResourceUtil.getFtpPassword());
			ftp.connectServer();
			String savePath=ResourceUtil.getNewsUploadDirectory()+"/titleImg/";
			String saveUrl=ResourceUtil.getWebPath()+savePath;
			if(!ftp.isDirExist(savePath)){
				ftp.createDir(savePath);
			}
			ftp.cd(savePath);
			String newFileName = UUID.randomUUID().toString()
					.replaceAll("-", "")
					+ "." + extName;
			if (!Arrays.<String> asList(
					ResourceUtil.getImage_Ext().split(",")).contains(
							extName)) {
				this.uploadError("上传文件扩展名是不允许的扩展名。\n只允许"
						+ ResourceUtil.getImage_Ext() + "格式！");
				return;
			}
			ftp.upload(news.getMyFile().getPath(),newFileName);
			news.setNewsPic(saveUrl+newFileName);
		}
		try {
			news.setId(ToolsUtil.getUUID());
			news.setModifytime(new Date());
			news.setUserId(si.getUserId());
			news.setResources(news.getResources().replaceAll(",", ""));
			newsService.addNews(news);
			j.setSuccess(true);
			j.setMsg("添加成功");
		} catch (SystemException e) {
			j.setSuccess(false);
			j.setMsg("添加失败");
			e.printStackTrace();
		}
		super.writeJson(j);
	}
	
	/**
	* @Title: updateNews
	* @Description: TODO更新商品
	* @param     设定文件
	* @return void    返回类型
	*/
	public void updateNews(){
		Json j=new Json();
		news.setStatus("true");
		news.setIsCallCenter(1);
		if(news.getMyFile()!=null){
			FtpUtil ftp= new FtpUtil(ResourceUtil.getFtpIp(), ResourceUtil.getFtpUserName(), ResourceUtil.getFtpPassword());
			ftp.connectServer();
			String extName = news.getMyFileFileName().substring(news.getMyFileFileName().lastIndexOf(".")+ 1).toLowerCase();
			String savePath=ResourceUtil.getNewsUploadDirectory()+"/titleImg/";
			String saveUrl=ResourceUtil.getWebPath()+savePath;
			if(!ftp.isDirExist(savePath)){
				ftp.createDir(savePath);
			}
			ftp.cd(savePath);
			String newFileName = UUID.randomUUID().toString().replaceAll("-", "")+ "." + extName;
			if (!Arrays.<String> asList(
					ResourceUtil.getImage_Ext().split(",")).contains(
							extName)) {
				this.uploadError("上传文件扩展名是不允许的扩展名。\n只允许"
						+ ResourceUtil.getImage_Ext() + "格式！");
				return;
			}
			ftp.upload(news.getMyFile().getPath(),newFileName);
			news.setNewsPic(saveUrl+newFileName);
		}
		
		try {
			news.setModifytime(new Date());
			newsService.updateNews(news);
			j.setSuccess(true);
			j.setMsg("编辑成功");
		} catch (SystemException e) {
			j.setSuccess(false);
			j.setMsg("编辑失败");
			e.printStackTrace();
		}
		super.writeJson(j);
	}
	
	/**
	* @Title: upload
	* @Description: TODO文件上传功能
	* @param     设定文件
	* @return void    返回类型
	*/
	public void upload() {
		FtpUtil ftp= new FtpUtil(ResourceUtil.getFtpIp(), ResourceUtil.getFtpUserName(), ResourceUtil.getFtpPassword());
		ftp.connectServer();
		String savePath=ResourceUtil.getNewsUploadDirectory()+"/";
		String saveUrl=ResourceUtil.getWebPath()+savePath;
		if(!ftp.isDirExist(savePath)){
			ftp.createDir(savePath);
		}
		ftp.cd(savePath);
		
		MultiPartRequestWrapper multiPartRequest = (MultiPartRequestWrapper) ServletActionContext
				.getRequest();// 由于struts2上传文件时自动使用了request封装
		File[] files = multiPartRequest.getFiles(ResourceUtil
				.getUploadFieldName());// 上传的文件集合
		String[] fileNames = multiPartRequest.getFileNames(ResourceUtil
				.getUploadFieldName());// 上传文件名称集合

		if (files == null || files.length < 1) {
			this.uploadError("您没有上传任何文件！");
			return;
		}
		for (int i = 0; i < files.length; i++) {// 循环所有文件
			File file = files[i];// 上传的文件(临时文件)
			String fileName = fileNames[i];// 上传文件名
			
			if (file.length() > ResourceUtil.getUploadFileMaxSize()) {
				this.uploadError("上传文件超出限制大小！", fileName);
				return;
			}
			// 检查文件扩展名
			String fileExt = fileName.substring(fileName.lastIndexOf(".") + 1)
					.toLowerCase();
			if (!Arrays.<String> asList(
					ResourceUtil.getUploadFileExts().split(",")).contains(
					fileExt)) {
				this.uploadError("上传文件扩展名是不允许的扩展名。\n只允许"
						+ ResourceUtil.getUploadFileExts() + "格式！");
				return;
			}
			String newFileName = UUID.randomUUID().toString()
					.replaceAll("-", "")
					+ "." + fileExt;// 新的文件名称
			try {
				ftp.upload(file.getPath(),newFileName);
			} catch (Exception e) {
				this.uploadError("上传文件失败！", fileName);
				return;
			}
			ftp.closeServer();
			this.uploadSuccess( saveUrl + newFileName, fileName, i);// 文件上传成功
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
		this.uploadError("", err);
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
}
