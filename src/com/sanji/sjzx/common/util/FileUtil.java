/**  
* @Title: FileUtil.java
* @Package com.sanji.mall.common.util
* @Description: TODO(用一句话描述该文件做�?��)
* @author ZhouZhangbao  
* @date 2014-7-21 下午5:11:46
* @version V1.0  
*/
package com.sanji.sjzx.common.util;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URL;
import java.nio.channels.FileChannel;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;


import com.sanji.sjzx.common.util.ResourceUtil;
import com.sanji.sjzx.common.exception.ApplicationException;

/**
 * 文件工具�?
 * @ClassName: FileUtil
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author ZhouZhangbao
 * @date 2014-7-21 下午5:11:46
 */
public class FileUtil {
	
	private static final Logger logger = Logger.getLogger(FileUtil.class);

	private static final int BUFFER = 1024;
	
	/**
	 * 获取文件后缀�?
	* @Title: getTypeOfTheFile
	* @Description: TODO(这里用一句话描述这个方法的作�?
	* @param @param fileName
	* @param @return    设定文件
	* @return String    返回类型
	* @author ZhouZhangbao
	 */
	public static String getTypeOfTheFile(String fileName) {
		int pos = fileName.lastIndexOf(".");
		return fileName.substring(pos);
	}
	
	/**
	 * �?�? 拷贝文件(只能拷贝文件)
	* @Title: copyTo
	* @Description: TODO(这里用一句话描述这个方法的作�?
	* @param @param strSourceFileName 指定的文件全路径�?
	* @param @param strDestDir 拷贝到指定的文件�?
	* @param @return    如果成功true;否则false
	* @return boolean    返回类型
	* @author ZhouZhangbao
	* @throws
	 */
	public boolean copyTo(String strSourceFileName, String strDestDir) {
		File fileSource = new File(strSourceFileName);
		File fileDest = new File(strDestDir);

		// 如果源文件不存或源文件是文件�?
		if (!fileSource.exists() || !fileSource.isFile()) {
			logger.debug("源文件[" + strSourceFileName + "],不存在或是文件夹!");
			return false;
		}

		// 如果目标文件夹不存在
		if (!fileDest.isDirectory() || !fileDest.exists()) {
			if (!fileDest.mkdirs()) {
				logger.debug("目录文件夹不存，在创建目标文件夹时失�?");
				return false;
			}
		}

		try {
			String strAbsFilename = strDestDir + File.separator
					+ fileSource.getName();

			FileInputStream fileInput = new FileInputStream(strSourceFileName);
			FileOutputStream fileOutput = new FileOutputStream(strAbsFilename);

			logger.debug("�?��拷贝文件:");

			int count = -1;

			long nWriteSize = 0;
			long nFileSize = fileSource.length();

			byte[] data = new byte[BUFFER];

			while (-1 != (count = fileInput.read(data, 0, BUFFER))) {

				fileOutput.write(data, 0, count);

				nWriteSize += count;

				long size = (nWriteSize * 100) / nFileSize;
				long t = nWriteSize;

				String msg = null;

				if (size <= 100 && size >= 0) {
					msg = "\r拷贝文件进度:   " + size + "%   \t" + "\t   已拷�?   " + t;
					logger.debug(msg);
				} else if (size > 100) {
					msg = "\r拷贝文件进度:   " + 100 + "%   \t" + "\t   已拷�?   " + t;
					logger.debug(msg);
				}

			}

			fileInput.close();
			fileOutput.close();

			logger.debug("拷贝文件成功!");
			return true;

		} catch (Exception e) {
			logger.debug("异常信息：[");
			logger.error(e);
			logger.debug("]");
			return false;
		}
	}
	
	/**
	 * �?�? 拷贝文件(只能拷贝文件)
	* @Title: copyFile
	* @Description: TODO(这里用一句话描述这个方法的作�?
	* @param @param srcFile  目标拷贝的文�?
	* @param @param destFile 目的地贝文件
	* @param @return 如果成功true;否则false
	* @param @throws IOException    设定文件
	* @return boolean    返回类型
	* @author ZhouZhangbao
	* @throws
	 */
	public static boolean copyFile(File srcFile, File destFile)
			throws IOException {
		if (!srcFile.exists() || !srcFile.isFile() || !srcFile.canRead()) {
			throw new FileNotFoundException(srcFile.getAbsolutePath());
		}
		if (!destFile.exists()) {
			if (destFile.getParentFile() != null) {
				destFile.getParentFile().mkdirs();
			}
			destFile.createNewFile();
		} else if (destFile.isDirectory()) {
			destFile = new File(destFile, srcFile.getName());
		}

		if (srcFile.equals(destFile)) {
			return false;
		}

		FileChannel src = null;
		FileChannel dst = null;

		try {
			src = new FileInputStream(srcFile).getChannel();
			dst = new FileOutputStream(destFile).getChannel();
			long total = src.size();
			long curr = 0L;
			do {
				// curr += src.transferTo(curr, total - curr, dst);
				curr += dst.transferFrom(src, curr, total - curr);
			} while (curr < total);
		} finally {
			if (src != null) {
				try {
					src.close();
				} catch (Exception e) {
				}
			}
			if (dst != null) {
				try {
					dst.close();
				} catch (Exception e) {
				}
			}
			destFile.setLastModified(srcFile.lastModified());
		}
		return true;
	}
	
	/**
	 * 复制文件夹下�?��文件到指定的文件�?
	* @Title: copyFileRecursively
	* @Description: TODO(这里用一句话描述这个方法的作�?
	* @param @param src
	* @param @param dst
	* @param @throws IOException    设定文件
	* @return void    返回类型
	* @author ZhouZhangbao
	 */
	public static void copyFileRecursively(File src, File dst)
			throws IOException {
		if (src == null) {
			throw new IllegalArgumentException("src null");
		}

		if (dst == null) {
			throw new IllegalArgumentException("dst null");
		}

		if (src.equals(dst)) {
			return;
		}

		if (!src.exists() || !src.canRead()) {
			throw new IllegalStateException("File: " + src.getAbsolutePath()
					+ " can't read or exist");
		}

		if (src.isDirectory() && dst.isFile()) {
			throw new IllegalStateException("File: " + src.getAbsolutePath()
					+ " is directory while File: " + dst.getAbsolutePath()
					+ " is file");
		}

		if (!dst.exists() && dst.isDirectory()) {
			System.out.println("create dst >>> " + dst.getAbsolutePath());
			dst.getParentFile().mkdirs();
			dst.mkdir();
		}

		if (src.isDirectory()) {
			File[] files = src.listFiles();
			for (File file : files) {
				copyFileRecursively(file, new File(dst, file.getName()));
			}
		} else {
			System.out.println("copy from {" + src.getAbsolutePath() + " to "
					+ dst.getAbsolutePath() + "}");
			copyFile(src, dst);
		}
	}

	/**
	 * 删除指定的文�?
	 * 
	 * @param strFileName
	 *            指定绝对路径的文件名
	 * @return 如果删除成功true否则false
	 */
	public static boolean delete(String strFileName) {
		File fileDelete = new File(strFileName);

		if (!fileDelete.exists() || !fileDelete.isFile()) {
			logger.debug("错误: " + strFileName + "不存�?");
			return false;
		}

		return fileDelete.delete();
	}

	/**
	 * 移动文件(只能移动文件)
	 * 
	 * @param strSourceFileName
	 *            是指定的文件全路径名
	 * @param strDestDir
	 *            移动到指定的文件夹中
	 * @return 如果成功true; 否则false
	 */
	public boolean moveFile(String strSourceFileName, String strDestDir) {
		if (copyTo(strSourceFileName, strDestDir))
			return delete(strSourceFileName);
		else
			return false;
	}

	/**
	 * 创建文件�?
	 * 
	 * @param strDir
	 *            要创建的文件夹名�?
	 * @return 如果成功true;否则false
	 */
	public boolean makedir(String strDir) {
		File fileNew = new File(strDir);

		if (!fileNew.exists()) {
			logger.debug("文件夹不存在--创建文件�?");
			return fileNew.mkdirs();
		} else {
			logger.debug("文件夹存�?");
			return true;
		}
	}
	
	/**
	 * 删除文件�?
	 * 
	 * @param strDir
	 *            要删除的文件夹名�?
	 * @return 如果成功true;否则false
	 */
	public boolean removeDir(String strDir) {
		File rmDir = new File(strDir);
		if (rmDir.isDirectory() && rmDir.exists()) {
			String[] fileList = rmDir.list();
			for (int i = 0; i < fileList.length; i++) {
				String subFile = strDir + File.separator + fileList[i];
				File tmp = new File(subFile);
				if (tmp.isFile())
					tmp.delete();
				else if (tmp.isDirectory())
					removeDir(subFile);
				else {
					logger.debug("error!");
				}
			}
			rmDir.delete();
		} else
			return false;
		return true;
	}
	
	/**
	 * 功能说明：附件下�?
	 * 
	 * @param request
	 * @param response
	 * @param accessoryPath
	 *            附件相对路径
	 * @param fileName
	 *            下载的附件名�?
	 * @param isOnLine
	 *            是否在线打开
	 * @throws ApplicationException
	 * @time Dec 7, 2010 11:18:39 AM
	 */
	public static String downloadFile(HttpServletRequest request,
			HttpServletResponse response,String fileName, boolean isOnLine)
			throws ApplicationException {
		String path="../download/"+fileName;//从页面获取要下载的文件的相对路径
		String filePath = ResourceUtil.getWebAppPath()+path;
		FileInputStream fis = null;
		BufferedInputStream bufInStream = null;
		OutputStream outStream = null;
		try {
			File file = new File(filePath);
			if (!file.exists())
				throw new ApplicationException("对不起，文件" + fileName + "找不�?");
			fis = new FileInputStream(file);
			bufInStream = new BufferedInputStream(fis);
			String nameStr = new String(fileName.getBytes("GBK"), "ISO8859-1")
					+ "\"";
			response.reset();
			if (isOnLine) {// 在线打开方式
				URL u = new URL("file:///" + filePath);
				response.setContentType(u.openConnection().getContentType());
				response.setHeader("Content-Disposition", "inline; filename="
						+ nameStr);
			} else {// 纯下载方�?
				response.setContentType("application/x-msdownload");
				response.setHeader("Content-Disposition",
						"attachment; filename=" + nameStr);
			}
			byte[] buffer = new byte[10240];
			int len = 0;
			outStream = response.getOutputStream();
			while ((len = bufInStream.read(buffer)) > 0) {
				outStream.write(buffer, 0, len);
				outStream.flush();
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (fis != null)
					fis.close();
				if (bufInStream != null)
					bufInStream.close();
				// if(outStream != null)
				// outStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	
	/**
	 * 附件上传,验证扩展�?
	* @Title: uploadFile
	* @Description: TODO(这里用一句话描述这个方法的作�?
	* @param @param request
	* @param @param file
	* @param @param accessoryPath
	* @param @param allowExt
	* @param @param fileName
	* @param @return    设定文件
	* @return String    返回类型
	* @author ZhouZhangbao
	 */
	public static String uploadFile(HttpServletRequest request, File file,String accessoryPath, String allowExt, String fileName) {
		if (file == null)
			return "";
		// 文件上传目录
		String savePath = ResourceUtil.getWebAppPath() + accessoryPath + "/";// 文件保存目录路径
		String databasePath = accessoryPath + "/";// 数据库存放路�?

		// �?��文件扩展�?
		String fileExt = fileName.substring(fileName.lastIndexOf(".") + 1)
				.toLowerCase();
		if (!Arrays.<String> asList(allowExt.split(",")).contains(fileExt)) {
			return "";
		}
		savePath += fileExt + "/";
		databasePath += fileExt + "/";
		SimpleDateFormat yearDf = new SimpleDateFormat("yyyy");
		SimpleDateFormat monthDf = new SimpleDateFormat("MM");
		SimpleDateFormat dateDf = new SimpleDateFormat("dd");
		Date date = new Date();
		String ymd = yearDf.format(date) + "/" + monthDf.format(date) + "/"
				+ dateDf.format(date) + "/";
		savePath += ymd;
		databasePath += ymd;
		File uploadDir = new File(savePath);// 创建要上传文件到指定的目�?
		if (!uploadDir.exists()) {
			uploadDir.mkdirs();
		}

		String tempName = "";
		for (int i = 0; i < 6; i++) {
			tempName += ToolsUtil.getRandomChar();
		}
		fileName = tempName + "_" + fileName;
		// 文件上传
		String outPath = uploadDir + File.separator + fileName;

		databasePath = databasePath + fileName;
		try {
			FileInputStream fis = new FileInputStream(file);
			FileOutputStream fos = new FileOutputStream(outPath);
			byte[] buffer = new byte[10240];
			int len = 0;
			while ((len = fis.read(buffer)) > 0) {
				fos.write(buffer, 0, len);
				fos.flush();
			}
			fis.close();
			fos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return databasePath;// 返回的相对路�?
		// return outPath; //返回的绝对路�?
	}
	
	/**
	 * 附件上传,不验证扩展名
	* @Title: uploadFile
	* @Description: TODO(这里用一句话描述这个方法的作�?
	* @param @param request
	* @param @param file file对象
	* @param @param accessoryPath 附件路径
	* @param @param fileName 附件名称
	* @param @return    设定文件
	* @return String    返回类型
	* @author ZhouZhangbao
	 */
	public static String uploadFile(HttpServletRequest request, File file,
			String accessoryPath, String fileName) {
		if (file == null)
			return "";
		// 文件上传目录
		String savePath = ResourceUtil.getWebAppPath() + accessoryPath + "/";// 文件保存目录路径
		// �?��文件扩展�?
		String fileExt = fileName.substring(fileName.lastIndexOf(".") + 1)
				.toLowerCase();
		savePath += fileExt + "/";
		SimpleDateFormat yearDf = new SimpleDateFormat("yyyy");
		SimpleDateFormat monthDf = new SimpleDateFormat("MM");
		SimpleDateFormat dateDf = new SimpleDateFormat("dd");
		Date date = new Date();
		String ymd = yearDf.format(date) + "/" + monthDf.format(date) + "/"
				+ dateDf.format(date) + "/";
		savePath += ymd;
		File uploadDir = new File(savePath);// 创建要上传文件到指定的目�?
		if (!uploadDir.exists()) {
			uploadDir.mkdirs();
		}

		String tempName = "";
		for (int i = 0; i < 6; i++) {
			tempName += ToolsUtil.getRandomChar();
		}
		fileName = tempName + "_" + fileName;
		// 文件上传
		String outPath = uploadDir + File.separator + fileName;
		try {
			FileInputStream fis = new FileInputStream(file);
			FileOutputStream fos = new FileOutputStream(outPath);
			byte[] buffer = new byte[10240];
			int len = 0;
			while ((len = fis.read(buffer)) > 0) {
				fos.write(buffer, 0, len);
				fos.flush();
			}
			fis.close();
			fos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return outPath;
	}
	
	/**
	 * 功能说明：附件删�?
	* @Title: unuploadFileForUpdate
	* @Description: TODO(这里用一句话描述这个方法的作�?
	* @param @param request
	* @param @param file file对象
	* @param @param accessoryPath 附件路径
	* @param @param newFileName 新文件名�?
	* @param @param oldFileName 旧文件名�?
	* @param @return    设定文件
	* @return String    返回类型
	* @author ZhouZhangbao
	 */
	public static String unuploadFileForUpdate(HttpServletRequest request,
			File file, String accessoryPath, String newFileName,
			String oldFileName) {
		// 文件上传目录
		// String uploadDir = request.getRealPath(File.separator) +
		// accessoryPath;
		String uploadDir = ToolsUtil.getClusterResourcePath("") + accessoryPath;
		// 如果目录不存在则自动创建
		File dirPath = new File(uploadDir);
		if (!dirPath.exists()) {
			dirPath.mkdirs();
		}

		if ((oldFileName != null || !"".equals(oldFileName)) && file != null) {
			File[] files = dirPath.listFiles();
			for (File filee : files) {
				if (filee.getName().equals(oldFileName)) {
					filee.delete();
					break;
				}
			}
		}
		if (file != null)
			return uploadFile(request, file, accessoryPath, newFileName);
		return "";
	}

	/**
	 * 功能说明：附件删�?
	 * 
	 * @param request
	 * @param accessoryPath
	 *            附件路径
	 * @param oldFileName
	 *            旧文件名�?
	 * @time Oct 19, 2010 10:28:00 PM
	 */
	public static void deleteAccessoryFile(HttpServletRequest request,
			String accessoryPath, String oldFileName) {
		// 文件上传目录
		// String uploadDir = request.getRealPath(File.separator) +
		// accessoryPath;
		String uploadDir = ToolsUtil.getClusterResourcePath("") + accessoryPath;
		// 如果目录不存在则自动创建
		File dirPath = new File(uploadDir);
		if (oldFileName != null || !"".equals(oldFileName)) {
			File[] files = dirPath.listFiles();
			for (File filee : files) {
				if (filee.getName().equals(oldFileName)) {
					filee.delete();
					break;
				}
			}
		}
	}

	/**
	 * 删除指定的文�?
	 * 
	 * @param strFileName
	 *            指定绝对路径的文件名
	 * @return 如果删除成功true否则false
	 */
	public boolean deleteFile(String strFileName) {
		File fileDelete = new File(strFileName);

		if (!fileDelete.exists() || !fileDelete.isFile()) {
			logger.debug("错误: " + strFileName + "不存�?");
			return false;
		}

		return fileDelete.delete();
	}

	
	/**
	 * 获取文件后缀�?
	* @Title: getExtention
	* @Description: TODO(这里用一句话描述这个方法的作�?
	* @param @param fileName
	* @param @return    设定文件
	* @return String    返回类型
	* @author ZhouZhangbao
	 */
	public static String getExtention(String fileName) {
		int pos = fileName.lastIndexOf(".");
		return fileName.substring(pos);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public static void main(String[] args) throws IOException {
		File t=new File("E:\\test1");
		File s=new File("E:\\test2");
		copyFileRecursively(t,s);
	}

}
