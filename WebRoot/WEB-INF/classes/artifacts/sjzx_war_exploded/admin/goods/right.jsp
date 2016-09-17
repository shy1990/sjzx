<%@ page language="java" import="java.util.*,com.sanji.sjzx.common.util.*" pageEncoding="UTF-8"%>
<%@page import="com.sanji.sjzx.common.util.ResourceUtil"%>
<%@page import="com.sanji.sjzx.pojo.SessionInfo"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%
	String basePath = PathUtil.getPath(request);
	SessionInfo sessionInfo = (SessionInfo) request.getSession().getAttribute(ResourceUtil.getSessionInfoName());
	String userId = sessionInfo.getUserId();
	request.setAttribute("goParam","${goParam}");
%>
 	<script type="text/javascript">
 		 console.info("****************************************************************");
 		console.info("这里是editPrice页面的值");
  		//获取add.jsp页面传递的参数paramObj
 		//var paramObj=$("#paramObj").val();
 		var paramObj = $.toJSON(<%=request.getAttribute("rpList")%>);
 		//console.info("paramObj===<<<<<<<<"+paramObj);
 		//paramObj==={"skuId":"aaa","oneParam":[{"memberId":"566","memberPrice":"9"},{"memberId":"567","memberPrice":"8"},{"memberId":"568","memberPrice":"7"}]}
		//把json转换为js对象
 		var oldMemberParam = $.parseJSON(paramObj);//对象 封装单品规格代码oldSkuId和数组oldMemberParam
 		//console.info("转换为js对象之后  oldParam==="+oldParam);
		//var oldSkuId = oldParam['skuId']; //属性 保存的单品规格代码
		var oldSkuId = '${skuId}'; //属性 保存的单品规格代码
		//console.info("转换为js对象之后  oldSkuId=============>>>"+oldSkuId);
		//var oldMemberParam = oldParam;//数组 存放对象该对象封装区域代码oldRegionId和区域价格oldmemberPrice
		var tempMemberParam = []; 
 		//树节点展示数据		
		 var datas = [{
			name : "设置所有",
			id : -1,
			isParent : true,
			//open : true,
		//	iconOpen : "ztree/css/ztreeStyle/img/diy/1_open.png",
		//	iconClose : "ztree/css/ztreeStyle/img/diy/1_close.png"
		} ];
		//保存的时候根据单品规格代码来保存
		var result;//数组 存放对象newObj  该对象封装区域代码和区域价格
		var allresult;//对象 封装单品规格代码和result数组
			  	
		var IDMark_Switch = "_switch",
		IDMark_Icon = "_ico",
		IDMark_Span = "_span",
		IDMark_Input = "_input",
		IDMark_Check = "_check",
		IDMark_Edit = "_edit",
		IDMark_Remove = "_remove",
		IDMark_Ul = "_ul",
		IDMark_A = "_a";
		
		var setting={
			data:{
				simpleData:{
					enable:true,
					idKey:"id",
					pIdKey:"pid",
					rootPId:"-1"
				}
			},
			view:{
				selectedMulti:false,
				addDiyDom: addDiyDom
			},
			callback:{
				//onExpand: zTreeOnExpand
			}
		};
		
		function addDiyDom(treeId, treeNode) {
			var aObj = $("#" + treeNode.tId + "_a");
			var flag = "false";
			var editStr2 = null;
			//若之前保存过，那么读出之前保存的数据进行展示
			//若之前没有保存过，则跳过，全部默认为0;
			if (oldMemberParam != null && oldMemberParam.length > 0){
				for (var i=0; i<oldMemberParam.length; i++){
					if (oldMemberParam[i].memberId == treeNode.id){
						var oldMemberPrice = oldMemberParam[i].floatPrice;//属性 区域价格
						if (oldMemberPrice == 0 || typeof(oldMemberPrice) == "undefined"){
							editStr2 = "<input type=text style='margin-left:10px;width:30px' value='0'  id='t_"+treeNode.id+"'/>";
						}else{
							editStr2 = "<input type=text style='margin-left:10px;width:30px' value='"+oldMemberPrice+"'  id='t_"+treeNode.id+"'/>";
						}
						flag = "true";
						break;
					}
				}
			}
			
			if (flag == "false"){
				editStr2 = "<input type=text style='margin-left:10px;width:50px' value='0'  id='t_"+treeNode.id+"'/>";
			}
			
			aObj.append(editStr2);
			var btn = $("#t_"+treeNode.id);
			if (btn) btn.blur(function(){
			  var val = $("#t_"+treeNode.id).val();
			//如果说节点值有修改，需要递归修改子节点的值
				//if (val >= 0){
					 dochange(treeNode.id,val); 
					
				//}
			});
		};
		 
		function changeAndSave(memberId, memberPrice){
				/* for (var i=0; i<tempMemberParam.length; i++){
					if (tempMemberParam[i].memberId == memberId){
						tempMemberParam.splice(i,1);
						break;
					}
				} */
				if(memberId != -1){
				   var obj = {"memberId":memberId, "memberPrice":memberPrice};
				   tempMemberParam.push(obj);
				   oldMemberParam.push(tempMemberParam);
					   allresult = {skuId:oldSkuId, result:tempMemberParam};
				//传递所有参数
				$("#goParam").val($.toJSON(allresult)); 
				 }
		}
		

		//填写或修改文本值的时候触发该函数
	function dochange(id, value){
		 if(id == -1){
		      for (var i=0; i<datas.length; i++) {
					//if(id != -1){
					    $("#t_"+datas[i].id).val(value);
					  changeAndSave(datas[i].id, value);
					//}
				}
		 }else{
		           
					changeAndSave(id, value);
		  }
		}
		
		//加载数据
		$(function(){
	 		//获取后台传来的json数据
	    	$.ajax({  
		        async : false,  
		        cache: true,  
		        type: 'POST',  
		        dataType : "json",  
		        url: "members/membersAction!gainMembersByRegions.action?areaid="+'${areaid}',//请求的action路径  
		        error: function () {//请求失败处理函数  
		            alert('请求失败');  
		        },  
		        success:function(data){ //请求成功后处理函数。   
	 				if(data.success && data.obj !=  undefined){
	 				   $.each(data.obj, function(i, value) {
					   var objvalue={"id":data.obj[i].id,"name":data.obj[i].username};
					   datas.push(objvalue);
					   $("#dd").css("display","block");
					   $.fn.zTree.init($("#hello"),setting,datas);
					});	 	
	 				}else{
	 				    alert(data.msg);
	 				}
	        	} 
	    	}); 
			
		});
		
		function dosave(){
			result=[];
			//保存所有参数	
			 allresult = {skuId:oldSkuId, result:tempMemberParam};
			//传递所有参数
			$("#goParam").val($.toJSON(allresult)); 
		}
		
		
	</script>
	
	<div id="dd" style="display:none ;">
		<div style="margin-left:80px;">
			<h1>设置客户浮动价格</h1>
			<input id="paramObj" type="hidden" value='${paramObj}'/>
		</div>
		<div style="margin-left:80px;float:left;">
			<div style="float:left;" id="hello" class="ztree"></div>
			<!-- <input type="button" value="点我 传值" onclick="goAdd();"/>  -->
		</div>
		<!-- <div style="margin-top:500px;margin-right:5px;">
			<input type="button" value="保存记录" onclick="dosave();" style="width:150px;height:30px;color:#f00;font-weight:bold"/>
		</div> -->
		
	</div>