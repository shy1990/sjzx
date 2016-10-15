(function ($) {

    var noSetting = function (value) {
        return (!value || window.isEmptyObjectOrNull(value) || value == "auto" || ($.type(value) != "number" && value == "auto"));
    };
    var _onResize = $.fn.panel.defaults.onResize;
    var _paneOnResize = function (width, height) {
        _onResize.call(this, width, height);
        var opts = $(this).panel("options");
        var needResizeWidth = false, needResizeHeight = false;
        if (!noSetting(opts.maxWidth)) { if (width > opts.maxWidth) { width = opts.maxWidth; needResizeWidth = true; } }
        if (!noSetting(opts.minWidth)) { if (width < opts.minWidth) { width = opts.minWidth; needResizeWidth = true; } }
        if (!noSetting(opts.maxHeight)) { if (height > opts.maxHeight) { height = opts.maxHeight; needResizeHeight = true; } }
        if (!noSetting(opts.minHeight)) { if (height < opts.minHeight) { height = opts.minHeight; needResizeHeight = true; } }
        if (needResizeWidth || needResizeHeight) {
            var size = {};
            if (needResizeWidth) { $.extend(size, { width: width }); }
            if (needResizeHeight) { $.extend(size, { height: height }); }
            $(this).panel("resize", size);
        }
    };

    var _defaults = {
        //表示 easyui-panel 面板的最小宽度。
        minWidth: "auto",

        //表示 easyui-panel 面板的最大宽度。
        maxWidth: "auto",

        //表示 easyui-panel 面板的最小高度。
        minHeight: "auto",

        //表示 easyui-panel 面板的最大高度。
        maxHeight: "auto",

        //重新定义的 onResize 事件。用于扩展四个新增属性 minWidth、maxWidth、minHeight、maxHeight 的功能。
        onResize: _paneOnResize
    };
    var _methods = {};


    $.extend($.fn.panel.defaults, _defaults);
    $.extend($.fn.panel.methods, _methods);
})(jQuery);