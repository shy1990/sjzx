 
console.info("here is addPrice.js");
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
			onClick:function(event,treeId,treeNode){
				//alert("treeId:"+treeId);
				//alert("treeNode.name:"+treeNode.name+"  treeNode.isParent:"+treeNode.isParent);
				console.info("here??????");
				onExpand: zTreeOnExpand;
			}
		}
	};
	
	function zTreeOnExpand(event, treeId, treeNode) {
		console.info("zTreeOnExpand>>>>>>>>>>>>>");
		for (var i=0; i<result.length; i++){
			if (result[i].id == treeNode.id){
				$("#t_"+treeNode.id).val(result[i].price);
				return;
			}
		}
		var val = $("#t_"+treeNode.id).val();
		if (val != 0){
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
   	//自定义事件
 	function addDiyDom(treeId, treeNode) {
		var aObj = $("#" + treeNode.tId + IDMark_A);
		var flag = "false";
		var editStr2 = null;
		for (var i=0; i<result.length; i++){
			if (result[i].id == treeNode.id){
				var val = result[i].price;
				if (val == 0 || typeof(val) == "undefined"){
					editStr2 = "<input type=text style='margin-left:10px;width:30px' value='0' onchange='dochange("+treeNode.id+","+treeNode.pid+");' id='t_"+treeNode.id+"'/>";
				}else{
					editStr2 = "<input type=text style='margin-left:10px;width:30px' value='"+val+"' onchange='dochange("+treeNode.id+","+treeNode.pid+");' id='t_"+treeNode.id+"'/>";
				}
				flag = "true";
				break;
			}
		}
		if (flag == "false"){
			editStr2 = "<input type=text style='margin-left:10px;width:30px' value='0' onchange='dochange("+treeNode.id+","+treeNode.pid+");' id='t_"+treeNode.id+"'/>";
		}
		
		var editStr1 = "  <button style='margin-left:10px;' type=button  id='b1_'+treeNode.id onclick='reduce("+treeNode.id+");'>-</button>";
		var editStr3 = "<button style='margin-left:10px;' type=button  id='b2_"+treeNode.id+"' onclick='add("+treeNode.id+");'>+</button>";
		aObj.append(editStr1);
		aObj.append(editStr2);
		aObj.append(editStr3);
	}
	//查询父节点的值
	function findParentValue(pid){
		var val = null;
		for (var i=0; i<result.length; i++){
			if (result[i].id == pid){
				val = $("#t_"+pid).val();
				if (val == 0 || typeof(val) == "undefined"){
					val = findParentValue(result[i].pid);
				}
			}
		}
		return val;
	}
	//修改文本值                    223  -1
	function dochange(id, pid){
		for (var i=0; i<datas.length; i++) {
			if (datas[i].pid == id){
				$("#t_"+datas[i].id).val($("#t_"+id).val());
				dochange(datas[i].id, datas[i].pid);
			}
		}
	}

 	//根据区域id获取该区域的文本值
 	var result = [];
	function getValue(id, val){
		for (var i=0; i<datas.length; i++){
			if (datas[i].pid == id){
				var value = $("#t_"+datas[i].id).val();
				console.info("value==="+value);
				if (value == 0 || typeof(value) == "undefined"){
					value = val;
				}
				var obj1 = {"id":datas[i].id, "name":datas[i].name, "pid":datas[i].pid, "price":value};
				result.push(obj1);
				getValue(datas[i].id, value);
			}
		}
	} 
	//保存事件
	function dosave(){
		result = [];
		for (var i=0; i<datas.length; i++){
			if (datas[i].pid == -1){
				var value = $("#t_"+datas[i].id).val();
				var obj1 = {"id":datas[i].id, "name":datas[i].name, "pid":datas[i].pid, "price":value};
				result.push(obj1);
				getValue(datas[i].id, value);
			}
		}
	}
	//加载节点数据
 	$(function(){
 	    console.info("here is $(function(){})");
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