package com.sanji.sjzx.aftersale.action;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ModelDriven;
import com.sanji.sjzx.aftersale.service.QhFormService;
import com.sanji.sjzx.aftersale.service.ThFormService;
import com.sanji.sjzx.aftersale.service.ThItemService;
import com.sanji.sjzx.aftersale.service.WxFormService;
import com.sanji.sjzx.aftersale.service.WxItemService;
import com.sanji.sjzx.common.util.BaseAction;
import com.sanji.sjzx.common.util.ResourceUtil;
import com.sanji.sjzx.common.util.ToolsUtil;
import com.sanji.sjzx.dlycorp.service.DlyCorpService;
import com.sanji.sjzx.members.service.MembersService;
import com.sanji.sjzx.model.DlyCorp;
import com.sanji.sjzx.model.Members;
import com.sanji.sjzx.model.QhForm;
import com.sanji.sjzx.model.QhItem;
import com.sanji.sjzx.model.ThForm;
import com.sanji.sjzx.model.ThItem;
import com.sanji.sjzx.model.WxForm;
import com.sanji.sjzx.model.WxItem;
import com.sanji.sjzx.pojo.Json;
import com.sanji.sjzx.pojo.SessionInfo;
@Namespace("/qhForm")
@Action(value = "qhFormAction",results={
		@Result(name="toAdd",location="/admin/qhForm/add.jsp"),
		@Result(name="toUpdate",location="/admin/qhForm/update.jsp"),
		@Result(name="toAddWxForm",location="/admin/qhForm/add.jsp")
})
public class QhFormAction extends BaseAction implements ModelDriven<QhForm> {

	private static final long serialVersionUID = 1L;
	
	private static final Logger logger = Logger.getLogger(QhFormAction.class);
	
	private QhForm qhForm = new QhForm();
	
	private List<QhItem> itemList = new ArrayList<QhItem>();
	
	private SessionInfo si;

	@Resource
	private QhFormService qhFormService;
	@Resource
	private MembersService membersService;
	@Resource
	private ThItemService thItemService;
	@Resource
	private ThFormService thFormService;
	@Resource
	private DlyCorpService dlyCorpService;
	@Resource
	private WxItemService wxItemService;
	@Resource
	private WxFormService wxFormService;
	
	private String thFormId;
	
	private ThForm thForm = new ThForm();
	
	private WxForm wxForm = new WxForm();
	
	private String qhFormId;
	
	private String qhFormStatus;
	
	private DlyCorp dlyCorp = new DlyCorp();
	/**
	 * 跳转到添加取货单
	* @Title: toAdd
	* @Description: TODO(跳转到添加取货单)
	* @param @return    设定文件
	* @return String    返回类型
	* @author songbaozhen
	 */
	public String toAdd(){
	Members member = membersService.gainMemberByUsername(qhForm.getUserName());
	List<ThItem> itemList = thItemService.gainThItemList(qhForm.getId());
		request.setAttribute("member", member);
		request.setAttribute("thItemList",itemList);
		request.setAttribute("id", qhForm.getId());
		return "toAdd";
	}
	
	/**
	 * 添加取货单
	* @Title: addQhForm
	* @Description: TODO(添加取货单)
	* @param @return    设定文件
	* @return void    返回类型
	* @author songbaozhen
	 */
	public void addQhForm(){
		si = (SessionInfo) session.get(ResourceUtil.getSessionInfoName());
		Json j = new Json();
		try {
			qhForm.setId(ToolsUtil.getUUID());
			qhForm.setReadUserId(si.getUserId());
			qhForm.setStatus("NOTIFIYED");
			qhFormService.addQhForm(qhForm,itemList);
			updateThForm();
			toDBWorker();
			j.setMsg("添加成功！");
			j.setSuccess(true);				
		} catch (Exception e) {
			j.setMsg("添加失败！");
			j.setSuccess(false);
			logger.error("addQhForm() occur error. ", e);
			e.printStackTrace();
		}
		writeJson(j);
	//	qhFormService.addQhForm(qhForm,itemList);
		
	}
	/**
	 * 更新退货单
	* @Title: updateThForm
	* @Description: TODO(更新退货单)
	* @param @return    设定文件
	* @return void    返回类型
	* @author songbaozhen
	 */
	private void updateThForm(){
		thForm.setId(thFormId);
		thForm.setQhFormId(qhForm.getId());
		thForm.setStatus("NOTIFIYED");
		thFormService.updateThForm(thForm);
	}
	/**
	 * 改变维修单状态
	* @Title: changeStatus
	* @Description: TODO(改变维修单状态)
	* @param @return    设定文件
	* @return void    返回类型
	* @author songbaozhen
	 */
	public void changeStatus(){
		Json j = new Json();
		try {
			wxForm.setId(qhForm.getId());
			wxForm.setStatus(qhForm.getStatus());
			wxFormService.updateWxForm(wxForm);
				j.setMsg("设置成功！");
				j.setSuccess(true);
			
		} catch (Exception e) {
			j.setMsg("设置失败！");
			j.setSuccess(false);
			logger.error("changeStatus() occur error. ", e);
			e.printStackTrace();
		}
		writeJson(j);
//		
	}
	/**
	 * 给地包与店主信息推送预留的方法接口
	* @Title: toDBWorker
	* @Description: TODO(给地包与店主信息推送预留的方法接口)
	* @param @return    设定文件
	* @return void    返回类型
	* @author songbaozhen
	 */
	private void toDBWorker(){
		System.out.println("==================确认退货");
	}
	/**
	 * 跳转到更新界面
	* @Title: toUpdate
	* @Description: TODO(跳转到更新界面)
	* @param @return    设定文件
	* @return toUpdate    返回类型
	* @author songbaozhen
	 */
	public String toUpdate(){
		List<DlyCorp> dlyCorpsList = dlyCorpService.gainDlyCorpListAll(dlyCorp);
		request.setAttribute("dlyCorpsList", dlyCorpsList);
		request.setAttribute("id", qhForm.getId());
		return "toUpdate";
	}
	/**
	 * 跳转到添加维修单界面
	* @Title: toAddWxForm
	* @Description: TODO(跳转到添加维修单界面)
	* @param @return    设定文件
	* @return String   返回类型
	* @author songbaozhen
	 */
	public String toAddWxForm(){
		Members member = membersService.gainMemberByUsername(qhForm.getUserName());
		List<WxItem> itemList = wxItemService.gainWxItemList(qhForm.getId());
		request.setAttribute("member", member);
		request.setAttribute("thItemList",itemList);
		request.setAttribute("id", qhForm.getId());
		return "toAddWxForm";
	}
	

	public WxForm getWxForm() {
		return wxForm;
	}


	public void setWxForm(WxForm wxForm) {
		this.wxForm = wxForm;
	}


	public String getQhFormStatus() {
		return qhFormStatus;
	}


	public void setQhFormStatus(String qhFormStatus) {
		this.qhFormStatus = qhFormStatus;
	}


	public String getQhFormId() {
		return qhFormId;
	}


	public void setQhFormId(String qhFormId) {
		this.qhFormId = qhFormId;
	}


	public String getThFormId() {
		return thFormId;
	}
	public void setThFormId(String thFormId) {
		this.thFormId = thFormId;
	}
	public ThForm getThForm() {
		return thForm;
	}


	public void setThForm(ThForm thForm) {
		this.thForm = thForm;
	}


	public List<QhItem> getItemList() {
		return itemList;
	}

	public void setItemList(List<QhItem> itemList) {
		this.itemList = itemList;
	}


	public QhForm getModel() {
		// TODO Auto-generated method stub
		return qhForm;
	}

}
