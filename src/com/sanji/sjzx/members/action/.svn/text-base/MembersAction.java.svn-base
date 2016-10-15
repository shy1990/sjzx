package com.sanji.sjzx.members.action;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ModelDriven;
import com.sanji.sjzx.apps.service.AppsService;
import com.sanji.sjzx.common.util.BaseAction;
import com.sanji.sjzx.common.util.ResourceUtil;
import com.sanji.sjzx.common.util.ToolsUtil;
import com.sanji.sjzx.members.service.MembersService;
import com.sanji.sjzx.model.Apps;
import com.sanji.sjzx.model.Members;
import com.sanji.sjzx.model.MembersGoodsShow;
import com.sanji.sjzx.pojo.Json;
import com.sanji.sjzx.pojo.SessionInfo;

@Namespace("/members")
@Action(value="membersAction", results={
		@Result(name="toMembersList", location="/admin/members/list.jsp"),
		@Result(name="toShowMembers", location="/admin/members/showMembers.jsp"),
		@Result(name="disabledList", location="/admin/members/disabledList.jsp"),
		@Result(name="toImport_Ex_atypeData", location="/admin/members/atype_Ex_Import.jsp"),
		@Result(name = "exportExcel",type= "stream" ,
		params = {
			"contentType"," application/vnd.ms-excel",
	        "inputName","excelStream",
	        "contentDisposition","attachment;filename=\"members.xls\"",
	        "bufferSize","1024"})
})
public class MembersAction extends BaseAction
  implements ModelDriven<Members>
{
  private static final long serialVersionUID = 1L;
  private static final Logger logger = Logger.getLogger(MembersAction.class);
  private Members members = new Members();
  private List<Members> membersList;
  private MembersGoodsShow membersGoodsShow = new MembersGoodsShow();
  private List<MembersGoodsShow> membersGoodsList = new ArrayList();
  private SessionInfo sInfo = null;

  @Resource
  private MembersService membersService;
  private Apps apps = new Apps();

  @Resource
  private AppsService appsService;
  private String mid;
  private InputStream excelStream;
  private String areaid;

  public String getAreaid() { return this.areaid; }

  public void setAreaid(String areaid)
  {
    this.areaid = areaid;
  }

  public InputStream getExcelStream() {
    return this.excelStream;
  }

  public void setExcelStream(InputStream excelStream) {
    this.excelStream = excelStream;
  }

  public String getMid() {
    return this.mid;
  }

  public void setMid(String mid) {
    this.mid = mid;
  }

  public Members getMembers() {
    return this.members;
  }

  public void setMembers(Members members) {
    this.members = members;
  }

  public List<Members> getMembersList() {
    return this.membersList;
  }

  public void setMembersList(List<Members> membersList) {
    this.membersList = membersList;
  }

  public MembersService getMembersService() {
    return this.membersService;
  }

  public void setMembersService(MembersService membersService) {
    this.membersService = membersService;
  }

  public static Logger getLogger() {
    return logger;
  }

  public Members getModel() {
    return this.members;
  }

  public Apps getApps() {
    return this.apps;
  }

  public void setApps(Apps apps) {
    this.apps = apps;
  }


  public void gainMembersByRegions()
  {
    Json json = new Json();
    try {
      List list = this.membersService.gainMembersByRegions(this.areaid);

      if ((list != null) && (list.size() > 0)) {
        json.setObj(list);
        json.setMsg("加载成功!");
        json.setSuccess(Boolean.valueOf(true));
      } else {
        json.setMsg("加载失败!");
        json.setSuccess(Boolean.valueOf(false));
      }
    }
    catch (Exception e) {
      e.printStackTrace();
      json.setMsg("加载失败!");
      json.setSuccess(Boolean.valueOf(false));
    }
    writeJson(json);
  }

  public void addVisibleSku()
  {
    Json j = new Json();
    try {
      this.sInfo = ((SessionInfo)this.session.get(ResourceUtil.getSessionInfoName()));
      this.membersGoodsShow.setUserId(this.sInfo.getUserId());
      this.membersService.addVisibleSku(this.membersGoodsShow, this.members.getIds(), ToolsUtil.StringConvertList(this.members.getSkuIds()));
      j.setMsg("设置成功！");
      j.setSuccess(Boolean.valueOf(true));
    } catch (Exception e) {
      j.setMsg("设置失败！");
      j.setSuccess(Boolean.valueOf(false));
      logger.error("addVisibleSku() occur error. ", e);
      e.printStackTrace();
    }
    writeJson(j);
  }

  public String exportMembersExcel()
  {
    List list = this.membersService.gainMembersByExport(this.members);
    this.excelStream = this.membersService.exportDateToExcel(list);
    return "exportExcel";
  }

  public void gainMembersGoodsByMid()
  {
    String sids = "";

    this.membersGoodsList = this.membersService.gainMembersGoodsByMembersId(ToolsUtil.StringConvertList(this.members.getIds()));
    writeJson(this.membersGoodsList);
  }

  public String toMembersList()
  {
    return "toMembersList";
  }

  public void gainMembersList()
  {
    try
    {
      super.writeJson(this.membersService.gainMembersList(this.members));
    } catch (Exception e) {
      e.printStackTrace();
      logger.error("gainMembersList() occur error. ", e);
    }
  }

  public String toDisabledList()
  {
    return "disabledList";
  }

  public void gainDisabledMembersList()
  {
    try
    {
      super.writeJson(this.membersService.gainDisabledMembersList(this.members));
    } catch (Exception e) {
      e.printStackTrace();
      logger.error("gainDisabledMembersList() occur error. ", e);
    }
  }

  public void enableMembers()
  {
    Json j = new Json();
    try {
      this.membersService.enableMembersById(ToolsUtil.StringConvertList(this.members.getIds()));
      j.setMsg("设置成功！");
      j.setSuccess(Boolean.valueOf(true));
    } catch (Exception e) {
      j.setMsg("设置失败！");
      j.setSuccess(Boolean.valueOf(false));
      logger.error("enableMembersById() occur error. ", e);
      e.printStackTrace();
    }
    writeJson(j);
  }

  public void deleteMembers()
  {
    Json j = new Json();
    try {
      String ids = this.request.getParameter("ids");
      String[] str = ids.split(",");
      for (int i = 0; i < str.length; i++) {
        String memberId = str[i];
        List list = this.appsService.gainAppsByMemberId(memberId);
        if ((list != null) && (list.size() > 0)) {
          j.setMsg("该会员存在商铺，不能删除！");
          j.setSuccess(Boolean.valueOf(false));
        } else {
          this.membersService.deleteMembers(ToolsUtil.StringConvertList(this.members.getIds()));
          j.setMsg("删除成功！");
          j.setSuccess(Boolean.valueOf(true));
        }
      }
    }
    catch (Exception e) {
      j.setMsg("删除失败！");
      j.setSuccess(Boolean.valueOf(false));
      logger.error("deleteMembers() occur error. ", e);
      e.printStackTrace();
    }
    writeJson(j);
  }

  public void closePay()
  {
    Json j = new Json();
    try {
      String ids = this.request.getParameter("ids");
      String[] str = ids.split(",");
      for (int i = 0; i < str.length; i++) {
        String memberId = str[i];
        List list = this.membersService.gainBlackMembersById(memberId);

        if ((list != null) && (list.size() > 0)) {
          j.setMsg("该会员已经关闭货到付款！");
          j.setSuccess(Boolean.valueOf(false));
        } else {
          this.membersService.insertBlackMembers(ToolsUtil.StringConvertList(memberId));

          j.setMsg("关闭成功！");
          j.setSuccess(Boolean.valueOf(true));
        }
      }
    }
    catch (Exception e) {
      j.setMsg("设置失败！");
      j.setSuccess(Boolean.valueOf(false));
      logger.error("insertBlackMembers() occur error. ", e);
      e.printStackTrace();
    }
    writeJson(j);
  }

  public void openPay()
  {
    Json j = new Json();
    try {
      String ids = this.request.getParameter("ids");
      String[] str = ids.split(",");
      for (int i = 0; i < str.length; i++) {
        String memberId = str[i];
        List list = this.membersService.gainBlackMembersById(memberId);
        if ((list != null) && (list.size() > 0)) {
          this.membersService.deleteBlackMembers(ToolsUtil.StringConvertList(memberId));
          j.setMsg("打开成功！");
          j.setSuccess(Boolean.valueOf(true));
        } else {
          j.setMsg("该会员没有关闭货到付款！");
          j.setSuccess(Boolean.valueOf(false));
        }
      }
    }
    catch (Exception e) {
      j.setMsg("设置失败！");
      j.setSuccess(Boolean.valueOf(false));
      logger.error("insertBlackMembers() occur error. ", e);
      e.printStackTrace();
    }
    writeJson(j);
  }

  public String toImport_Ex_atypeData()
  {
    return "toImport_Ex_atypeData";
  }

  public void import_Ex_atypeData()
  {
    Json json = new Json();
    try {
      String msg1 = "其中不存在的会员名称为:";

      String target = ServletActionContext.getServletContext().getRealPath("");
      if (this.members.getMyFile() != null) {
        target = target + ToolsUtil.uploadFile(this.request, this.members.getMyFile(), 
          "/attached/excel", "xls,xlsx", this.members.getMyFileFileName());
        if (target.equals("")) {
          uploadError("上传文件失败！", "上传文件扩展名是不允许的扩展名。\n只允许xls,xlsx格式！");
          return;
        }
        target = target.replace("../", "/");
        target = target.replace("/", "\\");
       // target = target.replace("/", "\\");适用Linux
        InputStream is = new FileInputStream(target);
        Workbook rwb = Workbook.getWorkbook(is);

        Sheet st = rwb.getSheet("Sheet1");
        int rs = st.getColumns();
        int rows = st.getRows();

       // System.out.println("列数===>" + rs + "行数：" + rows);
        for (int i = 1; i < rows; i++) {
          Cell c0 = st.getCell(0, i);
          String s0 = c0.getContents().trim();
          Cell c4 = st.getCell(4, i);
          String s4 = c4.getContents().trim();
          Cell c6 = st.getCell(6, i);
          String s6 = c6.getContents().trim();
          //System.out.println("会员名" + s0);
          if (this.membersService.gainMembersByName(s0))
          {
            msg1 = msg1 + s0 + ",";
          }
          else if ((s0 != null) && (!"".equals(s0))) {
            Members mem = new Members();
            mem.setMobile(s6);
            mem.setAType(s4);
            this.membersService.updateAtypeByMobile(mem);
          }
        }

        json.setSuccess(Boolean.valueOf(true));
        json.setMsg(msg1 + "<br/>");
      }
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (BiffException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }

    super.writeJson(json);
  }

  private void uploadError(String err, String msg)
  {
    Map m = new HashMap();
    m.put("err", err);
    m.put("msg", msg);
    super.writeJson(m);
  }

  public String toShowMembers()
  {
    try
    {
      this.members = this.membersService.gainMembersById(this.members.getId());
    } catch (Exception e) {
      e.printStackTrace();
    }
    return "toShowMembers";
  }

  public void gainMembersById()
  {
    super.writeJson(this.membersService.gainMembersById(this.members.getId()));
  }
}