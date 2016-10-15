<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>文件上传</title>
    <link rel="stylesheet" href="js/plupload/queue/css/jquery.plupload.queue.css" type="text/css"></link>
    <script type="text/javascript" src="js/jquery-easyui-1.3.1/jquery-1.8.0.min.js"></script>
	<script type="text/javascript" src="js/plupload/plupload.js"></script>
	<script type="text/javascript" src="js/plupload/plupload.html4.js"></script>
	<script type="text/javascript" src="js/plupload/plupload.html5.js"></script>
	<script type="text/javascript" src="js/plupload/plupload.flash.js"></script>
	<script type="text/javascript" src="js/plupload/zh_CN.js"></script>
    <script type="text/javascript" src="js/plupload/queue/jquery.plupload.queue.js"></script>
  <body style="padding: 0;margin: 0;">
  <div id="${id }">&nbsp;</div>
<script type="text/javascript">
var files = [];
//var paths=[];
var thumbPaths=[];
//var standardPaths=[];
var errors = [];
var type = 'file';
var chunk = eval('${param.chunk}');
var max_file_size = '5mb';
var filters = {title : "文档", extensions : "doc,docx,xls,xlsx,ppt,pptx,png,jpg"};
$(function(){
	$("#${id}").pluploadQueue($.extend({
		runtimes : 'gears,flash,silverlight,browserplus,html5,html4',
		url : 'imagesAction!ftpUpload.action',
		max_file_size : max_file_size,
		file_data_name:'file',
		unique_names:true,
		filters : [filters],
		flash_swf_url : 'js/plupload/plupload.flash.swf',
		init:{
			FileUploaded:function(uploader,file,response){
				if(response.response){
					var rs = $.parseJSON(response.response);
					if(rs.status){
						files.push(file.name);
						//paths.push(rs.imgPath);
						thumbPaths.push(rs.thumbPath);
						//standardPaths.push(rs.standardPath);
					}else{
						errors.push(file.name);
					}
				}
			},
			UploadComplete:function(uploader,fs){
				var e= errors.length ? ",失败"+errors.length+"个("+errors.join("、")+")。" : "。";
				alert("上传完成！共"+fs.length+"个。成功"+files.length+e+"保存之后生效!");
				target.window("close");
			}
		}
	},(chunk ? {chunk_size:'1mb'} : {})));
});
</script>
  </body>
</html>
