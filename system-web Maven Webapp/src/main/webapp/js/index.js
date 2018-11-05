$(function() {

	// 浏览器窗口变化
	cover();
	$(window).resize(function() {
				cover();
			});

	// 菜单初始化
	var div_leftmenu_html = '<div id="div_leftmenu" class="easyui-accordion">';//
	var system = "0";
	switch (system) {
		case "0" :// 中央审批系统
			div_leftmenu_html += '<div title="参数管理">';
			div_leftmenu_html += ' <ul>';
			div_leftmenu_html += ' <li  data="jsp/params.jsp" onclick="openLeftWin(this)">基础参数</li>';
			div_leftmenu_html += ' <li  data="jsp/city.jsp" onclick="openLeftWin(this)">贷款城市</li>';
			div_leftmenu_html += ' <li  data="jsp/product.jsp" onclick="openLeftWin(this)">贷款产品</li>';
			div_leftmenu_html += ' <li  data="jsp/contractType.jsp" onclick="openLeftWin(this)">合同类型</li>';
			div_leftmenu_html += ' <li  data="jsp/contract.jsp" onclick="openLeftWin(this)">合同管理</li>';
			div_leftmenu_html += ' <li  data="jsp/contractParam.jsp" onclick="openLeftWin(this)">合同参数</li>';
			//div_leftmenu_html += ' <li  data="jsp/contractVersion.jsp" onclick="openLeftWin(this)">合同版本</li>';
			div_leftmenu_html += ' <li  data="jsp/contractModel.jsp" onclick="openLeftWin(this)">合同模板</li>';
			div_leftmenu_html += ' </ul>';
			div_leftmenu_html += '</div>';
			div_leftmenu_html += '<div title="模板编辑">';
			div_leftmenu_html += ' <ul>';
			div_leftmenu_html += ' <li  data="jsp/contractEdit.jsp" onclick="openLeftWin(this)">模板管理</li>';
			div_leftmenu_html += ' </ul>';
			div_leftmenu_html += '</div>';
			break;
		default :
			break;
	}
	div_leftmenu_html += '</div>';
	$("#leftMenu").append(div_leftmenu_html);
	$(".easyui-accordion").accordion();

	/**
	 * 新增tabs右击事件
	 */
	$("#mainTabs").tabs({
				onContextMenu : function(e, title, index) {
					e.preventDefault();
					if (index >= 0) {
						$("#tab-tools").menu('show', {
									left : e.pageX,
									top : e.pageY
								}).data("tabTitle", title);
					}

				}
			});
	/**
	 * tabs右击菜单绑定事件
	 */
	$("#tab-tools").menu({
				onClick : function(node) {
					closeTab(this, node.id);
				}
			});

	openLeftWin('<li  data="jsp/contractModel.jsp" onclick="openLeftWin(this)">合同模板</li>');
});
function cover() {
	var win_width = $(window).width();
	var win_height = $(window).height();
	$("#body").attr({
				width : win_width,
				height : win_height
			});
}
function openLeftWin(e) {
	var tab = $(e);
	var tabName = tab.html();
	if ($("#mainTabs").tabs("exists", tabName)) {// 如果已存在，选中
		$("#mainTabs").tabs("select", tabName);
	} else {
		var content = "<iframe frameborder='0' scrolling='auto' style='width:100%;height:100%;' src="
				+ tab.attr("data") + "></iframe>";
		$("#mainTabs").tabs("add", {
					title : tabName,
					selected : true,
					closable : true,
					// href : "jsp/test.jsp",//此处可动态跳转页面
					content : content,// 此处可动态跳转页面,在加载的json、或者后台数据中组合添加属性即可
					tools : [{ // 加载刷新小按钮
						iconCls : "icon-page_refresh",// 应该使用8*8像素图片,没有找到8*8
						handler : function() {
							var currentTab = $("#mainTabs").tabs('getSelected');
							refreshTab(currentTab);
						}
					}]
				});
	}
	return false;
}
/**
 * 相关右击菜单的点击事件 menu 此处没有用到,即当前选择的menu菜单 id menu菜单的id标识，可用其他唯一标识代替
 */
function closeTab(menu, id) {
	var tab = $("#mainTabs").tabs('getSelected');// 当前所选tab
	var index = $("#mainTabs").tabs('getTabIndex', tab);// 当前所选tab的下标位置
	var tablist = $("#mainTabs").tabs('tabs'); // 所有的tabs列表
	switch (id) {
		case '1' :// 刷新
			refreshTab(tab);
			break;
		case '2' :// 关闭当前标签
			$("#mainTabs").tabs("close", index);
			break;
		case '3' :// 关闭非当前标签
			for (var i = tablist.length - 1; i > index; i--) {
				$("#mainTabs").tabs('close', i);
			}
			var num = index - 1;
			for (var i = num; i >= 0; i--) {
				$("#mainTabs").tabs('close', 0);
			}
			break;
		case '4' :// 关闭左侧
			var num = index - 1;
			for (var i = num; i >= 0; i--) {
				$("#mainTabs").tabs('close', 0);
			}
			break;
		case '5' :// 关闭右侧
			for (var i = tablist.length - 1; i > index; i--) {
				$("#mainTabs").tabs('close', i);
			}
			break;
		case '6' :// 关闭所有
			for (var i = tablist.length - 1; i >= 0; i--) {
				$("#mainTabs").tabs("close", i);
			}
			break;
		default :
	}
}
/**
 * 通用刷新tabs方法 currentTab 刷新的tabs对象
 */
function refreshTab(currentTab) {
	var url = $(currentTab.panel('options')).attr('href');
	$('#mainTabs').tabs('update', {
				tab : currentTab,
				options : {
					href : url
					// 重新获取目标页面
				}
			});
	currentTab.panel('refresh');// 刷新
}

var bLeftExpand = false;
/* 左边布局 */

$("#panelWest").panel({
			onCollapse : function() {
				if (!bLeftExpand) {
					expandWest();
					bLeftExpand = true;
				}
			}
		});

/* 展开左边面板 */
function expandWest() {
	var objs = $(".layout-expand-west");
	var obj = null;
	if (objs.length == 1) {
		obj = $(objs[0]);
		if (obj != null && obj.length == 1) {
			$(obj).mouseover(function() {
						$(obj).click(); // 用于模拟点击收缩功能
					});
		}
	}
}