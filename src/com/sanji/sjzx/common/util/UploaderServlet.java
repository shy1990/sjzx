package com.sanji.sjzx.common.util;

/**
 * 图片上传
 */
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;

import com.sanji.sjzx.common.util.FtpUtil;
import com.sanji.sjzx.common.util.ResourceUtil;
public class UploaderServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	String repositoryPath;
	String uploadPath;
	String webPath;
	FtpUtil ftp;

	@SuppressWarnings("unchecked")
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		Integer schunk = null;//分割块数
		Integer schunks = null;//总分割数
		String name = null;//文件�?
		BufferedOutputStream outputStream=null; 
		if (ServletFileUpload.isMultipartContent(request)) {
			try {
				DiskFileItemFactory factory = new DiskFileItemFactory();
				factory.setSizeThreshold(1024);
				factory.setRepository(new File(repositoryPath));//设置临时目录
				ServletFileUpload upload = new ServletFileUpload(factory);
				upload.setHeaderEncoding("UTF-8");
				upload.setSizeMax(5 * 1024 * 1024);//设置附近大小
				List<FileItem> items = upload.parseRequest(request);
				//生成新文件名
				String newFileName = null;
				for (FileItem item : items) {
					if (!item.isFormField()) {// 如果是文件类�?
						name = item.getName();// 获得文件�?
						newFileName = UUID.randomUUID().toString().replace("-","").concat(".").concat(FilenameUtils.getExtension(name));
						if (name != null) {
							String nFname = newFileName;
							if (schunk != null) {
								nFname = schunk + "_" + name;
							}
							File savedFile = new File(uploadPath, nFname);
							item.write(savedFile);
						}
					} else {
						//判断是否带分割信�?
						if (item.getFieldName().equals("chunk")) {
							schunk = Integer.parseInt(item.getString());
						}
						if (item.getFieldName().equals("chunks")) {
							schunks = Integer.parseInt(item.getString());
						}
					}
				}
				
				if (schunk != null && schunk + 1 == schunks) {
					outputStream = new BufferedOutputStream(new FileOutputStream(new File(uploadPath, newFileName)));
					//遍历文件合并
					for (int i = 0; i < schunks; i++) {
						File tempFile=new File(uploadPath,i+"_"+name);
						byte[] bytes=FileUtils.readFileToByteArray(tempFile);  
						outputStream.write(bytes);
						outputStream.flush();
						tempFile.delete();
					}
					outputStream.flush();
				}
				String imgPath=ResourceUtil.getGoods_Img_Directory()+"/"+newFileName;
//				String thumb=ResourceUtil.getGoods_Img_thumb_Directory()+"/"+newFileName;
//				String standard=ResourceUtil.getGoods_Img_standard_Directory()+"/"+newFileName;
//				ZoomImage.zoomImage(webPath+imgPath,webPath+thumb, 55, 41, false);
//				ZoomImage.zoomImage(webPath+imgPath, webPath+standard, 310, 233,false);
				response.getWriter().write("{\"status\":true,\"newName\":\""+newFileName+"\",\"thumbPath\":\""+imgPath+"\"}");
			} catch (FileUploadException e) {
				e.printStackTrace();
				response.getWriter().write("{\"status\":false}");
			} catch (Exception e) {
				e.printStackTrace();
				response.getWriter().write("{\"status\":false}");
			}finally{  
	            try {  
	            	if(outputStream!=null)
	            		outputStream.close();  
	            } catch (IOException e) {  
	                e.printStackTrace();  
	            }  
	        }   
		}
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		ftp=new FtpUtil("120.192.31.153", "admin", "123456");
		ftp.connectServer();
		repositoryPath = FileUtils.getTempDirectoryPath();
		webPath=config.getServletContext().getRealPath("")+"/";
		uploadPath = webPath+ResourceUtil.getGoods_Img_Directory();
		File up = new File(uploadPath);
		if(!up.exists()){
			up.mkdirs();
		}
	}
}
