var datas = [];
var child = [];
		var setting={
			async : {
				enable : true,
				url : "region/regionAction!gainRegionsListByPid.action",
				autoParam : [ "id" ],
				dataType: "json",
				dataFilter: ajaxDataFilter
			},
			data:{
				simpleData:{
					enable:true,
					idKey:"id",
					pIdKey:"pid",
					rootPId:"-1"
				}
			},
			callback: {
				beforeExpand : beforeExpand,
				onAsyncSuccess : onAsyncSuccess,
				onAsyncError : onAsyncError,
				onClick: zTreeOnClick
			}
		};
		
		function ajaxDataFilter(treeId, parentNode, responseData) {
		   /* if (responseData) {
		      for(var i =0; i < responseData.length; i++) {
		        alert(responseData[i].name);
		      }
		    }*/
			child = [];
			$.each(responseData.obj, function(i, value) {
				   var objvalue={"id":responseData.obj[i].id,"name":responseData.obj[i].name,"pid":responseData.obj[i].pid,"open":responseData.obj[i].open,"isParent":responseData.obj[i].isParent,"icon":responseData.obj[i].icon};
				   child.push(objvalue);
				   
				});	
		    return child;
		};
		
		
		/**
		 * 展开之前执行的函数
		 * 
		 * @param treeId
		 * @param treeNode
		 * @return
		 */
		function beforeExpand(treeId, treeNode) {
			if (!treeNode.isAjaxing) {
				ajaxGetNodes(treeNode, "refresh");
				return true;
			} else {
				alert("Loading...");
				return false;
			}
		}
		/**
		 * 加载成功后执行的函数
		 * 
		 * @param event
		 *            封装了js的事件
		 * @param treeId
		 *            树控件的Id
		 * @param treeNode
		 *            树节点对象
		 * @param msg
		 *            返回的JSON格式的消息
		 * @return
		 */
		function onAsyncSuccess(event, treeId, treeNode, msg) {
			if (!msg || msg.length == 0) {
				return;
			}
			var zTree = $.fn.zTree.getZTreeObj("treeDemo");
			treeNode.icon = "";
			zTree.updateNode(treeNode);// 更新树结构
			zTree.selectNode(treeNode.children[0]);// 设置为第一个子节点为选中状态
		}
		function onAsyncError(event, treeId, treeNode, XMLHttpRequest, textStatus,
				errorThrown) {
			var zTree = $.fn.zTree.getZTreeObj("treeDemo");
			alert("Error ! 异步获取数据异常");
			treeNode.icon = "";
			zTree.updateNode(treeNode);
		}
		function ajaxGetNodes(treeNode, reloadType) {
			var zTree = $.fn.zTree.getZTreeObj("treeDemo");
			if (reloadType == "refresh") {
				treeNode.icon = "style/img/loading.gif";
				zTree.updateNode(treeNode);
			}
			zTree.reAsyncChildNodes(treeNode, reloadType, true);
		}
		
		function zTreeOnClick(event, treeId, treeNode) {
				var subtitle = '设置客户价格';	
				if (!$('#priceTabs').tabs('exists', subtitle)) {
						$('#priceTabs').tabs('add', {
							title : subtitle,
							href : "goods/goodsAction!toRight.action?areaid=" + treeNode.id+"&areaname="+treeNode.name+"&skuId="+$("#skuId").val(),
							closable : true,
							icon : 'icon icon-magic'
						});
				} else {
					$('#priceTabs').tabs('close', subtitle);
					//$.messager.alert('提示','您已打开一个授权页面,请完成后再操作!','info');
					$('#priceTabs').tabs('add', {
						title : subtitle,
						href : "goods/goodsAction!toRight.action?areaid=" + treeNode.id+"&areaname="+treeNode.name+"&skuId="+$("#skuId").val(),
						closable : true,
						icon : 'icon icon-magic'
					});
					//return;
				}
		
		};
			
			
		//加载数据
		$(function(){
	 		//获取后台传来的json数据
	    	$.ajax({  
		        async : true,  
		        type: 'POST',  
		        dataType : "json",  
		        url: "region/regionAction!gainRegionsList.action",//请求的action路径  
		        error: function () {//请求失败处理函数  
		            alert('请求失败');  
		        },  
		        success:function(data){ //请求成功后处理函数。   
		        	
	 				$.each(data.obj, function(i, value) {
					   var objvalue={"id":data.obj[i].id,"name":data.obj[i].name,"pid":data.obj[i].pid,"open":data.obj[i].open,"isParent":data.obj[i].isParent,"icon":data.obj[i].icon};
					   datas.push(objvalue);
					});	
	 				$.fn.zTree.init($("#treeDemo"),setting,datas);
	        	} 
	    	}); 
			
		});