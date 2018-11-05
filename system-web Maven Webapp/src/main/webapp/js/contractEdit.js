$(document).ready(function(){
	
});
var pageCount = 1;//总页数
var regExp = /_ueditor_page_break_tag_/;//根据某处字符来分页
var saveContent;//用于保存分页数据
var content, pageList;//保存全局ID
var currentPage=1;

//ID=需要分页的html
//page=显示分页样式
UeInitialize = function (data, page) {
	content=data;
    pageList = $(page);
    if (content != null && regExp.test(content)) {
        saveContent = content.split(regExp);
        pageCount = saveContent.length;
    }
    window.UePageContent(1);
};

//显示分页的内容并自动生成页数
UePageContent = function (pageIndex) {
	currentPage=pageIndex;
    if (pageIndex >= 1 && pageIndex <= pageCount && saveContent != null && saveContent.length >= 0) {
        var pageHtml = pageList;
        if ((parseInt(pageIndex) - 1) <= saveContent.length) {
            ue.setContent(saveContent[parseInt(pageIndex) - 1]);
        }

        pageHtml.html("");
        var innHtml = "页数：" + pageIndex + "/" + pageCount;
        innHtml += "<a target='_self' href='javascript:UePageContent(1)'>首页</a>";
        if (pageIndex > 1) {
            innHtml += "<a target='_self' href='javascript:UePageContent(" + (parseInt(pageIndex) - 1) + ")'>上一页</a>";
        }
        if (pageIndex < pageCount) {
            innHtml += "<a target='_self' href='javascript:UePageContent(" + (parseInt(pageIndex) + 1) + ")'>下一页</a>";
        }
        innHtml += "<a target='_self' href='javascript:UePageContent(" + pageCount + ")'>末页</a>";
        pageHtml.html(innHtml);
    }
};
function addLoadEvent(func) {
	var oldonload = window.onload;
	if (typeof window.onload != 'function') {
		window.onload = func;
	} else {
		window.onload = function() {
			oldonload();
			func();
		};
	}
}

var ue;
function ueditorReady() {
	// 摒弃传统初始化，使用异步初始化
	UE.delEditor("editor");
	ue = new UE.ui.Editor({
		toolbars : [ [
		// 'anchor', //锚点
		'undo', // 撤销
		'redo', // 重做
		'bold', // 加粗
		'indent', // 首行缩进
		// 'snapscreen', //截图
		'italic', // 斜体
		'underline', // 下划线
		'strikethrough', // 删除线
		'subscript', // 下标
		'fontborder', // 字符边框
		'superscript', // 上标
		'formatmatch', // 格式刷
		'source', //源代码
		// 'blockquote', //引用
		'pasteplain', // 纯文本粘贴模式
		'selectall', // 全选
		'print', // 打印
		'preview', // 预览
		'horizontal', // 分隔线
		'removeformat', // 清除格式
		'time', // 时间
		'date', // 日期
		// 'unlink', //取消链接
		// 'insertrow', //前插入行
		// 'insertcol', //前插入列
		// 'mergeright', //右合并单元格
		// 'mergedown', //下合并单元格
		// 'deleterow', //删除行
		// 'deletecol', //删除列
		// 'splittorows', //拆分成行
		// 'splittocols', //拆分成列
		// 'splittocells', //完全拆分单元格
		 'deletecaption', //删除表格标题
		// 'inserttitle', //插入标题
		// 'mergecells', //合并多个单元格
		 'deletetable', //删除表格
		'cleardoc', // 清空文档
		 'insertparagraphbeforetable', //"表格前插入行"
		// 'insertcode', //代码语言
		'fontfamily', // 字体
		'fontsize', // 字号
		'paragraph', // 段落格式
		// 'simpleupload', //单图上传
		// 'insertimage', //多图上传
		 'edittable', //表格属性
		'edittd', //单元格属性
		// 'link', //超链接
		// 'emotion', //表情
		'spechars', // 特殊字符
		'searchreplace', // 查询替换
		// 'map', //Baidu地图
		// 'gmap', //Google地图
		// 'insertvideo', //视频
		// 'help', //帮助
		'justifyleft', // 居左对齐
		'justifyright', // 居右对齐
		'justifycenter', // 居中对齐
		'justifyjustify', // 两端对齐
		'forecolor', // 字体颜色
		'backcolor', //字体背景色
		'insertorderedlist', // 有序列表
		'insertunorderedlist', // 无序列表
		'fullscreen', // 全屏
		'directionalityltr', // 从左向右输入
		'directionalityrtl', // 从右向左输入
		'rowspacingtop', // 段前距
		'rowspacingbottom', // 段后距
		'pagebreak', // 分页
		// 'insertframe', //插入Iframe
		// 'imagenone', //默认
		// 'imageleft', //左浮动
		//'imageright', //右浮动
		// 'attachment', //附件
		'imagecenter', // 居中
		// 'wordimage', //图片转存
		'lineheight', // 行间距
		'edittip ', // 编辑提示
		'customstyle', // 自定义标题
		'autotypeset', // 自动排版
		// 'webapp', //百度应用
		'touppercase', // 字母大写
		'tolowercase', // 字母小写
		'background', // 背景
		'template', // 模板
		// 'scrawl', //涂鸦
		// 'music', //音乐
		'inserttable', //插入表格
		// 'drafts', // 从草稿箱加载
		// 'charts', // 图表
		'combox'// 下拉框
		] ],
		autoHeightEnabled : true,
		autoFloatEnabled : true,
		initialFrameWidth : 1200// 编辑器宽度，默认1000
		,initialFrameHeight : 800// 编辑器高度，默认320
		,maximumWords : 300000// 最大字符数
		,allowDivTransToP : false
		,enableAutoSave:false//启动自动保存
		,pageBreakTag:'_ueditor_page_break_tag_'
	// 阻止div标签自动转换为p标签
	});
	ue.render("editor");
	ue.addListener("ready", function() {
		// ueditor初始化后才可进行setcontent
		showContract();

	});
}
var contractHtml = "";
var paramName = new Array();
var paramValue = new Array();
var result;

function showContract() {
	$.ajax({
		type : "get",
		url : "print/readContract",
		data : {
			id : $("#model_id").val()
		},
		async : false,
		success : function(data) {
			data = JSON.parse(data);
			if (data.code == "0000") {
				filterParam(data.contract);
			} else {
				alert(data.message);
			}
		},
		error : function() {
			alert("系统错误");
		}
	});
}
function filterParam(data) {
	for (index in paramName) {
		var param = paramName[index];
		var reg = "{" + param + "}";
		data = data.replace(reg, result[param]);

	}
	ue.setContent(data);
	//UeInitialize(data,"#page");
}
function saveContractHtml() {
	var id = $("#model_id").val();
	var contractHtml = ue.getContent(); 
	//contractHtml+=saveContent[parseInt(currentPage)];
	$.ajax({
		type : "post",
		url : "print/writeContract",
		data : {
			id : id,
			contractHtml : contractHtml
		},
		async : false,
		success : function(data) {
			data = JSON.parse(data);
			alert(data.message);
		},
		error : function() {
			alert("系统错误");
		}
	});
};
function getHtml(){
	alert(ue.getContent());
}

addLoadEvent(ueditorReady);
