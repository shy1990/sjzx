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
 		var paramObj=$("#paramObj").val();
 		//console.info("paramObj==="+paramObj);
 		//paramObj==={"skuId":"aaa","oneParam":[{"regionCode":"566","regionPrice":"9"},{"regionCode":"567","regionPrice":"8"},{"regionCode":"568","regionPrice":"7"}]}
		//把json转换为js对象
 		var oldParam = $.parseJSON(paramObj);//对象 封装单品规格代码oldSkuId和数组oldRegionParam
 		//console.info("转换为js对象之后  oldParam==="+oldParam);
		var oldSkuId = oldParam['skuId']; //属性 保存的单品规格代码
		var oldRegionParam = oldParam['oneParam'];//数组 存放对象该对象封装区域代码oldRegionId和区域价格oldRegionPrice
		console.info("^^^^^^^^^^^^^^^^"+$.toJSON(oldRegionParam));
		var tempRegionParam = [];
 		//树节点展示数据		
		var datas = [];
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
				onExpand: zTreeOnExpand
			}
		};
		//自定义插件
		function addDiyDom(treeId, treeNode) {
		
			var aObj = $("#" + treeNode.tId + IDMark_A);
			var flag = "false";
			var editStr2 = null;
			//若之前保存过，那么读出之前保存的数据进行展示
			//若之前没有保存过，则跳过，全部默认为0;
			if (oldRegionParam != null && oldRegionParam.length > 0){
				for (var i=0; i<oldRegionParam.length; i++){
					if (oldRegionParam[i].regionCode == treeNode.id){
						var oldRegionPrice = oldRegionParam[i].regionPrice;//属性 区域价格
						console.info(oldRegionPrice);
						if (oldRegionPrice == 0 || typeof(oldRegionPrice) == "undefined"){
							editStr2 = "<input type=text style='margin-left:10px;width:30px' value='0' onchange='dochange("+treeNode.id+","+treeNode.pid+");' id='t_"+treeNode.id+"'/>";
						}else{
							editStr2 = "<input type=text style='margin-left:10px;width:30px' value='"+oldRegionPrice+"' onchange='dochange("+treeNode.id+","+treeNode.pid+");' id='t_"+treeNode.id+"'/>";
						}
						flag = "true";
						break;
					}
				}
			}
			
			if (flag == "false"){
				editStr2 = "<input type=text style='margin-left:10px;width:50px' value='0' onchange='dochange("+treeNode.id+","+treeNode.pid+");' id='t_"+treeNode.id+"'/>";
			}
			
			//var editStr1 = "<button style='margin-left:10px;' type=button  id='b1_'+treeNode.id onclick='reduce("+treeNode.id+");'>-</button>";
			//var editStr3 = "<button style='margin-left:10px;' type=button  id='b2_"+treeNode.id+"' onclick='add("+treeNode.id+");'>+</button>";
			//aObj.append(editStr1);
			aObj.append(editStr2);
			//aObj.append(editStr3);
		}
		//节点展开会调用此方法
		function zTreeOnExpand(event, treeId, treeNode) {
			if (oldRegionParam != null && oldRegionParam.length>0){
				for (var i=0; i<oldRegionParam.length; i++){
					if (oldRegionParam[i].regionCode == treeNode.id){
						$("#t_"+treeNode.id).val(oldRegionParam[i].regionPrice);
						return;
					}
				}
			}
			var val = $("#t_"+treeNode.id).val();
			//如果说节点值有修改，需要递归修改子节点的值
			if (val != 0){
				dochange(treeNode.id, treeNode.pid, val);
			}
		};
		
		function changeAndSave(regionCode, regionPrice){
				for (var i=0; i<tempRegionParam.length; i++){
					if (tempRegionParam[i].regionCode == regionCode){
						tempRegionParam.splice(i,1);
						break;
					}
				}
				var obj = {"regionCode":regionCode, "regionPrice":regionPrice};
				tempRegionParam.push(obj);
				oldRegionParam.push(tempRegionParam);
		}
		
		//加的按钮
		function add(id){
			alert("id为"+id+"的文本值增加"+$("#t_"+id).val());
			return;
		}
		//减的按钮
		function reduce(id){
			alert("id为"+id+"的文本值减少"+$("#t_"+id).val());
			return;
		}

		//填写或修改文本值的时候触发该函数
	function dochange(id, pid, parentValue){
			var regionValue = $("#t_"+id).val();
			if (regionValue == 0 || typeof(regionValue) == "undefined")
			{
				if(parentValue==0 || typeof(parentValue)=="undefined"){
					parentValue=0;
				}
				regionValue = parentValue;
			}
			
			 for (var i=0; i<datas.length; i++) {
				if (datas[i].pid == id){
					/* var val = $("#t_"+datas[i].id).val();
					if (val == 0 || typeof(val) == "undefined")
					{ */
					//val = regionValue;
					/* } */
					$("#t_"+datas[i].id).val(regionValue);
					//dochange(datas[i].id, datas[i].pid, val);
					changeAndSave(datas[i].id, regionValue);
						
				 }else{
				      $("#t_"+datas[i].pid).val(0);
				      parentValue = 0;
				 }
				}
				
				if(parentValue == 0){
				  changeAndSave(pid, 0);
				}
			    changeAndSave(id, regionValue);
		}
		//加载数据
		$(function(){
	 		//获取后台传来的json数据
	    	$.ajax({  
		        async : false,  
		        cache: true,  
		        type: 'POST',  
		        dataType : "json",  
		        url: "region/regionAction!gainRegionsList.action",//请求的action路径  
		        error: function () {//请求失败处理函数  
		            alert('请求失败');  
		        },  
		        success:function(data){ //请求成功后处理函数。   
	 				$.each(data.obj, function(i, value) {
					   var objvalue={"id":data.obj[i].id,"name":data.obj[i].name,"pid":data.obj[i].pid};
					   datas.push(objvalue);
					});	 		
	        	}  
	    	}); 
			$.fn.zTree.init($("#hello"),setting,datas);
		});
		
		function dosave(){
			result=[];
			 allresult = {skuId:oldSkuId, result:tempRegionParam};
			
			//传递所有参数
			$("#goParam").val($.toJSON(allresult)); 
		}
		
		
		//传递值		
/*   		function goAdd(){
			$("#goParam").val($.toJSON(allresult));
		} */
			
	</script>
	
	<div id="dd">
		<div style="margin-left:80px;">
			<h1>设置地域浮动价格</h1>
			<input id="paramObj" type="hidden" value='${paramObj}'/>
		</div>
		<div style="margin-left:80px;float:left;">
			<div style="float:left;" id="hello" class="ztree"></div>
			<!-- <input type="button" value="点我 传值" onclick="goAdd();"/>  -->
		</div>
		<div style="margin-top:500px;margin-right:5px;">
			<input type="button" value="保存记录" onclick="dosave();" style="width:150px;height:30px;color:#f00;font-weight:bold"/>
		</div>
		
	</div>