<%@ page language="java"
	import="java.util.*,com.sanji.sjzx.common.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String basePath = PathUtil.getPath(request);
%>

<script type="text/javascript">
	/**
 	 * 商品详情的编辑
     */
	window.setTimeout(function() {
		editor = KindEditor.create('#admin_goods_add_textarea', {
			width : '680px',
			height : '300px',
			items : [ 'source', '|', 'undo', 'redo', '|', 'preview', 'print', 'template', 'code', 'cut', 'copy', 'paste', 'plainpaste', 'wordpaste', '|', 'justifyleft', 'justifycenter', 'justifyright', 'justifyfull', 'insertorderedlist', 'insertunorderedlist', 'indent', 'outdent', 'subscript', 'superscript', 'clearhtml', 'quickformat', 'selectall', '|', 'fullscreen', '/', 'formatblock', 'fontname', 'fontsize', '|', 'forecolor', 'hilitecolor', 'bold', 'italic', 'underline', 'strikethrough', 'lineheight', 'removeformat', '|', 'image', 'flash', 'media', 'insertfile', 'table', 'hr', 'emoticons', 'baidumap', 'pagebreak', 'anchor', 'link', 'unlink' ],
			uploadJson : 'up!upload.action'
		});
	}, 1);

	/**
	 * 根据iframe对象获取iframe的window对象
	 * @param frame
	 * @returns {Boolean}
	 */
	function GetFrameWindowForAdd(frame) {
		return frame && typeof (frame) == 'object' && frame.tagName == 'IFRAME'
				&& frame.contentWindow;
	}
			//加载完所有节点之后
		$(document)
		.ready(
				function() {
					var tableNum1 = $("#admin_goods_edit_sku").children("table").length;//子元素table的个数
					for(var i =0;i<tableNum1;i++){
						var tableObj1 = $("#admin_goods_edit_sku").children("table")[i];//具体每个table对象
						//页面加载时，修改a标签的属性id的值
						var aNum = $(tableObj1).find("a").length;//一个table中的a标签的个数
						for(var aa=0;aa<aNum;aa++){
							var aObj = $(tableObj1).find("a")[aa];//具体的某个a标签
							var aObjValue = $(aObj).attr("id");
							if(aObjValue!=undefined){
								var aObjNewValue = aObjValue.replace(/\_\m/, "_" + i);
								$(aObj).attr("id",aObjNewValue);
							}
						}
						//加载时修改具体某个table中所有span的id属性，包括（颜色父节点span、原有图片父节点span、新添加图片父节点span）
						var spanNum = $(tableObj1).find("span").length;//找具体某个table里的span个数
						for(var ii=0;ii<spanNum;ii++){
							var spanObj = $(tableObj1).find("span")[ii];
							var spanObjValue = $(spanObj).attr("id");
							if(spanObjValue!= undefined){
								var spanObjNewValue = spanObjValue.replace(/\_\m/, "_" + i);
								$(spanObj).attr("id",spanObjNewValue);
							}
						}
						//页面加载时修改所有select的id属性
						var selectNum = $(tableObj1).find("select").length;//找具体某个table里的select个数
						for(var ii=0;ii<selectNum;ii++){
							var selectObj = $(tableObj1).find("select")[ii];//具体某个select对象
							var selectObjValue = $(selectObj).attr("id");
							if(selectObjValue!=undefined){
								var selectObjNewValue = selectObjValue.replace(/\_\m/, "_" + i);
								$(selectObj).attr("id",selectObjNewValue);
							}
						}
						
						//设置原有图片父节点span包含的图片的id属性
						var spanId = 'admin_goods_add_thumbPic_'+i;
						var spanLoadSpanObj = document.getElementById(spanId);
						var imgNum = $(spanLoadSpanObj).find("img").length;//图片父节点span包含的图片个数
						for(var mm = 0;mm<imgNum;mm++){
							var imgObj = $(spanLoadSpanObj).find("img")[mm];//具体的某张图片
							var imgObjValue = $(imgObj).attr("id");
							if(imgObjValue!=undefined){//img_n
								var newStr = imgObjValue.substr(0,imgObjValue.length - 1);
								var modifyAttrValue = newStr + a;
								$(imgObj).attr("id",modifyAttrValue);
								a++;
								//console.info('$(imgObj).attr("id")=='+$(imgObj).attr("id"));
							}
						}  
						//控制当前table中最后一个input的id
						var tdObj1 = $(tableObj1).find("input").last();//当前table中最后一个input
						var attrValue1 = $(tdObj1).attr("id");
						console.info("attrValue1====>>>>>>"+attrValue1);//admin_goods_delete_m
						if(attrValue1 != undefined){
							console.info("i====>>>>>>"+i);
							var modifyValue1 = attrValue1.substr(0,attrValue1.length-1)+i;
							console.info("modifyValue1====>>>>>>"+modifyValue1);
							$(tdObj1).attr("id",modifyValue1);
							console.info("id===>>>>>"+$(tdObj1).attr("id"));
						}
				    }							
					//此时m的值也需要修改
					m = tableNum1 - 1;
					tableNumInit = tableNum1;
		          });
</script>
<div class="easyui-layout" data-options="fit:true,border:false">
	<div data-options="region:'center',border:true,split:false">
		<form id="admin_showGoods_showForm" method="post">
			<p style="margin-left:30px;font-size:20px; font-weight: bold;">商品概况<span style="color:#f00;font-size:16px;">***</span></p>
			<table id="admin_goods_datagrid" class="tableForm" style="width:60%">
				<tr>
					<th>商品名称:</th>
					<td><input style="width:160px" value="${goods.name}" readonly="readonly"/></td>
					<th>商品品牌:</th>
					<td>
						<span>
							<input id="brandId" name="brandId" class="easyui-combobox" 
							data-options="url:'goods/goodsAction!gainGoodsBrandName.action',valueField:'brandId',textField:'brandName',editable:false,multiple:false"style="width:160px" value="${goods.brandId }" readonly="readonly"/>
						</span>
					</td>
					<th>商品类别:</th>
					<td>
						<span>
							<input name="catId" class="easyui-combobox" 
							data-options="url:'goods/goodsAction!gainGoodsCatName.action',valueField:'catId',textField:'catName',editable:false,multiple:false"style="width:160px" value="${goods.catId}"/>
						</span>
					</td>				
				</tr>
				<tr>		
					<th>手机类型:</th>
					<td>
					<input style="width:160px;" value="${goods.cellphoneType}" readonly="readonly"/>
					</td>
					<th>电池类型:</th>
					<td><input style="width:160px;" value="${goods.batteryType}" readonly="readonly"/></td>
					<th>电池容量:</th>
					<td><input style="width:160px" value="${goods.batteryCapacity}" readonly="readonly"/></td>
				</tr>
				<tr>
					<th>操作系统:</th>
					<td>
					<s:select list="osList" listValue="dictName" listKey="dictValue" name="goods.operationSystem" id="operationSystem"
           			cssStyle="width:160px" theme="simple" value="%{goods.operationSystem}" readonly="readonly">
           			</s:select> 
					</td>
					<th>CPU核心数:</th>
					<td>
					<s:select list="cpuList" listValue="dictName" listKey="dictValue" name="goods.cpuNumber" id="cpuNumber"
           			cssStyle="width:160px" theme="simple" value="%{goods.cpuNumber}" readonly="readonly">
           			</s:select> 
					</td>
					<th>运行内存:</th>
					<td>
						<s:select list="ramList" listValue="dictName" listKey="dictValue" name="goods.ram" id="ram"
            			cssStyle="width:160px" theme="simple" value="%{goods.ram}" readonly="readonly">
            			</s:select> 
					</td>
				</tr>
				<tr>
					<th>分辨率:</th>
					<td>
					<s:select list="resolutionList" listValue="dictName" listKey="dictValue" name="goods.resolution" id="resolution"
           			cssStyle="width:160px" theme="simple" value="%{goods.resolution}" readonly="readonly">
           			</s:select> 
					</td>
					<th>屏幕尺寸:</th>
					<td>
					<input type="text" style="width:80px" value="${goods.screenSize}" readonly="readonly"/>&nbsp;&nbsp;英寸
					</td>
					<th>触摸屏类型:</th>
					<td><input style="width:160px" value="${goods.touchscreenType}" readonly="readonly"/></td>
				</tr>
				<!-- <tr>
					<th>摄像头类型:</th>
					<td>
					<input name="cameraType" style="width:160px" value="${goods.cameraType}"/>
					</td>
					<th>前置摄像头:</th>
					<td><input name="frontCamera" style="width:160px" value="${goods.frontCamera}"/></td>
					<th>后置摄像头:</th>
					<td><input name="postCamera" style="width:160px" value="${goods.postCamera}" /></td>
				</tr>
				<tr>
					<th>屏幕技术 :</th>
					<td><input name="screenTechnology" style="width:160px" value="${goods.screenTechnology}"/></td>
					<th>屏幕像素密度:</th>
					<td><input name="sreenPixDensity" style="width:160px" value="${goods.sreenPixDensity}"/></td>
					<th>wlan功能:</th>
					<td><input name="wlanFunction" style="width:160px" value="${goods.wlanFunction}" /></td>
				</tr>
				<tr>
					<th>手机尺寸:</th>
					<td><input name='cellphoneSize' style="width:160px;" value="${goods.cellphoneSize}" /></td>
					<th>导航:</th>
					<td><input name="navigation" style="width:160px" value="${goods.navigation}" /></td>				
					<th>CPU频率:</th>
					<td><input name="cpuRate" style="width:160px" value="${goods.cpuRate}" /></td>
				</tr>
				<tr>
					<th>存储卡:</th>
					<td><input name='memoryCard' style="width:160px;" value="${goods.memoryCard}"/></td>
					<th>窄边框:</th>
					<td><input name='narrowFrame' style="width:160px;" value="${goods.narrowFrame}"/></td>
					<th>连接与共享 :</th>
					<td><input name="connectionShare" style="width:160px" value="${goods.connectionShare}"/></td>
				</tr>
				<tr>
					<th>用户界面:</th>
					<td><input name='userInterface' style="width:160px;" value="${goods.userInterface}" /></td>
					<th>扩展容量:</th>
					<td><input name="extendedCapacity" style="width:160px" value="${goods.extendedCapacity}"/></td>
					<th>三际天猫官方地址 :</th>
					<td><input name="tmallUrl" class="easyui-validatebox" data-options="required:true" style="width:160px" value="${goods.tmallUrl}"/></td>
				</tr>
				<tr>
					<th>点击量:</th>
					<td><input id="clickRate" name="clickRate" style="width:160px" value="${goods.clickRate}" /><div id="clickRateMsg"></div></td>
					<th>gpu型号:</th>
					<td><input name="gpuModel" style="width:160px" value="${goods.gpuModel }"/></td>
					<th>理论待机时间:</th>
					<td><input name="theoryStandbyTime" style="width:160px" value="${goods.theoryStandbyTime}" /></td>
				</tr>
				<tr>
					<th>曝光日期:</th>
					<td><input type="hidden" value="${goods.exposureDate}"/>
					<input id="admin_starttime" name="exposureDate"  class="easyui-my97" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" value="${goods.exposureDate}" style="width:160px;"/>
					</td>
					<th>理论通话时间:</th>
					<td><input name='talkTime' style="width:160px;" value="${goods.talkTime}"/></td>
					<th>传感器类型:</th>
					<td>
					<input name="sensorType" style="width:160px" value="${goods.sensorType}"/>
					</td>
				</tr>
				<tr>
					<th>摄像头:</th>
					<td><input name='camera' style="width:160px;" value="${goods.camera}" /></td>
					<th>摄像头认证:</th>
					<td><input name='cameraCertification' style="width:160px;" value="${goods.cameraCertification}"/></td>
					<th>屏幕占比:</th>
					<td><input name='screenRatio' style="width:160px;" value="${goods.screenRatio}"/></td>				
				</tr>
				<tr>
					<th>闪光灯:</th>
					<td><input name="flashLamp" style="width:160px" value="${goods.flashLamp}"></td>
					<th>视频拍摄:</th>
					<td><input name='videoShoot' style="width:160px;" value="${goods.videoShoot}" /></td>
					<th>拍照功能:</th>
					<td><input name="shootFunction" style="width:160px" value="${goods.shootFunction}"/></td>
				</tr>
				<tr>
					<th>光圈:</th>
					<td><input name='aperture' style="width:160px;" value="${goods.aperture}"/></td>
					<th>焦距:</th>
					<td><input name="focalLength" style="width:160px" value="${goods.focalLength}"/></td>
					<th>特色:</th>
					<td><input name="cameraFeatures" style="width:160px" value="${goods.cameraFeatures}"/></td>
				</tr>
				<tr>
					<th>其他摄像头参数:</th>
					<td><input name='cameraOtherparams' style="width:160px;" value="${goods.cameraOtherparams}"/></td>
					<th>造型设计:</th>
					<td><input name="modelDesign" style="width:160px" value="${goods.modelDesign}"/></td>
					<th>手机重量:</th>
					<td><input id="weight" name='weight' style="width:150px;" value="${goods.weight}"/>&nbsp;g
					<div id="weightMsg"></div></td>
				</tr>
				<tr>
					<th>机身特点:</th>
					<td><input name="bodyFeatures" style="width:160px" value="${goods.bodyFeatures}"/></td>
					<th>操作类型:</th>
					<td><input name="operationType" style="width:160px" value="${goods.operationType}"/></td>
					<th>感应器类型:</th>
					<td><input name='outSensorType' style="width:160px;" value="${goods.outSensorType}"/></td>
				</tr>
				<tr>
					<th>sim卡类型:</th>
					<td><input name="simType" style="width:160px" value="${goods.simType}"/></td>
					<th>机身接口:</th>
					<td><input name='bodyInterface' style="width:160px;" value="${goods.bodyInterface}"/></td>
					<th>机身材质:</th>
					<td><input name="bodyMaterial" style="width:160px" value="${goods.bodyMaterial}"/></td>
				</tr>
				<tr>
					<th>音频支持:</th>
					<td><input name="audioSupport" style="width:160px" value="${goods.audioSupport}" /></td>
					<th>视频支持:</th>
					<td><input name='videoSupport' style="width:160px;" value="${goods.videoSupport}"/></td>
					<th>图片支持:</th>
					<td><input name="imgSupport" style="width:160px" value="${goods.imgSupport}" /></td>
				</tr>
				<tr>
					<th>常用功能:</th>
					<td><input name='commonFunctions' style="width:160px;" value="${goods.commonFunctions}" /></td>
					<th>商务功能:</th>
					<td><input name="businessFunctions" style="width:160px" value="${goods.businessFunctions}" /></td>
					<th>包装清单:</th>
					<td><input name="optionalAccessory" style="width:160px" value="${goods.optionalAccessory}" /></td>
				</tr>
				<tr>
					<th>保修政策:</th>
					<td><input name='warrantyPolicy' style="width:160px;" value="${goods. warrantyPolicy}"/></td>
					<th>质保时间:</th>
					<td><input id="warrantyTime" name="warrantyTime" style="width:150px" value="${goods.warrantyTime}" />&nbsp;年<div id="warrantyTimeMsg"></div></td>
					<th>质保备注:</th>
					<td><input name='warrantyRemark' style="width:160px;" value="${goods.warrantyRemark}"/></td>
				</tr>
				<tr>
					<th>客服电话:</th>
					<td><input name="servicePhone" style="width:160px" value="${goods.servicePhone }" /></td>
					<th>电话备注:</th>
					<td><input name="phoneRemark" style="width:160px" value="${goods.phoneRemark}" /></td>
					<th>详细内容:</th>
					<td><input name='detailContents' style="width:160px;" value="${goods.detailContents}"/></td>
				</tr>
				<tr>
					<th>cpu型号:</th>
					<td><input name='cpuModel' style="width:160px;" value="${goods.cpuModel}" /></td>
				</tr> 
				<tr>		
					<th>商品详情:</th>	
					<td colspan="9"><textarea name='goodsDetail' id="admin_goods_add_textarea" style="width:60%;height:50px;">${goods.goodsDetail}</textarea></td>					
				</tr> -->
			</table>
			<p style="margin-left:30px;font-size:20px; font-weight: bold;">单品信息<span style="color:#f00;font-size:16px;">***</span></p>
			<c:forEach items="${list}" var="gs" varStatus="status">	
				<table id="admin_goods_edit_sku_table" class="tableForm" style="width:60%">
					<tr>
						<th></th>
						<td><input name="list[${status.index}].id" type="hidden" value="${gs.id}"/></td>
					</tr>	
					<tr>
						<th>商品代码:</th>
						<td><input style="width:160px" value="${gs.skuCode}" readonly="readonly"/></td>
						<th>规格代码: </th>
						<td><input style="width:160px" value="${gs.skuNum}" readonly="readonly"/></td>
						<th>库存:</th>
						<td><input style="width:160px" value="${gs.stock}" readonly="readonly"/></td>
					</tr>
					<tr>
						<th>单价:</th>
						<td><input style="width:160px" value="${gs.price}" readonly="readonly"/></td>
						<th>原价:</th>
						<td><input style="width:160px" value="${gs.originalPrice}" readonly="readonly"/></td>
						<th>天猫价:</th>
						<td><input style="width:160px" value="${gs.tmallPrice}" readonly="readonly"/></td>
					</tr>
					<tr>
						<th>颜色:</th>
						<td>						
						<span id="span_color_m">
							<input name="list[${status.index}].colorId" class="easyui-combobox" value="${gs.colorId}"
							data-options="url:'goods/goodsAction!gainSkuColorName.action',valueField:'colorId',textField:'colorName',editable:false,multiple:false"style="width:160px"/>
						</span>
						</td>
						<th>制式:</th>
						<td>
	          				<input style="width:160px" value="${gs.standard}" readonly="readonly"/>
						</td>
						<th>是否上架:</th>
						<td>
						<select name="list[${status.index}].shelves" style="width:140px">
							<c:if test="${gs.shelves=='true'}">　
							<option value="true" selected="selected">上架</option>  
							</c:if>
							<c:if test="${gs.shelves=='false'}">　
							<option value="false" selected="selected">下架</option>  
							</c:if>
						</select>
						</td>	
					</tr>
					<tr>
						<th>网络类型:</th>
						<td>
						<span id="span_netsuit_m">
							<input id="netsuitType" name="list[${status.index}].netsuitType" class="easyui-combobox" value="${gs.netsuitType}" style="width:160px"
							data-options=
								"url:'admin/goods/netsuitType.json',
								 method:'post',
								 valueField:'id',
								 textField:'text',
								 editable:true,
								 multiple:true"/>
						</span>						
						</td>		
						<th>浮动数量:</th>
						<td>
							<input style="width:160px" value="${gs.changeNum}" readonly="readonly"/>
						</td>
						<th>浮动价格:</th>
						<td>
							<input style="width:160px" value="${gs.changePrice}" readonly="readonly"/>
						</td>
					</tr>
					<tr>
						<th>网络模式</th>
						<td>
							<input style="width:160px" value = "${gs.netModel}" readonly="readonly"/>
						</td>
						<th>3G网络:</th>
						<td><input style="width:160px" value="${gs.networkThree}" readonly="readonly"/></td>
						<th>4G网络:</th>
						<td><input style="width:160px" value="${gs.networkFour}" readonly="readonly"/></td>
					</tr>
					<tr>
						<th>机身内存:</th>
						<td><input style="width:160px" value="${gs.storage}" readonly="readonly"/></td>
						<th>版本:</th>
						<td><input style="width:160px" value="${gs.edition}" readonly="readonly"/></td>
						<th>支持频段:</th>
						<td><input style="width:160px" value="${gs.supportChannel}" readonly="readonly"/></td>					
					</tr>												
					<tr>
						<th>商品图片:</th>
						<td colspan="3">
							 <span id="admin_goods_add_thumbPic_m">	
							 <c:if test="${!empty gs.picList[0].picSrc}">
							 	 <c:forEach items = "${gs.picList}" var="ppp" varStatus="status1">			 							
		 							<img id="img_n" width = '55px' height = '41px' src="${ppp.picSrc}"/>		 							
								</c:forEach>
							 </c:if>
							 </span>						
						</td>
						<th>下架时间:</th>
						<td>
							<input type="text" value="${gs.shelvesTime}" readonly="readonly"/>
						</td>
					</tr> 
				</table>
			</c:forEach>	
		</form>
	</div>
</div>
