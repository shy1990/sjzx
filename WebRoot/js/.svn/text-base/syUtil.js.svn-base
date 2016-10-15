
var sy = $.extend({}, sy);/* 定义全局对象，类似于命名空间或包的作用 */

/**
 * @author 孙宇
 * 
 * @requires jQuery,EasyUI
 * 
 * panel关闭时回收内存，主要用于layout使用iframe嵌入网页时的内存泄漏问题
 */
$.fn.panel.defaults.onBeforeDestroy = function() {
	var frame = $('iframe', this);
	try {
		if (frame.length > 0) {
			for ( var i = 0; i < frame.length; i++) {
				frame[i].contentWindow.document.write('');
				frame[i].contentWindow.close();
			}
			frame.remove();
			if ($.browser.msie) {
				CollectGarbage();
			}
		}
	} catch (e) {
	}
};

/**
 * 使panel和datagrid在加载时提示
 * 
 * @author 孙宇
 * 
 * @requires jQuery,EasyUI
 * 
 */
$.fn.panel.defaults.loadingMessage = '加载中,请稍后....';
$.fn.datagrid.defaults.loadMsg = '我正在努力的加载...';
/**
 * @author 孙宇
 * 
 * @requires jQuery,EasyUI
 * 
 * 通用错误提示
 * 
 * 用于datagrid/treegrid/tree/combogrid/combobox/form加载数据出错时的操作
 */
var easyuiErrorFunction = function(XMLHttpRequest) {
	$.messager.progress('close');
	$.messager.alert('错误', XMLHttpRequest.responseText);
};
//$.fn.datagrid.defaults.onLoadError = easyuiErrorFunction;
$.fn.treegrid.defaults.onLoadError = easyuiErrorFunction;
$.fn.tree.defaults.onLoadError = easyuiErrorFunction;
$.fn.combogrid.defaults.onLoadError = easyuiErrorFunction;
$.fn.combobox.defaults.onLoadError = easyuiErrorFunction;
$.fn.form.defaults.onLoadError = easyuiErrorFunction;
$.fn.combobox.defaults.width = 180;
$.fn.combotree.defaults.width = 180;

/**
 * @author 孙宇
 * 
 * @requires jQuery,EasyUI
 * 
 * 为datagrid、treegrid增加表头菜单，用于显示或隐藏列，注意：冻结列不在此菜单中
 */
var createGridHeaderContextMenu = function(e, field) {
	e.preventDefault();
	var grid = $(this);/* grid本身 */
	var headerContextMenu = this.headerContextMenu;/* grid上的列头菜单对象 */
	if (!headerContextMenu) {
		var tmenu = $('<div style="width:100px;"></div>').appendTo('body');
		var fields = grid.datagrid('getColumnFields');
		for ( var i = 0; i < fields.length; i++) {
			var fildOption = grid.datagrid('getColumnOption', fields[i]);
			if (!fildOption.hidden) {
				$('<div iconCls="icon-ok" field="' + fields[i] + '"/>').html(fildOption.title).appendTo(tmenu);
			} else {
				$('<div iconCls="icon-empty" field="' + fields[i] + '"/>').html(fildOption.title).appendTo(tmenu);
			}
		}
		headerContextMenu = this.headerContextMenu = tmenu.menu({
			onClick : function(item) {
				var field = $(item.target).attr('field');
				if (item.iconCls == 'icon-ok') {
					grid.datagrid('hideColumn', field);
					$(this).menu('setIcon', {
						target : item.target,
						iconCls : 'icon-empty'
					});
				} else {
					grid.datagrid('showColumn', field);
					$(this).menu('setIcon', {
						target : item.target,
						iconCls : 'icon-ok'
					});
				}
			}
		});
	}
	headerContextMenu.menu('show', {
		left : e.pageX,
		top : e.pageY
	});
};
$.fn.datagrid.defaults.onHeaderContextMenu = createGridHeaderContextMenu;
$.fn.treegrid.defaults.onHeaderContextMenu = createGridHeaderContextMenu;


/**
 * @requires Jquery,EasyUI 扩展validatebox 添加验证两次密码功能
 */
$.extend($.fn.validatebox.defaults.rules, {
	rePwd : {
		validator : function(value, param) {
			return value == $(param[0]).val();
		},
		message : '两次密码不一致'
	}
});

/**
 * 将form表单元素的值序列化成对象
 */
sy.serializeObject=function(form){/*将form表单元素序列化成对象*/
	var o={};
	$.each(form.serializeArray(),function(index){
		if (o[this['name']]) {
			o[this['name']] = o[this['name']] + "," + this['value'];
		} else {
			o[this['name']] = this['value'];
		}
	});
	return o;
};

/**
 * @author 郭华(夏悸)
 * 
 * 生成UUID
 * 
 * @returns UUID字符串
 */
sy.random4 = function() {
	return (((1 + Math.random()) * 0x10000) | 0).toString(16).substring(1);
};
sy.UUID = function() {
	return (sy.random4() + sy.random4() + "-" + sy.random4() + "-" + sy.random4() + "-" + sy.random4() + "-" + sy.random4() + sy.random4() + sy.random4());
};

/**
 * 扩展 datagrid行编辑输入日期带几点的
 */
$.extend($.fn.datagrid.defaults.editors, {   
    datetimebox : {   
        init: function(container, options){   
            var input = $('<input />').appendTo(container);  
            options.editable=false;
            input.datetimebox(options);
            return input;   
        },   
        getValue: function(target){   
            return $(target).datetimebox('getValue');   
        },   
        setValue: function(target, value){   
            $(target).datetimebox('setValue',value);   
        },   
        resize: function(target, width){   
            $(target).datetimebox('resize',width);
        },
        destory:function(target){
        	$(target).datetimebox('destory');
        }
    }   
});  

/**
 * @author 孙宇
 * 
 * @requires jQuery,EasyUI
 * 
 * 扩展datagrid，添加动态增加或删除Editor的方法
 * 
 * 例子如下，第二个参数可以是数组
 * 
 * datagrid.datagrid('removeEditor', 'cpwd');
 * 
 * datagrid.datagrid('addEditor', [ { field : 'createtime', editor : { type : 'datetimebox', options : { editable : false } } }, { field : 'cmodifytime', editor : { type : 'datetimebox', options : { editable : false } } } ]);
 * 
 */
$.extend($.fn.datagrid.methods, {
	addEditor : function(jq, param) {
		if (param instanceof Array) {
			$.each(param, function(index, item) {
				var e = $(jq).datagrid('getColumnOption', item.field);
				e.editor = item.editor;
			});
		} else {
			var e = $(jq).datagrid('getColumnOption', param.field);
			e.editor = param.editor;
		}
	},
	removeEditor : function(jq, param) {
		if (param instanceof Array) {
			$.each(param, function(index, item) {
				var e = $(jq).datagrid('getColumnOption', item);
				e.editor = {};
			});
		} else {
			var e = $(jq).datagrid('getColumnOption', param);
			e.editor = {};
		}
	}
});


/**
 * @author 孙宇
 * 
 * @requires jQuery,EasyUI
 * 
 * 避免验证tip屏幕跑偏
 */
var removeEasyuiTipFunction = function() {
	window.setTimeout(function() {
		$('div.validatebox-tip').remove();
	}, 0);
};
$.fn.panel.defaults.onClose = removeEasyuiTipFunction;
$.fn.window.defaults.onClose = removeEasyuiTipFunction;
$.fn.dialog.defaults.onClose = removeEasyuiTipFunction;
/**
 * @author 孙宇
 * 
 * @requires jQuery,EasyUI
 */
sy.messagerShow = function(options) {
	return $.messager.show(options);
};

/**
 * @author 孙宇
 * 
 * @requires jQuery,EasyUI
 * 
 * 防止panel/window/dialog组件超出浏览器边界
 * @param left
 * @param top
 */
var easyuiPanelOnMove = function(left, top) {
	var l = left;
	var t = top;
	if (l < 1) {
		l = 1;
	}
	if (t < 1) {
		t = 1;
	}
	var width = parseInt($(this).parent().css('width')) + 14;
	var height = parseInt($(this).parent().css('height')) + 14;
	var right = l + width;
	var buttom = t + height;
	var browserWidth = $(window).width();
	var browserHeight = $(window).height();
	if (right > browserWidth) {
		l = browserWidth - width;
	}
	if (buttom > browserHeight) {
		t = browserHeight - height;
	}
	$(this).parent().css({/* 修正面板位置 */
		left : l,
		top : t
	});
};
$.fn.dialog.defaults.onMove = easyuiPanelOnMove;
$.fn.window.defaults.onMove = easyuiPanelOnMove;
$.fn.panel.defaults.onMove = easyuiPanelOnMove;


/**
 * @author 夏季
 * 简单的树形结构 p,pid,text
 */
$.fn.tree.defaults.loadFilter = function (data, parent) {
	var opt = $(this).data().tree.options;
	var idFiled,
	textFiled,
	parentField;
	if (opt.parentField) {
		idFiled = opt.idFiled || 'id';
		textFiled = opt.textFiled || 'text';
		parentField = opt.parentField;
		var i,
		l,
		treeData = [],
		tmpMap = [];
		for (i = 0, l = data.length; i < l; i++) {
			tmpMap[data[i][idFiled]] = data[i];
		}
		for (i = 0, l = data.length; i < l; i++) {
			if (tmpMap[data[i][parentField]] && data[i][idFiled] != data[i][parentField]) {
				if (!tmpMap[data[i][parentField]]['children'])
					tmpMap[data[i][parentField]]['children'] = [];
				data[i]['text'] = data[i][textFiled];
				tmpMap[data[i][parentField]]['children'].push(data[i]);
			} else {
				data[i]['text'] = data[i][textFiled];
				treeData.push(data[i]);
			}
		}
		return treeData;
	}
	return data;
};
/**
 * @author 孙宇
 * 
 * @requires jQuery,EasyUI
 * 
 * 扩展treegrid，使其支持平滑数据格式
 */
$.fn.treegrid.defaults.loadFilter = function(data, parentId) {
	var opt = $(this).data().treegrid.options;
	var idFiled, textFiled, parentField;
	if (opt.parentField) {
		idFiled = opt.idFiled || 'id';
		textFiled = opt.textFiled || 'text';
		parentField = opt.parentField;
		var i, l, treeData = [], tmpMap = [];
		for (i = 0, l = data.length; i < l; i++) {
			tmpMap[data[i][idFiled]] = data[i];
		}
		for (i = 0, l = data.length; i < l; i++) {
			if (tmpMap[data[i][parentField]] && data[i][idFiled] != data[i][parentField]) {
				if (!tmpMap[data[i][parentField]]['children'])
					tmpMap[data[i][parentField]]['children'] = [];
				data[i]['text'] = data[i][textFiled];
				tmpMap[data[i][parentField]]['children'].push(data[i]);
			} else {
				data[i]['text'] = data[i][textFiled];
				treeData.push(data[i]);
			}
		}
		return treeData;
	}
	return data;
};
/**
 * @author 孙宇
 * 
 * @requires jQuery,EasyUI
 * 
 * @param options
 */
sy.dialog = function(options) {
	var opts = $.extend({
		modal : true,
		onClose : function() {
			$(this).dialog('destroy');
		}
	}, options);
	return $('<div/>').dialog(opts);
};
/**
 * @author 孙宇
 * 
 * @requires jQuery,EasyUI
 * 
 * 扩展combotree，使其支持平滑数据格式
 */
$.fn.combotree.defaults.loadFilter = $.fn.tree.defaults.loadFilter;

/**
 * author ____′↘夏悸
 * create date 2012-11-5
 **/
$.extend($.fn.datagrid.methods, {
	autoMergeCells : function (jq, fields) {
		return jq.each(function () {
			var target = $(this);
			if (!fields) {
				fields = target.datagrid("getColumnFields");
			}
			var rows = target.datagrid("getRows");
			var i = 0,
			j = 0,
			temp = {};
			for (i; i < rows.length; i++) {
				var row = rows[i];
				j = 0;
				for (j; j < fields.length; j++) {
					var field = fields[j];
					var tf = temp[field];
					if (!tf) {
						tf = temp[field] = {};
						tf[row[field]] = [i];
					} else {
						var tfv = tf[row[field]];
						if (tfv) {
							tfv.push(i);
						} else {
							tfv = tf[row[field]] = [i];
						}
					}
				}
			}
			$.each(temp, function (field, colunm) {
				$.each(colunm, function () {
					var group = this;
					
					if (group.length > 1) {
						var before,
						after,
						megerIndex = group[0];
						for (var i = 0; i < group.length; i++) {
							before = group[i];
							after = group[i + 1];
							if (after && (after - before) == 1) {
								continue;
							}
							var rowspan = before - megerIndex + 1;
							if (rowspan > 1) {
								target.datagrid('mergeCells', {
									index : megerIndex,
									field : field,
									rowspan : rowspan
								});
							}
							if (after && (after - before) != 1) {
								megerIndex = after;
							}
						}
					}
				});
			});
		});
	}
});

/**
 * @author 孙宇
 * 
 * @requires jQuery,EasyUI,jQuery cookie plugin
 * 
 * 更换EasyUI主题的方法
 * 
 * @param themeName
 *            主题名称
 */
sy.changeTheme = function(themeName) {
	var $easyuiTheme = $('#easyuiTheme');
	var url = $easyuiTheme.attr('href');
	var href = url.substring(0, url.indexOf('themes')) + 'themes/' + themeName + '/easyui.css';
	$easyuiTheme.attr('href', href);

	var $iframe = $('iframe');
	if ($iframe.length > 0) {
		for ( var i = 0; i < $iframe.length; i++) {
			var ifr = $iframe[i];
			$(ifr).contents().find('#easyuiTheme').attr('href', href);
		}
	}

	$.cookie('easyuiThemeName', themeName, {
		expires : 7
	});
};

/**
 * @author 孙宇
 * 
 * 增加formatString功能
 * 
 * 使用方法：formatString('字符串{0}字符串{1}字符串','第一个变量','第二个变量');
 * 
 * @returns 格式化后的字符串
 */
formatString = function(str) {
	for ( var i = 0; i < arguments.length - 1; i++) {
		str = str.replace("{" + i + "}", arguments[i + 1]);
	}
	return str;
};

/**
 * @author 孙宇
 * 
 * 接收一个以逗号分割的字符串，返回List，list里每一项都是一个字符串
 * 
 * @returns list
 */
stringToList = function(value) {
	if (value != undefined && value != '') {
		var values = [];
		var t = value.split(',');
		for ( var i = 0; i < t.length; i++) {
			values.push('' + t[i]);/* 避免他将ID当成数字 */
		}
		return values;
	} else {
		return [];
	}
};

/**
 * @author 孙宇
 * 
 * @requires jQuery
 * 
 * 改变jQuery的AJAX默认属性和方法
 */
$.ajaxSetup({
	type : 'POST',
	error : function(XMLHttpRequest, textStatus, errorThrown) {
		$.messager.progress('close');
		$.messager.alert('错误', XMLHttpRequest.responseText);
	}
});

var detailview = $.extend({}, $.fn.datagrid.defaults.view, {
	addExpandColumn: function(target, index){
		var opts = $.data(target, 'datagrid').options;
		if (index >= 0){
			_add(index);
		} else {
			var length = $(target).datagrid('getRows').length;
			for(var i=0; i<length; i++){
				_add(i);
			}
		}
		
		function _add(rowIndex){
			var tr = opts.finder.getTr(target, rowIndex, 'body', 1);
			if (tr.find('div.datagrid-row-expander').length){return;}	// the expander is already exists
			var cc = [];
			cc.push('<td>');
			cc.push('<div style="text-align:center;width:25px">');
			cc.push('<div class="datagrid-row-expander datagrid-row-expand" style="cursor:pointer;height:14px;" />');
			cc.push('</div>');
			cc.push('</td>');
			if (tr.is(':empty')){
				tr.html(cc.join(''));
			} else if (tr.children('td.datagrid-td-rownumber').length){
				$(cc.join('')).insertAfter(tr.children('td.datagrid-td-rownumber'));
			} else {
				$(cc.join('')).insertBefore(tr.children('td:first'));
			}
			$(target).datagrid('fixRowHeight', rowIndex);
			tr.find('div.datagrid-row-expander').unbind('.datagrid').bind('click.datagrid', function(e){
				var rowIndex = $(this).closest('tr').attr('datagrid-row-index');
				if ($(this).hasClass('datagrid-row-expand')){
					$(target).datagrid('expandRow', rowIndex);
				} else {
					$(target).datagrid('collapseRow', rowIndex);
				}
				$(target).datagrid('fixRowHeight');
				return false;
			});
		}
	},
	
	render: function(target, container, frozen){
		var state = $.data(target, 'datagrid');
		var opts = state.options;
		var rows = state.data.rows;
		var fields = $(target).datagrid('getColumnFields', frozen);
		var table = [];
		for(var i=0; i<rows.length; i++) {
			table.push('<table class="datagrid-btable" cellspacing="0" cellpadding="0" border="0"><tbody>');
			
			// get the class and style attributes for this row
			var cls = (i % 2 && opts.striped) ? 'class="datagrid-row datagrid-row-alt"' : 'class="datagrid-row"';
			var styleValue = opts.rowStyler ? opts.rowStyler.call(target, i, rows[i]) : '';
			var style = styleValue ? 'style="' + styleValue + '"' : '';
			var rowId = state.rowIdPrefix + '-' + (frozen?1:2) + '-' + i;
			table.push('<tr id="' + rowId + '" datagrid-row-index="' + i + '" ' + cls + ' ' + style + '>');
			table.push(this.renderRow.call(this, target, fields, frozen, i, rows[i]));
			table.push('</tr>');
			
			table.push('<tr style="display:none;">');
			if (frozen){
				table.push('<td colspan=' + (fields.length+2) + ' style="border-right:0">');
			} else {
				table.push('<td colspan=' + (fields.length) + '>');
			}
			table.push('<div class="datagrid-row-detail">');
			if (frozen){
				table.push('&nbsp;');
			} else {
				table.push(opts.detailFormatter.call(target, i, rows[i]));
			}
			table.push('</div>');
			table.push('</td>');
			table.push('</tr>');
			
			table.push('</tbody></table>');
		}
		
		$(container).html(table.join(''));
	},
	
	insertRow: function(target, index, row){
		var opts = $.data(target, 'datagrid').options;
		var dc = $.data(target, 'datagrid').dc;
		var panel = $(target).datagrid('getPanel');
		var view1 = dc.view1;
		var view2 = dc.view2;
		
		var isAppend = false;
		var rowLength = $(target).datagrid('getRows').length;
		if (rowLength == 0){
			$(target).datagrid('loadData',{total:1,rows:[row]});
			return;
		}
		
		if (index == undefined || index == null || index >= rowLength) {
			index = rowLength;
			isAppend = true;
			this.canUpdateDetail = false;
		}
		
		$.fn.datagrid.defaults.view.insertRow.call(this, target, index, row);
		
		_insert(true);
		_insert(false);
		
		this.addExpandColumn(target, index);
		this.canUpdateDetail = true;
		
		function _insert(frozen){
			var v = frozen ? view1 : view2;
			var tr = v.find('tr[datagrid-row-index='+index+']');
			var table = tr.parents('table:first');
			
			var newTable = $('<table cellspacing="0" cellpadding="0" border="0"><tbody></tbody></table>');
			if (isAppend){
				newTable.insertAfter(table);
				var newDetail = tr.next().clone();
			} else {
				newTable.insertBefore(table);
				var newDetail = tr.next().next().clone();
			}
			tr.appendTo(newTable.children('tbody'));
			newDetail.insertAfter(tr);
			newDetail.hide();
			if (!frozen){
				newDetail.find('div.datagrid-row-detail').html(opts.detailFormatter.call(target, index, row));
			}
		}
	},
	
	deleteRow: function(target, index){
		var opts = $.data(target, 'datagrid').options;
		var dc = $.data(target, 'datagrid').dc;
		var tr = opts.finder.getTr(target, index);
		tr.parent().parent().remove();
		$.fn.datagrid.defaults.view.deleteRow.call(this, target, index);
		dc.body2.triggerHandler('scroll');
	},
	
	updateRow: function(target, rowIndex, row){
		var dc = $.data(target, 'datagrid').dc;
		var opts = $.data(target, 'datagrid').options;
		var cls = opts.finder.getTr(target, rowIndex).find('div.datagrid-row-expander').attr('class');
		$.fn.datagrid.defaults.view.updateRow.call(this, target, rowIndex, row);
		this.addExpandColumn.call(this, target, rowIndex);
		opts.finder.getTr(target, rowIndex).find('div.datagrid-row-expander').attr('class',cls);
		
		// update the detail content
		if (this.canUpdateDetail){
			var row = $(target).datagrid('getRows')[rowIndex];
			var detail = $(target).datagrid('getRowDetail', rowIndex);
			detail.html(opts.detailFormatter.call(target, rowIndex, row));
		}
	},
	
	onBeforeRender: function(target){
		var opts = $.data(target, 'datagrid').options;
		var dc = $.data(target, 'datagrid').dc;
		var panel = $(target).datagrid('getPanel');
		
		var t = dc.view1.children('div.datagrid-header').find('table');
		if (t.find('div.datagrid-header-expander').length){
			return;
		}
		var td = $('<td rowspan="'+opts.frozenColumns.length+'"><div class="datagrid-header-expander" style="width:25px;"></div></td>');
		if ($('tr',t).length == 0){
			td.wrap('<tr></tr>').parent().appendTo($('tbody',t));
		} else if (opts.rownumbers){
			td.insertAfter(t.find('td:has(div.datagrid-header-rownumber)'));
		} else {
			td.prependTo(t.find('tr:first'));
		}
	},
	
	onAfterRender: function(target){
		var state = $.data(target, 'datagrid');
		var dc = state.dc;
		var opts = state.options;
		var panel = $(target).datagrid('getPanel');
		
		$.fn.datagrid.defaults.view.onAfterRender.call(this, target);
		
		if (!state.onResizeColumn){
			state.onResizeColumn = opts.onResizeColumn;
		}
		if (!state.onResize){
			state.onResize = opts.onResize;
		}
		function setBodyTableWidth(){
			var columnWidths = dc.view2.children('div.datagrid-header').find('table').width();
			dc.body2.children('table').width(columnWidths);
		}
		
		opts.onResizeColumn = function(field, width){
			setBodyTableWidth();
			var rowCount = $(target).datagrid('getRows').length;
			for(var i=0; i<rowCount; i++){
				$(target).datagrid('fixDetailRowHeight', i);
			}
			
			// call the old event code
			state.onResizeColumn.call(target, field, width);
		};
		opts.onResize = function(width, height){
			setBodyTableWidth();
			state.onResize.call(panel, width, height);
		};
		
		this.addExpandColumn(target);
		this.canUpdateDetail = true;	// define if to update the detail content when 'updateRow' method is called;
		
		dc.footer1.find('div.datagrid-row-expander').css('visibility', 'hidden');
		$(target).datagrid('resize');
	}
});

$.extend($.fn.datagrid.methods, {
	fixDetailRowHeight: function(jq, index){
		return jq.each(function(){
			var opts = $.data(this, 'datagrid').options;
			var dc = $.data(this, 'datagrid').dc;
			var tr1 = opts.finder.getTr(this, index, 'body', 1).next();
			var tr2 = opts.finder.getTr(this, index, 'body', 2).next();
			// fix the detail row height
			if (tr2.is(':visible')){
				tr1.css('height', '');
				tr2.css('height', '');
				var height = Math.max(tr1.height(), tr2.height());
				tr1.css('height', height);
				tr2.css('height', height);
			}
			dc.body2.triggerHandler('scroll');
		});
	},
	getExpander: function(jq, index){	// get row expander object
		var opts = $.data(jq[0], 'datagrid').options;
		return opts.finder.getTr(jq[0], index, 'body', 1).find('div.datagrid-row-expander');
	},
	// get row detail container
	getRowDetail: function(jq, index){
		var opts = $.data(jq[0], 'datagrid').options;
		var tr = opts.finder.getTr(jq[0], index, 'body', 2);
		return tr.next().find('div.datagrid-row-detail');
	},
	expandRow: function(jq, index){
		return jq.each(function(){
			var opts = $(this).datagrid('options');
			var dc = $.data(this, 'datagrid').dc;
			var expander = $(this).datagrid('getExpander', index);
			if (expander.hasClass('datagrid-row-expand')){
				expander.removeClass('datagrid-row-expand').addClass('datagrid-row-collapse');
				var tr1 = opts.finder.getTr(this, index, 'body', 1).next();
				var tr2 = opts.finder.getTr(this, index, 'body', 2).next();
				tr1.show();
				tr2.show();
				$(this).datagrid('fixDetailRowHeight', index);
				if (opts.onExpandRow){
					var row = $(this).datagrid('getRows')[index];
					opts.onExpandRow.call(this, index, row);
				}
			}
		});
	},
	collapseRow: function(jq, index){
		return jq.each(function(){
			var opts = $(this).datagrid('options');
			var dc = $.data(this, 'datagrid').dc;
			var expander = $(this).datagrid('getExpander', index);
			if (expander.hasClass('datagrid-row-collapse')){
				expander.removeClass('datagrid-row-collapse').addClass('datagrid-row-expand');
				var tr1 = opts.finder.getTr(this, index, 'body', 1).next();
				var tr2 = opts.finder.getTr(this, index, 'body', 2).next();
				tr1.hide();
				tr2.hide();
				dc.body2.triggerHandler('scroll');
				if (opts.onCollapseRow){
					var row = $(this).datagrid('getRows')[index];
					opts.onCollapseRow.call(this, index, row);
				}
			}
		});
	}
});

/**
 * 扩展validatebox最少输入多少位验证
 */
$.extend($.fn.validatebox.defaults.rules, {   
    minLength: {   
        validator: function(value, param){   
            return value.length >= param[0];   
        },   
        message: 'Please enter at least {0} characters.'  
    }   
});
/**
 * 扩展validatebox至多输入多少位验证
 */
$.extend($.fn.validatebox.defaults.rules, {   
    maxLength: {   
        validator: function(value, param){   
            return value.length <= param[0];   
        },   
        message: 'Please enter at most {0} characters.'  
    }   
});
/**
 * 扩展validatebox 手机号验证
 */
$.extend($.fn.validatebox.defaults.rules, {   
    mobilePhone: {   
        validator: function(value){   
            return value.match(/^1[3|4|5|8][0-9]\d{4,8}$/); 
        },   
        message: '请输入合法的手机号码.'  
    }   
});

/**
 * 扩展validatebox 身份证号验证
 */
$.extend($.fn.validatebox.defaults.rules, {   
    idCard: {   
        validator: function(value){  
            return value.match(/^\d{15}$|^\d{17}[\d,x,X]{1}$/); 
        },   
        message: '请输入合法的身份证号码.'  
    }   
});

//弹出信息窗口 title:标题 msgString:提示信息 msgType:信息类型 [error,info,question,warning]
function msgShow(title, msgString, msgType) {
	$.messager.alert(title, msgString, msgType);
}
/**
 * @author 孙宇
 * @requires jQuery,EasyUI
 * @param title标题
 * @param msg 提示信息
 * @param fun 回调方法
 */
sy.messagerConfirm = function(title, msg, fn) {
	return $.messager.confirm(title, msg, fn);
};
/**
 * 扩展mydate 97
 */
(function ($) {
	$.fn.my97 = function (options, params) {
		if (typeof options == "string") {
			return $.fn.my97.methods[options](this, params);
		}
		options = options || {};
		if (!WdatePicker) {
			alert("未引入My97js包！");
			return;
		}
		return this.each(function () {
			var data = $.data(this, "my97");
			var newOptions;
			if (data) {
				newOptions = $.extend(data.options, options);
				data.opts = newOptions;
			} else {
				newOptions = $.extend({}, $.fn.my97.defaults, $.fn.my97.parseOptions(this), options);
				$.data(this, "my97", {
					options : newOptions
				});
			}
			$(this).addClass('Wdate').click(function () {
				WdatePicker(newOptions);
			});
		});
	};
	$.fn.my97.methods = {
		setValue : function (target, params) {
			target.val(params);
		},
		getValue : function (target) {
			return target.val();
		},
		clearValue : function (target) {
			target.val('');
		}
	};
	$.fn.my97.parseOptions = function (target) {
		return $.extend({}, $.parser.parseOptions(target, ["el", "vel", "weekMethod", "lang", "skin", "dateFmt", "realDateFmt", "realTimeFmt", "realFullFmt", "minDate", "maxDate", "startDate", {
						doubleCalendar : "boolean",
						enableKeyboard : "boolean",
						enableInputMask : "boolean",
						autoUpdateOnChanged : "boolean",
						firstDayOfWeek : "number",
						isShowWeek : "boolean",
						highLineWeekDay : "boolean",
						isShowClear : "boolean",
						isShowToday : "boolean",
						isShowOthers : "boolean",
						readOnly : "boolean",
						errDealMode : "boolean",
						autoPickDate : "boolean",
						qsEnabled : "boolean",
						autoShowQS : "boolean",
						opposite : "boolean"
					}
				]));
	};
	$.fn.my97.defaults = {
		dateFmt : 'yyyy-MM-dd HH:mm:ss'
	};

	$.parser.plugins.push('my97');
})(jQuery);

String.prototype.trim=function(){
    return this.replace(/(^\s*)|(\s*$)/g, "");
 };
 String.prototype.ltrim=function(){
    return this.replace(/(^\s*)/g,"");
 };
 String.prototype.rtrim=function(){
    return this.replace(/(\s*$)/g,"");
 };
 
 function _onLoadSuccess(){
		var target = $(this);
		var data = target.combobox("getData");
		var options = target.combobox("options");
		if(data && data.length>0){
			var fs = data[0];
			target.combobox("setValue",fs[options.valueField]);
		}
}
 
 //扩展easyui validatebox的两个方法.移除验证和还原验证
 $.extend($.fn.validatebox.methods, {  
		remove: function(jq, newposition){  
			return jq.each(function(){  
				$(this).removeClass("validatebox-text validatebox-invalid").unbind('focus.validatebox').unbind('blur.validatebox');
			});  
		},
		reduce: function(jq, newposition){  
			return jq.each(function(){  
			   var opt = $(this).data().validatebox.options;
			   $(this).addClass("validatebox-text").validatebox(opt);
			});  
		}	
	}); 