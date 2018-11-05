var editor;
$(document).ready(function() {
					KindEditor.plugin['param'] = {
						// 插件图标被点击的处理函数，要弹出下拉列表
						click : function(id) {
							var codeList = KindEditor.lang.plugins.code.code;
							var cmd = 'param';
							KindEditor.util.selection(id);
							// 创建一个menu
							var menu = new KindEditor.menu({
								id : id,
								cmd : cmd,
								width : 150
							});
							KindEditor.each(codeList, function(key, value) {
								// 产生列表里每一项的html
								var html = '<span class="ke-reset">' + value
										+ '</span>';
								// 添加每一项到menu里，当menu点击时调用code插件的exec方法，并把点击了的id和key传给exec
								menu.add(html, function() {
									KindEditor.plugin[cmd].exec(id, key);
								});
							});
							menu.show();
							this.menu = menu;
						},
						// 点了下拉列表的某一项后，在文本域插入一些代码
						exec : function(id, value) {
							var html = '<pre name="param" class="' + value
									+ '"><br/><br/></pre>';
							KindEditor.util.insertHtml(id, html);
							this.menu.hide();
							KindEditor.util.focus(id);
						}
					};    
		  
	KindEditor.ready(function(K) {
		var options = {
			cssPath : '../js/kindeditor/plugins/code/prettify.css',
			uploadJson : '../js/kindeditor/jsp/upload_json.jsp',
			fileManagerJson : '../js/kindeditor/jsp/file_manager_json.jsp',
			allowFileManager : true,
			filterMode : false,
			allowFileManager: false,
            allowFlashUpload: false,
            allowMediaUpload: false,
            allowFileUpload: false,
            enterTag : 'br',
	/*		items: [
			   'source',
			   'undo',
			   'redo',
			   'plainpaste',
			   'wordpaste',
			   'clearhtml',
			   'quickformat',
			   'selectall',
			   'fullscreen',
			   'fontname', 
			   'fontsize', 
			   '|', 
			   'forecolor',
			   'hilitecolor',
			   'bold',
			   'italic',
			   'underline',
			   'hr',
			   'removeformat',
			   '|',
			   'justifyleft', 
			   'justifycenter',
			   'justifyright',
			   'insertorderedlist',
			   'insertunorderedlist',
			   '|',
			   'link',
			   'image',
			   'unlink',
			   'baidumap',
			   'emoticons','param'
			],*/
			afterBlur : function() {
				this.sync();
			},
			afterCreate : function() {
				this.sync();
				var self = this;
				K.ctrl(document, 13, function() {
					self.sync();
					document.forms['example'].submit();
				});
				K.ctrl(self.edit.doc, 13, function() {
					self.sync();
					document.forms['example'].submit();
				});
				showContract();
			},
			afterChange: function () {
	            //富文本输入区域的改变事件，一般用来编写统计字数等判断
	            K('.word_count1').html("最多20000个字符,已输入" + this.count() + "个字符");
	       },
		};
		editor = K.create('textarea[name="content"]', options);

		
	});
});
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

var contractHtml = "";
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
				KindEditor.html("#editor",data.contract);
			} else {
				alert(data.message);
			}
		},
		error : function() {
			alert("系统错误");
		}
	});
}
function saveContractHtml() {
	var id = $("#model_id").val();
	var contractHtml = $.trim($("#editor").val());
	// contractHtml+=saveContent[parseInt(currentPage)];
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
function getHtml() {
	alert(editor.getContent());
}
