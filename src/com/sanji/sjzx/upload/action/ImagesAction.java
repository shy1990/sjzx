/**  
* @Title: ImagesAction.java
* @Package com.sanji.sjzx.upload.action
* @Description: TODO(用一句话描述该文件做什么)
* @author ZhouZhangbao  
* @date 2014-9-13 下午5:34:10
* @version V1.0  
*/
package com.sanji.sjzx.upload.action;

import java.io.File;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.dispatcher.multipart.MultiPartRequestWrapper;

import sun.net.ftp.FtpClient;

import com.sanji.sjzx.common.util.BaseAction;
import com.sanji.sjzx.common.util.FtpUtil;
import com.sanji.sjzx.common.util.ResourceUtil;
import com.sanji.sjzx.common.util.ToolsUtil;

/**
 * @ClassName: ImagesAction
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author ZhouZhangbao
 * @date 2014-9-13 下午5:34:10
 */
@Namespace("/")
//命名空间
@Action(value = "imagesAction", results = {
		@Result(name = "toUpLoaderForAdd", location = "/admin/upload/uploaderForAdd.jsp"),
		@Result(name = "toUpLoaderForEdit", location = "/admin/upoad/uploaderForEdit.jsp")})
public class ImagesAction extends BaseAction{

	/**
	* @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)
	*/
	
	private static final long serialVersionUID = 1L;
	
	private File file;
	
	/**
	* @Title: toupLoader
	* @Description: TODO跳转上传页面弹窗
	* @param @return    设定文件
	* @return String    返回类型
	*/
	public String toUpLoaderForAdd(){
		try {
			request.setAttribute("id",ToolsUtil.getUUID());
			System.out.println(">>>>>>>>>>>>>");
			return "toUpLoaderForAdd";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public String toUpLoaderForEdit(){
		request.setAttribute("id",ToolsUtil.getUUID());
		return "toUpLoaderForEdit";
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
		String savePath=ResourceUtil.getUploadDirectory()+"/";
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
			// TODO Auto-generated catch block
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
	
		// 删除文件至FTP通用方法
		public static void deleteFileFtp(String fileName){
			try {
				
				
				FtpClient ftpClient = new FtpClient("192.168.2.141", 21);// ftpHost为FTP服务器的IP地址，port为FTP服务器的登陆端口,ftpHost为String型,port为int型。
				ftpClient.login("3j", "sanji168");// userName、passWord分别为FTP服务器的登陆用户名和密码
				ftpClient.binary();
				ftpClient.cd("/attached/img");// path为FTP服务器上保存上传文件的路径。
				try {
					ftpClient.sendServer("dele " + fileName + "\r\n");
				} catch (Exception e) {
					System.out.println("删除文件失败！请检查系统FTP设置,并确认FTP服务启动");
				}
				ftpClient.closeServer();
			} catch (Exception e) {
				System.out.println("删除文件失败！");
			}
		}
		/**
		 * 上传图片，并返回地址<br>为APP开发接口
		* @Title: uploadFileByFile
		* @Description: TODO(这里用一句话描述这个方法的作用)
		* @param @param uploadFile
		* @param @param uploadFileName
		* @param @return    设定文件
		* @return String    返回类型
		* @author ZhouZhangbao
		 */
		public String uploadFileByFile(File uploadFile,String uploadFileName){
			String uploadURL =null;
			if(uploadFile!=null){
				String extName = uploadFileName.substring(uploadFileName.lastIndexOf(".")+ 1).toLowerCase();
				FtpUtil ftp= new FtpUtil(ResourceUtil.getFtpIp(), ResourceUtil.getFtpUserName(), ResourceUtil.getFtpPassword());
				ftp.connectServer();
				String savePath=ResourceUtil.getNewsUploadDirectory()+"/dianpu/";
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
					return null;
				}
				ftp.upload(uploadFile.getPath(),newFileName);
				uploadURL = saveUrl+newFileName;
			}
			return uploadURL;
		}
	
	public static void main(String[] args) {
		try {
			deleteFileFtp("/attached/1234.jpg");
		} catch (Exception e) {
			// TODO: handle exception
		}
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
