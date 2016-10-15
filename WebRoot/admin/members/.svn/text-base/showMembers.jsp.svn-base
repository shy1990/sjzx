<%@ page language="java" import="java.util.*,com.sanji.sjzx.common.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%
String basePath = PathUtil.getPath(request);
%>
<div class="easyui-layout" data-options="fit:true,border:false">
	<div data-options="region:'center',border:true,split:false">
		<form id="admin_showMembers_showForm" method="post">
			<table  id="admin_members_datagrid" class="tableForm" style="margin-left: 70px;margin-top: 15px">
				<tr>
					<th><!-- 会员ID： --></th>
					<td><input type="hidden" name="id" value="<s:property value='members.id'/>"  /></td>				
				</tr>
				<tr>
					<th>登录名称：</th>
					<td><input name="username" class="easyui-validatebox"
						data-options="required:true" style="width:160px" readonly="readonly" value="<s:property value='members.username'/>"/></td>
				</tr>
				<tr>	
					<th>真实姓名：</th>
					<td><input name="truename" class="easyui-validatebox" style="width:160px" readonly="readonly" value="<s:property value='members.truename'/>"/></td>
<%-- 					<th>昵称：</th>
					<td><input name="nickname" class="easyui-validatebox" style="width:160px" readonly="readonly" value="<s:property value='members.nickname'/>"/></td>
 --%>			
 				</tr>
 				<tr>	
 					<th>性别 ：</th>
					<td>					
					<s:if test="members.gender==0">
						<input name="gender"class="easyui-validatebox" style="width:160px" readonly="readonly" value="女"/>						
					</s:if>
					<s:if test="members.gender==1">
						<input name="gender"class="easyui-validatebox" style="width:160px" readonly="readonly" value="男"/>						
					</s:if>
					</td>
 				</tr>
				<tr>
					<th>出生日期：</th>
					<td>
					<s:date name="members.birthday" format="yyyy-MM-dd HH:mm:ss" />	
					<input name="birthday"
						class="easyui-validatebox" style="width:160px" readonly="readonly" value="${members.birthday}"/>
					</td>
<%-- 					<th>学历：</th>
					<td><input name="education"
						class="easyui-validatebox" style="width:160px" readonly="readonly" value="<s:property value='members.education'/>"/></td>
 --%>			</tr>
				<tr>
					<th>手机号码：</th>
					<td><input name="mobile" class="easyui-validatebox"
						data-options="validType:'mobile'" style="width:160px" readonly="readonly" value="<s:property value='members.mobile'/>"/>
					</td>
				</tr>
				<tr>
					<th>退款银行开户行：</th>
					<td><input name="bankDeposit"
						class="easyui-validatebox" style="width:160px" readonly="readonly" value="<s:property value='members.bankDeposit'/>"/> 
					</td>
				</tr>
				<tr>
					<th>退款银行卡号：</th>
					<td><input name="bankCardNo"
						class="easyui-validatebox" style="width:160px" readonly="readonly" value="<s:property value='members.bankCardNo'/>"/> 
					</td>
				</tr>
				<tr>
					<th>退款银行卡户名：</th>
					<td><input name="bankAccount"
						class="easyui-validatebox" style="width:160px" readonly="readonly" value="<s:property value='members.bankAccount'/>"/> 
					</td>
				</tr>
				<tr>
					<th>固定电话：</th>
					<td><input name="telphone"
						class="easyui-validatebox" style="width:160px" readonly="readonly" value="<s:property value='members.telphone'/>"/>
					</td>
				</tr>
				<tr>					
					<th>邮箱：</th>
					<td><input name="email"
						class="easyui-validatebox" data-options="validType:'email'"
						style="width:160px" readonly="readonly" value="<s:property value='members.email'/>"/>
					</td>
				</tr>
				<tr>
					<th>邮政编码：</th>
					<td><input name="zip"
						class="easyui-validatebox" style="width:160px" readonly="readonly" value="<s:property value='members.zip'/>"/></td>
				</tr>
				<tr>
					<th>联系地址：</th>
					<td><input name="address"
						class="easyui-validatebox" style="width:160px" readonly="readonly" value="<s:property value='members.address'/>"/></td>
<%-- 					<th>从事领域：</th>
					<td><input name="engageindustry"
						class="easyui-validatebox" style="width:160px" readonly="readonly" value="<s:property value='members.engageindustry'/>"/></td>
 --%>			</tr>
				<tr>
					<th>所在省：</th>
					<td><input name="pname"
						class="easyui-validatebox" style="width:160px" readonly="readonly" value="<s:property value='members.pname'/>"/></td>
				</tr>
				<tr>
					<th>城市：</th>
					<td><input name="cname" class="easyui-validatebox" style="width:160px" readonly="readonly" value="<s:property value='members.cname'/>"/></td>
				</tr>
				<tr>
					<th>地区：</th>
					<td><input name="aname" class="easyui-validatebox" style="width:160px" readonly="readonly" value="<s:property value='members.aname'/>"/></td>
				</tr>					
				<tr>
<%-- 					<th>预存款余额：</th>
					<td><input name="advance"
						class="easyui-validatebox" style="width:160px" readonly="readonly" value="<s:property value='members.advance'/>"/></td>
					<th>积分：</th>
					<td><input name="point"
						class="easyui-validatebox" style="width:160px" readonly="readonly" value="<s:property value='members.point'/>"/></td>
 --%>					<th>会员类别：</th>
					<td>
					<s:if test="members.type==1">
					<input name="type"
						class="easyui-validatebox" style="width:160px" readonly="readonly" value="B2B会员"/>
					</s:if>
					</td>
				</tr>			
				<tr>
					<th>注册时间：</th>
					<td>					
					<!-- sss<s:date name="members.regTime" format="yyyy-MM-dd HH:mm:ss" /> -->
					<input name="regTime"
						class="easyui-validatebox" style="width:160px" readonly="readonly" value="<s:date name='members.regTime' format='yyyy-MM-dd HH:mm:ss' />"/></td>
				</tr>
				<tr>
					<th>注册IP：</th>
					<td><input name="regIp"
						class="easyui-validatebox" style="width:160px" readonly="readonly" value="<s:property value='members.regIp'/>"/></td>
					
					<%-- <th>备注：</th>
					<td><input name="remark"
						class="easyui-validatebox" style="width:160px" readonly="readonly" value="<s:property value='members.remark'/>"/></td>
					<th>审核状态：</th>
					<td colspan="3">
					<s:if test="members.state==0">
						<input name="state"
						class="easyui-validatebox" style="width:160px" readonly="readonly" value="未审核"/>
					</s:if>
					<s:if test="members.state==1">
						<input name="state"
						class="easyui-validatebox" style="width:160px" readonly="readonly" value="审核通过"/>
					</s:if>
					<s:if test="members.state==2">
						<input name="state"
						class="easyui-validatebox" style="width:160px" readonly="readonly" value="审核未通过"/>
					</s:if>
					</td>
				</tr>
				<tr>
					<th>邮箱验证状态：</th>
					<td>
					<s:if test="members.emailStatus==0">
					<input name="emailStatus"
						class="easyui-validatebox" style="width:160px" readonly="readonly" value="未验证"/>
					</s:if>
					<s:if test="members.emailStatus==1">
					<input name="emailStatus"
						class="easyui-validatebox" style="width:160px" readonly="readonly" value="已验证"/>
					</s:if>
					</td>
					<th>手机验证状态：</th>
					<td>
					<s:if test="members.mobileStatus == 0">
					<input name="mobileStatus"
						class="easyui-validatebox" style="width:160px" readonly="readonly" value="未验证"/>
					</s:if>	
					<s:if test="members.mobileStatus == 1">
					<input name="mobileStatus"
						class="easyui-validatebox" style="width:160px" readonly="readonly" value="已验证"/>
					</s:if>	
					</td>
					<th>是否作废：</th>
					<td><input name="disabled"
						class="easyui-validatebox" style="width:160px" readonly="readonly" value="<s:property value='members.disabled'/>"/></td>
 --%>				</tr>
				<tr>
					<th>最后登录时间：</th>
					<td>
					<!-- sss<s:date name="members.lastLoginTime" format="yyyy-MM-dd HH:mm:ss" /> -->
					<input name="lastLoginTime"
						class="easyui-validatebox" style="width:160px" readonly="readonly" value="<s:date name='members.lastLoginTime' format='yyyy-MM-dd HH:mm:ss' />"/></td>
				</tr>
				<tr>	
					<th>最后登录IP：</th>
					<td><input name="lastLoginIp"
						class="easyui-validatebox" style="width:160px" readonly="readonly" value="<s:property value='members.lastLoginIp'/>"/></td>
<%-- 					<th>备注类型：</th>
					<td><input name="remarkType"
						class="easyui-validatebox" style="width:160px" readonly="readonly" value="<s:property value='members.remarkType'/>"/></td>
 --%>				</tr>
				<tr>
<%-- 					<th>推荐人ID：</th>
					<td><input name="recommendUserid"
						class="easyui-validatebox" style="width:160px" readonly="readonly" value="<s:property value='members.recommendUserid'/>"/></td>
					<th>安全问题答案：</th>
					<td><input name="questionAnswer"
						class="easyui-validatebox" style="width:160px" readonly="readonly" value="<s:property value='members.questionAnswer'/>"/></td>
 --%>				</tr>		
			</table>
		</form>
	</div>
</div>
