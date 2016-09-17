/**  
* @Title: AdminInfoMsgServiceImpl.java
* @Package com.sanji.sjzx.authorityManage.admin.service.impl
* @Description: TODO(用一句话描述该文件做什么)
* @author ZhouZhangbao  
* @date 2015-2-5 下午4:28:23
* @version V1.0  
*/
package com.sanji.sjzx.authorityManage.admin.service.impl;

import java.util.ArrayList;
import java.util.List;

import javassist.compiler.ast.NewExpr;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.sanji.sjzx.authorityManage.admin.dao.AdminInfoMsgMapper;
import com.sanji.sjzx.authorityManage.admin.service.AdminInfoMsgService;
import com.sanji.sjzx.common.util.ToolsUtil;
import com.sanji.sjzx.model.AdminInfoMsg;

/**
 * @ClassName: AdminInfoMsgServiceImpl
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author ZhouZhangbao
 * @date 2015-2-5 下午4:28:23
 */
@Service("adminInfoMsgService")
public class AdminInfoMsgServiceImpl implements AdminInfoMsgService {

	@Resource
	private AdminInfoMsgMapper adminInfoMsgMapper;
	
	/* (非 Javadoc)
	* <p>Title: gainInfoMsgByUserId</p>
	* <p>Description: </p>
	* @param userId
	* @return
	* @see com.sanji.sjzx.authorityManage.admin.service.AdminInfoMsgService#gainInfoMsgByUserId(java.lang.String)
	*/
	
	public List<AdminInfoMsg> gainInfoMsgByUserId(AdminInfoMsg adminInfoMsg) {
		// TODO Auto-generated method stub
		return adminInfoMsgMapper.gainInfoMsgByUserId(adminInfoMsg);
	}

	/* (非 Javadoc)
	* <p>Title: addMsgAuthors</p>
	* <p>Description: </p>
	* @param aid
	* @param mids
	* @param type
	* @see com.sanji.sjzx.authorityManage.admin.service.AdminInfoMsgService#addMsgAuthors(java.lang.String, java.lang.String, java.lang.String)
	*/
	
	public void addMsgAuthors(AdminInfoMsg adminInfoMsg) {
		adminInfoMsgMapper.deleteByUserIdAndType(adminInfoMsg);
		if (adminInfoMsg.getRegionsList() !=null && adminInfoMsg.getRegionsList().size()>0) {
			adminInfoMsgMapper.addMsgAuthors(getMsgAuthors(adminInfoMsg));
		}
		
	}
	
	
	private List<AdminInfoMsg> getMsgAuthors(AdminInfoMsg infoMsg){
		List<AdminInfoMsg> adminInfoMsgs = new ArrayList<AdminInfoMsg>();
		AdminInfoMsg adminInfoMsg ;
		for (int i = 0; i < infoMsg.getRegionsList().size(); i++) {
			adminInfoMsg = new AdminInfoMsg();
			adminInfoMsg.setId(ToolsUtil.getUUID());
			adminInfoMsg.setRegions(infoMsg.getRegionsList().get(i));
			adminInfoMsg.setType(infoMsg.getType());
			adminInfoMsg.setUserId(infoMsg.getUserId());
			adminInfoMsgs.add(adminInfoMsg);
		}
		
		return adminInfoMsgs;
	};

}
