window.onload = function() {
	$('#loading-mask').fadeOut();
};

var onlyOpenTitle = "欢迎使用";// 不允许关闭的标签的标题

$(function() {
	InitLeftMenu();
	tabClose();
	tabCloseEven();
	
	$('#tabs').tabs({
		tools : [ {
			iconCls : 'icon-reload',
			handler : function() {
				var href = $('#tabs').tabs('getSelected').panel('options').href;
				var title= $('#tabs').tabs('getSelected').panel('options').title;
				if(title== onlyOpenTitle){
					return false;
				}
				if (href) {/*说明tab是以href方式引入的目标页面*/
					var index = $('#tabs').tabs('getTabIndex', $('#tabs').tabs('getSelected'));
					$('#tabs').tabs('getTab', index).panel('refresh');
				} else {/*说明tab是以content方式引入的目标页面*/
					var currentTab = $('#tabs').tabs('getSelected');
					var iframe = $(currentTab.panel('options').content);
					var src = iframe.attr('src');
					$('#tabs').tabs('update', {
						tab : currentTab,
						options : {
							content : createFrame(src)
						}
					});
				}
			}
		}, {
			iconCls : 'icon-cancel',
			handler : function() {
				var index = $('#tabs').tabs('getTabIndex', $('#tabs').tabs('getSelected'));
				var tab = $('#tabs').tabs('getTab', index);
				if (tab.panel('options').closable) {
					$('#tabs').tabs('close', index);
				} else {
					$.messager.alert('提示', '[' + tab.panel('options').title + ']不可以被关闭', 'error');
				}
			}
		} ]
	});

	/*
	 * 选择TAB时刷新内容
	
	$('#tabs').tabs({
		onSelect : function(title) {
			if(title=='商品列表'){
				var currTab = $('#tabs').tabs('getTab', title);
				currTab.panel('open').panel('refresh');
				var iframe = $(currTab.panel('options').content);
				var src = iframe.attr('src');
				if (src)
					$('#tabs').tabs('update', {
						tab : currTab,
						options : {
							content : createFrame(src)
						}
					});
			}
		
		}
	});
	 */

});

// 初始化左侧
var menu;
function InitLeftMenu() {
	$("#nav").accordion({
		animate : true,
		fit : true,
		border : false
	});
	$.ajax({
		url:'module/moduleAction!gainTreeMenus.action',
		dataType : 'json',
		success : function(data) {
			menu = data;
			$.each(data, function(i, n) {
				var menulist = '';
				menulist += '<ul class="navlist">';
				$.each(n.menus, function(j, o) {
					if(o.url==undefined||o.url=='') o.url='error/404.jsp';
					menulist += '<li><div ><a ref="' + o.menuid
							+ '" href="javascript:void(0)"  ret="'+o.imType+'" rel="' + o.url
							+ '" ><span class="icon ' + o.icon
							+ '" >&nbsp;</span><span class="nav">' + o.menuname
							+ '</span></a></div> ';
					if (o.child && o.child.length > 0) {//如何菜单还有子菜单,继续循环
						menulist += '<ul class="third_ul">';
						$.each(o.child, function(k, p) {
							menulist += '<li><div><a ref="' + p.menuid
									+ '" href="javascript:void(0)"  rel="' + p.url
									+ '" ><span class="icon ' + p.icon
									+ '" >&nbsp;</span><span class="nav">' + p.menuname
									+ '</span></a></div> </li>';
						});
						menulist += '</ul>';
					}
					menulist += '</li>';
				});
				menulist += '</ul>';
				if(i==0){
					$('#nav').accordion('add', {
						title : n.menuname,
						content : menulist,
						border : false,
						iconCls : 'icon ' + n.icon
					});
				}else{
					$('#nav').accordion('add', {
						title : n.menuname,
						content : menulist,
						border : false,
						selected:false,
						iconCls : 'icon ' + n.icon
					});
				}

			});			
		}
	});	
	$('.navlist li a').live('click',function() {
		var tabTitle = $(this).children('.nav').text();
		var url = $(this).attr("rel");
		var menuid = $(this).attr("ref");
		var icon = $(this).find('.icon').attr('class');
		var imType=$(this).attr("ret");
		var third = find(menuid);
		if (third && third.child && third.child.length > 0) {
			$('.third_ul').slideUp();
			var ul = $(this).parent().next();
			if (ul.is(":hidden"))
				ul.slideDown();
			else
				ul.slideUp();
		} else {
			addTab(tabTitle, url, icon,imType);
			$('.navlist li div').removeClass("selected");
			$(this).parent().addClass("selected");
		}
	}).hover(function() {
		$(this).parent().addClass("hover");
	}, function() {
		$(this).parent().removeClass("hover");
	});
}
// 获取左侧导航的图标
function getIcon(menuid) {
	var icon = 'icon ';
	$.each(menu, function(i, n) {
		$.each(n.menus, function(j, o) {
			if (o.menuid == menuid) {
				icon += o.icon;
			}
		});
	});

	return icon;
}

function find(menuid) {
	var obj = null;
	$.each(menu, function(i, n) {
		$.each(n.menus, function(j, o) {
			if (o.menuid == menuid) {
				obj = o;
			}
		});
	});

	return obj;
}

function addTab(subtitle, url, icon,imType) {
	if (!$('#tabs').tabs('exists', subtitle)) {
		if(imType=='href'){
			$('#tabs').tabs('add', {
				title : subtitle,
				href : url,
				closable : true,
				icon : icon
			});
		}else{
			$('#tabs').tabs('add', {
				title : subtitle,
				content : createFrame(url),
				closable : true,
				icon : icon
			});
		}
	} else {
		$('#tabs').tabs('select', subtitle);
		$('#mm-tabupdate').click();
	}
	tabClose();
}

function createFrame(url) {
	var s = '<iframe scrolling="auto" frameborder="0"  src="' + url
			+ '" style="width:100%;height:100%;"></iframe>';
	return s;
}

function tabClose() {
	/* 双击关闭TAB选项卡 */
	$(".tabs-inner").dblclick(function() {
		var subtitle = $(this).children(".tabs-closable").text();
		$('#tabs').tabs('close', subtitle);
	});
	/* 为选项卡绑定右键 */
	$(".tabs-inner").bind('contextmenu', function(e) {
		$('#mm').menu('show', {
			left : e.pageX,
			top : e.pageY
		});

		var subtitle = $(this).children(".tabs-closable").text();

		$('#mm').data("currtab", subtitle);
		$('#tabs').tabs('select', subtitle);
		return false;
	});
}

// 绑定右键菜单事件
function tabCloseEven() {

	$('#mm').menu({
		onClick : function(item) {
			closeTab(item.id);
		}
	});

	return false;
}

function closeTab(action) {
	var alltabs = $('#tabs').tabs('tabs');
	var currentTab = $('#tabs').tabs('getSelected');
	var allTabtitle = [];
	$.each(alltabs, function(i, n) {
		allTabtitle.push($(n).panel('options').title);
	});

	switch (action) {
	case "refresh":
		var currtab_title = currentTab.panel('options').title;
		if (currtab_title == onlyOpenTitle) {
			return false;
		}
		var href = $('#tabs').tabs('getSelected').panel('options').href;
		if (href) {/*说明tab是以href方式引入的目标页面*/
			var index = $('#tabs').tabs('getTabIndex', $('#tabs').tabs('getSelected'));
			$('#tabs').tabs('getTab', index).panel('refresh');
		} else {/*说明tab是以content方式引入的目标页面*/
			var iframe = $(currentTab.panel('options').content);
			var src = iframe.attr('src');
			$('#tabs').tabs('update', {
				tab : currentTab,
				options : {
					content : createFrame(src)
				}
			});
		}
		break;
	case "close":
		var currtab_title = currentTab.panel('options').title;
		if (currtab_title == onlyOpenTitle) {
			return false;
		}
		$('#tabs').tabs('close', currtab_title);
		break;
	case "closeall":
		$.each(allTabtitle, function(i, n) {
			if (n != onlyOpenTitle) {
				$('#tabs').tabs('close', n);
			}
		});
		break;
	case "closeother":
		var currtab_title = currentTab.panel('options').title;
		$.each(allTabtitle, function(i, n) {
			if (n != currtab_title && n != onlyOpenTitle) {
				$('#tabs').tabs('close', n);
			}
		});
		break;
	case "closeright":
		var tabIndex = $('#tabs').tabs('getTabIndex', currentTab);

		if (tabIndex == alltabs.length - 1) {
			alert('亲，后边没有啦 ^@^!!');
			return false;
		}
		$.each(allTabtitle, function(i, n) {
			if (i > tabIndex) {
				if (n != onlyOpenTitle) {
					$('#tabs').tabs('close', n);
				}
			}
		});

		break;
	case "closeleft":
		var tabIndex = $('#tabs').tabs('getTabIndex', currentTab);
		if (tabIndex == 1) {
			alert('亲，前边那个上头有人，咱惹不起哦。 ^@^!!');
			return false;
		}
		$.each(allTabtitle, function(i, n) {
			if (i < tabIndex) {
				if (n != onlyOpenTitle) {
					$('#tabs').tabs('close', n);
				}
			}
		});

		break;
	case "exit":
		var currtab_title = currentTab.panel('options').title;
		if (currtab_title == onlyOpenTitle) {
			return false;
		}
		$('#tabs').tabs('close', currtab_title);
		break;
	}
}

// 弹出信息窗口 title:标题 msgString:提示信息 msgType:信息类型 [error,info,question,warning]
function msgShow(title, msgString, msgType) {
	$.messager.alert(title, msgString, msgType);
}
