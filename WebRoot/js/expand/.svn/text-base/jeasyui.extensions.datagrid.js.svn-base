////////////////////////////////////////////////////////////////////////////////////////////////
/// 扩展 easyui-datagrid；使得 easyui-datagrid 在原基础上，增加右键点击行和右键点击表头的菜单；并且没有破坏 easyui-datagrid 的原生事件和属性；
/// 该扩展在 easyui-datagrid 的基础上增加或重载了如下属性：
///     url: 该参数 easyui-datagrid 本来就有，这里是进行了重载；
///         该参数表示 easyui-datagrid 控件所加载远程数据的 webservice 地址(可以为 一般处理程序 或者 ASP.NET WEB 服务等url地址)；
///         注意：该url参数如果指向基于 ASP.NET WebService 则必须返回 JSON 类型数据且必须标记 [ScriptMethod(ResponseFormat = ResponseFormat.Json)]
///             如果该 url 参数指向 WebService 类型的数据源路径，则 isWebService 参数必须设置为 true，否则加载数据格式不正确；
///     isWebService: 执行 easyui-datagrid 的 url 数据源返回的数据格式是不是符合 WebService 规范的 XML 数据格式，默认为 true；
///     queryParams: 该参数 easyui-datagrid 本来就有，这里是进行了重载；
///         该参数表示请求远程 WebService 所传递的 JSON 格式参数对象，该 JSON 对象中各个键值对的值可以为具体的值，也可以是获取值的回调函数。
///     searchButton: 执行查询按钮操作的按钮元素，可以为按钮的 jquery 选择器，也可以是一个 jquery 对象(可以是数组)或者 HTML DOM 对象（也可以是数组）。
///         如果设定了该值，则在点击相关按钮时自动执行查询事件，并且 queryParams 参数所有键值对的值必须是一个获取参数具体值的回调函数；
///     offset: 表示 easyui-datagrid 控件最浏览器窗口大小调整而自动调整的偏移量，这是一个 json 对象，该对象有如下属性：
///         width: 表示相对于浏览器窗口宽度的偏移量，如果是正数则其宽度比浏览器窗口大，反之则其宽度比浏览器窗口小，int类型；
///         height: 表示相对于浏览器窗口高度的偏移量，如果是正数则其高度比浏览器窗口大，反之则其高度比浏览器窗口小，int类型；
///         注意，也可以不设置该参数，则 easyui-datagrid 的大小不自动随浏览器窗口大小调整而调整。
///     remotePaging：表示 easyui-datagrid 的数据分页方式是基于远程服务器数据分页还是本地分页，如果为 true 则表示进行远程服务器数据分页；
///         该值默认为 true；这是一个 bool 类型的值；
///     headerContextMenus: 当右键点击 easyui-datagrid 数据列表头位置所触发的右键菜单按钮及其按钮事件。这是一个数组对象，数组中的每个元素可以是一个字符串 "-"，也可以是一个包含如下属性的 json 对象：
///         id: 表示该菜单按钮的id，可以为字符串，也可以是一个签名为 function(e, field, eventData) 的函数，该函数返回一个字符串；
///         text: 表示该菜单按钮的显示文本，可以为字符串，也可以是一个签名为 function(e, field, eventData) 的函数，该函数返回一个字符串；
///         iconCls: 表示该菜单按钮的图标样式，可以为字符串，也可以是一个签名为 function(e, field, eventData) 的函数，该函数返回一个字符串；
///         disabled: 表示该菜单按钮的可用状态，可以是一个布尔值，也可以是一个签名为 function(e, field, eventData) 的函数，该函数返回一个布尔值；
///         handler: 表示该菜单按钮的id，格式必须是签名为 function(e, field, eventData) 的函数；
///             备注：签名为 function(e, field, eventData)的函数中，前2个参数(e, field) 的数据和 easyui-datagrid 控件的 onHeaderContextMenu 事件函数的参数一样；
///                   参数 eventData 为一个 JSON 对象，格式如：{ e: e, pager: pager, total: total, pageNumber: pageNumber, pageSize: pageSize, pageCount: pageCount }。
///         children: 表示该菜单的子级菜单，为一个数组对象，数组中每一个元素和当前父级元素的格式相同；
///     rowContextMenus：当右键点击 easyui-datagrid 数据行所触发的右键菜单按钮及其按钮事件。这是一个数组对象，数组中的每个元素可以是一个字符串 "-"，也可以是一个包含如下属性的 json 对象：
///         id: 表示该菜单按钮的id，可以为字符串，也可以是一个签名为 function(e, rowIndex, rowData, eventData) 的函数，该函数返回一个字符串；
///         text: 表示该菜单按钮的显示文本，可以为字符串，也可以是一个签名为 function(e, rowIndex, rowData, eventData) 的函数，该函数返回一个字符串；
///         iconCls: 表示该菜单按钮的图标样式，可以为字符串，也可以是一个签名为 function(e, rowIndex, rowData, eventData) 的函数，该函数返回一个字符串；
///         disabled: 表示该菜单按钮的可用状态，可以是一个布尔值，也可以是一个签名为 function(e, rowIndex, rowData, eventData) 的函数，该函数返回一个布尔值；
///         handler: 表示该菜单按钮的触发事件，格式必须是签名为 function(e, rowIndex, rowData, eventData) 的函数；
///             备注：签名为 function(e, rowIndex, rowData, eventData)的函数中，前3个参数(e, rowIndex, rowData) 的数据和 easyui-datagrid 控件的 onRowContextMenu 事件函数的参数一样；
///                   参数 eventData 为一个 JSON 对象，格式如：{ e: e, pager: pager, total: total, pageNumber: pageNumber, pageSize: pageSize, pageCount: pageCount }。
///         children: 表示该菜单的子级菜单，为一个数组对象，数组中每一个元素和当前父级元素的格式相同；
///     contextMenuWidth: 右键菜单的像素宽度，为一个 int 类型值，默认为 140。
////////////////////////////////////////////////////////////////////////////////////////////////
/// 作者：陈建伟
/// 最后修改日期：
////////////////////////////////////////////////////////////////////////////////////////////////
/// 该文件的功能实现按顺序引用了如下文件：
/// 
////////////////////////////////////////////////////////////////////////////////////////////////
(function ($) {

    var _getDataGridLocalPagingData = function (data, pageNumber, pageSize) {
        return { total: data.total, rows: $.plugin.pagingData(data.rows, pageNumber, pageSize).data };
    };
    var _removePagingParams = function (queryParams) {
        var params = {};
        if (window.isEmptyObjectOrNull(queryParams)) { queryParams = {}; }
        for (var key in queryParams) {
            var value = queryParams[key];
            if (key != "page" && key != "pageNumber" && key != "pageIndex" && key != "rows" && key != "pageSize") { params[key] = value; }
        }
        return params;
    };

    var _loader = function (params, success, error) {
        params = $.plugin.parseObjectFuncMap(params);
        var opts = $(this).datagrid("options");
        if (!opts.loadExtensions) {
            var queryParams = opts.queryParams;
            opts.queryParams = $.plugin.parseObjectFuncMap(queryParams);
            opts.paramsData = queryParams;

            var backup = { onHeaderContextMenuCopy: opts.onHeaderContextMenu, onRowContextMenuCopy: opts.onRowContextMenu };
            $.extend(opts, backup);
            var contextMenuEvent = _getDataGridContextMenuEvent(this, opts);
            opts.onHeaderContextMenu = contextMenuEvent.onHeaderContextMenu;
            opts.onRowContextMenu = contextMenuEvent.onRowContextMenu;
            if (opts.searchButton && !window.isEmptyObjectOrNull(opts.searchButton)) { _bindDataGridSearchButtonEvent(this, opts); }
            _bindDataGridPagingEvent(this, opts);

            if (opts.offset) { _setDataGridAutoSize(this, opts.offset); }
            opts.loadExtensions = true;
        }
        if (!opts.url) { return false; }
        if (!opts.remoteSort || opts.remoteSort == false) { params.sort = ""; params.order = ""; }
        if (window.isEmptyObjectOrNull(params.sort) || window.isEmptyObjectOrNull(params.order)) { params.sort = ""; params.order = ""; }
        var orderby = params.sort + " " + params.order;
        if (window.isEmptyObjectOrNull(orderby)) { orderby = ""; }
        $.extend(params, {
            sortName: params.sort,
            sortOrder: params.order,
            orderby: orderby,
            pageNumber: params.page,
            pageIndex: params.page - 1,
            pageSize: params.rows
        });
        var pageNumber = params.pageNumber;
        var pageSize = params.pageSize;
        if (opts.remotePaging == false) { params = _removePagingParams(params); }
        var ajaxOptions = {
            type: opts.method,
            url: opts.url,
            data: params,
            dataType: "json",
            success: function (data) {
                var callbackData = $.plugin.parseSOADataToJSON(data);
                if (opts.remotePaging == false) {
                    opts.cacheData = callbackData;
                    callbackData = _getDataGridLocalPagingData(callbackData, pageNumber, pageSize);
                }
                success(callbackData);
            },
            error: function () { error.apply(this, arguments); }
        };
        if (opts.isWebService == true) {
            $.extend(ajaxOptions, { data: JSON.stringify(params), contentType: "application/json; charset=utf-8" });
        }
        $.ajax(ajaxOptions);
    };


    var _getDataGridSortParams = function (datagrid) {
        if (!datagrid || window.isEmptyObjectOrNull(datagrid)) { return { orderby: "", sortName: "", sortOrder: "" }; }
        var options = $(datagrid).datagrid("options");
        var sortName = options.sortName;
        var sortOrder = options.sortOrder;
        if (window.isEmptyObjectOrNull(sortName)) { sortOrder = ""; sortName = ""; }
        if (window.isEmptyObjectOrNull(sortOrder) && !window.isEmptyObjectOrNull(sortName)) { sortOrder = ""; sortName = ""; }
        var orderby = sortName.trim() + " " + sortOrder.trim();
        var params = { orderby: orderby, sortName: sortName, sortOrder: sortOrder };
        return params;
    };
    var _getDataGridPaginationParams = function (datagrid) {
        var params = {};
        if ($(datagrid).datagrid("options").pagination == true) {
            var pager = $(datagrid).datagrid("getPager");
            var options = pager.pagination("options");
            var pageSize = options.pageSize;
            if ($.type(pageSize) != "number" || pageSize < 1) { pageSize = 10; }
            var pageNumber = options.pageNumber;
            if ($.type(pageNumber) != "number" || pageSize < 1) { pageNumber = 1; }
            var total = options.total;
            if ($.type(total) != "number" || total < 0) { total = 0; }
            var pageCount = Math.ceil(parseFloat(total) / parseFloat(pageSize));
            params = $.extend(params, {
                pager: pager,
                total: total,
                pageSize: pageSize,
                pageNumber: pageNumber,
                pageCount: pageCount
            });
        }
        return params;
    };
    var _getDataGridContextMenuEventData = function (e, datagrid) {
        var sortParams = _getDataGridSortParams(datagrid);
        var pagingParams = _getDataGridPaginationParams(datagrid);
        var params = $.extend({}, sortParams, pagingParams, { e: e, datagrid: datagrid });
        return params;
    };
    var _bindDataGridSearchButtonEvent = function (datagrid, options) {
        var searchButton = options.searchButton;
        $(searchButton).each(function (index, element) {
            $(element).live("click", function () {
                var parameters = $.plugin.parseObjectFuncMap(options.paramsData);
                $(datagrid).datagrid("load", parameters);
            });
        });
    };
    var _bindDataGridPagingEvent = function (datagrid) {
        var options = $(datagrid).datagrid("options");
        if (!options.remotePaging && options.pagination) {
            var pager = $(datagrid).datagrid("getPager");
            pager.pagination("options").onSelectPage = function (pageNumber, pageSize) {
                var data = options.cacheData;
                data = _getDataGridLocalPagingData(data, pageNumber, pageSize);
                $(datagrid).datagrid("loadData", data);
            };
        }
    };
    var _getDataGridContextMenuEvent = function (datagrid, options) {
        var headerContextMenuEvent = _getDataGridHeaderContextMenuEvent(datagrid, options);
        var rowContextMenuEvent = _getDataGridRowContextMenuEvent(datagrid, options);
        var contextMenuEvent = { onHeaderContextMenu: headerContextMenuEvent, onRowContextMenu: rowContextMenuEvent };
        return contextMenuEvent;
    };
    var _getDataGridHeaderContextMenuEvent = function (datagrid, options) {
        return function (e, field) {
            e.preventDefault();
            var eventData = _getDataGridContextMenuEventData(e, datagrid);
            var menuOptions = _getDataGridHeaderContextMenuOptions(datagrid, e, field, eventData, options.headerContextMenus);
            var menu = $.plugin.createMenu(menuOptions);
            menu.menu("show", { left: e.pageX, top: e.pageY });
            options.onHeaderContextMenuCopy.apply(this, arguments);
        };
    };
    var _getDataGridRowContextMenuEvent = function (datagrid, options) {
        return function (e, rowIndex, rowData) {
            e.preventDefault();
            var eventData = _getDataGridContextMenuEventData(e, datagrid);
            var menuOptions = _getDataGridRowContextMenuOptions(datagrid, e, rowIndex, rowData, eventData, options.rowContextMenus);
            var menu = $.plugin.createMenu(menuOptions);
            menu.menu("show", { left: e.pageX, top: e.pageY });
            options.onRowContextMenuCopy.apply(this, arguments);
        };
    };
    var _getDataGridHeaderContextMenuOptions = function (datagrid, e, field, eventData, headerContextMenus) {
        var menu = null;
        var id = $(datagrid).attr("id") + "_headercontextmenu_" + window.guid().replaceAll("-", "").left(8);
        var options = { id: id, width: $(datagrid).datagrid("options").contextMenuWidth, menus: new Array() };
        var customMenu = _getDataGridHeaderCustomContextMenuOptions(datagrid, e, field, eventData, id, headerContextMenus);
        var baseMenu = _getDataGridHeaderBaseContextMenuOptions(datagrid, e, field, id, eventData);
        options.menus = options.menus.concat(customMenu);
        if (customMenu.length > 0) { options.menus.push("-"); }
        options.menus = options.menus.concat(baseMenu);
        return options;
    };
    var _getDataGridHeaderCustomContextMenuOptions = function (datagrid, e, field, eventData, id, headerContextMenus) {
        var menu = new Array();
        if ($.type(headerContextMenus) == "array") {
            for (var i = 0; i < headerContextMenus.length; i++) {
                var item = _parseDataGridHeaderContextMenuItem(datagrid, e, field, eventData, headerContextMenus[i]);
                menu.push(item);
            }
        }
        return menu;
    };
    var _getDataGridHeaderBaseContextMenuOptions = function (datagrid, e, field, id, eventData) {
        var _bindDataGridHeaderBaseContextMenuOrderEvent = function () {
            var title = _getDataGridHeaderClickDiv();
            if ($(title).size() > 0) { $(title).click(); }
        };
        var _getDataGridHeaderClickDiv = function () {
            var element = e.target;
            var tagName = element.tagName.toLowerCase();
            var div = $(element);
            switch (tagName) {
                case "td":
                    div = $(element).children("div.datagrid-cell");
                    break;
                case "span":
                    div = $(element).parent("div.datagrid-cell");
                    break;
                default:
                    break;
            }
            return div;
        };
        var menu = new Array();
        var m1 = {
            id: id + "_asc_" + window.guid().replaceAll("-", "").left(8),
            text: "升序",
            iconCls: "icon-menu-asc",
            disabled: function (e, field, eventData) {
                var columnOptions = $(datagrid).datagrid("getColumnOption", field);
                if (columnOptions.sortable == true) { var div = _getDataGridHeaderClickDiv(e); return div.hasClass("datagrid-sort-asc"); } else {
                    return true;
                }
            },
            handler: function (e, field, eventData) { _bindDataGridHeaderBaseContextMenuOrderEvent(); }
        };
        var m2 = {
            id: id + "_desc_" + window.guid().replaceAll("-", "").left(8),
            text: "降序",
            iconCls: "icon-menu-desc",
            disabled: function (e, field, eventData) {
                var columnOptions = $(datagrid).datagrid("getColumnOption", field);
                if (columnOptions.sortable == true) { var div = _getDataGridHeaderClickDiv(e); return !div.hasClass("datagrid-sort-asc"); } else {
                    return true;
                }
            },
            handler: function (e, field, eventData) { _bindDataGridHeaderBaseContextMenuOrderEvent(); }
        };
        var m3 = {
            id: id + "_columns_" + window.guid().replaceAll("-", "").left(8),
            text: "显示/隐藏列",
            iconCls: "icon-columns",
            disabled: false,
            children: new Array()
        };

        var _getDataGridFields = function (datagrid) {
            var result = new Array();
            var fields = $(datagrid).datagrid("getColumnFields");
            for (var i = 0; i < fields.length; i++) {
                var fieldName = fields[i];
                if (!window.isEmptyObjectOrNull(fieldName)) {
                    var fieldOptions = $(datagrid).datagrid("getColumnOption", fieldName);
                    if (!window.isEmptyObjectOrNull(fieldOptions.title)) { result.push(fieldName); }
                }
            }
            return result;
        };
        var fields = _getDataGridFields(datagrid);
        for (var i = 0; i < fields.length; i++) {
            var fieldName = fields[i];
            var fieldOptions = $(datagrid).datagrid("getColumnOption", fieldName);
            var mm = {
                id: id + "_" + fieldName,
                text: fieldOptions.title,
                iconCls: (fieldOptions.hidden === true ? "icon-unchecked" : "icon-checked"),
                disabled: false,
                handler: function (e, field, eventData) {
                    var counts = 0;
                    var columns = _getDataGridFields(datagrid);
                    for (var index = 0; index < columns.length; index++) {
                        var c = columns[index];
                        if ($(datagrid).datagrid("getColumnOption", c).hidden != true) { counts++; }
                    }
                    var title = this.id.right(this.id.length - 1 - id.length);
                    var hidden = $(datagrid).datagrid("getColumnOption", title).hidden;
                    if (counts == 1 && hidden !== true) { return; }
                    $(datagrid).datagrid((hidden === true ? "showColumn" : "hideColumn"), title);
                }
            };
            m3.children.push(mm);
        }
        var item1 = _parseDataGridHeaderContextMenuItem(datagrid, e, field, eventData, m1);
        var item2 = _parseDataGridHeaderContextMenuItem(datagrid, e, field, eventData, m2);
        var item3 = _parseDataGridHeaderContextMenuItem(datagrid, e, field, eventData, m3);
        menu.push(item1);
        menu.push(item2);
        menu.push("-");
        menu.push(item3);
        return menu;
    };
    var _parseDataGridHeaderContextMenuItem = function (datagrid, e, field, eventData, item) {
        if ($.type(item) == "string" && item.trim() == "-") { return item.trim(); }
        var defaults = {
            id: null,
            text: null,
            iconCls: null,
            disabled: false,
            handler: function (e, field, eventData) { },
            children: new Array()
        };
        if ($.type(item) != "object") { item = {}; }
        item = $.extend({}, defaults, item);
        var menuItem = {
            id: ($.isFunction(item.id) ? item.id(e, field, eventData) : item.id),
            text: ($.isFunction(item.text) ? item.text(e, field, eventData) : item.text),
            iconCls: ($.isFunction(item.iconCls) ? item.iconCls(e, field, eventData) : item.iconCls),
            disabled: ($.isFunction(item.disabled) ? item.disabled(e, field, eventData) : item.disabled),
            onclick: function () { item.handler(e, field, eventData); },
            children: { width: $(datagrid).datagrid("options").contextMenuWidth, menus: new Array() }
        };
        if (item.children.length > 0) {
            for (var i = 0; i < item.children.length; i++) {
                var childrenMenu = _parseDataGridHeaderContextMenuItem(datagrid, e, field, eventData, item.children[i]);
                menuItem.children.menus.push(childrenMenu);
            }
        }
        return menuItem;
    };
    var _getDataGridRowContextMenuOptions = function (datagrid, e, rowIndex, rowData, eventData, rowContextMenus) {
        var menu = null;
        var id = $(datagrid).attr("id") + "_rowrcontextmenu_" + window.guid().replaceAll("-", "").left(8);
        var options = { id: id, width: $(datagrid).datagrid("options").contextMenuWidth, menus: [] };
        var customMenu = _getDataGridRowCustomContextMenuOptions(datagrid, e, rowIndex, rowData, eventData, id, rowContextMenus);
        var baseMenu = _getDataGridRowBaseContextMenuOptions(datagrid, e, rowIndex, rowData, id, eventData);
        options.menus = options.menus.concat(customMenu);
        if (customMenu.length > 0) { options.menus.push("-"); }
        options.menus = options.menus.concat(baseMenu);
        return options;
    };
    var _getDataGridRowCustomContextMenuOptions = function (datagrid, e, rowIndex, rowData, eventData, id, rowContextMenus) {
        var menu = new Array();
        if ($.type(rowContextMenus) == "array") {
            for (var i = 0; i < rowContextMenus.length; i++) {
                var item = _parseDataGridRowContextMenuItem(datagrid, e, rowIndex, rowData, eventData, rowContextMenus[i]);
                menu.push(item);
            }
        }
        return menu;
    };
    var _getDataGridRowBaseContextMenuOptions = function (datagrid, e, rowIndex, rowData, id, eventData) {
        var menu = new Array();
        var m1 = {
            id: id + "_reload",
            text: "刷新当前页",
            iconCls: "pagination-load",
            disabled: function (e, rowIndex, rowData, eventData) {
                return false;
            },
            handler: function (e, rowIndex, rowData, eventData) {
                if ($(datagrid).datagrid("options").pagination == true) { eventData.pager.pagination("select", eventData.pageNumber); } else {
                    $(datagrid).datagrid("reload");
                }
            }
        };
        var m2 = {
            id: id + "_first",
            text: "首页",
            iconCls: "pagination-first",
            disabled: function (e, rowIndex, rowData, eventData) {
                return ($(datagrid).datagrid("options").pagination != true || eventData.pageNumber <= 1);
            },
            handler: function (e, rowIndex, rowData, eventData) {
                if (eventData.pageNumber > 1) { eventData.pager.pagination("select", 1); }
            }
        };
        var m3 = {
            id: id + "_previous",
            text: "上一页",
            iconCls: "pagination-prev",
            disabled: function (e, rowIndex, rowData, eventData) {
                return ($(datagrid).datagrid("options").pagination != true || eventData.pageNumber <= 1);
            },
            handler: function (e, rowIndex, rowData, eventData) {
                if (eventData.pageNumber > 1) { eventData.pager.pagination("select", eventData.pageNumber - 1); }
            }
        };
        var m4 = {
            id: id + "_next",
            text: "下一页",
            iconCls: "pagination-next",
            disabled: function (e, rowIndex, rowData, eventData) {
                return ($(datagrid).datagrid("options").pagination != true || eventData.pageNumber >= eventData.pageCount);
            },
            handler: function (e, rowIndex, rowData, eventData) {
                if (eventData.pageNumber < eventData.pageCount) { eventData.pager.pagination("select", eventData.pageNumber + 1); }
            }
        };
        var m5 = {
            id: id + "_last",
            text: "末页",
            iconCls: "pagination-last",
            disabled: function (e, rowIndex, rowData, eventData) {
                return ($(datagrid).datagrid("options").pagination != true || eventData.pageNumber >= eventData.pageCount);
            },
            handler: function (e, rowIndex, rowData, eventData) {
                if (eventData.pageNumber < eventData.pageCount) { eventData.pager.pagination("select", eventData.pageCount); }
            }
        };
        var item1 = _parseDataGridRowContextMenuItem(datagrid, e, rowIndex, rowData, eventData, m1);
        var item2 = _parseDataGridRowContextMenuItem(datagrid, e, rowIndex, rowData, eventData, m2);
        var item3 = _parseDataGridRowContextMenuItem(datagrid, e, rowIndex, rowData, eventData, m3);
        var item4 = _parseDataGridRowContextMenuItem(datagrid, e, rowIndex, rowData, eventData, m4);
        var item5 = _parseDataGridRowContextMenuItem(datagrid, e, rowIndex, rowData, eventData, m5);
        menu.push(item1);
        menu.push("-");
        menu.push(item2);
        menu.push(item3);
        menu.push("-");
        menu.push(item4);
        menu.push(item5);
        return menu;
    };
    var _parseDataGridRowContextMenuItem = function (datagrid, e, rowIndex, rowData, eventData, item) {
        if ($.type(item) == "string" && item.trim() == "-") { return item.trim(); }
        var defaults = {
            id: null,
            text: null,
            iconCls: null,
            disabled: false,
            handler: function (e, rowIndex, rowData, eventData) { },
            children: []
        };
        if ($.type(item) != "object") { item = {}; }
        item = $.extend({}, defaults, item);
        var menuItem = {
            id: ($.isFunction(item.id) ? item.id(e, rowIndex, rowData, eventData) : item.id),
            text: ($.isFunction(item.text) ? item.text(e, rowIndex, rowData, eventData) : item.text),
            iconCls: ($.isFunction(item.iconCls) ? item.iconCls(e, rowIndex, rowData, eventData) : item.iconCls),
            disabled: ($.isFunction(item.disabled) ? item.disabled(e, rowIndex, rowData, eventData) : item.disabled),
            onclick: function () { item.handler(e, rowIndex, rowData, eventData); },
            children: { width: $(datagrid).datagrid("options").contextMenuWidth, menus: new Array() }
        };
        if (item.children.length > 0) {
            for (var i = 0; i < item.children.length; i++) {
                var childrenMenu = _parseDataGridRowContextMenuItem(datagrid, e, rowIndex, rowData, eventData, item.children[i])
                menuItem.children.menus.push(childrenMenu);
            }
        }
        return menuItem;
    };
    var _setDataGridAutoSize = function (datagrid, offset) {
        var defaults = {
            offsetWidth: 0,
            offsetHeight: 0,
            width: 0,
            height: 0
        };
        offset = $.extend({}, defaults, offset);
        if ($.type(offset.offsetWidth) != "number") { offset.offsetWidth = 0; }
        if ($.type(offset.offsetHeight) != "number") { offset.offsetHeight = 0; }
        if ($.type(offset.width) != "number") { offset.width = 0; }
        if ($.type(offset.height) != "number") { offset.height = 0; }
        var autoSize = function () {
            var size = $.plugin.browserSize();
            var width = (offset.width != 0 ? offset.width : offset.offsetWidth);
            var height = (offset.height != 0 ? offset.height : offset.offsetHeight)
            $(datagrid).datagrid("resize", { "width": size.width + width, "height": size.height + height });
        };
        autoSize();
        $(window).resize(autoSize);
    };


    var _defaults = {
        isWebService: true,
        headerContextMenus: null,
        rowContextMenus: null,
        offset: null,
        searchButton: null,
        remotePaging: true,
        contextMenuWidth: 140,
        loader: _loader
    };

    var _deleteRow = $.fn.datagrid.methods.deleteRow;
    var _methods = {
        ////////////////////////////////////////////////////////
        /// 获取当前数据页上的行数据，返回的是一个 JSON 对象。
        /// 参数 param 表示查找的内容；该参数可以是以下三种类型：
        ///     int 类型，表示行索引号；
        ///     待查找的行数据的 idField(主键) 字段值，或者行数据对象；
        ///     function 类型，该函数签名为 function(rowData)，rowData 表示遍历的行数据对象；该回调函数返回 true 时则表示查找到相应的行数据。
        ////////////////////////////////////////////////////////
        getRow: function (jq, param) {
            var rows = $(jq).datagrid("getRows");
            var row = null;
            if (rows.length == 0) { return row; }
            if ($.isNumeric(param)) { row = rows[param]; } else {
                if (!$.isFunction(param)) {
                    var index = $(jq).datagrid("getRowIndex", param); row = rows[index];
                } else {
                    for (var i = 0; i < rows.length; i++) { if (param.call(rows[i], rows[i]) == true) { row = rows[i]; break; } }
                }
            }
            return row;
        },
        ////////////////////////////////////////////////////////
        /// 删除一行数据；指定的参数 row 如果是 int 类型则表示行索引号,否则表示行数据的 idField(主键) 值或者行数据对象。
        /// 这是 easyui-datagrid 中本身就具有的方法，此处是进行功能增强重写。
        ////////////////////////////////////////////////////////
        deleteRow: function (jq, row) {
            if ($.isNumeric(row)) { _deleteRow.apply(this, arguments); return; }
            var index = $(jq).datagrid("getRowIndex", row);
            _deleteRow.call(this, jq, index);
        },
        ////////////////////////////////////////////////////////
        /// 删除多行数据；指定的参数 rows 是一个数组，数组中的每个元素可以是 行索引号，也可以是行数据的 idField(主键) 值或者行数据对象，还可以是一个查找行数据的回调参数；
        /// 如果数组参数 rows 中的元素为回调函数时，则该回调参数的签名为 function(rowData)，rowData 表示遍历的行数据对象；该回调函数返回 true 时则表示查找到相应的行数据。
        ////////////////////////////////////////////////////////
        deleteRows: function (jq, rows) {
            if (!$.isNumeric(rows)) { $(jq).datagrid("deleteRow", rows); return; }
            if (rows.length == 0) { return; }
            var temps = new Array();
            for (var i = 0; i < rows.length; i++) { temps.push($(jq).datagrid("getRow", rows[i])); }
            for (var i = 0; i < temps.length; i++) {
                var row = $(jq).datagrid("getRow", temps[i]);
                $(jq).datagrid("deleteRow", row);
            }
        }
    };
    $.extend($.fn.combogrid.defaults, _defaults);
    $.extend($.fn.datagrid.defaults, _defaults);
    $.extend($.fn.treegrid.defaults, _defaults);
    $.extend($.fn.datagrid.methods, _methods);
})(jQuery);