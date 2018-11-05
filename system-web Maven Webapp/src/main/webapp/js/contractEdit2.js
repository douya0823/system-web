$(document).ready(function() {

	var SequenceButton = function (context) {
	    var ui = $.summernote.ui;
	    var button = ui.buttonGroup([
	        ui.button({
	            contents: '<i class="note-icon-special-character" />    <span class="caret"></span>',
	            tooltip: '插入序号',
	            data: {
	                toggle: 'dropdown'
	            }
	        }),
	        ui.dropdown({
	            items: ['①', '②', '③', '④', '⑤', '⑥','⑦','⑧','⑨'],
	            callback: function (items) {
	                $(items).find('li a').on('click', function () {
	                    context.invoke("editor.insertText", $(this).html());
	                });
	            }
	        })
	    ]);
	 
	    return button.render();
	};
	$('#summernote').summernote({
	height: 800,
	width:900,
	lang:'zh-CN',
    tabsize: 2,
    focus: true ,
    fontSizes: ['8', '9', '10', '11', '12', '13','14', '18', '24', '36'],
    fontNames: ['宋体',
                'Arial', 'Arial Black', 'Comic Sans MS', 'Courier New',
                'Helvetica Neue', 'Helvetica', 'Impact', 'Lucida Grande',
                'Tahoma', 'Times New Roman', 'Verdana'
              ],
    toolbar: [
        // [groupName, [list of button]]
        ['style', ['bold', 'italic', 'underline', 'clear']],
        ['font', ['strikethrough', 'superscript', 'subscript']],
        ['fontsize', ['fontsize']],
        ['color', ['color']],
        ['para', ['ul', 'ol', 'paragraph']],
        ['height', ['height']],
        ['fontname', ['fontname']],
        ['table', ['table']],
        ['view', ['fullscreen', 'codeview', 'help']]
    ]
	});
	showContract();
	
	$("#param").change(function(){
		if($("#param").val()){
			$('#summernote').summernote('insertText',"{"+$("#param").val()+"}");
		}
		$("#param").val("");
	});
});
function cc() {
	$("#dd").val($('#summernote').summernote('code'));
}
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
		url : "readContract",
		data : {
			id : $("#model_id").val()
		},
		async : false,
		success : function(data) {
			data = JSON.parse(data);
			if (data.code == "0000") {
				$('#summernote').summernote('code',data.contract);
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
	var contractHtml =$('#summernote').summernote('code');
	// contractHtml+=saveContent[parseInt(currentPage)];
	$.ajax({
		type : "post",
		url : "writeContract",
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
	alert($('#summernote').summernote('code'));
}
