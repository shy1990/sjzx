<%@ page language="java" import="java.util.*,com.sanji.sjzx.common.util.*" pageEncoding="UTF-8"%>
<%@page import="com.sanji.sjzx.common.util.ResourceUtil"%>
<%@page import="com.sanji.sjzx.pojo.SessionInfo"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%
	String basePath = PathUtil.getPath(request);
	SessionInfo sessionInfo = (SessionInfo) request.getSession().getAttribute(ResourceUtil.getSessionInfoName());
	String userId = sessionInfo.getUserId();
%>
 	<script type="text/javascript">
		var datas = [];
		
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
				//dblClickExpand:true,
				selectedMulti:false,
				addDiyDom: addDiyDom
			},
			callback:{
				onExpand: zTreeOnExpand
			}
		};
		
		function zTreeOnExpand(event, treeId, treeNode) {
			
			var skuresult = null;
			//找到此单品之前保存过的修改结果
			for (var i=0; i<allresult.length; i++)
			{
				if (allresult[i].skuid == skuiddd)
				{
					skuresult = allresult[i].skuresult;
				}
			}
			
			if (skuresult != null)
			{
				for (var i=0; i<skuresult.length; i++)
				{
					if (skuresult[i].id == treeNode.id){
						$("#t_"+treeNode.id).val(skuresult[i].price)
						return;
					}
				}
			}
			
			var val = $("#t_"+treeNode.id).val();
			if (val != 0)
			{
				dochange(treeNode.id, treeNode.pid);
			}
			
		};
		
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
		
		function addDiyDom(treeId, treeNode) {
			var aObj = $("#" + treeNode.tId + IDMark_A);
			
			var flag = "false";
			var editStr2 = null;
			var skuresult = null;
			//找到此单品之前保存过的修改结果
			for (var i=0; i<allresult.length; i++)
			{
				if (allresult[i].skuid == skuiddd)
				{
					skuresult = allresult[i].skuresult;
				}
			}
			
			//若之前没有保存过，则跳过，全部默认为0;
			if (skuresult != null)
			{
				for (var i=0; i<skuresult.length; i++)
				{
					if (skuresult[i].id == treeNode.id)
					{
						var val = skuresult[i].price;
						if (val == 0 || typeof(val) == "undefined")
						{
							editStr2 = "<input type=text style='margin-left:10px;width:30px' value='0' onchange='dochange("+treeNode.id+","+treeNode.pid+");' id='t_"+treeNode.id+"'/>";
						}
						else
						{
							editStr2 = "<input type=text style='margin-left:10px;width:30px' value='"+val+"' onchange='dochange("+treeNode.id+","+treeNode.pid+");' id='t_"+treeNode.id+"'/>";
						}
						flag = "true";
						break;
					}
				}
			}
			
			if (flag == "false")
			{
				editStr2 = "<input type=text style='margin-left:10px;width:30px' value='0' onchange='dochange("+treeNode.id+","+treeNode.pid+");' id='t_"+treeNode.id+"'/>";
			}
			
			var editStr1 = "<button style='margin-left:10px;' type=button  id='b1_'+treeNode.id onclick='reduce("+treeNode.id+");'>-</button>";
			var editStr3 = "<button style='margin-left:10px;' type=button  id='b2_"+treeNode.id+"' onclick='add("+treeNode.id+");'>+</button>";
			aObj.append(editStr1);
			aObj.append(editStr2);
			aObj.append(editStr3);
		}
		
		function dochange(id, pid)
		{
			for (var i=0; i<datas.length; i++) 
			{
				if (datas[i].pid == id)
				{
					$("#t_"+datas[i].id).val($("#t_"+id).val());
					dochange(datas[i].id, datas[i].pid);	
				}
			}
		}
		
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
		            //console.info("length: "+data.obj.length);
	 				$.each(data.obj, function(i, value) {
					    //console.info("data.obj[i].id=="+data.obj[i].id+"  data.obj[i].name=="+data.obj[i].name);
					    //console.info("value.id==="+value.id+"  value.name==="+value.name+"  value.pid==="+value.pid);
					    //datas.push(data.obj[i]);
					   var objvalue={"id":data.obj[i].id,"name":data.obj[i].name,"pid":data.obj[i].pid};
					   datas.push(objvalue);
					});	 		
	        	}  
	    	}); 
			//$.fn.zTree.init($("#hello_1"),setting,datas);
			
		});
			
		//保存所有单品的价格浮动信息
		var allresult = [];
		function getValue(id, val)
		{
			for (var i=0; i<datas.length; i++)
			{
				if (datas[i].pid == id)
				{
					var value = $("#t_"+datas[i].id).val();
					if (value == 0 || typeof(value) == "undefined")
					{
						value = val;
					}
					var obj1 = {"id":datas[i].id, "name":datas[i].name, "pid":datas[i].pid, "price":value};
					result.push(obj1);
					getValue(datas[i].id, value);
				}
			}
		}
			
		//保存的时候根据单品Id来保存
		var result;
		function dosave(skuid)
		{
			result=[];
			for (var i=0; i<datas.length; i++)
			{
				if (datas[i].pid == -1)
				{
					var value = $("#t_"+datas[i].id).val();
					var obj1 = {"id":datas[i].id, "name":datas[i].name, "pid":datas[i].pid, "price":value};
					result.push(obj1);
					getValue(datas[i].id, value);
				}
			}
			
			//保存之前判断此单品是否已经修改过，若修改过，删除之前保存的，重新保存
			var objsku = {"skuid":skuid, "skuresult":result};
			for (var i=0; i<allresult.length; i++)
			{
				if (allresult[i].skuid == skuid)
				{
					allresult.splice(i,1);
				}
			}
			allresult.push(objsku);
		}
			
		function doopen(skuid)
		{
			skuiddd = skuid;
			$.fn.zTree.init($("#hello_"+skuid),setting,datas);
		}
		
		function doshutdown(skuid)
		{
			$.fn.zTree.destroy("hello_"+skuid);
		}
			
		var skuiddd = null;
		
	</script>
	<div>
		<input type="text" id="sku_1"/>
		<input type="button" value="打开" onclick="doopen(1);"/>
		<input type="button" value="保存单品" onclick="dosave(1);"/>
		<input type="button" value="关闭" onclick="doshutdown(1);"/>
		<div id="hello_1" class="ztree"></div>
		
<!-- 		<input type="text" id="sku_2"/>
		<input type="button" value="打开" onclick="doopen(2);"/>
		<input type="button" value="保存单品" onclick="dosave(2);"/>
		<input type="button" value="关闭" onclick="doshutdown(2);"/>
		<div id="hello_2" class="ztree"></div> -->
	</div>