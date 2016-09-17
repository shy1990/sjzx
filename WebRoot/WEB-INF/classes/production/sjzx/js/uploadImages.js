/**
	 * 创建上传窗口 公共方法
	 * @param chunk 是否分割大文件
	 * @param callBack 上传成功之后的回调
	 */
	function UploaderForAdd(chunk, callBack) {
		var editWin = $('<div style="overflow: hidden;"/>');
		var upladoer = $('<iframe/>');
		upladoer.attr({
			'src' : 'imagesAction!toUpLoaderForAdd.action?chunk=' + chunk,
			width : '100%',
			height : '100%',
			frameborder : '0',
			scrolling : 'no'
		});
		editWin.window({
			title : "上传文件",
			height : 350,
			width : 550,
			minimizable : false,
			modal : true,
			collapsible : false,
			maximizable : false,
			resizable : false,
			content : upladoer,
			onClose : function() {
				var fw = GetFrameWindowForAdd(upladoer[0]);
				var files = fw.files;
				//var paths=fw.paths;
				var thumbPaths = fw.thumbPaths;
				//var standardPaths=fw.standardPaths;
				$(this).window('destroy');
				//callBack.call(this,files,paths,thumbPaths,standardPaths);
				callBack.call(this, files, thumbPaths);
			},
			onOpen : function() {
				var target = $(this);
				setTimeout(function() {
					var fw = GetFrameWindowForAdd(upladoer[0]);
					fw.target = target;
				}, 100);
			}
		});
	}

	/**
	 * 根据iframe对象获取iframe的window对象
	 * @param frame
	 * @returns {Boolean}
	 */
	function GetFrameWindowForAdd(frame) {
		return frame && typeof (frame) == 'object' && frame.tagName == 'IFRAME'
				&& frame.contentWindow;
	}
	/**
	 * 图片上传
	 * @param chunk 是否分割大文件
	 * @param uploadThumbPic 上传后需要展示的ID
	 */
	function makerUploadForAdd(chunk,uploadThumbPic) {
		//Uploader(chunk,function(files,paths,thumbPaths,standardPaths){
		UploaderForAdd(chunk, function(files, thumbPaths) {
			if (files && files.length > 0) {
				var admin_goods_add_thumbPic =document.getElementById(uploadThumbPic);
				var thumb = thumbPaths.join(",").split(",");
				for ( var i = 0; i < thumb.length; i++) {
					var img=document.createElement("img");  
					img.setAttribute("id",sy.UUID()); 
					img.setAttribute('src',thumb[i]);
					img.style.height='41px';
					img.style.width='55px';
					img.style.marginRight='10px';
					img.style.display="inline";
					img.ondblclick= function(){
						goods_add_dropDom(this);
					};
					admin_goods_add_thumbPic.appendChild(img);
				} ;
			};
		});
	}