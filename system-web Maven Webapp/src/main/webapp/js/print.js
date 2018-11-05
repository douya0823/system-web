//打印
var LODOP;
function printPage(areaId) {
    var code = $("#lblWfType").val();
    $.ajax({
        url: "/WF/WFDesign/GetPrintSet",
        type: "POST",
        dataType: "json",
        data: { code: code, wfId: "@Model.lblInstanceID" },
        success: function (data) {
            if (!data.ok) {
                alert(data.msg);
                return;
            }
 
            //数据
            $("#printTem").html($("form").parent().html());

            var inputArr = $("#printTem").find("input:text,input:radio,input:checkbox,textarea,select");
            inputArr.each(function () {
                var jQ = $(this);
                jQ.attr("disabled", false);
            });

            var dataFrmVal = $("#printTem").find("form").serializeArray();
            $("#printTem").html("");
            var dataFrm = eval("(" + FormToJson(dataFrmVal) + ")");

            var jsonData = { frmData: dataFrm, list: [] };

            var forPrint = [];
            $("[printkey]").each(function () {
                var printKey = $(this).attr("printkey");
                var val = $(this).html();
                forPrint.push({ key: printKey, val: val });
            });

            var allSpecifiedGrids = $("#AllSpecifiedGrids").val();
            if (allSpecifiedGrids != "" && allSpecifiedGrids != null) {
                var alspGridsArr = allSpecifiedGrids.split(',');
                for (var i = 0; i < alspGridsArr.length; i++) {
                    jsonData.list.push({ Key: alspGridsArr[i], Value: $('#' + alspGridsArr[i]).datagrid('getRows') });
                }
            }

            var html = decodeHtml(data.content);

            $("#printTem").append('<style type="text/css">table{border-collapse: collapse;}table td{border: solid 1px #000; height:25px; padding:2px;}</style>');
            $("#printTem").append(html);
            $("#printTem").find("table").each(function () {
                $(this).attr("cellspacing", "0");
                $(this).attr("cellpadding", "0");
            });

            for (var i = 0; i < jsonData.list.length; i++) { //遍历子表
                var key = jsonData.list[i].Key;
                var list = jsonData.list[i].Value;

                var detailTable = $("#printTem").find("table[id=’" + key + "’]");
                if (detailTable.length > 0) {
                    detailTable.find("td").each(function () {
                        var re = /\[\[[^\]\[]*\]\]/g;
                        if (re.test($(this).html()) == true) {
                            $(this).remove();
                        }
                    });
                    for (var j = 0; j < list.length; j++) {
                        var rowTem = $("#printTem").find("table[id=’" + key + "’]").find("tr:eq(1)").html();
                        for (items in list[j]) {
                            var reg = new RegExp("{{" + items + "}}", "g");
                            if (list[j][items]) {
                                var dateVal = getDateVal(list[j][items]);
                                if (dateVal) {
                                    rowTem = rowTem.replace(reg, dateVal);
                                }
                                else {
                                    rowTem = rowTem.replace(reg, list[j][items]);
                                }
                            }
                            else {
                                rowTem = rowTem.replace(reg, "");
                            }
                        }
                        $("#printTem").find("table[id=’" + key + "’]").append("<tr>" + rowTem + "</tr>");
                    }
                    $("#printTem").find("table[id=’" + key + "’]").find("tr:eq(1)").remove();
                }
            }

            html = $("#printTem").html();
            //处理主表
            for (items in jsonData.frmData[0]) {
                var reg = new RegExp("{{" + items + "}}", "g");
                html = html.replace(reg, jsonData.frmData[0][items]);
            }
            //处理主表
            for (var i = 0; i < forPrint.length; i++) {
                var items = forPrint[i];
                var reg = new RegExp("{{" + items.key + "}}", "g");
                html = html.replace(reg, items.val);
            }
            html = html.replace(/\[\[[^\]\[]*\]\]/g, "");
            $("#printTem").html(html);

            /* $("#printTem").find("table:first").prev().before(’<p>工作流信息：</p><table style="width:100%;">’ + $("#tabDetailWf2Info").html() + ’</table>’);
            $("#printTem").find("table:first").find("td").removeAttr("class");
            $("#printTem").find("table:first").find("td").removeAttr("style"); */
            $("#printTem").append('<p>审批记录：</p><table style="width:100%;">' + $("#auditRecord").html() + '</table>');
            $("#printTem").find("table:last").find("td").removeAttr("class");
            $("#printTem").find("table:last").find("td").removeAttr("style");
            $("#printTem").find("table").attr("width", "100%");
            $("#printTem").find("table").css("width", "100%");
            $("#printTem").find("table td").removeAttr("width");
            //$("#printTem").show(); return; //测试用

            html = $("#printTem").html();
            $("#printTem").html("");

            //打印
            LODOP = getLodop(document.getElementById('LODOP_OB'), document.getElementById('LODOP_EM'));
            LODOP.PRINT_INIT("分页打印");
            LODOP.ADD_PRINT_HTM(30, 30, 1070, "BottomMargin:30px", html);
            LODOP.SET_PRINT_PAGESIZE(2, 0, 0, "A4");
            LODOP.SET_PRINT_COPIES(1);
            LODOP.SET_SHOW_MODE("LANDSCAPE_DEFROTATED", 1); //横向时的正向显示
            var printResult = LODOP.PREVIEW();
            if (printResult) {
                //alert("打印成功");
                $.ajax({
                    url: "/WF/WFDesign/SavePrintRecords",
                    type: "POST",
                    dataType: "json",
                    data: { wfTypeCode: code, wfId: "@Model.lblInstanceID", wfName: "@Model.lblTitle", printResult: 1, reason: "" },
                    success: function (data) { }
                });
            }
            else {
                //alert("打印失败：取消打印");
            }
        }
    });
}

function getLodop(oOBJECT, oEMBED) {
    /**************************
    本函数根据浏览器类型决定采用哪个对象作为控件实例：
    IE系列、IE内核系列的浏览器采用oOBJECT，
    其它浏览器(Firefox系列、Chrome系列、Opera系列、Safari系列等)采用oEMBED。
    **************************/
    var strHtml1 = "<br><br><br><br><font color=’#FF00FF’>打印控件未安装!点击这里<a href=’/Content/Plugins/lodop/install_lodop.exe’>执行安装</a>,安装后请刷新页面或重新进入。</font>";
    var strHtml2 = "<br><br><br><br><font color=’#FF00FF’>打印控件需要升级!点击这里<a href=’/Content/Plugins/lodop/install_lodop.exe’>执行升级</a>,升级后请重新进入。</font>";
    var strHtml3 = "<br><br><br><br><font color=’#FF00FF’>注意：<br>1：如曾安装过Lodop旧版附件npActiveXPLugin,请在【工具】->【附加组件】->【扩展】中先卸它;<br>2：如果浏览器表现出停滞不动等异常，建议关闭其“plugin-container”(网上搜关闭方法)功能;</font>";
    var LODOP = oEMBED;
    try {
        if (navigator.appVersion.indexOf("MSIE") >= 0) LODOP = oOBJECT;

        if ((LODOP == null) || (typeof (LODOP.VERSION) == "undefined")) {
            if (navigator.userAgent.indexOf('Firefox') >= 0)
                document.documentElement.innerHTML = strHtml3 + document.documentElement.innerHTML;
            if (navigator.appVersion.indexOf("MSIE") >= 0) document.write(strHtml1); else
                document.documentElement.innerHTML = strHtml1 + document.documentElement.innerHTML;
            return LODOP;
        } else if (LODOP.VERSION < "6.0.5.8") {
            if (navigator.appVersion.indexOf("MSIE") >= 0) document.write(strHtml2); else
                document.documentElement.innerHTML = strHtml2 + document.documentElement.innerHTML;
            return LODOP;
        }
        //*****如下空白位置适合调用统一功能:*********         


        //*******************************************
        return LODOP;
    } catch (err) {
        document.documentElement.innerHTML = "Error:" + strHtml1 + document.documentElement.innerHTML;
        return LODOP;
    }
}

function decodeHtml(val) {
    return val.replace(/&lt;/g, "<")
            .replace(/&gt;/g, ">")
            .replace(/&quot;/g, "\"")
            .replace(/&#039;/g, "’")
            .replace(/&amp;/g, "&");
}

//日期格式
function getDateVal(value) {
    if (!value) return undefined;
    if (value instanceof Date) {
        return value.format("yyyy-MM-dd");
    }
    else if (value.toString().indexOf("Date") != -1) {
        var date = new Date();
        date.setTime(value.replace(/\/Date\((-?\d+)\)\//, '$1'));
        return date.format("yyyy-MM-dd");
    }
    else {
        return undefined;
    }
}